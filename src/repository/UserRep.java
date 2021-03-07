package repository;

import entities.Book;
import entities.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserRep implements IUserRep{
    private final data.IDB db;

    public UserRep(data.IDB db) {
        this.db = db;
    }
    @Override
    // method for login user
    public boolean checkUser(String name, String pass){
        boolean check = false;
        Scanner in = new Scanner(System.in);
        Connection con = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            con = db.getConnection();
            statement = con.createStatement();
            rs = statement.executeQuery("SELECT * FROM users where nickname = '"+name+"' AND password = '"+pass+"'");
            if(rs.next() == false) {
                check = false;
            }
            else {
                check = true;
            }

        }catch (SQLException | ClassNotFoundException e) {
            // If it doesn't connect, it shows ERROR
            System.out.println("Error to connecting to DBMS server");
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return check;
    }
    @Override
    // Admin's method for registering users
    public boolean regisUser(User u) {
        Connection con = null;
        Statement statement = null;
        try {
            con = db.getConnection();
            String value = "INSERT INTO users(name,surname,age,nickname,password,email)" +
                    " " + "VALUES('" +u.getName()+"','"+u.getSurname()+"',"+u.getAge()+",'"+u.getUserName()
            +"','"+u.getPassword()+"','"+u.getEmail()+"'"+ ")";
            statement = con.createStatement();
            // Adds to DBMS
            statement.executeUpdate(value);
        } catch (SQLException | ClassNotFoundException e) {
            // If it doesn't connect, it shows ERROR
            System.out.println("Error to connecting to DBMS server");
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return true;
    }

    @Override
    // user's method for selecting a book by its id
    public boolean selectBookById(int book_id, int user_id) {
        Connection con = null;
        Statement statement = null;
        try {
            con = db.getConnection();
            String value = "INSERT INTO selected_books(book_id, user_id)" +
                    " " + "VALUES('" +book_id+"','"+user_id + ")";
            statement = con.createStatement();
            // Adds to DBMS
            statement.executeUpdate(value);
        } catch (SQLException | ClassNotFoundException e) {
            // If it doesn't connect, it shows ERROR
            System.out.println("Error to connecting to DBMS server");
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return true;
    }
    @Override
    // method for getting id of an user
    public int getIdByNickName(String nickname) {
        Connection con = null;
        Statement statement = null;
        ResultSet rs = null;
        int id;
        try {
            con = db.getConnection();
            statement = con.createStatement();
            rs = statement.executeQuery("SELECT id FROM users where nickname = '" + nickname + "'");
            if(rs.next()) {
                id = rs.getInt("id");
                return id;
            }
        }catch (SQLException | ClassNotFoundException e) {
            // If it doesn't connect, it shows ERROR
            System.out.println("Error to connecting to DBMS server");
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return -1;
    }
}

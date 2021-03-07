package repository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import entities.Book;
import entities.User;


public class AdminRep implements IAdminRep { // admin's console
    private final data.IDB db;

    public AdminRep(data.IDB db){
        this.db = db;
    }
    @Override
    // admin's method for adding books
    public boolean addBook(Book b) {
        Connection con = null;
        Statement statement = null;
        try {
            con = db.getConnection();
            String value = "INSERT INTO books(title,subject,author,language) values('" + b.getTitle() +
                    "','" + b.getSubject() + "','" +  b.getAuthor() + "','" + b.getLanguage()+"')";
            statement = con.createStatement();
            statement.executeUpdate(value);
        }catch (SQLException | ClassNotFoundException e) {
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
    // removing books method
    public boolean removeBookByName(String title) {
        Scanner in = new Scanner(System.in);
        Connection con = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            con = db.getConnection();
            statement = con.createStatement();
            statement.executeUpdate("DELETE FROM books WHERE title LIKE '%" + title + "%'");
        } catch (SQLException | ClassNotFoundException e) {
        System.out.println("Error in connecting to DBMS server");
    }finally {
        try{
            con.close();
        }
        catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }
        return true;
    }
    @Override
    // method for displaying all users that registered in DB
    public List<User> showUsers() {
        Connection con = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            con = db.getConnection();
            statement = con.createStatement();
            rs = statement.executeQuery("SELECT * FROM users");
            LinkedList<User> uses = new LinkedList<>();
            while (rs.next()) {
                User user = new User(rs.getInt("id: "),rs.getString("name: "),
                        rs.getString("surname: "),rs.getInt("age: "),rs.getString("login: "),
                        rs.getString("password: "),rs.getString("email: ")
                        );
                uses.add(user);
            }
            return uses;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error in connecting to DBMS server");
        } finally {
            try {
                rs.close();
                statement.close();
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}
package repository;

import java.util.List;
import java.sql.*;
import java.util.LinkedList;
import java.util.Scanner;
import entities.Book;

public class BookRep implements IBookRep{
    private final data.IDB db;

    public BookRep(data.IDB db) {
        this.db = db;
    }

    @Override
    // user's method for displaying all books in DB
    public List<Book> showAllBook(){
        Scanner in = new Scanner(System.in);
        Connection con = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            con = db.getConnection();
            statement = con.createStatement();
            rs = statement.executeQuery("SELECT * FROM books");
            LinkedList<Book> books = new LinkedList<>();
            while (rs.next()) {
               Book b = new Book(rs.getInt("id: "),rs.getString("title: "), rs.getString("subject: "),
                        rs.getString("author: "),rs.getString("language: "));
                books.add(b);
            }
            return books;
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
    @Override
    // method for searching books by id
    public Book getBookbyId(int id){
        Scanner in = new Scanner(System.in);
        Connection con = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            con = db.getConnection();
            statement = con.createStatement();
            rs = statement.executeQuery("SELECT * FROM books where id = " + id);
            while (rs.next()) {
                Book b = new Book(rs.getString("title: "), rs.getString("subject: "),
                        rs.getString("author: "), rs.getString("language: "));
                return b;
            }
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
    @Override
    // method for select books and add them to user account
    public boolean createSelectedBook(int user_id, int book_id) {
        Connection con = null;
        Statement statement = null;
        try {
            con = db.getConnection();
            String value = "INSERT INTO selected_books(user_id,book_id) values(" + user_id + "," + book_id + ")";
            statement = con.createStatement();
            statement.executeUpdate(value);
        }catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error in connecting to DBMS server");
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
    public List<Book> getSelectedBooks(int user_id){
        Scanner in = new Scanner(System.in);
        Connection con = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            con = db.getConnection();
            statement = con.createStatement();
            rs = statement.executeQuery("SELECT book_id FROM selected_books where user_id = " + user_id);
            LinkedList<Book> books = new LinkedList<>();
            while (rs.next()) {
                Book b = getBookbyId(rs.getInt("book_id"));
                books.add(b);
            }
            return books;
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
    @Override
    // method for displaying books by their subject
    public List<Book> showBooksBySubject(String subject){
        Scanner in = new Scanner(System.in);
        Connection con = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            con = db.getConnection();
            statement = con.createStatement();
            rs = statement.executeQuery("SELECT * FROM books WHERE subject LIKE '%"+subject+"%'");
            LinkedList<Book> books = new LinkedList<>();
            while (rs.next()) {
                Book b = new Book(rs.getString("title: "), rs.getString("subject: "),
                        rs.getString("author: "),rs.getString("language: "));
                books.add(b);
            }
            return books;
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
    @Override
    // method for displaying books that were written by a certain author
    public List<Book> showBooksByAuthor(String author){
        Scanner in = new Scanner(System.in);
        Connection con = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            con = db.getConnection();
            statement = con.createStatement();
            rs = statement.executeQuery("SELECT * FROM books WHERE author LIKE '%"+author+"%'");
            LinkedList<Book> books = new LinkedList<>();
            while (rs.next()) {
                Book b = new Book(rs.getString("title: "), rs.getString("subject: "),
                        rs.getString("author: "),rs.getString("language: "));
                books.add(b);
            }
            return books;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error to connecting to DBMS server");
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
    @Override
    // method for displaying books by their language
    public List<Book> showBooksByLanguage(String language){
        Scanner in = new Scanner(System.in);
        Connection con = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            con = db.getConnection();
            statement = con.createStatement();
            rs = statement.executeQuery("SELECT * FROM books WHERE language LIKE '%" +language+ "%'");
            LinkedList<Book> books = new LinkedList<>();
            while (rs.next()) {
                Book b = new Book(rs.getString("title: "), rs.getString("subject:"),
                        rs.getString("author: "),rs.getString("language: "));
                books.add(b);
            }
            return books;
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

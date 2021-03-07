package controller;

import entities.Book;
import entities.User;
import repository.IBookRep;
import repository.IUserRep;
import repository.IAdminRep;

import java.util.List;

public class UserController {
    // Methods from interface IUserRep as u
    private final IUserRep u;
    // Methods from interface IBookRep as b
    private final IBookRep b;
    // Methods from interface IAdminRep as a
    private final IAdminRep a;

    // Constructor what contains 3 interfaces above
    public  UserController(IUserRep u, IBookRep b, IAdminRep a){
        this.u = u;
        this.b = b;
        this.a = a;
    }

    // CheckUser method with the name( in this case nickname ) and pass as password of user
    // IUserRep
    public boolean checkUser(String name, String pass) {
       boolean check = u.checkUser(name,pass);
       return check;
    }

    // showAllBooks method to which returns List(array) of books
    // IBookRep
    public String showAllBooks() {
        List<Book> book = b.showAllBook();
        return book.toString().replace("[", "").replace("]", "").replace(",", "");
    }

    // regisUser method from IUserRep to register user to DBMS
    public String regisUser(String name, String surname, int age, String userName, String password, String email){
        User us = new User(name,surname,age,userName,password,email);
        boolean created = u.regisUser(us);
        return (created ? "You successfully registered :D " : "Something went wrong, your registration failed :( ");
    }

    // addBook in interface IAdminRep
    public String addBook(String t,String at, String s,String l){
        Book book = new Book(t,at,s,l);
        boolean created = a.addBook(book);
        return (created ? "Book was added :D " : "Something went wrong, we can't add this book :( ");
    }

    // removeBookByName in the interface IAdminRep
    public String removeBookByName(String name){
       boolean book = a.removeBookByName(name);
        return (book? "Book was removed :> " : "Removing was failed!");
    }

    // SelectBook in the interface IUserRep
    public String selectBook(int user_id, int book_id) {
        boolean iscreated = b.createSelectedBook(user_id, book_id);
        return (iscreated ? "Selected :D" : "Nope :(");
    }

    // getSelectedBooks in the interface IUserRep
    public String getSelectedBooks(int user_id) {
        List<Book> books = b.getSelectedBooks(user_id);
        return books.toString().replace("[", "").replace("]", "").replace(",", "").replace("0","");
    }

    // getIdByNickName in IUserRep to get id of user by name
    public int getIdByNickName(String nickname) {
        int id = u.getIdByNickName(nickname);
        return id;
    }

    // showBooksBySubject in IBookRep to show books with same subject(s)
    public String showBooksBySubject(String subject) {
        List<Book> book = b.showBooksBySubject(subject);
        return book.toString().replace("[", "").replace("]", "").replace(",", "");
    }

    // showBooksByAuthor in IBookRep to show books with same author
    public String showBooksByAuthor(String author) {
        List<Book> book = b.showBooksByAuthor(author);
        return book.toString().replace("[", "").replace("]", "").replace(",", "");
    }

    // showBooksByLanguage in IBookRep to show books with one language
    public String showBooksByLanguage(String language) {
        List<Book> book = b.showBooksByLanguage(language);
        return book.toString().replace("[", "").replace("]", "").replace(",", "");
    }

    // Show users from DBMS, IAdminRep
    public String showUsers(){
        List<User> user = a.showUsers();
        return user.toString().replace("[", "").replace("]", "").replace(",", "");
    }
}

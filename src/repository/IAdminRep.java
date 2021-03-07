package repository;

import entities.Book;
import entities.User;
import java.util.List;
// creating an interface that defines behavior of AdminRep subclass
public interface IAdminRep {
    boolean addBook(Book book);
    boolean removeBookByName(String title);
    List<User> showUsers();
}

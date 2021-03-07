package repository;

import java.util.List;
import entities.Book;
public interface IBookRep {
    // interface that define behaviour of BookRep subclass
    List<Book> showAllBook();
    List<Book> showBooksBySubject(String subject);
    List<Book> showBooksByAuthor(String author);
    List<Book> showBooksByLanguage(String language);
    Book getBookbyId(int id);
    boolean createSelectedBook(int user_id, int book_id);
    List<Book> getSelectedBooks(int user_id);
}

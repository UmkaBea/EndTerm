package repository;
import entities.Book;
import entities.User;

public interface IUserRep {
    // interface that defines behaviour of UserRep subclass
    boolean checkUser(String name, String pass);
    boolean regisUser(User u);
    boolean selectBookById(int book_id, int user_id);
    int getIdByNickName(String nickname);
}

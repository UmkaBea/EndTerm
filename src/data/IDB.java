package data;
import java.sql.Connection;
import java.sql.SQLException;

public interface IDB {
    // Connection to the DataBase
    Connection getConnection() throws SQLException, ClassNotFoundException;
}
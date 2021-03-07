package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQL implements IDB {

    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        // Connect to URL, localhost - > 2020, after it choose Database by name Java
        String connectionUrl = "jdbc:postgresql://localhost:2020/java";
        try {
            Class.forName("org.postgresql.Driver");

            // Connection with username: postgres, password: 2020
            Connection con = DriverManager.getConnection(connectionUrl, "postgres", "2020");

            return con;
        } catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
}
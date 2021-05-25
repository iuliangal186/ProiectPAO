package config;
import java.sql.*;

public class DatabaseConnection {
    private static Connection connection;

    private DatabaseConnection() {

    }

    public static Connection getInstance() throws SQLException {
        if(connection == null) {
            String url = "jdbc:mysql://localhost:3306/proiect";
            String username = "root";
            String password = "";

            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }
}

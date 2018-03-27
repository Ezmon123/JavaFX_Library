package library.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConfigureConnection {
    public static Connection getConnection(){
        Connection connection = null;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library?useUnicode=true&amp;characterEncoding=utf8", "root", ""
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}

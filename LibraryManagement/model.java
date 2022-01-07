package LibraryManagement;

import java.sql.Connection;
import java.sql.DriverManager;

public class model {
    public static Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con =
DriverManager.getConnection("jdbc:mysql://localhost:3306/LibraryManagement", "root", "MySQLPassword");
            return con;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}

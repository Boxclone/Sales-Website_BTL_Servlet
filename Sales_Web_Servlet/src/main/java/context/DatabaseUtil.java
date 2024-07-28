package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
	private static final String URL = "jdbc:sqlserver://ZIIECH:1433;databaseName=Store_Huy;encrypt=true;trustServerCertificate=true";
	private static final String USER = "sa";
    private static final String PASSWORD = "sapassword";
    
    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Failed to load SQL Server JDBC driver", e);
        }
    }
    
    public static Connection getConnection() throws SQLException {
    	System.out.println("Connection Database");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=Resource_Sharing";
        conn = DriverManager.getConnection(url, "sa", "Emlahuy123");
        return conn;
    }
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection con = DBUtils.getConnection();
        System.out.println(con);
        
    }
}

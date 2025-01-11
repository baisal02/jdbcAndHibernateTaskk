package peaksoft.jdbcconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCconnection {
    public static Connection getConnection() {
        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","1234");
            return connection;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}

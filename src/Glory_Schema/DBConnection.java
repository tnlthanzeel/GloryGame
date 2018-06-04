package Glory_Schema;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.*;

public class DBConnection {

    static Connection conObj;
    Statement stObj;

    public static Connection GetConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://db4free.net:3306/glorygame?autoReconnect=true&useSSL=false";
            conObj = DriverManager.getConnection(url, "glorygamedb", "553e27ec");

            //conObj = DriverManager.getConnection(url, "sql12241164", "JI6BCHXkTh");
            //String url = "jdbc:mysql://sql12.freemysqlhosting.net:3307/sql12241164";
            return conObj;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return conObj;
    }

}

/**
 *
 * @author Thanzeel
 */

package Glory_Schema;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.*;

public class DBConnection {

    Connection conObj;
    Statement stObj;

    public Connection GetConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
             String url = "jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12238630";

             conObj = DriverManager.getConnection(url, "sql12238630", "nLJ8lFIzqr");

            System.out.println("db connected");
            
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
            return conObj;
    }
}

/**
 *
 * @author Thanzeel
 */

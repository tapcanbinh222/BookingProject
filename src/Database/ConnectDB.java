
package Database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author trums
 */
public class ConnectDB {
     Connection con = null;

    public Connection GetConnectDB() {
        try {
            String url = "jdbc:sqlserver://localhost:1433;databaseName= FlightBookingDBTestV13;";
            String user = "sa";
            String password = "1";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url, user, password);
            
        } catch (Exception e) {
            System.out.println("cannot connect");
        }
        return con;
    }
}

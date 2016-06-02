package dal;

import java.sql.*;

/* Creates a connection to the DB */
public class DbConnection {
    Connection connection;

    public DbConnection() {
        createConnection();
    }

    private void createConnection() {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            connection =
                DriverManager.getConnection("jdbc:oracle:thin:@140.192.30.237:1521:def", "DESCOBAR", "cdm1210621");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public Connection getConnection() {
        return connection;
    }

}

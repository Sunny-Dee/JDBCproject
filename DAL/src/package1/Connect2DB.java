package package1;

import java.sql.*;

public class Connect2DB {
    public Connect2DB() {
        super();
    }
    
    public static void main(String[] args){
        try {
            //Class.forName("oracle.jdbc.driver.OracleDriver");
            DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
            
            Connection connection =
                DriverManager.getConnection("jdbc:oracle:thin:@140.192.30.237:1521:def", "DESCOBAR", "cdm1210621");
            
            Statement stmt = connection.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM RESTAURANT");
            while (rs.next()){
                System.out.println(rs.getString("RestaurantName"));
            }
            
            
        } catch (Exception ce) {
            ce.printStackTrace();
        }
    }
}

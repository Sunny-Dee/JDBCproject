package dal;

import java.sql.*;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class CreateQuery {
    private static ArrayList<String> restaurants;
    private String restaurant;
    private Connection connection;
     
    
    public CreateQuery() {
        restaurants = new ArrayList<String>();
        connection = new DbConnection().getConnection();
        getRestaurants();
        selectRestaurant();
    }
    
    public String getRestaurant(){
        return restaurant;
    }
    
    private void getRestaurants(){
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT RestaurantName FROM RESTAURANT");
            while (rs.next()){
                restaurants.add(rs.getString("RestaurantName"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        
    }
    
    //Ask the user to choose a restaurant that exists in the database
    public void selectRestaurant(){
        JFrame frame = new JFrame("Restaurant Selection");
        restaurant = (String) JOptionPane.showInputDialog(frame, 
                "Choose a restaurant from the list",
                "Choose one",
                JOptionPane.QUESTION_MESSAGE, 
                null, 
                restaurants.toArray(), 
                restaurants.get(0));
    }
    
    
    public ResultSet queryDb(){
        ResultSet report = null;
        try {
              
            String query = "SELECT r.Restaurantname, r.Address, r.Neighborhood, r.Av_Yelp_Stars, \n" + 
            "i.Inspection_Date, i.Grade, i.Risk\n" + 
            "FROM RESTAURANT r\n" + 
            "JOIN INSPECTION i\n" + 
            "ON r.RestaurantId = i.RestaurantId\n" + 
            "WHERE r.RestaurantName = '"+ restaurant +"'";
            
            Statement stmt = connection.createStatement();
            report = stmt.executeQuery(query);
        
            
        } catch (Exception e){
            e.printStackTrace();
        }  
        
        return report;
    }
    
    
    public void createReport(){
        String message = "";
        ResultSet report = queryDb();

        try {
            while (report.next()){
                message = "Restaurant name: " + report.getString("RestaurantName") + "\n" +
                    "Location: " + report.getString("Address") + "\n" +
                    "Neighborhood: " + report.getString("Neighborhood") + "\n" +
                    "Average Yelp Stars: " + report.getString("Av_Yelp_Stars") + "\n" +
                    "Last food inspection: " + report.getString("Inspection_Date").substring(0, 10) + "\n" +
                    "Grade: " + report.getString("Grade") + "\n" +
                    "Risk: " + report.getString("Risk");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        JFrame frame = new JFrame("Your Restaurant Selection");
        JOptionPane.showMessageDialog(frame, message);
    }
    
    
    
}

package dal;

import java.sql.Connection;

public class Main {
    public Main() {
        super();
    }
    
    public static void main(String [] args){
        
        CreateQuery ask = new CreateQuery();
        System.out.println(ask.getRestaurant());
        
        ask.createReport();

        //DbConnection c = new DbConnection();
        
    }
}

package dal;

/* Run this class to test the whole app */
public class Main {
    public Main() {
        super();
    }
    
    public static void main(String [] args){
        
        CreateQuery ask = new CreateQuery();
        System.out.println(ask.getRestaurant());
        
        ask.createReport();

        
    }
}

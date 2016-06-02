package dal;

import java.sql.*;
import java.util.Dictionary;

public class CreateStatement {
    Connection connection;
    String table;
    Dictionary<String, String> values;
    Statement stmt;
    
    public CreateStatement() {
        connection = new DbConnection().getConnection();
    }
    
    public void createStatement(){
        
    }
}

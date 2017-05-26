/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Data;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author tom
 */

public class  ConnectionSingleton {
    
    
    public Connection conn;
    public static ConnectionSingleton db;
    
    
    protected ConnectionSingleton() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/gameplatform","root","tomtom");
           
        
        }
        catch (Exception sqle) {
            sqle.printStackTrace();
        }
    }
   
    
    /**
     *
     * @return db
     */
    
    public static synchronized ConnectionSingleton getDbCon() {
        if ( db == null ) {
            db = new ConnectionSingleton();
        }
        return db;
 
    }
      
}
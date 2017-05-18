/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

/**
 *
 * @author LuKa
 */
public class connectDb {
	
	private static final  String url = "jdbc:mysql://localhost/gameplatform";
	private static final  String user = "root";
	private static final  String psw = "";
	
	
	private static Connection db;
	/**
	 * Metodo per la connessione al database
	 * @return Connection
	 */
	protected static Connection connect(){
		 try {   
			 db = DriverManager.getConnection(url,user,psw);
			} catch (SQLException ex) {
			    // handle any errors
			    System.out.println("SQLException: " + ex.getMessage());
			    System.out.println("SQLState: " + ex.getSQLState());
			    System.out.println("VendorError: " + ex.getErrorCode());
			}
		
		 return db;
	
		 
        }
  }



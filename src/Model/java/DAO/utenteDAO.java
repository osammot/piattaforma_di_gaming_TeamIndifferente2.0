/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import data.implement.utenteImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LuKa
 */
public class utenteDAO implements utenteInterface {
    
    
    /** ci consente di inserire un nuovo utente con i propri dati*/
    
    @Override
    public boolean signin( String username, String nome, String cognome, String password, String indirizzo, String email, String città, String ruolo) {
		Connection db = connectDb.connect();
		PreparedStatement pstmt;
		try {
		    pstmt = db.prepareStatement("INSERT INTO utente ( username, nome, cognome, password, indirizzo, email, città, ruolo) VALUES (?,?,?,?,?,?,?,?)");
		    pstmt.setString(1,username);
                    pstmt.setString(2,nome);
		    pstmt.setString(3,cognome);
                    pstmt.setString(4,password);
                    pstmt.setString(5,indirizzo);
                    pstmt.setString(6,email);
                    pstmt.setString(7,città);
                    pstmt.setString(8,ruolo);
                    
		    if (pstmt.execute()){
		    	return true;
		    }
		    pstmt.close();
		    db.close();
		}
		catch (SQLException ex){
		    
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		return false;
    }
    
    
    
    @Override
    public boolean promuoviUtente(String username, String ruolo){
		Connection db = connectDb.connect();
		PreparedStatement pstmt;
		try {
			pstmt= db.prepareStatement("UPDATE user SET gruppo=? WHERE username=?");
			pstmt.setString(1, ruolo);
			pstmt.setString(2, username);
			 if (pstmt.executeUpdate()>0){
				pstmt.close();
		    	db.close();
 		    	return true;
 		    }	
			 pstmt.close();
			 db.close();
		}
		catch (SQLException ex){
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		
		return false;
    }
    
    
    @Override
    public boolean eliminaUtente(String username) throws SQLException{
        
        try (Connection db = connectDb.connect()) {
            PreparedStatement pstmt;
            
            pstmt=db.prepareStatement("DELETE FROM utente WHERE username=?");
            pstmt.setString(1,username);
            if (pstmt.execute()){
                return true;
            }
            pstmt.close();
            db.close();
        }
		catch (SQLException ex){
		    
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		return false;
        }
    
    
    @Override
    public boolean modificaUtentePassword(String username, String password) throws SQLException{
            
            try (Connection db = connectDb.connect()) {
                PreparedStatement pstmt;
            
                pstmt=db.prepareStatement ("UPDATE utente SET password = ? WHERE username = ?");
                pstmt.setString(1, password);
                pstmt.setString(2,username);
                if (pstmt.executeUpdate()>0){
                return true;
                }
                pstmt.close();
                db.close();
            }
        
        return false;
                    
     }
    
    
    
    
    @Override
    public utenteImpl myProfile(String username) throws SQLException{ 
        
        utenteImpl utente;
        utente = new utenteImpl(this);
        ResultSet rs;
         try (Connection db = connectDb.connect()) {
            PreparedStatement pstmt;
            
            pstmt = db.prepareStatement("SELECT * FROM utente WHERE username=?");
        
        pstmt.setString(1, username);
        rs =  pstmt.executeQuery();
            if(rs.next()){
       /**String nome = rs.getString("name");*/
                utente.setNome(rs.getString("nome"));
                utente.setCognome(rs.getString("cognome"));
                utente.setIndirizzo(rs.getString("indirizzo"));
                utente.setCittà(rs.getString("citta"));
                utente.setEmail(rs.getString("email"));
                utente.setUsername(rs.getString("username"));
               /* utente.setPassword(rs.getString("password"));
                utente.setRuolo("role");*/
            }
     
         }
        return utente;
       }
    
    
    
    /**
     *
     * @param Username dell'utente  
     * @param password dell'utente
     * @return
     */
    @Override
    public utenteImpl loginUser(String Username, String password){
            utenteImpl utente = null;
            PreparedStatement pstmt;
            ResultSet rs;

            try (Connection db = connectDb.connect()){
                pstmt = db.prepareStatement("SELECT * FROM utente WHERE USERNAME=? AND PASSWORD=?");
                pstmt.setString(1,Username);
                pstmt.setString(2,password);
                 rs =  pstmt.executeQuery();
            
            utente=new utenteImpl(this);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(utenteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    return utente;
    }
    

    @Override
    public List<utenteImpl> selectlistUtente() throws SQLException{
        List<utenteImpl> listUtente = new ArrayList();
        
        ResultSet rs;
        
        try (Connection db = connectDb.connect()) {
            PreparedStatement pstmt;
            
            pstmt = db.prepareStatement("SELECT * FROM utente");
       
            rs =  pstmt.executeQuery();
            
            utenteImpl utente = new utenteImpl(this);
                utente.setNome(rs.getString("nome"));
                utente.setCognome(rs.getString("cognome"));
                utente.setIndirizzo(rs.getString("indirizzo"));
                utente.setCittà(rs.getString("citta"));
                utente.setEmail(rs.getString("email"));
                utente.setUsername(rs.getString("username"));
                utente.setPassword(rs.getString("password"));
                utente.setRuolo("ruolo");
            
               listUtente.add(utente);
    
    }
        return listUtente;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import data.implement.giocoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LuKa
 */
public class giocoDAO implements giocoInterface {
     /** ci permette di caricare/creare un nuovo gioco*/
    
    @Override
    public boolean creaGioco(String titolo, String genere, float mediaVoto, String descrizione, int valore, String path) {
		
		Connection conn = connectDb.connect();
		PreparedStatement pstmt;
	
		try {
				pstmt = conn.prepareStatement("SELECT * FROM gioco WHERE titolo= ?");
		    	pstmt.setString(1, titolo);
		    	if(!(pstmt.execute())){
		    		pstmt.close();
		    		conn.close();
		    		return false;
		    	}
		    	else{
		    		pstmt=(PreparedStatement) conn.prepareStatement("INSERT INTO gioco (titolo, genere, mediaVoto, descrizione, valore, path) VALUES ( ?, ?, ?, ?, ?, ?)");
		    		pstmt.setString(1, titolo);
		    		pstmt.setString(2, genere);
		    		pstmt.setFloat(3, mediaVoto);
                                pstmt.setString(4, descrizione);
                                pstmt.setInt(5, valore);
                                pstmt.setString(6, path);
		    		pstmt.execute();
		    		pstmt.close();
		    		conn.close();
		    		return true;
		    	}
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
    public boolean eliminaGioco(String titolo){
        try (Connection db = connectDb.connect()) {
            PreparedStatement pstmt;
            
            pstmt=db.prepareStatement("DELETE FROM gioco WHERE titolo=?");
            pstmt.setString(1,titolo);
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
    
    /**
     *
     * @param voto voto inserito
     * @param username dell'utente che inserisce il voto
     * @param titolo nome del gioco da votare
     * @return true: inserimento riuscito, false inserimento non riuscito
     */
    @Override
    public boolean votaGioco(int voto, String username, String titolo){
        try (Connection db = connectDb.connect()) {
            PreparedStatement pstmt;
            
            pstmt=db.prepareStatement("INSERT INTO voto VALUE (?,?,?)");
                    pstmt.setInt(1, voto);
                    pstmt.setString(2, username);
                    pstmt.setString(3, titolo);
                    if(pstmt.execute()){
                        return true;
                    }
                    pstmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(giocoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
     
    
    
    
    public boolean inserisciRecensione(String titoloRecensione, String testo) throws SQLException{
        try (Connection db = connectDb.connect()) {
            PreparedStatement pstmt;
            
            pstmt=db.prepareStatement("INSERT INTO recensione (titoloRecensione ,testo)values(?,?)");
            pstmt.setString(1, titoloRecensione);
            pstmt.setString(2, testo);
            
            
            if(pstmt.execute()){
                return true;
            }
            pstmt.close();
        }
         return false;
            
        
    }
    
    
    
    
    
    @Override
    public giocoImpl myGame (String titolo) throws SQLException{ 
        
        giocoImpl g;
        g = new giocoImpl(this);
        ResultSet rs;
         try (Connection db = connectDb.connect()) {
            PreparedStatement pstmt;
            
            pstmt = db.prepareStatement("SELECT * FROM gioco WHERE titolo=?");
        
        pstmt.setString(1, titolo);
        rs =  pstmt.executeQuery();
            if(rs.next()){
       /**String nome = rs.getString("name");*/
               
       
                g.setTitolo(rs.getString("titolo"));
                g.setGenere(rs.getString("genere"));
                g.setMediaVoto(rs.getInt("mediaVoto"));
                g.setDescrizione(rs.getString("descrizione"));
                            
            }
     
         }
        return g;
       } 

    @Override
    public boolean inserisciRecensione(String titolo, String text, String username, String nomeGioco) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
   
    
    
    
    
    
    
    
    
}

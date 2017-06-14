package data.model;

/** modifica, assegnatrofeo, aggiorna punteggio, */
import data.implement.UtenteImpl;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LuKa
 */
public class utenteDAO {

    /** ci consente di inserire un nuovo utente con i propri dati*/
    
    public boolean signin(String nome, String cognome, String username, String password, String indirizzo, String email, String città, String ruolo) {
		Connection db = connectDb.connect();
		PreparedStatement pstmt;
		try {
		    pstmt = db.prepareStatement("INSERT INTO user (nome, cognome, username, password, indirizzo, email, città, ruolo) VALUES (?,?,?,?,?,?,?,?)");
		    pstmt.setString(1,nome);
		    pstmt.setString(2,cognome);
		    pstmt.setString(3,username);
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


    /** permette da backoffice di promuovore/retrocedere un utente
     * @param username è l'utente al quale dovro modificare il ruolo, è identificativo
     * @param ruolo campo che modificato aggiungerà/toglierà funzioni
     * @return true, inserimento a buon fine, false inserimento non riuscito
     */

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
    
        public boolean eliminaUtente(String username) throws SQLException{
        
        try (Connection db = connectDb.connect()) {
            PreparedStatement pstmt;
            
            pstmt=db.prepareStatement("DELETE FROM user WHERE username=?");
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
        
        
        public boolean modificaUtentePassword(String username, String password) throws SQLException{
            
            try (Connection db = connectDb.connect()) {
                PreparedStatement pstmt;
            
                pstmt=db.prepareStatement ("UPDATE user SET password = ? WHERE username = ?");
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
        
        

        
        
        public boolean cambioIndirizzo(String username, String nIndirizzo) throws SQLException{
        try (Connection db = connectDb.connect()) {
            PreparedStatement pstmt;
            
            pstmt = db.prepareStatement("UPDATE user SET indirizzo=? WHERE username=?");
            pstmt.setString(1, username);
            pstmt.setString(2, nIndirizzo);
            if(pstmt.executeUpdate()>0){
                return true;
            }
            pstmt.close();
        }
         catch (SQLException ex){
                        System.out.println("SQLException: " + ex.getMessage());
                        System.out.println("SQLState: " + ex.getSQLState());
                        System.out.println("VendorError: " + ex.getErrorCode());
		}
        return false;
        }
        
        
        
        
      public UtenteImpl myProfile(String username) throws SQLException{ 
        
        UtenteImpl user;
        user = new UtenteImpl(this);
        ResultSet rs;
         try (Connection db = connectDb.connect()) {
            PreparedStatement pstmt;
            
            pstmt = db.prepareStatement("SELECT * FRM user WHERE username=?");
        
        pstmt.setString(1, username);
        rs =  pstmt.executeQuery();
            if(rs.next()){
       /**String nome = rs.getString("name");*/
                user.setNome("nome");
                user.setCognome(rs.getString("cognome"));
                user.setIndirizzo(rs.getString("indirizzo"));
                user.setCitta(rs.getString("citta"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole("role");
            }
     
         }
        return user;
       } 
      
      
      
      
      
      
      public List<UtenteImpl> selectListUser() throws SQLException{
        List<UtenteImpl> listUser = new ArrayList();
        
        ResultSet rs;
        
        try (Connection db = connectDb.connect()) {
            PreparedStatement pstmt;
            
            pstmt = db.prepareStatement("SELECT * FROM USER");
       
            rs =  pstmt.executeQuery();
            
            UtenteImpl user = new UtenteImpl(this);
                user.setNome(rs.getString("nome"));
                user.setCognome(rs.getString("cognome"));
                user.setIndirizzo(rs.getString("indirizzo"));
                user.setCitta(rs.getString("citta"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole("role");
            listUser.add(user);
    
    }
        return listUser;
    }
        
    /**
     *
     * @param Username dell'utente  
     * @param password dell'utente
     * @return
     */
    public UtenteImpl loginUser(String Username, String password){
            UtenteImpl utente = null;
            PreparedStatement pstmt;
            ResultSet rs;

            try (Connection db = connectDb.connect()){
                pstmt = db.prepareStatement("SELECT * FROM USER WHERE USERNAME=? AND PASSWORD=?");
                pstmt.setString(1,Username);
                pstmt.setString(2,password);
                 rs =  pstmt.executeQuery();
            
            utente=new UtenteImpl(this);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(utenteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    return utente;
    }
   
        
        
 }

    


    


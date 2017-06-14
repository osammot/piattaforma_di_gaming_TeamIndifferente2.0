package Data;


import Model.Utente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author tom
 */
public class UtenteDao {
    
    
    ConnectionSingleton cn = ConnectionSingleton.getDbCon();
    
    private PreparedStatement sUtente,sTOpGAMER ;
    private PreparedStatement checkUtente ;
    private PreparedStatement iUtente ;
    
   
    private ResultSet rs;
    
    
        public UtenteDao() throws SQLException{
            
            sUtente = cn.conn.prepareStatement("SELECT * FROM utente where username = ? ");
            iUtente = cn.conn.prepareStatement  ("insert into utente(username,nome,cognome,password,indirizzo,email,città,ruolo) value (?,?,?,?,?,?,?,?)");
            checkUtente = cn.conn.prepareStatement("SELECT * FROM utente WHERE username = ? and password = ?");
            
        }
        
        public Utente inserisciUtente(String username ,String password,String nome ,String cognome, String indirizzo ,
                String città , String email  ) throws SQLException{
            
            
            Utente user = new Utente();
            
            iUtente.setString(1, username);
            iUtente.setString(2, nome);
            iUtente.setString(3, cognome);
            iUtente.setString(4, password);
            iUtente.setString(5, indirizzo);
            iUtente.setString(6, email);
            iUtente.setString(7, città);
            iUtente.setString(8, "utente");
            if( iUtente.execute()){
                user = this.recuperaUtente(username);
            }
       
        
        return user;
        }
        
        
        
        public  Utente recuperaUtente(String username) throws SQLException {
       
            Utente utente = new Utente();
            
            sUtente.setString(1, username);
           
            rs = sUtente.executeQuery();
            
                if(rs.next()){
                
                    utente.setNome((String)rs.getString("nome"));
                    utente.setCognome((String)rs.getString("cognome"));
                    utente.setIndirizzo((String)rs.getString("indirizzo"));
                    utente.setCity((String)rs.getString("città"));
                    utente.setEmail((String)rs.getString("email"));
                    utente.setRuolo((String)rs.getString("ruolo"));
                    utente.setUsername(username);
                    utente.setPassword(rs.getString("password"));
                return utente;
                }
            
                
            return null;
        }
        
        public boolean checkLogin(String username , String password) throws SQLException{
            checkUtente.setString(1, username);
            checkUtente.setString(2, password);
            rs = checkUtente.executeQuery();
            if(rs.next())
            {
            
                return true ;
            
            }
            
            return false ;
        
        }
        

}
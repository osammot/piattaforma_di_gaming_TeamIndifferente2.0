package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author LuKa
 */
public class livelloDAO implements livelloInterface {
    
    
    @Override
    public boolean inserisciLivello(int id_livello, int numeroLivello, int punteggioProssimoLivello, String titolo, int id_trofeo) throws SQLException{
        try (Connection db = connectDb.connect()) {
            PreparedStatement pstmt;
            
            pstmt=db.prepareStatement("INSERT INTO livello (id_livello, numeroLivello, punteggioProssimoLivello, titolo, id_trofeo)values(?, ?, ?, ?, ?)");
            pstmt.setInt(1, id_livello);
            pstmt.setInt(2, numeroLivello);
            pstmt.setInt(3, punteggioProssimoLivello);
            pstmt.setString(4, titolo);
            pstmt.setInt(5, id_trofeo);
            
            if(pstmt.execute()){
                return true;
            }
            pstmt.close();
        }
         return false;
              
    }
    
    
    
    @Override
    public boolean eliminaLivello(int id_livello) throws SQLException{
        try (Connection db = connectDb.connect()) {
            PreparedStatement pstmt;
            
            pstmt=db.prepareStatement("DELETE FROM livello WHERE (id_livello) values(?)");
            pstmt.setInt(1, id_livello);
                
            if(pstmt.execute()){
                return true;
            }
            pstmt.close();
        }
         return false;
              
    }
    
    
    
}

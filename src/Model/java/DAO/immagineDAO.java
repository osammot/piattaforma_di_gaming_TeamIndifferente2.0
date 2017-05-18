package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author LuKa
 */
public class immagineDAO implements immagineInterface {
    
    @Override
    public boolean inserisciImmagine(int id_immagine, String path, String titolo) throws SQLException{
        try (Connection db = connectDb.connect()) {
            PreparedStatement pstmt;
            
            pstmt=db.prepareStatement("INSERT INTO gioco (id_immagine, path, titolo)values(?, ?, ?)");
            pstmt.setInt(1, id_immagine);
            pstmt.setString(2, path);
            pstmt.setString(3, titolo);
            
            if(pstmt.execute()){
                return true;
            }
            pstmt.close();
        }
         return false;
              
    }
    
    
    @Override
    public boolean eliminaImmagine(int id_immagine) throws SQLException{
        try (Connection db = connectDb.connect()) {
            PreparedStatement pstmt;
            
            pstmt=db.prepareStatement("DELETE FROM gioco WHERE (id_immagine)values(?)");
            pstmt.setInt(1, id_immagine);
                
            if(pstmt.execute()){
                return true;
            }
            pstmt.close();
        }
         return false;
              
    }
    
    
    
    
}

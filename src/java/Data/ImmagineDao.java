/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Model.Immagine;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author tom
 */
public class ImmagineDao {
    
    ConnectionSingleton cn = ConnectionSingleton.getDbCon();
    private PreparedStatement sImmagine ,sImmagineGioco ;
    private PreparedStatement iImage ;
    private  ResultSet rs;
    
    public ImmagineDao() throws SQLException{
    
        sImmagine=cn.conn.prepareStatement("SELECT * FROM immagine where id_immagine=? ");
        sImmagineGioco = cn.conn.prepareStatement(" SELECT * FROM immaginegioco left join immagine on immaginegioco.id_immagine = immagine.id_immagine where titolo = ?");
        
    }
    
        public Immagine recuperaImmeginePerGioco(String titologioco) throws SQLException{
               
            Immagine immagine = new Immagine();
            sImmagineGioco.setString(1, titologioco);
            rs = sImmagineGioco.executeQuery();
            if(rs.next()){
            immagine.setPath(rs.getString("pathImmagine"));
            immagine.setId_immagine(rs.getInt("id_immagine"));
            immagine.setTitolo(rs.getString("titoloImmagine"));
            }
            return immagine;
        
        }
        public  Immagine recuperaImmagine(int id) throws SQLException {
       
           
            Immagine immagine = new Immagine();

            sImmagine.setInt( 1 , id);
            rs = sImmagine.executeQuery();

                if(rs.next()){
                    immagine.setId_immagine(rs.getInt("id_immagine"));
                    immagine.setPath((String)rs.getString("pathImmagine"));
                    immagine.setTitolo ((String)rs.getString("titoloImmagine"));

                }
                      
        
            return immagine ;
        
        }
    
}

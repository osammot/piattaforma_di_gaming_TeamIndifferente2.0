/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Model.Immagine;
import Model.Trofeo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tom
 */
public class TrofeoDao {
 
     ConnectionSingleton cn = ConnectionSingleton.getDbCon();
    private PreparedStatement sTrofeo,sTrofeoVintiPerGioco ;
    private ResultSet rs ;
    
    
        public TrofeoDao() throws SQLException{

                sTrofeo = cn.conn.prepareStatement("SELECT * FROM trofeo where id_trofeo = ? ");
                sTrofeoVintiPerGioco = cn.conn.prepareStatement("SELECT * FROM trofeo where username = ? and titologioco = ?");
            }
    
            
        public List<Trofeo> trofeiVintiPerGioco(String username , String gioco) throws SQLException{
        /*ritorna la lista dei trofei vinti su gioco*/
        List <Trofeo> listatrofei = new ArrayList();
        sTrofeoVintiPerGioco.setString(1, username);
        sTrofeoVintiPerGioco.setString(1, gioco);
        rs = sTrofeoVintiPerGioco.executeQuery();
        
        while(rs.next()){
          
            Trofeo trofeo =  this.assegnaTrofeo(rs.getInt("id_trofeo"));
            
            listatrofei.add(trofeo);
        }
        return listatrofei ;
        }
        
        
        public List<Trofeo> trofeiVintiPerSistema(String username ){
        /*ritorna la lista dei trofei vinti su tutti i giochi*/
        List <Trofeo> listatrofei = new ArrayList();
        return listatrofei ;
        }
        
            public Trofeo assegnaTrofeo(int id) throws SQLException{
            
            Trofeo trofeo = new Trofeo();
            
            sTrofeo.setInt(1, id);
            rs = sTrofeo.executeQuery();
            
                if(rs.next()){
                
                    ImmagineDao im = new ImmagineDao();
                    Immagine immagine = im.recuperaImmagine(rs.getInt("id_immagine"));
                    
                    
                    trofeo.setImmagine(immagine);
                    trofeo.setNome((String)rs.getString("nome"));
                    
                
                }
            return trofeo;
            }
            
}

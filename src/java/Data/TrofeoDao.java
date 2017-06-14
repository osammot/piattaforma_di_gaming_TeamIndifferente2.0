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
    private PreparedStatement sTrofeo,sTrofeoVintiPerGioco,sTrofeiVintiPerUtente ,sListTrofei;
    private PreparedStatement dTrofeo ;
    private ResultSet rs ;
    
    
    
        public TrofeoDao() throws SQLException{
                sTrofeiVintiPerUtente = cn.conn.prepareStatement(" select * from utentetrofeo left join trofeo on utentetrofeo.id_trofeo = trofeo.id_trofeo where utentetrofeo.username = ?");
                sTrofeo = cn.conn.prepareStatement("SELECT * FROM trofeo where id_trofeo = ? ");
                sTrofeoVintiPerGioco = cn.conn.prepareStatement("SELECT * FROM trofeo where username = ? and titologioco = ?");
                sListTrofei = cn.conn.prepareStatement("SELECT * FROM trofeo ");
                dTrofeo = cn.conn.prepareStatement("DELETE FROM trofeo WHERE id_trofeo = ?");
        
        }
    
            
         public List<Trofeo> trofeiVinti(String username ) throws SQLException{
        /*ritorna la lista dei trofei vinti su gioco*/
        List <Trofeo> listatrofei = new ArrayList();
        sTrofeiVintiPerUtente.setString(1, username);
        ResultSet rsList;
        rsList = sTrofeiVintiPerUtente.executeQuery();
        
        while(rsList.next()){
          
            Trofeo trofeo =  this.getTrofeo(rsList.getInt("id_trofeo"));
            
            listatrofei.add(trofeo);
        }
        return listatrofei ;
        }
         
        public List<Trofeo> trofeiVintiPerGioco(String username , String gioco) throws SQLException{
        /*ritorna la lista dei trofei vinti su gioco*/
        List <Trofeo> listatrofei = new ArrayList();
        sTrofeoVintiPerGioco.setString(1, username);
        sTrofeoVintiPerGioco.setString(1, gioco);
        rs = sTrofeoVintiPerGioco.executeQuery();
        
        while(rs.next()){
          
            Trofeo trofeo =  this.getTrofeo(rs.getInt("id_trofeo"));
            
            listatrofei.add(trofeo);
        }
        return listatrofei ;
        }
        
        
        
        public List<Trofeo> listTrofei() throws SQLException{
        /*ritorna la lista dei trofei vinti su tutti i giochi*/
        List <Trofeo> listatrofei = new ArrayList();
        ResultSet listT = sListTrofei.executeQuery();
        while(listT.next()){
            Trofeo trofeo = this.getTrofeo(listT.getInt("id_trofeo"));
            listatrofei.add(trofeo);
            }
        return listatrofei ;
        }
        
        public Trofeo getTrofeo(int id) throws SQLException{
            
            Trofeo trofeo = new Trofeo();
            
            sTrofeo.setInt(1, id);
            ResultSet srs = sTrofeo.executeQuery();
            
                if(srs.next()){
                
                    ImmagineDao im = new ImmagineDao();
                    Immagine immagine = im.recuperaImmagine(srs.getInt("id_immaginetrofeo"));
                    trofeo.setImmagine(immagine);
                    trofeo.setId_trofeo(srs.getInt("id_trofeo"));
                    trofeo.setNome((String)srs.getString("nome"));
                    System.out.println((String)srs.getString("nome"));
                }
            return trofeo;
        } 
        public void deleteTrofeo(int id) throws SQLException{
        
            dTrofeo.setInt(1, id);
            dTrofeo.execute();
        
        }
            
             
            
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Model.Livello;
import Model.Partita;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author tom
 */
public class PartitaDao {
    
    ConnectionSingleton cn = ConnectionSingleton.getDbCon();
    private PreparedStatement sPartita ;
    private ResultSet rs ;
    
    public PartitaDao() throws SQLException{
        
        
            sPartita = cn.conn.prepareStatement("SELECT * FROM partita where usernamepartita = ? and id_livellopartita = ? order by punteggio limit 1 ");
    }     
        
    public Partita recuperaPartita(String username ,String gioco ) throws SQLException{
    
    Partita partita = new Partita();    
    sPartita.setString(1, username);
    sPartita.setString(2, gioco);
    rs = sPartita.executeQuery();
    
            if (rs.next()){

                partita.setPunteggio(rs.getInt("punteggio"));
                LivelloDao lvlDao = new LivelloDao();
                Livello livello = lvlDao.recuperaLivello(rs.getInt("id_livellopartita"));
                partita.setPunteggio(rs.getInt("punteggio"));
                partita.setLivello(livello);


            }
    
    
    return partita;
    }
    
    
    public List<Partita> recuperaListaPartiteGiocate(String username ,String gioco){
    List<Partita> listapartita = new ArrayList();
    return listapartita;
    }
}

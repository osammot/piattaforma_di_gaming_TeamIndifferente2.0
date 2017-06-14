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
    private PreparedStatement sPartita ,sTOpGAMER,sListaPartite,createPartita;
    private ResultSet rs ;
    
    public PartitaDao() throws SQLException
    {
        sListaPartite = cn.conn.prepareStatement("SELECT * FROM partita WHERE titologiocopartita= ? AND usernamepartita = ? ORDER BY data");
       
        sPartita = cn.conn.prepareStatement("SELECT * FROM partita WHERE id_partita = ? ");
        createPartita = cn.conn.prepareStatement("insert into partita (punteggio,usernamepartita,id_livellopartita,titologiocopartita) value (0,?,1,?)");
    }     
        
    public Partita recuperaPartita(int id) throws SQLException{
    
    Partita partita = new Partita();    
    sPartita.setInt(1, id);
    
    rs = sPartita.executeQuery();
    
            if (rs.next())
            {
                partita.setPunteggio(rs.getInt("punteggio"));
                LivelloDao lvlDao = new LivelloDao();
                Livello livello = lvlDao.recuperaLivello(rs.getInt("id_livellopartita"));
                partita.setPunteggio(rs.getInt("punteggio"));
                partita.setLivello(livello);
            }
    return partita;
    }
    
    
    public List<Partita> recuperaListaPartiteGiocate(String username ,String gioco) throws SQLException{
    List<Partita> listapartita = new ArrayList();
    ResultSet rsList;
    
    sListaPartite.setString(1, gioco);
    sListaPartite.setString(2, username);
    rsList = sListaPartite.executeQuery();
    
    
    while(rsList.next())
    {
        
    Partita partita = this.recuperaPartita(rsList.getInt("id_partita"));
    listapartita.add(partita);
    
    }
    return listapartita;
    }

    public Partita createPartita(String username,String titologioco) throws SQLException{
        
        Partita partita = new Partita();
        
        createPartita.setString(1, username);
        createPartita.setString(2, titologioco);
    
        rs = createPartita.executeQuery();
            if (rs.next())
                {
                    partita.setPunteggio(rs.getInt("punteggio"));
                    LivelloDao lvlDao = new LivelloDao();
                    Livello livello = lvlDao.recuperaLivello(rs.getInt("id_livellopartita"));
                    partita.setPunteggio(rs.getInt("punteggio"));
                    partita.setLivello(livello);
                }
        return partita;
    }




}

    

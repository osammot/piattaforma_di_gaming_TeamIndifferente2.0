
package Data;

import Model.Gioco;
import Model.Immagine;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GiocoDao {
    
    ConnectionSingleton cn = ConnectionSingleton.getDbCon();
    private PreparedStatement sGioco ,sListaGioco,sListaGiocoPerValore,sListNameGame, sVoto ,sVotoPerTitolo;
    private PreparedStatement iVoto;
    private PreparedStatement uVoto,uMediaVoto;
    private ResultSet rs ;
    
    
        public GiocoDao() throws SQLException {
            sListNameGame = cn.conn.prepareStatement("SELECT titolo FROM gioco ");
            sGioco      =cn.conn.prepareStatement("SELECT * FROM gioco where titolo = ? ");
            sListaGioco =cn.conn.prepareStatement("SELECT titolo FROM gioco  ");
            sListaGiocoPerValore =cn.conn.prepareStatement("SELECT * FROM gioco ORDER BY valore DESC LIMIT 3 ");
            sVoto       = cn.conn.prepareStatement(" SELECT * FROM voto WHERE usernamevoto = ? AND titologiocovoto = ?");
            uVoto       = cn.conn.prepareStatement(" update voto set voto=? where usernamevoto = ? and titologiocovoto = ?");
            iVoto       = cn.conn.prepareStatement("INSERT INTO voto VALUE (?,?,?)");
            sVotoPerTitolo = cn.conn.prepareStatement("select * from voto where titologiocovoto = ?");
            uMediaVoto = cn.conn.prepareStatement("update gioco set mediavoto=? where titolo = ? ");
        }

        
        
        public Gioco recuperaGioco(String titolo) throws SQLException{
        Gioco gioco = new Gioco();
        sGioco.setString(1, titolo);
        rs = sGioco.executeQuery();
            if(rs.next()){

                gioco.setTitolo(titolo);
                gioco.setGenere(rs.getString("genere"));
                gioco.setDescrizione(rs.getString("descrizione"));
                gioco.setMediavoto(rs.getFloat("mediaVoto"));
                
                
                ImmagineDao a = new ImmagineDao();
                Immagine immaginegioco = a.recuperaImmeginePerGioco(titolo);
                gioco.setImmagine(immaginegioco);
                
                gioco.setValore(rs.getInt("valore"));
                gioco.setTemplate(rs.getString("template"));
                
            }
        
        return gioco ;

        }
        
        
    public List <Gioco> getListaGiochi() throws SQLException{
    ResultSet rsqu ;
        List<Gioco> listgame = new ArrayList();
        
        rsqu = sListaGioco.executeQuery();
        
        while (rsqu.next()){
        
            Gioco game = recuperaGioco(rsqu.getString("titolo"));
        
            listgame.add(game);
        }
        
        return listgame;
    }
    
    
    /*  select titolo,mediavoto,valore from gioco order by valore desc limit 3; */
    public List <Gioco> getListaGiochiPerValore() throws SQLException{
    
    ResultSet rsqu ;
        List<Gioco> listgame = new ArrayList();
        
        rsqu = sListaGiocoPerValore.executeQuery();
        
        while (rsqu.next()){
        
            Gioco game = recuperaGioco(rsqu.getString("titolo"));
        
            listgame.add(game);
        }
        
        return listgame; 
    }
    
    
    public void voto (String username,String titologioco, int vote) throws SQLException{
    
        sVoto.setString(1, username);
        sVoto.setString(2, titologioco);
        System.out.println(sVoto);
        rs = sVoto.executeQuery();
        
        if(rs.next())
        {
            uVoto.setInt(1, vote);
            uVoto.setString(2, username);
            uVoto.setString(3, titologioco);
            System.out.println(uVoto);
            uVoto.executeUpdate();
            
        }
        else
        {
            iVoto.setString(1, username);
            iVoto.setString(2, titologioco);
            iVoto.setInt(3, vote);
            System.out.println(iVoto);
            iVoto.executeUpdate();
            
        }
        this.setMediaVoto(titologioco);
    }

    public void setMediaVoto(String titoloGioco) throws SQLException
    {
          //seleziona tutti i voti per quel gioco
    sVotoPerTitolo.setString(1, titoloGioco);
    rs = sVotoPerTitolo.executeQuery();
    
    float mediavoto =0;
    int count =0;
     // update mediavoto perquel gioco
     
     while(rs.next()){
     count++;
     mediavoto+= rs.getInt("voto");
     
     
     }
     mediavoto= mediavoto/count;
     uMediaVoto.setFloat(1, mediavoto);
     uMediaVoto.setString(2, titoloGioco);
     uMediaVoto.execute();
    }
    
    public List<String>getListNameGame() throws SQLException{
        
        List<String> listgame = new ArrayList();
        rs = sListNameGame.executeQuery();
        
            while(rs.next()){
            
                String temp = rs.getString("titolo");
                listgame.add(temp);
            }
            
    return listgame;
    }
}

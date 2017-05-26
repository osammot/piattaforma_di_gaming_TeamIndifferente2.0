
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
    private PreparedStatement sGioco ,sListaGioco,sListaGiocoOrdinata;
    private ResultSet rs ;
    
    
        public GiocoDao() throws SQLException{

            sGioco=cn.conn.prepareStatement("SELECT * FROM gioco where titolo = ? ");
            sListaGioco=cn.conn.prepareStatement("SELECT titolo FROM gioco  ");
            
            //sListaGiocoOrdinata=cn.conn.prepareStatement("SELECT titolo FROM gioco order by ? ");
        }

        
        
        public Gioco recuperaGioco(String titolo) throws SQLException{
        Gioco gioco = new Gioco();
        sGioco.setString(1, titolo);
        rs = sGioco.executeQuery();
            if(rs.next()){

                gioco.setTitolo(titolo);
                gioco.setGenere(rs.getString("genere"));
                gioco.setDescrizione(rs.getString("descrizione"));
                
                
                
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
}

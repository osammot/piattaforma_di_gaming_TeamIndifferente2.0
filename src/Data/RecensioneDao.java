
package Data;

import Model.Recensione;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class RecensioneDao {


    ConnectionSingleton cn = ConnectionSingleton.getDbCon();
    private PreparedStatement sRecensione ;
    private PreparedStatement iRecensione ;
    private PreparedStatement sListRecensione ;
    private ResultSet rs ;
    public RecensioneDao() throws SQLException{
    
        sRecensione = cn.conn.prepareStatement("SELECT * FROM recensione where id_recensione=? ");
        sListRecensione = cn.conn.prepareStatement("SELECT * FROM recensione where titologiocorec = ? order by datainserimento");
        iRecensione = cn.conn.prepareStatement("INSERT INTO recensione ( titoloRecensione,testo,usernamerec,titologiocorec )value (?,?,?,?)");
    
    }
    
    
    public Recensione getRecensione(int id_recensione) throws SQLException{
    
        Recensione rec = new Recensione();
       
        sRecensione.setInt(1, id_recensione);
        rs = sRecensione.executeQuery();
        
        if(rs.next())
        {
            rec.setUsername(rs.getString("usernamerec"));
            rec.setTesto(rs.getString("titoloRecensione"));
            rec.setTitoloRecensione(rs.getString("testo"));
            rec.setDataInserimentoRecensione(rs.getDate("datainserimento"));
        }
        
        return rec ;
        
        }
    
    
        
        public boolean insertRecensione(String titolo,String testo, String usernamerec,String titologiocorec) throws SQLException{
        
        
            iRecensione.setString(1, titolo);
            iRecensione.setString(2,testo);
            iRecensione.setString(3,usernamerec);
            iRecensione.setString(4,titologiocorec);
                
            if(iRecensione.execute()){
            
                return true ;
            }
            return false ;
        
        }

        public List<Recensione> listaRecensioni(String titologioco) throws SQLException{
        List<Recensione> listaRec = new ArrayList();
        
        sListRecensione.setString(1, titologioco);
        
            rs = sListRecensione.executeQuery();
            
            while (rs.next()){
            
                Recensione rec = new Recensione();
                rec = this.getRecensione(rs.getInt("id_recensione"));
                listaRec.add(rec);
            }
            return listaRec;
        }
    
}



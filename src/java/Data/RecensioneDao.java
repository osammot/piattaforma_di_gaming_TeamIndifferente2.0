
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
    private PreparedStatement sListRecensioniBO;
    private PreparedStatement approvaRec, declineRec;
    private ResultSet rs ;


    public RecensioneDao() throws SQLException{
    
        sRecensione = cn.conn.prepareStatement("SELECT * FROM recensione where id_recensione=? ");
        sListRecensione = cn.conn.prepareStatement("SELECT * FROM recensione where titologiocorec = ? and approvata = true order by datainserimento");
        iRecensione = cn.conn.prepareStatement("INSERT INTO recensione ( titoloRecensione,testo,usernamerec,titologiocorec )value (?,?,?,?)");
        sListRecensioniBO = cn.conn.prepareStatement("SELECT * FROM recensione where approvata = false order by datainserimento");
        approvaRec = cn.conn.prepareStatement ("UPDATE recensione SET approvata = true WHERE id_recensione = ?");
        declineRec= cn.conn.prepareStatement("DELETE FROM recensione WHERE id_reccensione = ?");
    }
    
    public void approveRec(int id_rec) throws SQLException{
    
    approvaRec.setInt(1, id_rec);
    approvaRec.execute();
    }
    
    public void declineRec(int id_rec) throws SQLException{
    
    declineRec.setInt(1, id_rec);
    declineRec.execute();
    }
    
    public Recensione getRecensione(int id_recensione) throws SQLException{
    
        Recensione rec = new Recensione();
       
        sRecensione.setInt(1, id_recensione);
        rs = sRecensione.executeQuery();
        
        if(rs.next())
        {
            rec.setId_recensione(rs.getInt("id_recensione"));
            rec.setUsername(rs.getString("usernamerec"));
            rec.setTesto(rs.getString("testo"));
            rec.setTitoloRecensione(rs.getString("titoloRecensione"));
            rec.setDataInserimentoRecensione(rs.getDate("datainserimento"));
            rec.setTitologiocorec(rs.getString("titologiocorec"));
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
        
           ResultSet rsa = sListRecensione.executeQuery();
            
            while (rsa.next()){
            
                Recensione rec = new Recensione();
                rec = this.getRecensione(rsa.getInt("id_recensione"));
                listaRec.add(rec);
            }
            return listaRec;
        }
        
        
        public List<Recensione> listaRecensioniBO() throws SQLException{
        List<Recensione> listaRec = new ArrayList();
        
       
        
           ResultSet rsa = sListRecensioniBO.executeQuery();
            
            while (rsa.next()){
            
                Recensione rec = new Recensione();
                rec = this.getRecensione(rsa.getInt("id_recensione"));
                listaRec.add(rec);
            }
            return listaRec;
        }
    
}



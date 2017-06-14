
package Data;

import Model.Posizione;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PosizioneDao {

    ConnectionSingleton cn = ConnectionSingleton.getDbCon();
    private PreparedStatement sClassificaGenerale,sClassificaPerGioco,sPunteggio;
    private ResultSet rs ;
    
    public PosizioneDao() throws SQLException
    {
        
        sClassificaGenerale = cn.conn.prepareStatement(" SELECT sum(punteggio),usernamepartita from partita group by usernamepartita order by sum(punteggio) desc ");
        sClassificaPerGioco = cn.conn.prepareStatement(" SELECT sum(punteggio),usernamepartita from partita where titologiocopartita = ? group by usernamepartita order by sum(punteggio) desc ");
        sPunteggio = cn.conn.prepareStatement(" SELECT  SUM(punteggio) from partita where titologiocopartita = ?  and usernamepartita = ?" );
    }
    
    
    public int Punteggio (String titolo,String username) throws SQLException{
   
        int punteggio=0;
        sPunteggio.setString(1, titolo);
        sPunteggio.setString(2, username);
        rs = sPunteggio.executeQuery();

        if(rs.next())
        {
            punteggio = rs.getInt("sum(punteggio)");
        }
    
        return punteggio;
    }
    
     public List<Posizione> classificaPerPunteggioGioco(String nomegioco) throws SQLException{
        List<Posizione> lista = new ArrayList();
        
        sClassificaPerGioco.setString(1, nomegioco);
        
        ResultSet rsList = sClassificaPerGioco.executeQuery();
        
            while (rsList.next())
            {
                Posizione posizione = new Posizione();
                UtenteDao userdao = new UtenteDao();
                posizione.setUser( userdao.recuperaUtente(rsList.getString("usernamepartita")));
                posizione.setPunteggio(this.Punteggio(nomegioco, posizione.getUser().getUsername()));
                lista.add(posizione);
            }
        return  lista ;
        
     }
       
         public List<Posizione> classificaPerPunteggioGenerale() throws SQLException{
        List<Posizione> lista = new ArrayList();
        
       ResultSet rsList = sClassificaGenerale.executeQuery();
        
            while (rsList.next())
            {
                Posizione posizione = new Posizione();
                UtenteDao userdao = new UtenteDao();
                posizione.setUser( userdao.recuperaUtente(rsList.getString("usernamepartita")));
                posizione.setPunteggio(rsList.getInt("sum(punteggio)"));
                lista.add(posizione);
            }
        return  lista ;
        }


        

}

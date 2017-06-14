/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Model.Livello;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author tom
 */
public class LivelloDao {
    
    
    ConnectionSingleton cn = ConnectionSingleton.getDbCon();
    private PreparedStatement sLivello ;
    private ResultSet rs ;
    
    
        public LivelloDao() throws SQLException{

                sLivello = cn.conn.prepareStatement("SELECT * FROM livello where id_livello = ? ");

            }

        
        
        
                public Livello recuperaLivello(int id) throws SQLException{

                Livello lvl = new Livello();

                sLivello.setInt(1, id);
                rs = sLivello.executeQuery();

                    if(rs.next()){

                        
                        lvl.setNumeroLivello(rs.getInt("numeroLivello"));
                        lvl.setPunteggioProssimoLivello(rs.getInt("numeroProssimoLivello"));
                        lvl.setTitolo(rs.getString("titolo"));
                        /*set Trofeo*/

                    }

                return lvl;

                }

    
}

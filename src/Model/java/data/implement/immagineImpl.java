package data.implement;

import DAO.immagineDAO;
import DAO.immagineInterface;
import java.sql.SQLException;

/**
 *
 * @author LuKa
 */
public class immagineImpl implements immagineInterface {
    
    private int id_immagine;
    private String path;
    private String titolo;
    
    public immagineImpl(immagineDAO immagine){
        id_immagine=0;
        path="";
        titolo="";
    }    

    /**
     * @return the id_immagine
     */
    public int getId_immagine() {
        return id_immagine;
    }

    /**
     * @param id_immagine the id_immagine to set
     */
    public void setId_immagine(int id_immagine) {
        this.id_immagine = id_immagine;
    }

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return the titolo
     */
    public String getTitolo() {
        return titolo;
    }

    /**
     * @param titolo the titolo to set
     */
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    @Override
    public boolean eliminaImmagine(int id_immagine) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean inserisciImmagine(int id_immagine, String path, String titolo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

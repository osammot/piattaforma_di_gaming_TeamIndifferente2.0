package data.implement;

import DAO.livelloDAO;
import DAO.livelloInterface;
import java.sql.SQLException;

/**
 *
 * @author LuKa
 */
public class livelloImpl implements livelloInterface {
    
    private int id_livello;
    private int numeroLivello;
    private int punteggioProssimoLivello;
    private String titolo;
    private int id_trofeo;
    
    
    public livelloImpl(livelloDAO livello){
        id_livello=0;
        numeroLivello=0;
        punteggioProssimoLivello=0;
        titolo="";
        id_trofeo=0;
    }

    /**
     * @return the id_livello
     */
    public int getId_livello() {
        return id_livello;
    }

    /**
     * @param id_livello the id_livello to set
     */
    public void setId_livello(int id_livello) {
        this.id_livello = id_livello;
    }

    /**
     * @return the numeroLivello
     */
    public int getNumeroLivello() {
        return numeroLivello;
    }

    /**
     * @param numeroLivello the numeroLivello to set
     */
    public void setNumeroLivello(int numeroLivello) {
        this.numeroLivello = numeroLivello;
    }

    /**
     * @return the punteggioProssimoLivello
     */
    public int getPunteggioProssimoLivello() {
        return punteggioProssimoLivello;
    }

    /**
     * @param punteggioProssimoLivello the punteggioProssimoLivello to set
     */
    public void setPunteggioProssimoLivello(int punteggioProssimoLivello) {
        this.punteggioProssimoLivello = punteggioProssimoLivello;
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

    /**
     * @return the id_trofeo
     */
    public int getId_trofeo() {
        return id_trofeo;
    }

    /**
     * @param id_trofeo the id_trofeo to set
     */
    public void setId_trofeo(int id_trofeo) {
        this.id_trofeo = id_trofeo;
    }

    @Override
    public boolean eliminaLivello(int id_livello) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean inserisciLivello(int id_livello, int numeroLivello, int punteggioProssimoLivello, String titolo, int id_trofeo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

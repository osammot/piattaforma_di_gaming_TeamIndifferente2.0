package data.implement;

import DAO.giocoDAO;
import DAO.giocoInterface;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author LuKa
 */
  public class giocoImpl implements giocoInterface {  
    
    private String titolo;
    private String genere;
    private float mediaVoto;
    private String descrizione;
    private int valore;
    private String path;
    private Date dataInserimentoGioco;
    
    
    public giocoImpl(giocoDAO gioco){
        
        titolo="";
        genere="";
        mediaVoto=0;
        descrizione="";
        valore=0;
        path="";
        dataInserimentoGioco=null;
      
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
     * @return the genere
     */
    public String getGenere() {
        return genere;
    }

    /**
     * @param genere the genere to set
     */
    public void setGenere(String genere) {
        this.genere = genere;
    }

    /**
     * @return the mediaVoto
     */
    public float getMediaVoto() {
        return mediaVoto;
    }

    /**
     * @param mediaVoto the mediaVoto to set
     */
    public void setMediaVoto(float mediaVoto) {
        this.mediaVoto = mediaVoto;
    }

    /**
     * @return the descrizione
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * @param descrizione the descrizione to set
     */
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    /**
     * @return the valore
     */
    public int getValore() {
        return valore;
    }

    /**
     * @param valore the valore to set
     */
    public void setValore(int valore) {
        this.valore = valore;
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
     * @return the dataInserimentoGioco
     */
    public Date getDataInserimentoGioco() {
        return dataInserimentoGioco;
    }

    /**
     * @param dataInserimentoGioco the dataInserimentoGioco to set
     */
    public void setDataInserimentoGioco(Date dataInserimentoGioco) {
        this.dataInserimentoGioco = dataInserimentoGioco;
    }

    @Override
    public boolean creaGioco(String titolo, String genere, float mediaVoto, String descrizione, int valore, String path) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminaGioco(String titolo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean inserisciRecensione(String titolo, String text, String username, String nomeGioco) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public giocoImpl myGame(String titolo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean votaGioco(int voto, String username, String nomeGioco) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

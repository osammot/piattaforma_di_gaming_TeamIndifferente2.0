package data.implement;

import java.util.Date;



/**
 *
 * @author LuKa
 */
public class recensioneImpl {
    
    private int id_recensione;
    private String titoloRecensione;
    private String testo;
    private boolean approvato;
    private Date dataInserimentoRecensione;
    private String username;
    private String titoloGioco;
    
    
    public recensioneImpl(){
        id_recensione=0;
        titoloRecensione="";
        testo="";
        approvato=false;
        dataInserimentoRecensione=null;
        username="";
        titoloGioco="";
        
    }

    /**
     * @return the id_recensione
     */
    public int getId_recensione() {
        return id_recensione;
    }

    /**
     * @param id_recensione the id_recensione to set
     */
    public void setId_recensione(int id_recensione) {
        this.id_recensione = id_recensione;
    }

    /**
     * @return the titoloRecensione
     */
    public String getTitoloRecensione() {
        return titoloRecensione;
    }

    /**
     * @param titoloRecensione the titoloRecensione to set
     */
    public void setTitoloRecensione(String titoloRecensione) {
        this.titoloRecensione = titoloRecensione;
    }

    /**
     * @return the testo
     */
    public String getTesto() {
        return testo;
    }

    /**
     * @param testo the testo to set
     */
    public void setTesto(String testo) {
        this.testo = testo;
    }

    /**
     * @return the approvato
     */
    public boolean isApprovato() {
        return approvato;
    }

    /**
     * @param approvato the approvato to set
     */
    public void setApprovato(boolean approvato) {
        this.approvato = approvato;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the titoloGioco
     */
    public String getTitoloGioco() {
        return titoloGioco;
    }

    /**
     * @param titoloGioco the titoloGioco to set
     */
    public void setTitoloGioco(String titoloGioco) {
        this.titoloGioco = titoloGioco;
    }
    
}

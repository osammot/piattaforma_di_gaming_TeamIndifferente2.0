package data.implement;

import java.util.Date;

/**
 *
 * @author LuKa
 */
public class partitaImpl {
    
    private int id_partita;
    private int punteggio;
    private Date data;
    private String username;
    private int id_livello;
    
    
    public partitaImpl(){
        id_partita=0;
        punteggio=0;
        data=null;
        username="";
        id_livello=0;
    }

    /**
     * @return the id_partita
     */
    public int getId_partita() {
        return id_partita;
    }

    /**
     * @param id_partita the id_partita to set
     */
    public void setId_partita(int id_partita) {
        this.id_partita = id_partita;
    }

    /**
     * @return the punteggio
     */
    public int getPunteggio() {
        return punteggio;
    }

    /**
     * @param punteggio the punteggio to set
     */
    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
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
    
}

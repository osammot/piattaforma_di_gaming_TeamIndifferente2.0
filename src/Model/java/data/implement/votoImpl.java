package data.implement;

import java.util.Date;

/**
 *
 * @author LuKa
 */
public class votoImpl {
    
    private int id_voto;
    private int valore;
    private Date data_voto;
    private String username;
    private String titolo;
    
    public votoImpl(){
        
        id_voto=0;
        valore=0;
        data_voto=null;
        username="";
        titolo="";
        
      
    }

    /**
     * @return the id_voto
     */
    public int getId_voto() {
        return id_voto;
    }

    /**
     * @param id_voto the id_voto to set
     */
    public void setId_voto(int id_voto) {
        this.id_voto = id_voto;
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
     * @return the data_voto
     */
    public Date getData_voto() {
        return data_voto;
    }

    /**
     * @param data_voto the data_voto to set
     */
    public void setData_voto(Date data_voto) {
        this.data_voto = data_voto;
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
    
    
    
}

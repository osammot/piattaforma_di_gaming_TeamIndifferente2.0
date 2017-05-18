package data.implement;

/**
 *
 * @author LuKa
 */
public class trofeoImpl {
    
    private int id_trofeo;
    private String nome;
    private immagineImpl immagine;
    
    
    public trofeoImpl(){
        id_trofeo=0;
        nome="";
        immagine = null;
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

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the immagine
     */
    public immagineImpl getImmagine() {
        return immagine;
    }

    /**
     * @param immagine the immagine to set
     */
    public void setImmagine(immagineImpl immagine) {
        this.immagine = immagine;
    }
    
}

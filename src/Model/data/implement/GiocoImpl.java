package data.implement;

import data.model.Gioco;
import data.model.Recensione;
import data.model.giocoDAO;
import java.util.ArrayList;

/**
 *
 * @author LuKa
 */
public class GiocoImpl implements Gioco{
    private int id_gioco;
    private String titolo;
    private String genere;
    private String descrizione;
    private String path;
    private float mediaVoto;
    private int valore;
    ArrayList<Recensione> listRecensioni ;
    
    public GiocoImpl(giocoDAO gioco){
        this.id_gioco=0;
        this.titolo="";
        this.genere="";
        this.descrizione="";
        this.path="";
        this.mediaVoto=0;
        this.valore=0;
    }
    
    @Override
    public int getId_gioco(){
        return id_gioco;
    }
    
    @Override
    public String getTitolo(){
        return titolo;
    }
    
    @Override
    public String getGenere(){
        return genere;
    }
    
    @Override
    public String getDescrizione(){
        return descrizione;
    }
    
    @Override
    public String getPath(){
        return path;
    }
    
    @Override
    public float getMediaVoto(){
        return mediaVoto;
    }
    
    @Override
    public int getValore(){
        return valore;
    }
    
    @Override
    public ArrayList<Recensione> getListRecensioni() {
        return listRecensioni;
    }
    
    @Override
    public void setId_gioco(int id_gioco){
        this.id_gioco=id_gioco;
    }
    
    @Override
    public void setTitolo(String titolo){
        this.titolo=titolo;
    }
    
    @Override
    public void setGenere(String genere){
        this.genere=genere;
    }
    
    @Override
    public void setDescrizione(String descrizione){
        this.descrizione=descrizione;
    }
    
    @Override
    public void setPath(String path){
        this.path=path;
    }
    
    @Override
    public void setMediaVoto(float mediaVoto){
        this.mediaVoto=mediaVoto;
    }
    
    @Override
    public void setValore(int valore){
        this.valore=valore;
    }
    
    @Override
    public void setListRecensioni(ArrayList<Recensione> listRecensioni) {
        this.listRecensioni = listRecensioni;
    }
    
    
}

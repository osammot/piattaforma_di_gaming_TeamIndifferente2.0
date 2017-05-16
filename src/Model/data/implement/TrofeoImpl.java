package data.implement;

import data.model.Trofeo;
import data.model.Image;

/**
 *
 * @author LuKa
 */
public class TrofeoImpl implements Trofeo {
    private int id_trofeo;
    private String nome;
    private Image image;
    
    public TrofeoImpl(Trofeo trofeo){
        id_trofeo=0;
        nome="";
        image=null;
    }
    
    @Override
    public int getId_trofeo(){
        return id_trofeo;
    }
    
    @Override
    public String getNome(){
        return nome;
    }
    
    @Override
    public Image getImage(){
        return image;
    }
    
    @Override
    public void setId_trofeo(int id_trofeo){
        this.id_trofeo=id_trofeo;
    }
    
    @Override
    public void setNome(String nome){
        this.nome=nome;
    }
    
    @Override
    public void setImage(Image image){
        this.image=image;
    }
    
}

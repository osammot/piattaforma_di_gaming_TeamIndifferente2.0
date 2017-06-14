package data.implement;

import data.model.Image;

/**
 *
 * @author LuKa
 */
public class ImageImpl implements Image {
    private int id_image;
    private String path;
    private String titolo;
    
    public ImageImpl(Image image){
        id_image=0;
        path="";
        titolo="";
    }    
    
    @Override
    public int getId_image(){
        return id_image;
    }
    
    @Override
    public String getPath(){
        return path;
    }
    
    @Override
    public String getTitolo(){
        return titolo;
    }
    
    @Override
    public void setId_image(int id_image){
        this.id_image=id_image;
    }
    
    @Override
    public void setPath(String path){
        this.path=path;
    }

    @Override
    public void setTitolo(String titolo){
        this.titolo=titolo;
    }

}

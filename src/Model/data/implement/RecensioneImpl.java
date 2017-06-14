package data.implement;

import data.model.Recensione;

/**
 *
 * @author LuKa
 */
public class RecensioneImpl implements Recensione {
    private int id_recensione;
    private String titolo;
    private String text;
    private boolean approvato;
    
    
    public RecensioneImpl(Recensione recensione){
        this.id_recensione=0;
        this.titolo="";
        this.text="";
        this.approvato=false;
    }
    
    @Override
    public int getId_recensione(){
        return id_recensione;
    }
    
    @Override
    public String getTitolo(){
        return titolo;
    }
    
    @Override
    public String getText(){
        return text;
    }
    
    @Override
    public boolean getApprovato(){
        return approvato;
    }
    
    @Override
    public void setId_recensione(int id_recensione){
        this.id_recensione=id_recensione;
    }
    
    @Override
    public void setTitolo(String titolo){
        this.titolo=titolo;
    }
    
    @Override
    public void setText(String text){
        this.text=text;
    }
    
    @Override
    public void setText (boolean approvato){
        this.approvato=approvato;
    }
       
    
}

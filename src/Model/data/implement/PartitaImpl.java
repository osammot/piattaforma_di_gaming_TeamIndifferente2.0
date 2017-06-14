package data.implement;

import data.model.Partita;
import java.util.Date;

/**
 *
 * @author LuKa
 */
public class PartitaImpl implements Partita {
    private int id_partita;
    private int punteggio;
    private Date data;
    
    public PartitaImpl(Partita partita){
        id_partita=0;
        punteggio=0;
        data=null;
    }
    
    @Override
    public int getId_partita(){
        return id_partita;
    }
    
    @Override
    public int getPunteggio(){
        return punteggio;
    }
    
    @Override
    public Date getData(){
        return data;
    }
    
    @Override
    public void setId_partita(int id_partita){
        this.id_partita=id_partita;
    }
    
    @Override
    public void setPunteggio(int punteggio){
        this.punteggio=punteggio;
    }
    
    @Override
    public void setData(Date data){
        this.data=data;
    }
    
    
}

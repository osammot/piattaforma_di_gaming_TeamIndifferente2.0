package data.implement;

import data.model.Livello;

/**
 *
 * @author LuKa
 */
public class LivelloImpl implements Livello {
    private int id_livello;
    private int numeroLivello;
    private int punteggioProssimoLivello;
    
    
    public LivelloImpl(Livello livello){
        id_livello=0;
        numeroLivello=0;
        punteggioProssimoLivello=0;
    }
    
    @Override
    public int getId_livello(){
        return id_livello;
    }
    
    @Override
    public int getNumeroLivello(){
        return numeroLivello;
    }
    
    @Override
    public int getPunteggioProssimoLivello(){
        return punteggioProssimoLivello;
    }
    
    @Override
    public void setId_livello(int id_livello){
        this.id_livello=id_livello;
    }
    
    @Override
    public void setNumeroLivello(int numeroLivello){
        this.numeroLivello=numeroLivello;
    }
    
    @Override
    public void setPunteggioProssimoLivello(int punteggioProssimoLivello){
        this.punteggioProssimoLivello=punteggioProssimoLivello;
    }
    
}

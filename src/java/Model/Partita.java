
package Model;




public class Partita  {
    
    
    
    private int punteggio;

    
    private Livello livello;
    
    
    
        public Partita(){
           
            punteggio=0;
            
           
            livello=null;
        }

 

    /**
     *
     * @return punteggio
     */

    public int getPunteggio() {
       
        return punteggio;
    }

    /**
     *
     * @param punteggio
     * 
     */
    
    public void setPunteggio(int punteggio) {
        
        this.punteggio = punteggio;
    }

    /**
     *
     * @return
     */
    
    public Livello getlivello() {
        
        return livello;
    }

    /**
     *
     * @param id_livello
     */
    
    public void setLivello(Livello livello) {
        
        this.livello =livello;
    }

  
    
    
}

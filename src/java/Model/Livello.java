
package Model;

public class Livello  {
 
    
    
    private int numeroLivello;
    
    private int punteggioProssimoLivello;
    
    private String titolo;
    
    private Trofeo trofeo;
    
    
            public Livello (){
                
                
                this.numeroLivello = 0;
                
                this.punteggioProssimoLivello = 0;
                
                this.titolo = "";
                
                this.trofeo=null;
            }
            
                
            public int getNumeroLivello() {
            
                return numeroLivello;
            }

    
            public void setNumeroLivello(int numeroLivello) {
                
                this.numeroLivello = numeroLivello;
            }

    
            public int getPunteggioProssimoLivello() {
                
                return punteggioProssimoLivello;
            }

    
            public void setPunteggioProssimoLivello(int punteggioProssimoLivello) {
                
                this.punteggioProssimoLivello = punteggioProssimoLivello;
            }

    
            public String getTitolo() {
                
                return titolo;
            }

    
            public void setTitolo(String titolo) {
                
                this.titolo = titolo;
            }

    
            public Trofeo gettrofeo() {
                
                return trofeo;
            }

    
            public void settrofeo(Trofeo id_trofeo) {
                
                this.trofeo = id_trofeo;
            }
           

}

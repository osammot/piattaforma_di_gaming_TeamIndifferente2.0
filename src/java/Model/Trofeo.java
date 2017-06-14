/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author tom
 */
public class Trofeo  {
    
    private int id_trofeo;
    private String nome;
    
    private Immagine immagine;
    
    
    
        public Trofeo(){
        
            this.nome = "";
            
            this.immagine = null;
        }

    
        public int getId_trofeo() {
          
            return id_trofeo;
        }

    
        public void setId_trofeo(int id_trofeo) {
            
            this.id_trofeo = id_trofeo;
        }
        
        public String getNome() {
          
            return nome;
        }

    
        public void setNome(String nome) {
            
            this.nome = nome;
        }

    
        public Immagine getImmagine() {
            
            return immagine;
        }

    
        public void setImmagine(Immagine immagine) {
            
            this.immagine = immagine;
        }
}

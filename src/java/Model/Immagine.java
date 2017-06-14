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
public class Immagine {
 
     private int id_immagine ;
    
    private String path;
    
    private String titolo;

    
        public Immagine(){
            this.id_immagine = 0;
            
            this.path="";
    
            this.titolo="";
        }

        public int getId_immagine() {
            
            return id_immagine;
        }

        public void setId_immagine(int id_immagine) {
           
            this.id_immagine = id_immagine;
        }

        public String getPath() {
            
            return path;
        }

    
        public void setPath(String path) {
            
            this.path = path;
        }

    
        public String getTitolo() {
            
            return titolo;
        }


        public void setTitolo(String titolo) {
            
            this.titolo = titolo;
        }
    
    
}


package Model;



/**
 *
 * @author LuKa
 */
  public class Gioco  {  
    
    private String titolo;
    
    private String genere;
    
    private String descrizione;
    
    private Immagine immagine ;
   
    private int valore;
    
    private float mediavoto;

    
    public float getMediavoto() {
    
        return mediavoto;
    }

    public void setMediavoto(float mediavoto) {
        
        this.mediavoto = mediavoto;
    }
    
    private String template;


        public Gioco() {

            this.titolo = "";

            this.genere = "";

            this.descrizione = "";        

            this.template = "";        

            this.valore = 0;        


            this.immagine = null ; 

        }

        public String getTitolo() {
        
            return titolo;
        }

        public void setTitolo(String titolo) {
            
            this.titolo = titolo;
        }

        public String getGenere() {
            
            return genere;
        }

        public void setGenere(String genere) {
            
            this.genere = genere;
        }

        public String getDescrizione() {
            
            return descrizione;
        }

        public void setDescrizione(String descrizione) {
            
            this.descrizione = descrizione;
        }

        public Immagine getImmagine() {
            
            return immagine;
        }

        public void setImmagine(Immagine immagine) {
            
            this.immagine = immagine;
        }

        public int getValore() {
            
            return valore;
        }

        public void setValore(int valore) {
            
            this.valore = valore;
        }

        public String getTemplate() {
            
            return template;
        }

        public void setTemplate(String template) {
            
            this.template = template;
        }

}


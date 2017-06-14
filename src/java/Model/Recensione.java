
package Model;

import java.util.Date;


public class Recensione   {
    
    private int id_recensione;
    private String username;
    
    private Date dataInserimentoRecensione;
    
    private String titoloRecensione;
    
    private String testo;
    
    private String titologiocorec;
    
 
    

    
    
        public Recensione(){
        
            this.id_recensione = 0;
            
            this.titoloRecensione = "";
            
            this.testo = "";
            
            this.dataInserimentoRecensione = null ;
            
            this.username = "";
            
            this.titologiocorec="";
           
        
        }

        public int getId_recensione() {
  
            return id_recensione;
        }

        public void setId_recensione(int id_recensione) {
            
            this.id_recensione = id_recensione;
        }
        
        public String getTitoloRecensione() {
 
            return titoloRecensione;
        }

    
        public void setTitoloRecensione(String titoloRecensione) {
            
            this.titoloRecensione = titoloRecensione;
        }

    
        public String getTesto() {
            
            return testo;
        }

    
        public void setTesto(String testo) {
            
            this.testo = testo;
        }

    
        public Date getDataInserimentoRecensione() {
        
            return dataInserimentoRecensione;
        }

    
        public void setDataInserimentoRecensione(Date dataInserimentoRecensione) {
            
            this.dataInserimentoRecensione = dataInserimentoRecensione;
        }

    
        public String getUsername() {
            
            return username;
        }

    
        public void setUsername(String username) {
            
            this.username = username;
        }

        public String getTitologiocorec() {
            return titologiocorec;
        }

        public void setTitologiocorec(String titologiocorec) {
            this.titologiocorec = titologiocorec;
        }

    
}

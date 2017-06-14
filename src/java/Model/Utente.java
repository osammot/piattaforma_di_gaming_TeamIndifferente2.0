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
public class Utente  {
    
    private String username;
    
    private String nome;
    
    private String cognome;
    
    private String password;
    
    private String indirizzo;
    
    private String email;
    
    private String city;
    
    private String ruolo;
    
        public Utente (){
            username = "" ;
           
            nome = "";
            
            cognome = "";
            
            password = "" ;
            
            city = "";
            
            email = "";
            
            indirizzo = "";
            
            ruolo="";
        }

        public String getUsername() {
            
            return username;
        }

        public void setUsername(String username) {
            
            this.username = username;
        }

        public String getNome() {
            
            return nome;
        }

        public void setNome(String nome) {
            
            this.nome = nome;
        }

        public String getCognome() {
            
            return cognome;
        }

        public void setCognome(String cognome) {
            
            this.cognome = cognome;
        }

        public String getPassword() {
            
            return password;
        }

        public void setPassword(String password) {
            
            this.password = password;
        }

        public String getIndirizzo() {
            
            return indirizzo;
        }

        public void setIndirizzo(String indirizzo) {
            
            this.indirizzo = indirizzo;
        }

        public String getEmail() {
            
            return email;
        }

        public void setEmail(String email) {
            
            this.email = email;
        }


        public String getCity() {
            
            return city;
        }

        public void setCity(String città) {
            
            this.city = città;
        }

        public String getRuolo() {
            
            return ruolo;
        }

        public void setRuolo(String ruolo) {
            
            this.ruolo = ruolo;
        }

}

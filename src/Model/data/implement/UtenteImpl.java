package data.implement;

import data.model.Utente;
import data.model.utenteDAO;

/**
 *
 * @author LuKa
 */
public class UtenteImpl implements Utente {
    private int id;
    private String nome;
    private String cognome;
    private String username;
    private String password;
    private String indirizzo;
    private String email;
    private String citta;
    private String role;
    
    
    
    public UtenteImpl (utenteDAO ud){
    this.id=0;
    this.nome = "";
    this.cognome = "";
    this.username = "" ;
    this.password = "" ;
    this.citta = "";
    this.email = "";
    this.indirizzo = "";
    this.role="";
    }
    
    
    @Override
    public int getId() {
        return id;
    }
    
    @Override
    public String getNome() {
        return nome;
    }
    
    @Override
    public String getCognome() {
        return cognome;
    }
    
    @Override
    public String getUsername() {
        return username;
    }
    
    @Override
    public String getPassword() {
        return password;
    }
    
    @Override
    public String getIndirizzo(){
        return indirizzo;
    }
    
    @Override
    public String getEmail(){
        return email;
    }
    
    @Override
    public String getCitta(){
        return citta;
    }
    
    @Override
    public String getRole(){
        return role;
    }
    
    @Override
    public void setId(int id){
        this.id= id;
    }
    
    @Override
    public void setNome(String nome){
        this.nome=nome;
    }
    
    @Override
    public void setCognome(String cognome){
        this.cognome=cognome;
    }
    
    @Override
    public void setUsername(String username){
        this.username=username;
    }
    
    @Override
    public void setPassword(String password){
        this.password=password;
    }
    
    @Override
    public void setIndirizzo(String indirizzo){
        this.indirizzo=indirizzo;
    }
    
    @Override
    public void setEmail(String email){
        this.email=email;
    }
    
    @Override
    public void setCitta(String citta){
        this.citta=citta;
    }
    
    @Override
    public void setRole(String role){
        this.role=role;
    }


}

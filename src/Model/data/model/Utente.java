package data.model;

/**
 *
 * @author LuKa
 */
public interface Utente{

    String getCitta();

    String getCognome();

    String getEmail();

    int getId();

    String getIndirizzo();

    String getNome();

    String getPassword();

    String getRole();

    String getUsername();

    void setCitta(String citta);

    void setCognome(String cognome);

    void setEmail(String email);

    void setId(int id);

    void setIndirizzo(String indirizzo);

    void setNome(String nome);

    void setPassword(String password);

    void setRole(String role);

    void setUsername(String username);
    
}

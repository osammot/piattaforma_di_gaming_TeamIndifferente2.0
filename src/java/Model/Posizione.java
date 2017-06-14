
package Model;


public class Posizione {
    
    
private Utente user;
private int punteggio;

    public Posizione(){

    this.user= null;
    this.punteggio=0;
    }

    public Utente getUser() {
        return user;
    }

    public void setUser(Utente user) {
        this.user = user;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }



}

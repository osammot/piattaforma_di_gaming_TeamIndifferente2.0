package data.model;
import java.util.Date;

/**
 *
 * @author LuKa
 */
public interface Partita {

    Date getData();

    int getId_partita();

    int getPunteggio();

    void setData(Date data);

    void setId_partita(int id_partita);

    void setPunteggio(int punteggio);
    
}

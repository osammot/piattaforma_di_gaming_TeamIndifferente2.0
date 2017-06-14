/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.model;

import java.util.ArrayList;

/**
 *
 * @author LuKa
 */
public interface Gioco{

    String getDescrizione();

    String getGenere();

    int getId_gioco();

    ArrayList<Recensione> getListRecensioni();

    float getMediaVoto();

    String getPath();

    String getTitolo();

    int getValore();

    void setDescrizione(String descrizione);

    void setGenere(String genere);

    void setId_gioco(int id_gioco);

    void setListRecensioni(ArrayList<Recensione> listRecensioni);

    void setMediaVoto(float mediaVoto);

    void setPath(String path);

    void setTitolo(String titolo);

    void setValore(int valore);
    
}

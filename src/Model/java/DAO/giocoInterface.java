package DAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import data.implement.giocoImpl;
import java.sql.SQLException;

/**
 *
 * @author LuKa
 */
public interface giocoInterface {

    /** ci permette di caricare/creare un nuovo gioco*/
    boolean creaGioco(String titolo, String genere, float mediaVoto, String descrizione, int valore, String path);

    boolean eliminaGioco(String titolo);

    boolean inserisciRecensione(String titolo, String text, String username, String nomeGioco) throws SQLException;

    giocoImpl myGame(String titolo) throws SQLException;

    /**
     *
     * @param voto voto inserito
     * @param username dell'utente che inserisce il voto
     * @param nomeGioco nome del gioco da votare
     * @return true: inserimento riuscito, false inserimento non riuscito
     */
    boolean votaGioco(int voto, String username, String nomeGioco);
    
}

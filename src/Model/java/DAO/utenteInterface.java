/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import data.implement.utenteImpl;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author LuKa
 */
public interface utenteInterface {

    boolean eliminaUtente(String username) throws SQLException;

    /**
     *
     * @param Username dell'utente
     * @param password dell'utente
     * @return
     */
    utenteImpl loginUser(String Username, String password);

    boolean modificaUtentePassword(String username, String password) throws SQLException;

    utenteImpl myProfile(String username) throws SQLException;

    boolean promuoviUtente(String username, String ruolo);

    List<utenteImpl> selectlistUtente() throws SQLException;

    /** ci consente di inserire un nuovo utente con i propri dati*/
    boolean signin(String nome, String cognome, String username, String password, String indirizzo, String email, String città, String ruolo);
    
}

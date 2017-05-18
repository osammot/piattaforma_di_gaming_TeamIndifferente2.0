/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.SQLException;

/**
 *
 * @author LuKa
 */
public interface livelloInterface {

    boolean eliminaLivello(int id_livello) throws SQLException;

    boolean inserisciLivello(int id_livello, int numeroLivello, int punteggioProssimoLivello, String titolo, int id_trofeo) throws SQLException;
    
}

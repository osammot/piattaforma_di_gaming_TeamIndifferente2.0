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
public interface immagineInterface {

    boolean eliminaImmagine(int id_immagine) throws SQLException;

    boolean inserisciImmagine(int id_immagine, String path, String titolo) throws SQLException;
    
}

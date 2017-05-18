/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import data.implement.immagineImpl;
import java.sql.SQLException;

/**
 *
 * @author LuKa
 */
public interface trofeoInterface {

    boolean eliminaImmagine(int id_trofeo) throws SQLException;

    boolean inserisciTrofeo(int id_trofeo, String nome, immagineImpl immagine) throws SQLException;
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import data.implement.immagineImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author LuKa
 */
public class trofeoDAO implements trofeoInterface {
    
    @Override
    public boolean inserisciTrofeo(int id_trofeo, String nome, immagineImpl immagine) throws SQLException{
        try (Connection db = connectDb.connect()) {
            PreparedStatement pstmt;
            
            pstmt=db.prepareStatement("INSERT INTO trofeo (id_trofeo, nome)values(?, ?)");
            pstmt.setInt(1, id_trofeo);
            pstmt.setString(2, nome);
            
            if(pstmt.execute()){
                return true;
            }
            pstmt.close();
        }
         return false;
              
    }
    
    
    @Override
    public boolean eliminaImmagine(int id_trofeo) throws SQLException{
        try (Connection db = connectDb.connect()) {
            PreparedStatement pstmt;
            
            pstmt=db.prepareStatement("DELETE FROM trofeo WHERE (id_trofeo)values(?)");
            pstmt.setInt(1, id_trofeo);
                
            if(pstmt.execute()){
                return true;
            }
            pstmt.close();
        }
         return false;
              
    }
    
    
    
    
    
    
    
}

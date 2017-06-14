/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.model;

/**
 *
 * @author LuKa
 */
public interface Recensione {

    boolean getApprovato();

    int getId_recensione();

    String getText();

    String getTitolo();

    void setId_recensione(int id_recensione);

    void setText(String text);

    void setText(boolean approvato);

    void setTitolo(String titolo);
    
}

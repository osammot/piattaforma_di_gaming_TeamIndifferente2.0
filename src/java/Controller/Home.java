package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Data.GiocoDao;

import Model.Gioco;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import result.TemplateManagerException;
import result.TemplateResult;

/**
 *
 * @author tom
 */
public class Home extends BaseServlet {

    protected void action_Base(HttpServletRequest request,HttpServletResponse response){
        TemplateResult res = new TemplateResult(getServletContext());
        GiocoDao gameDao;
    
        try {
            gameDao = new GiocoDao();
            List <Gioco> listagame = gameDao.getListaGiochi();
            request.setAttribute("page_title", "Home");
            request.setAttribute("listagiochi", listagame); 
            res.activate("listagiochi.html", request, response);
        } catch (SQLException | TemplateManagerException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response){
     
        action_Base(request, response);
        }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

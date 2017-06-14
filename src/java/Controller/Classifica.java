/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Data.GiocoDao;
import Data.PosizioneDao;
import Model.Posizione;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import result.TemplateManagerException;
import result.TemplateResult;

/**
 *
 * @author tom
 */
public class Classifica extends BaseServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            {
      
        try {
        
             GiocoDao gamedao = new GiocoDao();
            List<String> listnamegame = gamedao.getListNameGame();
            request.setAttribute("listgamename", listnamegame);
            request.setAttribute("page_title", "classifica");
            
            if(request.getParameter("title") != null){
                System.out.println(request.getParameter("title"));
                PosizioneDao positiondao = new PosizioneDao();
                List<Posizione> listpo = positiondao.classificaPerPunteggioGioco(request.getParameter("title"));
                Gson s = new Gson();
                String jsonvar= s.toJson(listpo);
                System.out.println(jsonvar);
                response.getWriter().println(jsonvar);
            }else{
           
            System.out.println(request.getParameter("title"));
            TemplateResult template = new TemplateResult(getServletContext());
            template.activate("classifica.html", request, response);
        } }catch (TemplateManagerException ex) {
            Logger.getLogger(Classifica.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Classifica.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Classifica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

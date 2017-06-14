package Controller;

import Data.UtenteDao;
import Model.Utente;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import result.TemplateManagerException;
import result.TemplateResult;

public class Register extends HttpServlet {

    
    
    protected void action_default(HttpServletRequest request, HttpServletResponse response){
        try{ TemplateResult template = new TemplateResult(getServletContext());
            
            template.activate("registrazione.html", request, response);
        } catch (TemplateManagerException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }

    
    }
    protected void action_register (HttpServletRequest request, HttpServletResponse response){
    
        try {
            String nome = request.getParameter("nome");
            String cognome = request.getParameter("cognome");
            String indirizzo= request.getParameter("indirizzo");
            String citta = request.getParameter("citta");
            String  username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            
            UtenteDao userdao = new UtenteDao();
            System.out.println("aaaaaaaaaaa");
            Utente user = userdao.inserisciUtente(username, password, nome, cognome, indirizzo, citta, email);
             System.out.println("bbbbbbbbbbbb");
            response.sendRedirect("Home");
            
        } catch (SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
      
            
            if( request.getParameter("nome") != null && !(request.getParameter("nome").isEmpty()) &&
                request.getParameter("cognome") != null && !(request.getParameter("cognome").isEmpty())&&
                request.getParameter("indirizzo") != null && !(request.getParameter("indirizzo").isEmpty())&&
                request.getParameter("citta") != null && !(request.getParameter("citta").isEmpty())&&
                request.getParameter("username") != null && !(request.getParameter("username").isEmpty())&&
                request.getParameter("password") != null && !(request.getParameter("password").isEmpty())&&
                request.getParameter("email") != null && !(request.getParameter("email").isEmpty())){
            
            
               action_register(request,response);
                
            }
            else {
            action_default(request,response);
            }
           
        
    
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

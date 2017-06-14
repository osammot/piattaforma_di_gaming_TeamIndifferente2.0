package Controller;

import Data.TrofeoDao;
import Data.UtenteDao;
import Model.Utente;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import result.TemplateManagerException;
import result.TemplateResult;

/**
 *
 * @author tom
 */
public class Profilo extends BaseServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
             {
        
        HttpSession session = request.getSession(false);
        
        if(session == null)
        {
            try {
                response.sendRedirect("Home");
            } catch (IOException ex) {
                Logger.getLogger(Profilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            try {
                
                TemplateResult template = new TemplateResult(request.getServletContext());
                
                UtenteDao aaa = new UtenteDao();
                Utente user = aaa.recuperaUtente((String)session.getAttribute("username"));
                System.out.println(user.getIndirizzo() + " " + user.getUsername());
                request.setAttribute("utente", user);
                TrofeoDao trofeodao = new TrofeoDao();
                List trofeiVinti = trofeodao.trofeiVinti((String)session.getAttribute("username"));
                request.setAttribute("listatrofeiVinti", trofeiVinti);
                
                template.activate("profilo.html", request, response);
            } catch (SQLException ex) {
                Logger.getLogger(Profilo.class.getName()).log(Level.SEVERE, null, ex);
            } catch (TemplateManagerException ex) {
                Logger.getLogger(Profilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

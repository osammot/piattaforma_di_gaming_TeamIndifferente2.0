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
import javax.servlet.http.HttpSession;


public abstract class BaseServlet extends HttpServlet {

   private final String ROLE = "utente"; 
    protected void action_Not_Log(HttpServletRequest request,HttpServletResponse response) throws SQLException {
    
        if(( request.getParameter("username") != null && !(request.getParameter("username").isEmpty()))&&
            (request.getParameter("password") != null && !(request.getParameter("password").isEmpty())))
        {
            String username = (String) request.getParameter("username");
            String password = (String) request.getParameter("password");
            UtenteDao userdao = new UtenteDao();
            boolean log = userdao.checkLogin(username, password);
            if(log){
                HttpSession session = request.getSession(true);
                Utente user = userdao.recuperaUtente(username);
                request.setAttribute("login", true);
                request.setAttribute("username", user.getUsername());
                session.setAttribute("username", user.getUsername());
                 session.setAttribute("ruolo", user.getRuolo());
                if(!user.getRuolo().equals(ROLE)) request.setAttribute("bo", true);
            }
        }
         processRequest(request, response);
    }
    
    protected void action_Log(HttpServletRequest request,HttpServletResponse response) {
       HttpSession session = request.getSession(false);
        System.out.println(session.getAttribute("username")+"asddadsadssadadsasd"); 
       request.setAttribute("username",session.getAttribute("username"));
       request.setAttribute("login",true); 
       if(!session.getAttribute("ruolo").equals(ROLE)) request.setAttribute("bo", true);
        processRequest(request, response);
    }
    
    protected void processBaseRequest(HttpServletRequest request, HttpServletResponse response){
    
           HttpSession session = request.getSession(false);
        if(session != null) action_Log(request, response);
        else                try {
            action_Not_Log(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(BaseServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     protected abstract void processRequest(HttpServletRequest request, HttpServletResponse response);

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processBaseRequest(request, response);
       
        }
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processBaseRequest(request, response);
    }

   
}

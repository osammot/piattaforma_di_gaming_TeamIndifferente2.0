package Controller;

import Data.GiocoDao;
import Data.RecensioneDao;
import Model.Gioco;
import Model.Recensione;
import result.TemplateResult;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import result.TemplateManagerException;


public class PaginaGioco extends BaseServlet {
    
    private GiocoDao gamedao;
    private HttpSession session;
    private int  vote;
    private String titlegame;
    private Gioco game;
    private RecensioneDao daorec ;
    
    
    private void action_comment(HttpServletRequest request , HttpServletResponse response ) throws SQLException{
    
        System.out.println(request.getParameter("title") + " "+request.getParameter("message"));
        daorec.insertRecensione( request.getParameter("title"),request.getParameter("message"),(String)session.getAttribute("username"), titlegame );
    }
    
    private void action_vote(HttpServletRequest request , HttpServletResponse response ){
        try {
            vote = Integer.parseInt(request.getParameter("rating-input-1"));
            gamedao.voto((String)session.getAttribute("username"),  titlegame, vote);
        } catch (SQLException ex) {
            Logger.getLogger(PaginaGioco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void action_base(HttpServletRequest request , HttpServletResponse response) throws SQLException{
        
        request.setAttribute("page_title", "game");
        request.setAttribute("menu", "menulog.html");
        request.setAttribute("gioco", game);
        RecensioneDao daorec = new RecensioneDao();
        
        List<Recensione> listrec = daorec.listaRecensioni(request.getParameter("titolo"));
        request.setAttribute("listaRec", listrec);
        TemplateResult res = new TemplateResult(getServletContext());
        
        try {
            res.activate("pagina-gioco.html", request, response);
        } catch (TemplateManagerException ex) {
            Logger.getLogger(PaginaGioco.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
        
       
        try {
            this.gamedao = new GiocoDao();
            this.session = request.getSession(false);
            this.vote = 0;
            this.titlegame = (String) request.getParameter("titolo");
            this.game = gamedao.recuperaGioco(titlegame);
            this.daorec = new RecensioneDao();
            
            
            
            
            if(request.getParameter("rating-input-1")!= null)
            {
                if(this.session != null) action_vote(request,response);
                else action_base(request, response);
            }
            else if(request.getParameter("titolo")!= null && !(request.getParameter("titolo").isEmpty()) 
                    && request.getParameter("message")!= null && !(request.getParameter("message").isEmpty()))
            {
                if(this.session != null) action_comment(request, response);
                else response.sendRedirect("PaginaGioco");
            }
            else
            action_base(request,response);
        } catch (SQLException | IOException ex) {
            Logger.getLogger(PaginaGioco.class.getName()).log(Level.SEVERE, null, ex);
        }
        } 
    
        
    


    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

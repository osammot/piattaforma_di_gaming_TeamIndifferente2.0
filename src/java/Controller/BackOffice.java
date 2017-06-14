/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Data.RecensioneDao;
import Data.TrofeoDao;
import Model.Recensione;
import Model.Trofeo;
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


public class BackOffice extends BaseServlet {

   
  private TrofeoDao trofeodao ;
    private RecensioneDao recdao;
    private Gson s;
    
    
    
    
    protected void action_deleteTrofeoAjax(HttpServletRequest request, HttpServletResponse response) {
            System.out.println("aaaaa");
    if(request.getParameter("n")!= null ){
        
            
            
            
            int value = Integer.parseInt(request.getParameter("n"));
            System.out.println(value);
           
            try{
                trofeodao.deleteTrofeo(value);
            
        } catch (SQLException ex) {
            Logger.getLogger(BackOffice.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
    this.action_TrofeiAjax(request, response);
    }
    
    
    protected void action_RecensioniAjax(HttpServletRequest request, HttpServletResponse response){
        try {
            
             if(request.getParameter("id") != null){
            
                recdao.approveRec(Integer.parseInt(request.getParameter("id")));
            }
             else if(request.getParameter("rem") != null){
            
                 recdao.declineRec(Integer.parseInt(request.getParameter("rem")));
             }
             
            
            
            
            List<Recensione> listrec = recdao.listaRecensioniBO();
            this.s = new Gson();
            String jsonRec = s.toJson(listrec);
            System.out.println(jsonRec);
            response.getWriter().println(jsonRec);
        } catch (SQLException ex) {
            Logger.getLogger(BackOffice.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BackOffice.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    protected void action_TrofeiAjax(HttpServletRequest request, HttpServletResponse response) {
        
        if(request.getParameter("id") != null){
            
            try {
                int value = Integer.parseInt(request.getParameter("id") );
                Trofeo trofeo = trofeodao.getTrofeo(value);
                System.out.println("nome trofeo =  " +value+ trofeo.getNome() );
                this.s = new Gson();
                String jsonRec = s.toJson(trofeo);
                response.getWriter().println(jsonRec);
                
                
            } catch (SQLException ex) {
                Logger.getLogger(BackOffice.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(BackOffice.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        
        else{
        try {
            
            List<Trofeo> listTrofei = trofeodao.listTrofei();
            this.s = new Gson();
            String jsonRec = s.toJson(listTrofei);
            response.getWriter().println(jsonRec);
        } catch (SQLException ex) {
            Logger.getLogger(BackOffice.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BackOffice.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }}
    
    protected void action_base(HttpServletRequest request, HttpServletResponse response){
        
        try {
            request.setAttribute("menu", "menuadvanceduser.html");
            request.setAttribute("page_title", "BO");
            TemplateResult template = new TemplateResult(getServletContext());
            template.activate("dashboard.html", request, response);
        } catch (TemplateManagerException ex) {
            Logger.getLogger(BackOffice.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response){
        try {
            
            response.setContentType("text/html");
            this.recdao = new RecensioneDao();
            this.trofeodao= new TrofeoDao();
        
         
        if(request.getParameter("action") != null ){
                
                switch ((String)request.getParameter("action")){
                
                    case "rec": action_RecensioniAjax(request, response); break ;
                    case "trofei" : action_TrofeiAjax(request, response);break;
                    case "deletetrofeo" : action_deleteTrofeoAjax(request,response);break;
                }
            }
        else {
            action_base(request, response);
            }}
            catch (SQLException ex) {
            Logger.getLogger(BackOffice.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
}

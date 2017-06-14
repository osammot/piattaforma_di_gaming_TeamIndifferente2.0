/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package result;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author metantz
 */
public class FailureResult {

    protected ServletContext context;
    private final TemplateResult template;

    public FailureResult(ServletContext context) throws IOException {
        this.context = context;
        template = new TemplateResult(context);
    }

    public void activate(Exception exception, HttpServletRequest request, HttpServletResponse response) throws ParseException, UnsupportedEncodingException, MalformedTemplateNameException, TemplateException, TemplateManagerException {
        String message;
        if (exception != null && exception.getMessage() != null) {
            message = exception.getMessage();
        } else if (exception != null) {
            message = exception.getClass().getName();
        } else {
            message = "Unknown Error";
        }
        activate(message, request, response);
    }

    public void activate(String message, HttpServletRequest request, HttpServletResponse response) throws ParseException, UnsupportedEncodingException, MalformedTemplateNameException, TemplateException, TemplateManagerException {
        try {
            //se abbiamo registrato un template per i messaggi di errore, proviamo a usare quello
            //if an error template has been configured, try it
            if (context.getInitParameter("view.error_template") != null) {
                request.setAttribute("error", message);
                request.setAttribute("outline_tpl", "");
                template.activate(context.getInitParameter("view.error_template"), request, response);
            } else {
                //altrimenti, inviamo un errore HTTP
                //otherwise, use HTTP errors
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message);
            }
        } catch (IOException ex) {
            //se qualcosa va male inviamo un errore HTTP
            //if anything goue wrong, sent an HTTP error
            message += ". In addition, the following exception was generated while trying to display the error page: " + ex.getMessage();
            try {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message);
            } catch (IOException ex1) {
                Logger.getLogger(FailureResult.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
}

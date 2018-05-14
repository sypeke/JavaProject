/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servletProjet;

import java.io.IOException;
import static java.lang.System.out;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author moumene
 */
public class ControleurFrontal extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String sousAct=request.getParameter("recherche");
        
        if (action !=null)
        {
            if ("login".equals(action))
            {
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/signin");  //redirection vers la servlet login
                r.forward(request, response);     
                return;
            }            
            if ("logout".equals(action))
            {
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/signout");  //redirection vers la servlet login
                r.forward(request, response);                
                return;
            }         
            if ("consulter".equals(action))
            {
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/pagelivre");  //redirection vers la servlet login
                r.forward(request, response);                
                return;
            } 
            if ("evaluation".equals(action))
            {
                
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/EvaluationLivre");  //redirection vers la servlet login
                r.forward(request, response);  
               
                return;
            }
           
            if ("recherche".equals(action)){
                 //RequestDispatcher r = null;
                char oper =' ';
          if (sousAct!=null && sousAct.length()>0)
              oper = sousAct.charAt(0);
            
                switch (oper){
          
              case 'i' :
                  //forward vers la servlet Addition :
                  out.print("je sui da le");
                   RequestDispatcher r = this.getServletContext().getRequestDispatcher("/FindServlet");  //redirection vers la servlet login
                r.forward(request, response);     
                    break;
              case 't' :
                  //forward vers la servlet Soustraction :
                     RequestDispatcher re = this.getServletContext().getRequestDispatcher("/FindServlet");  //redirection vers la servlet login
                re.forward(request, response);    ;
                    break;
                  default :
                    String msg = "Opération "+sousAct+" inconnue";
                    request.setAttribute("message", msg);
                    //forward vers la page index.jsp :
                    r = this.getServletContext().getRequestDispatcher("/recherche.jsp");
                    r.forward(request, response);
                }
            }
              if ("consulterCours".equals(action))
            {
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/ServletCour");  //redirection vers la servlet login
                r.forward(request, response);                
                return;
            } 
            return;
        }
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */

    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

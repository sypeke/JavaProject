/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servletProjet;

import com.classeProjet.EvaluationLivre;
import com.classeProjet.Livre;
import com.connectionProjet.Connexion;
import com.daoProjet.EvaluationLivreDao;
import com.daoProjet.LivreDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sypeke
 */
public class FindServlet extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String isbn=  request.getParameter("champ");
            String motCles =  request.getParameter("motCle");
            String titre= request.getParameter("titre");
             String actionFro = request.getParameter("recherche");
            boolean isbnTrouver= true;
            boolean titreTrouver= true;
         
            Class.forName(this.getServletContext().getInitParameter("piloteJdbc"));
            Connexion.setUrl(this.getServletContext().getInitParameter("urlBd"));
          LivreDao l = new LivreDao(Connexion.getInstance());
          LivreDao lu = new LivreDao(Connexion.getInstance());
        Livre livre = l.read(isbn);
         Livre livre2 = l.read(titre);
         Livre livrer = lu.read(motCles);
        List<Livre> live = l.findAll();
         EvaluationLivreDao eval = new  EvaluationLivreDao(Connexion.getInstance());
       
         List<EvaluationLivre> lesnotes = eval.noteEvaluation(isbn);
         List<Livre> titreAuteur = lu.findTitreAut();
        
     
       
        
        if(livre!=null && actionFro.equals("i")   ) {  
           HttpSession session = request.getSession(true);
          out.print("je suis isbn");
          request.setAttribute("note", lesnotes);
           session.setAttribute("trouver",livre );
                 
            request.getServletContext().getRequestDispatcher("/resultat.jsp").forward(request, response);
                
         
        
        }
          else{
            request.setAttribute("message", "Mauvais chois");
            
       request.getRequestDispatcher("/recherche.jsp").forward(request, response);
         
              
              
           
            }
             if(livre!=null && actionFro.equals("t") ){
                   out.print("zero");
               
              HttpSession session = request.getSession(true);
          session.setAttribute("trouver",livre );
          request.setAttribute("note", lesnotes);
           session.setAttribute("trouverTitre",titreAuteur);
            request.getServletContext().getRequestDispatcher("/resultatMot.jsp").forward(request, response);
                
            
      
         
        
        }
          else{
                  out.print("zero");
              //request.getRequestDispatcher("/recherche.jsp").forward(request, response);
                request.setAttribute("message", "Le tritre est incorrect");
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/recherche.jsp");
           r.forward(request, response);
                 
                
                
           
            }
    
            request.getRequestDispatcher("/recherche.jsp").forward(request, response);
            
         } catch (ClassNotFoundException ex) {
            Logger.getLogger(FindServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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

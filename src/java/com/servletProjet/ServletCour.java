/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servletProjet;

import com.classeProjet.Cours;
import com.classeProjet.EvaluationCours;
import com.classeProjet.Livre;
import com.connectionProjet.Connexion;
import com.daoProjet.CoursDao;
import com.daoProjet.EvaluationCoursDao;
import com.daoProjet.LivreDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sypeke
 */
public class ServletCour extends HttpServlet {

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
        PrintWriter out = response.getWriter();
       String book = request.getParameter("idCours"),
               isbn =request.getParameter("ISBN"),
                booknote =request.getParameter("idCours");
                
               
               
     LivreDao lirLiv = new LivreDao(Connexion.getInstance());
       
        CoursDao l = new CoursDao(Connexion.getInstance());
        Cours   livcour = l.read(isbn);
          Livre livre = lirLiv.read(isbn);
       
        
        List<Cours> courliv = l.findAll(); // tous les cours
          EvaluationCoursDao eval = new  EvaluationCoursDao(Connexion.getInstance());// instance de connection
           List<EvaluationCours> lesnote = eval.noteEvaluation(booknote); // on recuperles notes 
          EvaluationCours liva = eval.read(book);//on recuper l'objet des evaluation sans calculer les notes
        
           List<EvaluationCours> livv = eval.findAll();// on recuper la liste des evaluation sans calculer les notes
       
        
             out.print(" les ISBN sont defferent");
               
        
            out.println("La liste des livres est vide...");
     
      request.setAttribute("cour", liva);
      request.setAttribute("livreEva", courliv);
      request.setAttribute("noteCours", lesnote);
       request.setAttribute("trouverLivre", livre);
            request.getRequestDispatcher("/listeCours.jsp").forward(request, response);
  
              
       
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

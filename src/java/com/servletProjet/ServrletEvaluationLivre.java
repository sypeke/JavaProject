/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servletProjet;

import com.classeProjet.EvaluationLivre;
import com.classeProjet.Livre;
import com.classeProjet.User;
import com.connectionProjet.Connexion;
import com.daoProjet.EvaluationLivreDao;
import com.daoProjet.LivreDao;
import com.daoProjet.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sypeke
 */
public class ServrletEvaluationLivre extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) 
        {
            
            String idLivre=  request.getParameter("idLivre"),
            idProf= request.getParameter("idProf") ,
            titre= request.getParameter("titre"),
            commentaire =request.getParameter("commentaire");
            double note = 0;
           if (request.getParameter("note")!= null)
           {
             note =Double.parseDouble(request.getParameter("note"));
            }
            
           if( idLivre == null ) 
           {
              
                request.getServletContext().getRequestDispatcher("/evaluation.jsp").forward(request, response);
           }
            
        try {
            Class.forName(this.getServletContext().getInitParameter("piloteJdbc"));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Connexion.setUrl(this.getServletContext().getInitParameter("urlBd"));
       
        LivreDao l = new LivreDao(Connexion.getInstance());
        Livre livre = l.read(idLivre);
        if( livre == null) 
        {      
            out.println("Probleme avec Livre");
            //request.getServletContext().getRequestDispatcher("/evaluation.jsp").forward(request, response);   
        }
        EvaluationLivreDao evali = new  EvaluationLivreDao(Connexion.getInstance());
        EvaluationLivre eval = new EvaluationLivre();
        eval.setNote(note);
       

        
        UserDao dao = new UserDao(Connexion.getInstance());
 
        User user = dao.read(idProf.trim());
  
        
        if (user == null)
        {
           
            out.println("Probleme avec user");
            request.setAttribute("message", "Utilisateur "+idProf+" inexistant.");
          
           
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/evaluation.jsp");
            r.forward(request, response);
           
        }
        else if (livre == null)
           
        {
          
            request.setAttribute("message", "l'identifiant ou ISBN  "+idLivre+ "est inexistant");
         
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/evaluation.jsp");
            r.forward(request, response);
        
        }
        else if(note >10|| note < 0 ){
            out.println("Probleme avec note");
             request.setAttribute("message", "la note doit etre inferiure ou egale 10 ");
           
            
        }
       
        else
           
        {
           
           eval.setIdProf(idProf);
           eval.setIdLivre(idLivre);
           eval.setNote(note);
           eval.setCommentaire(commentaire);
           if( evali.create(eval) )
           {
               out.println("<h3>Vous avez termine l'evaluation</h3>");
           } else 
           {
               
           
       
           EvaluationLivre  evaluInsert= new EvaluationLivre (idProf,idLivre, note,commentaire);
           evali.evaluer(evaluInsert);
         
            HttpSession session = request.getSession(true);
           
            out.print("je suis la ");
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/livrepage.jsp");
            r.forward(request, response);
            /* TODO output your page here. You may use following sample code. */
           }
        }
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
         
        //eval.setPrenom(request.getParameter("prenom"));
        
       
      
        
        
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

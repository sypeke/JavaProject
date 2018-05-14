/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servletProjet;
import com.classeProjet.Livre;
import com.classeProjet.User;
import com.classeProjet.EvaluationLivre;
import com.connectionProjet.Connexion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import  com.daoProjet.LivreDao;
import  com.daoProjet.EvaluationLivreDao;
import com.daoProjet.UserDao;
import java.sql.Connection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sypeke
 */
public class ServletLivre extends HttpServlet {

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
       String book = request.getParameter("idLivre"),
               isbn =request.getParameter("ISBN"),
                booknote =request.getParameter("idLivre");
                
               
               
  
       
        LivreDao l = new LivreDao(Connexion.getInstance());
        Livre livre = l.read(isbn);
      
        List<Livre> liv = l.findAll();
          EvaluationLivreDao eval = new  EvaluationLivreDao(Connexion.getInstance());
           List<EvaluationLivre> testNote = eval.noteEvaluation(booknote);
          EvaluationLivre liva = eval.read(book);
        
           List<EvaluationLivre> livv = eval.findAll();
       
        
             out.print(" les ISBN sont defferent");
               
        
            out.println("La liste des livres est vide...");
     
      request.setAttribute("livre", liv);
      request.setAttribute("livreEva", livv);
      request.setAttribute("noteLivre", testNote);
            request.getRequestDispatcher("/livrepage.jsp").forward(request, response);
  
              
            //request.setAttribute("Voici la liste de non livre ", liv);
            //request.getRequestDispatcher("/livrepage.jsp").forward(request, response);
            
       
        
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
        String idLivre=  request.getParameter("idLivre"),
               idProf= request.getParameter("idProf") ,
               titre= request.getParameter("titre"),
               commentaire =request.getParameter("commenetaire");
        double  note = Double.parseDouble(request.getParameter("note"));
        Livre live = new Livre();
        EvaluationLivreDao evali = new  EvaluationLivreDao(Connexion.getInstance());
        EvaluationLivre eval = new EvaluationLivre();
        eval.setNote(Double.parseDouble(request.getParameter("1")));
       

        try {
            Class.forName(this.getServletContext().getInitParameter("piloteJdbc"));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Connexion.setUrl(this.getServletContext().getInitParameter("urlBd"));
        UserDao dao = new UserDao(Connexion.getInstance());
        //User util = new User("a","po","ki");
        User user = dao.read(idProf.trim());
       // User user = dao.read( nomperso.trim());
        
        if (user.getUsername().equals(idProf))
        {
            //Utilisateur inexistant
            
            request.setAttribute("message", "Utilisateur "+idProf+" inexistant.");
            //response.sendRedirect("login.jsp");Ne fonctionne pas correctement (ie. perd le message d'erreur).
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/evaluation.jsp");
            r.forward(request, response);
        }
        else if (!live.getISBN().equals(idLivre))
           
        {
            //Mot de passe incorrect
            request.setAttribute("message", "l'identifiant ou ISBN  "+idLivre+ "est inexistant");
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/evaluation.jsp");
            r.forward(request, response);
        }
        else if(note >10|| note < 0 ){
             request.setAttribute("message", "la note doit etre inferiure ou egale 10 ");
            //response.sendRedirect("login.jsp");Ne fonctionne pas correctement (ie. perd le message d'erreur).
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/evaluation.jsp");
            r.forward(request, response);
        
        }
       
        else
           
        {
           titre = live.getTitre();
           idProf = eval.getProf();
           idLivre =live.getISBN();
           
           EvaluationLivre  evaluInsert= new EvaluationLivre (idProf,idLivre, note,commentaire);
           evali.evaluer(evaluInsert);
            //nomperso=toto;
            HttpSession session = request.getSession(true);
           // session.setAttribute("connecte", nomperso);
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/livrepage.jsp");
            r.forward(request, response);
        }
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


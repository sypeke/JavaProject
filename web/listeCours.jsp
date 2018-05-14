<%-- 
    Document   : livrepage
    Created on : 28 nov. 2015, 18:37:12

    Author     : sypeke
--%>
<%@page import="com.classeProjet.Livre"%>
<%@page import="java.util.*,java.io.*,com.classeProjet.Cours,com.classeProjet.EvaluationCours, java.util.Collections"%>
<%@page import ="java.util.HashMap,java.util.HashSet,java.util.Set "%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <hr><ol> <%
        
            
            String nbre = request.getParameter("Nbre");
                  Livre liv = (Livre)session.getAttribute("trouverLivre");
                   Cours courliv = (Cours)session.getAttribute("cour");
            List<Cours> cour = (List<Cours>)request.getAttribute("livreEva");
            
   List<EvaluationCours> listDouble = (List<EvaluationCours>)request.getAttribute("noteCours");
   
 
          if (cour != null){
               out.print("Voici les livre deja evalue");
               
              out.print( " <table border='1' solid black> ");
               out.print("<tr><th>Titre</th><th>Auteur</th><th>IdLivre</th><th>"
                       + "IdCours</th><th>Note</th><th>Commenatire</th><th>Duree</th></tr>");
                       
              
            
                 for( EvaluationCours lir : listDouble){
                       for( Cours co : cour ){
                      
                  
                       if((liv.getISBN().equals(lir.getIdLivre())) && (lir.getIdCours().equals(co.getNumero()))){
                             
                         
                            out.print("<tr><th>"+liv.getTitre() + "</th><th>"+lir.getIdLivre() + "</th>"
                        + " <th>"+lir.getIdCours()+"</th><th>"+lir.getNote() + "</th><th>"+ lir.getCommentaire()+"</th>"
                        + " <th>"+courliv.getDuree()+"</th></tr>");
               
                        }
                        
                       
                       }   
                 
               
                     
           }
                
                
                 out.print("</table><br />");
                  out.println("la liste de tous les cours"); 
                  out.print( " <table border='1' solid black> ");
                  out.print("<tr><th>Numero</th><th>Nom</th><th>Duree</th><th>");
                      
                 
               
                            for (Cours c : cour) {
                         
                                  out.print("<th>"+c.getNumero() + "</th><th>"+c.getNom()+ "</th>"
                        + " <th>"+c.getDuree()+"</th></tr>");
                          }
                        
                        
                
                out.print("</table><br/>");
                
                
           }else{
               out.println("<h3>La liste est vide.ssss.</h3>");
          }
           
           
        %>
        </ol><hr>
    </body>
</html>

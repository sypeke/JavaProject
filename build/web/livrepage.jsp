<%-- 
    Document   : livrepage
    Created on : 28 nov. 2015, 18:37:12

    Author     : sypeke
--%>
<%@page import="java.util.*,java.io.*,com.classeProjet.Livre,com.classeProjet.EvaluationLivre, java.util.Collections"%>
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
          
            
            String nbre = request.getParameter("Nbre");;
            List<Livre> vreli = (List<Livre>)request.getAttribute("livre");
            List<EvaluationLivre> vreliEva = (List<EvaluationLivre>)request.getAttribute("livreEva");
   List<EvaluationLivre> listDouble = (List<EvaluationLivre>)request.getAttribute("noteLivre");
   List<EvaluationLivre> elimineAction = (List<EvaluationLivre>)request.getAttribute("eliminer");
   
           if (vreli != null)
           {
               out.print("Voici les livre deja evalue");
               
              out.print( " <table border='1' solid black> ");
               out.print("<tr><th>Titre</th><th>Auteur</th><th>Edition</th><th>"
                       + "Annee</th><th>ISBN</th><th>nombre de page</th><th>Etat</th>"
                       + "<th>Description</th><th>Motscles</th>"
                       + "<th>Moyenne </th><th>Commentaire</th><th>Nbre evaluation</th></tr>");
              
          
                for(EvaluationLivre livav :vreliEva )
                {
                    
                   for( EvaluationLivre lir : listDouble)
                   {
                       
                       for (Livre lil: vreli) 
                       {
                  
                        if(livav.getIdLivre().equals(lil.getISBN()) && (livav.getIdLivre().equals(lir.getIdLivre())))
                        {
                             
                      
                            out.print("<tr><th>"+lil.getTitre() + "</th><th>"+lil.getNomAuteur() + "</th>"
                        + " <th>"+lil.getEdition()+"</th><th>"+lil.getAnnee() + "</th><th>"+ lil.getISBN()+"</th>"
                        + " <th>"+lil.getNbPages()+"</th><th>"+lil.getEtat() + "</th>"
                        + "<th>"+ lil.getDescription()+"</th><th>"+lil.getMotsCles()+"</th>"
                            +"<th>"+lir.getNote() + "</th><th>"+livav.getCommentaire()+"</th><th>"+lir.getNbre()+"</th>");
               
                        }
                        
                       
                     
           }
                 } 
                } 
                 out.print("</table><br />");
                  out.println("la liste de toud les livre"); 
                  out.print( " <table border='1' solid black> ");
                  out.print("<tr><th>Titre</th><th>Auteur</th><th>Edition</th><th>"
                       + "Annee</th><th>ISBN</th><th>nombre de page</th><th>Etat</th>"
                       + "<th>Description</th><th>Motscles</th></tr>");
                 
               
                            for (Livre lij: vreli) {
                          //if (livav.getIdLivre()!= (lil.getISBN()) && (livav.getIdLivre()!=(lir.getIdLivre()))){
                                  out.print("<th>"+lij.getTitre() + "</th><th>"+lij.getNomAuteur() + "</th>"
                        + " <th>"+lij.getEdition()+"</th><th>"+lij.getAnnee() + "</th><th>"+ lij.getISBN()+"</th>"
                        + " <th>"+lij.getNbPages()+"</th><th>"+lij.getEtat() + "</th>"
                        + "<th>"+ lij.getDescription()+"</th><th>"+lij.getMotsCles()+"</th></tr>");
                          }
                        
                        
                
                out.print("</table><br/>");
                
                
           }else{
               out.println("<h3>La liste est vide..</h3>");
           }
           
           
        %>
        </ol><hr>
    </body>
</html>

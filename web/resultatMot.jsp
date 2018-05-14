<%-- 
    Document   : resultatMot
    Created on : 9 déc. 2015, 02:50:04
    Author     : sypeke
--%>

<%@page import="com.classeProjet.EvaluationLivre"%>
<%@page import="com.classeProjet.Livre"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
             out.print("<table border='1' solid black>");
            Livre liv = (Livre)session.getAttribute("trouver");
            List<EvaluationLivre> listEva = (List<EvaluationLivre>)request.getAttribute("note");
             List< Livre> listTitre = (List<Livre>)request.getAttribute("trouverTitre");
            // List<Livre> vre = (List<Livre>)session.getAttribute("trouverMot");
            
          
            //EvaluationLivre lir =new EvaluationLivre();
             out.print("<tr><th>ISBN</th><th>Titre</th><th>Auteur</th><th>"
                       + "Moyenne</th><th>Nbre d'evaluation</th></tr>");
           
          if (listTitre != null)
        {
                out.print ( "Voici les resultat de votre recherche");
             for(EvaluationLivre lirt :listEva )
           {
                 for( Livre lirtitre : listTitre)
                {
                     
                  
                        if(lirtitre.getTitre().equals(liv.getTitre()) && (lirt.getIdLivre().equals(liv.getISBN())))
                    {
                             
                       
                            out.print("<tr><th>"+lirtitre.getTitre() + "</th><th>"+lirtitre.getNomAuteur() + "</th>"
                        + " <th>"+lirtitre.getEdition()+"</th><th>"+lirtitre.getAnnee() + "</th><th>"+ lirtitre.getISBN()+"</th>"
                        + " <th>"+lirtitre.getNbPages()+"</th><th>"+lirtitre.getEtat() + "</th>"
                        + "<th>"+ lirtitre.getDescription()+"</th><th>"+lirtitre.getMotsCles()+"</th>"
                            +"<th>"+lirt.getNote() + "</th><th>"+lirt.getCommentaire()+"</th><th>"+lirt.getNbre()+"</th>");
               
                    }
                        
                     
          
                 } 
            }
        }
                
                %>
    </body>
</html>

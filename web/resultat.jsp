<%-- 
    Document   : resultat
    Created on : 8 déc. 2015, 12:29:59
    Author     : sypeke
--%>

<%@page import="java.util.List"%>
<%@page import="com.classeProjet.EvaluationLivre"%>
<%@page import="com.classeProjet.Livre"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; ISO-8859-1">
        <title>JSP Page</title>
    </head>
    <body>
        
        
        <%
          
            out.print("<table border='1' solid black>");
            Livre liv = (Livre)session.getAttribute("trouver");
           // Livre liv2 = (Livre)session.getAttribute("trouver2");
            
            // List<Livre> vre = (List<Livre>)session.getAttribute("trouverMot");
            
           //List<EvaluationLivre> vreliEva = (List<EvaluationLivre>)request.getAttribute("livreEva");
            List<EvaluationLivre> listEva = (List<EvaluationLivre>)request.getAttribute("note");
             List< Livre> listTitre = (List<Livre>)request.getAttribute("trouverTitre");
            //EvaluationLivre lir =new EvaluationLivre();
             out.print("<tr><th>ISBN</th><th>Titre</th><th>Auteur</th><th>"
                       + "Moyenne</th><th>Nbre d'evaluation</th></tr>");
             
            if (listEva != null)
            {
                out.print ( "Voici les resultat de votre recherche");
                for(EvaluationLivre lir :listEva )
                {
                    //for(Livre live:listTitre){
                    if(lir.getIdLivre().equals(liv.getISBN()))
                    {
          
        
                       out.print("<tr><th>"+liv.getISBN()+"</th><th>"+liv.getTitre()+""
                       + "</th><th>"+liv.getNomAuteur()+"</th>"
                      + "<th>"+lir.getNote()+"</th><th>"+lir.getNbre()+"</th></tr>" );
                   //}
                    }
               }
            }
            
  else{
               //out.println("<h3>" +request.getAttribute("message")+"</h3>");
               out.print("c'est qoiou");
        }
           
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
            
   else
        {
               //out.println("<h3>" +request.getAttribute("message")+"</h3>");
            out.print("je suis la");
        }
            
             
           out.print( " </table><br/> ");
                   
%>  
      
        

    </body>
</html>

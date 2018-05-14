<%
    if (session.getAttribute("connecte")==null)  //déjà connecté
    {
%>
        <jsp:forward page="login.jsp" />
<%
    }
%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Page d'acceuil</title>
        <style type="text/css">
            .errorMessage {color : red;}
            .resultat {font-weight: bold;}
        </style>
    </head>
    <body>       
<%        
    
            out.println("<p class=\"resultat\"> Bonjour. "+session.getAttribute("connecte")+", vous êtes connectés. "+"<BR>"+
                        "<BR>"+
                    "vous pouvez faire  les actions suivantes: "+"<BR>" +
                           "<BR>"+
                    "<a href=\"logout.do?action=logout\">déconnexion</a></p>" +
                     "<a href=\"livrepage.do?action=consulter\">Consulter les livres</a></p>"
                    + "<a href=\"listeCours.do?action=consulterCours\">Consulter les cours</a></p>"
                    + "<a href=\"evaluation.do?action=evaluation\">Evaluer les livres</a></p>"
                + "<a href=\"recherche.do?action=recherche\">Rechercher les livres</a></p>");


                
%>
        

    </body>
</html>

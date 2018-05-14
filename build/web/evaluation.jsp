<%-- 
    Document   : evaluation
    Created on : 7 déc. 2015, 17:30:48
    Author     : sypeke
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title> Page evaluation + </title>
    </head>
    <body>
        <%
        if(request.getAttribute("message")!=null)
            out.print("<h3>" +request.getAttribute("message")+"</h3>");
            %>
          <table border="1px solid black">
        
         <form action="evaluation.do?action=evaluation" method="post">
             <tr>
                 <th>Isbn :</th> 
                 <th><input type="text" name="idLivre"</th><br />
              </tr>
              <tr>
                  <th>Votre Id : </th>
                  <th><input type="text" name="idProf" </th>
                </tr>
                <tr>  
                    <th> Commentaire: </th>
                    <th><input type="text" name="commentaire"</th> 
              </tr>
              <tr> 
                  <th>Note: </th>
                  <th><input type="number" min ="0" max ="10" name="note"</th>
                  
                </tr>
              
             <tr>
                 <th><input type="submit" value=" evaluer "</th>
             </tr>
        </form>
  
    </body>
</html>

<%-- 
    Document   : recherche
    Created on : 8 déc. 2015, 12:08:46
    Author     : sypeke
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title> Recherche </title>
    </head>
    <body>
      
        <%
       if(request.getAttribute("message")!= null) 
            out.print("<h3>" +request.getAttribute("message")+"</h3>");
            %>
          <table border="2px solid black">
        
         <form action="recherche.do"method=post">
        <tr><th>
            <select name="recherche">
                
                
                <option value="">-Choix de recherche-</option>
               
                <option value="i">Par ISBN</option>
                <option value= "t">Par Titre</option>
            
                   
            </select>
          </th></tr>
          <tr><th>  Tapez votre recherche:<input type="text" name="champ"</th></tr>
            
                
             <tr><th><input type="submit" value="Evaluer" </th></tr>
             
              </form>
           </table><br/> 
    </body>
</html>

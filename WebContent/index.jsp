<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form  method="post" action="test"> <label> login </label> <input type="text" name="login">
    <label> MotDePasse </label>  <input type="text" name="mdp">
     <%
               if(request.getParameter("erreur")!= null && request.getParameter("erreur").equalsIgnoreCase("true")){%>

                 <p style='color:red'>Utilisateur ou mot de passe incorrect</p>
              <% }
               %>
    <button type="submit">Envoyer</button>
  
     </form>
</body>
</html>
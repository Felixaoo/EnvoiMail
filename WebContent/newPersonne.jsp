<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form  method="post" action="formulaireServlet"> <label> login </label> <input type="text" name="login">
    <label> mdp </label>  <input type="password" name="pass"><label> nom </label>  
    <input type="text" name="nom"> <label> prenom </label>  <input type="text" name="prenom">
     <label> mail </label>  <input type="email" name="email">  <label> n°tel </label>  <input type="number" name="tel">
   
    <button type="submit">Envoyer</button>
  
     </form>
</body>
</html>
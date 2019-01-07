<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form  method="post" action="MailServlet"> <label> mail </label> <input type="email" name="mail">
    <label> objet </label>  <input type="text" name="mail"><label> message </label>  
    <input type="text" name="message">
   
    <button type="submit">Envoyer</button>
  
     </form>
</body>
</html>
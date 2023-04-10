<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
		<link rel="stylesheet" href="css/simple.css">
</head>
<body>
		<p style="color:red">${redirectMessage}</p>
		
		<form action="innlogging" method="post">
			
			 
            <input type="text" name="mail" value="" /> 
			<input type="password" name="passord" value=""/>
			<input type="submit" value="Logg inn"/>
		
		</form>
		
		<form action="tilnybruker" method="post">
		<input type="submit" value="Registrer ny bruker">
		
		</form>
		
		
		
	</body>
	</html>
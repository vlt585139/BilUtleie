<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

	<form action="nybruker" method="post">
	
	fornavn: <input type="text" name="fornavn" value="" /><br/>
	etternavn: <input type="text" name="etternavn" value="" /><br/>
	mail: <input type="text" name="mail" value="" /> <br/>
	adresse: <input type="text" name="adresse" value="" /> <br/>
	postnummer: <input type="number" name="postnummer" value="" /> <br/>
	telefonnummer: <input type="text" name="telefonnummer" value="" /> <br/>
	passord: <input type="password" name="passord" value="" /> <br/>
	<input type="submit" value="register"/>  
	</form>

</html>
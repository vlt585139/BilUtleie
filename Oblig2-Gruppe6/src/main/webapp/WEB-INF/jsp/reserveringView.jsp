<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
</head>
<body>		
  <h2>Ny reservasjon</h2>
  <form action="reservasjon" method="post">
    <input type="text" name="regNummer" value="" placeholder="AB12345"/> 
    <input type="number" name="kontornummer" placeholder="Kontornummer">
    <input type="date" name="dato">
    <input type="time" name="klokkeslett">
    <input type="number" name="antallDager">
    <input type="submit" value="Lag reservasjon"/>
  </form>

  <h2>Våre biler</h2>
  <table>
    <tr>
      <th>Regnr</th>
      <th>Bil</th>
      <th>Kontornummer</th>
    </tr>
    
    <c:forEach var="bil" items="${biler}">
      <tr>
        <td>${bil.registreringsnummer}</td>
        <td>${bil.farge} ${bil.modell.merke} ${bil.modell.modell}</td>
        <td>${bil.utleiekontor.kontornummer}</td>
      </tr>
    </c:forEach>
  </table>
	</body>
	</html>
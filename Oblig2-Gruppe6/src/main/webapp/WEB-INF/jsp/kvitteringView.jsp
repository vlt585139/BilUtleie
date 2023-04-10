<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <style>
            .res {
                border: 1px solid black;
                margin: 5;
            }
        </style>
    </head>
    <body>
        <c:forEach var="reservasjon" items="${reservasjoner}">
            <div class="res">
                <p>Dato: ${reservasjon.dato} Kl: ${reservasjon.klokkeslett}</p>
                <p>${reservasjon.bil.farge} ${reservasjon.bil.modell.merke} ${reservasjon.bil.modell.modell}</p>
                <p>${reservasjon.bil.registreringsnummer}</p>
                <p>Hentes fra: ${reservasjon.bil.utleiekontor.navn}</p>
                <p>Leveres til: ${reservasjon.retursted.navn}</p>
                <p>Antall dager: ${reservasjon.antalldager}</p>
            </div>
        </c:forEach>
	    <form action="kvittering" method="post">
			<input type="submit" value="Tilbake Til Forside">
		</form>	
	</body>
</html>
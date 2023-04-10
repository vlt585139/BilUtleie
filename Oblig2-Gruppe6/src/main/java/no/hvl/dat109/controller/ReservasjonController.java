package no.hvl.dat109.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import no.hvl.dat109.model.Kunde;
import no.hvl.dat109.service.InnloggingService;
import no.hvl.dat109.service.ReservasjonService;

@Controller
@RequestMapping("/reservasjon")
public class ReservasjonController {

	@Autowired
	private ReservasjonService resService;

	@Autowired
	private InnloggingService loginService;

	/**
	 * Method to show the reservasjon page
	 * 
	 * have to be logged in to access this page, else gets redirected to login
	 *
	 * @param session
	 *
	 * @return a view for the reservasjon page
	 */
	@GetMapping
	public String visReservering(HttpSession session) {

		if (!loginService.erInnlogget(session)) {
			return "redirect:innlogging";
		}

		session.setAttribute("biler", resService.hentBiler());

		return "reserveringView";
	}

	/**
	 * Method to go to kvittering page
	 * 
	 * Saves the new reservasjon
	 * 
	 * @param session
	 * 
	 * @return redirect to kvittering
	 */
	@PostMapping
	public String tilKvittering(HttpSession session, @RequestParam String regNummer, @RequestParam int kontornummer,
			@RequestParam String dato, @RequestParam String klokkeslett, @RequestParam int antallDager) {

		if (!loginService.erInnlogget(session)) {
			return "redirect:innlogging";
		}

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.parse(dato, formatter);

		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm");
		LocalTime localTime = LocalTime.parse(klokkeslett, formatter2);

		resService.nyReservasjon((Kunde) session.getAttribute("kunde"), regNummer, kontornummer, localDate, localTime,
				antallDager);

		return "redirect:kvittering";
	}
}

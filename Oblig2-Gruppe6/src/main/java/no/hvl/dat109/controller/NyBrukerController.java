package no.hvl.dat109.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import no.hvl.dat109.service.InnloggingService;
import no.hvl.dat109.service.NyBrukerService;

@Controller
@RequestMapping("/nybruker")
public class NyBrukerController {

	@Autowired
	private NyBrukerService nyBrukerService;

	@Autowired
	private InnloggingService loginService;

	/**
	 * Method to show the make new user page
	 * 
	 * @return a view for the make new user page
	 */
	@GetMapping
	public String visLagNyBruker() {
		return "nybrukerView";
	}

	/**
	 * Method to make a new user
	 * 
	 * Turn input into a new user/customer and save to database Login the new user
	 * 
	 * @return redirect to front page
	 */
	@PostMapping
	public String lagBruker(HttpSession session, @RequestParam String mail, @RequestParam String fornavn,
			@RequestParam String etternavn, @RequestParam String adresse, @RequestParam int postnummer,
			@RequestParam String telefonnummer, @RequestParam String passord) {

		if (!loginService.erInnlogget(session)) {
			if(!nyBrukerService.lagNyBruker(mail, fornavn, etternavn, adresse, postnummer, telefonnummer, passord)) {
				return "redirect:nybruker";
			}
			loginService.loggInn(session, mail, passord);
		}

		return "redirect:forside";
	}
}

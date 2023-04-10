package no.hvl.dat109.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import no.hvl.dat109.service.InnloggingService;

@Controller
@RequestMapping("/innlogging")
public class InnloggingController {
	
	@Autowired
	private InnloggingService loginService;

	/**
	 * Method to show the login page
	 * 
	 * If already logged in, return to the front page
	 * 
	 * @param session
	 * 
	 * @return a view for the login page
	 */
	@GetMapping
	public String visInnlogging(HttpSession session) {
		
		if(loginService.erInnlogget(session)) {
			return "redirect:forside";
		}
		
		return "innloggingView";
	}

	/**
	 * Method to log in
	 * 
	 * Attempts to log in a customer If the customer does not have an account, or
	 * the password is wrong, return to login page
	 * 
	 * @param session
	 * @param mail
	 * @param passord
	 * 
	 * @return redirect to front page
	 */
	@PostMapping
	public String loggInn(HttpSession session, @RequestParam String mail, @RequestParam String passord) {
		
		if(!loginService.loggInn(session, mail, passord)) {
			return "redirect:innlogging";
		}
		
		return "redirect:forside";
	}
}

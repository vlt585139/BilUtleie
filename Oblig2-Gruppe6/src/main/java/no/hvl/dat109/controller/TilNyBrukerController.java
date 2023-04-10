package no.hvl.dat109.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tilnybruker")
public class TilNyBrukerController {
	
	/**
	 * Method to go to new user page
	 * 
	 * @return redirect to new user
	 */
	@PostMapping
	public String tilLagNyBruker() {
		return "redirect:nybruker";
	}
}

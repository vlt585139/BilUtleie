package no.hvl.dat109.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/forside")
public class ForsideController {

	/**
	 * Method to show the front page
	 * 
	 * @return a view for the front page
	 */
	@GetMapping
	public String visForside() {
		return "forsideView";
	}
	
	/**
	 * Method to go to reservering page
	 * 
	 * @return redirect to reservering
	 */
	@PostMapping
	public String tilReservasjon() {
		return "redirect:reservasjon";
	}
}

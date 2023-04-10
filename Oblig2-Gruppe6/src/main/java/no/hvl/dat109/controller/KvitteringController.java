package no.hvl.dat109.controller;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import no.hvl.dat109.service.InnloggingService;
import no.hvl.dat109.service.KvitteringService;

@Controller
@RequestMapping("/kvittering")
public class KvitteringController {
	
	@Autowired
	private InnloggingService loginService;
	
	@Autowired 
	KvitteringService kvitteringservice;

	/**
	 * Method to show the front page
	 * 
	 * Only accessible while logged in
	 * Gets all reservasjoner
	 * 
	 * @param session
	 * 
	 * @return a view for the kvittering
	 */
	@GetMapping
	public String visKvittering(HttpSession session) {
		
		if(!loginService.erInnlogget(session)) {
			return "redirect:innlogging";
		}
		
		kvitteringservice.hentAlleReservasjoner(session);
		
		return "kvitteringView";
	}
	
	/**
	 * Method to go to front page
	 * 
	 * @return redirect to front page
	 */
	@PostMapping
	public String tilForside() {
		return "redirect:forside";
	}
}

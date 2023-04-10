package no.hvl.dat109.service;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import no.hvl.dat109.model.Kunde;
import no.hvl.dat109.repo.KundeRepo;

@Service
public class InnloggingService {
	
	@Autowired
	private KundeRepo kunderepo;

	/**
	 * Method to check if a customer is logged in
	 * 
	 * @param session
	 * 
	 * @return true if logged in, else false
	 */
	public boolean erInnlogget(HttpSession session) {
		return session != null && session.getAttribute("kunde") != null;
	}
	
	/**
	 * Method to log in
	 * 
	 * @param session
	 * @param passord 
	 * @param mail 
	 * 
	 * @return true for successful log in, else false
	 */
	public boolean loggInn(HttpSession session, String mail, String passord) {
		
		Optional<Kunde> opt = kunderepo.findById(mail);
		
		if(opt.get() != null && opt.get().getPassord().equals(passord)) {
			session.setAttribute("kunde", opt.get());
			return true;
		}
		
		return false;
	}
	
}
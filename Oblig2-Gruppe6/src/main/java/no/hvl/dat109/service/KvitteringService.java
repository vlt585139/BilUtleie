package no.hvl.dat109.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import no.hvl.dat109.model.Kunde;
import no.hvl.dat109.model.Reservasjon;
import no.hvl.dat109.repo.ReservasjonRepo;

@Service
public class KvitteringService {
	
	@Autowired
	private ReservasjonRepo resRepo;

	/** 
	 * Method to get all reservations and add them to session
	 */
	public void hentAlleReservasjoner(HttpSession session) {
		List<Reservasjon> reservasjoner = resRepo.findAll();
		
		Kunde k = (Kunde) session.getAttribute("kunde");
		
		session.setAttribute("reservasjoner", reservasjoner.stream().filter(r -> r.getKunde().getMail().equals(k.getMail())).toList());
	}
	
}

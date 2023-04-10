package no.hvl.dat109.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import no.hvl.dat109.model.Kunde;
import no.hvl.dat109.model.PostAdresse;
import no.hvl.dat109.repo.KundeRepo;
import no.hvl.dat109.repo.PostAdresseRepo;

@Service
public class NyBrukerService {
	
	@Autowired
	private KundeRepo kundeRepo;
	
	@Autowired
	private PostAdresseRepo postadresseRepo;

	/**
	 * Method to make a new user/customer
	 * 
	 * @return true if new user is made, else false
	 */
	public boolean lagNyBruker(String mail, String fornavn, String etternavn, String adresse, int postnummer,
			String telefon, String passord) {

		Optional<PostAdresse> opt = postadresseRepo.findById(Integer.toString(postnummer));
		
		if(opt.get() == null) {
			return false;
		}
		
		if(kundeRepo.findById(mail).get() != null) {
			return false;
		}
		
		Kunde bruker = new Kunde(mail, fornavn, etternavn, adresse, opt.get(), telefon, passord);
		
		kundeRepo.save(bruker);
		
		return true;
		
	}

}

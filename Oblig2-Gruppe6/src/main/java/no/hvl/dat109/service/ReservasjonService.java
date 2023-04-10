package no.hvl.dat109.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import no.hvl.dat109.model.Bil;
import no.hvl.dat109.model.Kunde;
import no.hvl.dat109.model.Reservasjon;
import no.hvl.dat109.model.Utleiekontor;
import no.hvl.dat109.repo.BilRepo;
import no.hvl.dat109.repo.ReservasjonRepo;
import no.hvl.dat109.repo.Utleiekontorrepo;

@Service
public class ReservasjonService {
	
	@Autowired
	private BilRepo bilRepo;
	
	@Autowired
	private ReservasjonRepo resRepo;
	
	@Autowired
	private Utleiekontorrepo kontorRepo;

	public List<Bil> hentBiler() {
		return bilRepo.findAll();
	}

	/**
	 * Method to make a new reservasjon
	 * 
	 * @return true if new reservasjon is made, else false
	 */
	public boolean nyReservasjon(Kunde kunde, String regNummer, int kontornummer, LocalDate dato, LocalTime klokkeslett,
			int antallDager) {
		
		Optional<Bil> optBil = bilRepo.findById(regNummer);
		
		if(optBil.get() == null) {
			return false;
		}
		
		Optional<Utleiekontor> kontor = kontorRepo.findById(kontornummer);
		
		if(kontor.get() == null)
			return false;
		
		Reservasjon reservasjon = new Reservasjon(kunde, optBil.get(), kontor.get(), dato, klokkeslett, antallDager);
		
		resRepo.save(reservasjon);

		return true;
	}

}

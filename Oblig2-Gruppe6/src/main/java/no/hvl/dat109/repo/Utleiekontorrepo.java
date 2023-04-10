package no.hvl.dat109.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import no.hvl.dat109.model.Kunde;
import no.hvl.dat109.model.Utleiekontor;

public interface Utleiekontorrepo extends JpaRepository<Utleiekontor, Integer> {
	
}
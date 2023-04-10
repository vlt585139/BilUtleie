package no.hvl.dat109.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import no.hvl.dat109.model.Bil;
import no.hvl.dat109.model.Kunde;

public interface BilRepo extends JpaRepository<Bil, String> {
	
}
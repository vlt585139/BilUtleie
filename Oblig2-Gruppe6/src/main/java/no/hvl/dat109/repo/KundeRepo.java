package no.hvl.dat109.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import no.hvl.dat109.model.Kunde;

public interface KundeRepo extends JpaRepository<Kunde, String> {
	
}

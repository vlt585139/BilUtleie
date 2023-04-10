package no.hvl.dat109.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import no.hvl.dat109.model.Reservasjon;

public interface ReservasjonRepo extends JpaRepository<Reservasjon, Integer> {

}

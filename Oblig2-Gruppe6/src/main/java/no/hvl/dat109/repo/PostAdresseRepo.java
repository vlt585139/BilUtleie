package no.hvl.dat109.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import no.hvl.dat109.model.PostAdresse;

public interface PostAdresseRepo extends JpaRepository<PostAdresse, String> {
	
}

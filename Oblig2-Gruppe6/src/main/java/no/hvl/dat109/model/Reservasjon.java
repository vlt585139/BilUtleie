package no.hvl.dat109.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "bilutleie", name = "reservasjon")
public class Reservasjon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int resid;
	
	@ManyToOne 
	@JoinColumn(name = "kunde", referencedColumnName = "mail")
	private Kunde kunde;
	
	@ManyToOne 
	@JoinColumn(name = "bil", referencedColumnName = "registreringsnummer")
	private Bil bil;
	
	@ManyToOne 
	@JoinColumn(name = "retursted", referencedColumnName = "kontornummer")
	private Utleiekontor retursted;
	private LocalDate dato;
	private LocalTime klokkeslett;
	private int antalldager;

	public Reservasjon() {

	}

	public Reservasjon(Kunde kunde, Bil bil, Utleiekontor retursted, LocalDate dato, LocalTime klokkeslett,
			int antalldager) {
		this.kunde = kunde;
		this.bil = bil;
		this.retursted = retursted;
		this.dato = dato;
		this.klokkeslett = klokkeslett;
		this.antalldager = antalldager;
	}

	public int getResid() {
		return resid;
	}

	public void setResid(int resid) {
		this.resid = resid;
	}

	public Kunde getKunde() {
		return kunde;
	}

	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}

	public Bil getBil() {
		return bil;
	}

	public void setBil(Bil bil) {
		this.bil = bil;
	}

	public Utleiekontor getRetursted() {
		return retursted;
	}

	public void setRetursted(Utleiekontor retursted) {
		this.retursted = retursted;
	}

	public LocalDate getDato() {
		return dato;
	}

	public void setDato(LocalDate dato) {
		this.dato = dato;
	}

	public LocalTime getKlokkeslett() {
		return klokkeslett;
	}

	public void setKlokkeslett(LocalTime klokkeslett) {
		this.klokkeslett = klokkeslett;
	}

	public int getAntalldager() {
		return antalldager;
	}

	public void setAntalldager(int antalldager) {
		this.antalldager = antalldager;
	}

}

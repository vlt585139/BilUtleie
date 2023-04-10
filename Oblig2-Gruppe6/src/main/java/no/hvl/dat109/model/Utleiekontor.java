package no.hvl.dat109.model;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Id;

@Entity
@Table(schema = "bilutleie", name = "utleiekontor")
public class Utleiekontor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int kontornummer;
	
	private String navn;
	private String adresse;
	
	@ManyToOne 
	@JoinColumn(name = "postnummer", referencedColumnName = "postnummer")
	private PostAdresse postnummer;
	private String telefon;
	
	@OneToMany (mappedBy = "retursted", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Reservasjon> returer = new ArrayList<Reservasjon>();
	
	@OneToMany (mappedBy = "utleiekontor", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Bil> biler = new ArrayList<Bil>();

	public Utleiekontor() {

	}

	public Utleiekontor(int kontornummer, String navn, String adresse, PostAdresse postnummer, String telefon) {
		this.kontornummer = kontornummer;
		this.navn = navn;
		this.adresse = adresse;
		this.postnummer = postnummer;
		this.telefon = telefon;
	}

	public List<Reservasjon> getReturer() {
		return returer;
	}

	public void setReturer(List<Reservasjon> returer) {
		this.returer = returer;
	}

	public List<Bil> getBiler() {
		return biler;
	}

	public void setBiler(List<Bil> biler) {
		this.biler = biler;
	}

	public int getKontornummer() {
		return kontornummer;
	}

	public void setKontornummer(int kontornummer) {
		this.kontornummer = kontornummer;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public PostAdresse getPostnummer() {
		return postnummer;
	}

	public void setPostnummer(PostAdresse postadresse) {
		this.postnummer = postadresse;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefonnummer(String telefon) {
		this.telefon = telefon;
	}

}

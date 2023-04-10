package no.hvl.dat109.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "bilutleie", name = "kunde")
public class Kunde {

	@Id
	private String mail;
	private String fornavn;
	private String etternavn;
	private String adresse;

	@ManyToOne
	@JoinColumn(name = "postnummer", referencedColumnName = "postnummer")
	private PostAdresse postnummer;
	private String telefon;
	private String passord;

	@OneToMany(mappedBy = "kunde", fetch = FetchType.EAGER)
	private List<Reservasjon> reservasjoner = new ArrayList<Reservasjon>();

	/**
	 * Default Constructor for JPA
	 */
	public Kunde() {

	}

	public Kunde(String mail, String fornavn, String etternavn, String adresse, PostAdresse postnummer, String telefon,
			String passord) {
		this.mail = mail;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.adresse = adresse;
		this.postnummer = postnummer;
		this.telefon = telefon;
		this.passord = passord;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
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

	public void setPostnummer(PostAdresse postnummer) {
		this.postnummer = postnummer;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getPassord() {
		return passord;
	}

	public void setPassord(String passord) {
		this.passord = passord;
	}

	public List<Reservasjon> getReservasjoner() {
		return reservasjoner;
	}

	public void setReservasjoner(List<Reservasjon> reservasjoner) {
		this.reservasjoner = reservasjoner;
	}

}

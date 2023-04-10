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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(schema = "bilutleie", name = "bil")
public class Bil {

	@Id
	private String registreringsnummer;

	@ManyToOne
	@JoinColumn(name = "modell", referencedColumnName = "modell")
	private Modell modell;

	@ManyToOne
	@JoinColumn(name = "utleiekontor", referencedColumnName = "kontornummer")
	private Utleiekontor utleiekontor;
	private String farge;

	@OneToMany(mappedBy = "bil", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Reservasjon> reservasjoner = new ArrayList<Reservasjon>();

	public Bil() {

	}

	public Bil(String registreringsnummer, Modell modell, Utleiekontor utleiekontor, String farge) {
		this.registreringsnummer = registreringsnummer;
		this.modell = modell;
		this.utleiekontor = utleiekontor;
		this.farge = farge;
	}

	public String getRegistreringsnummer() {
		return registreringsnummer;
	}

	public void setRegistreringsnummer(String registreringsnummer) {
		this.registreringsnummer = registreringsnummer;
	}

	public Modell getModell() {
		return modell;
	}

	public void setModell(Modell modell) {
		this.modell = modell;
	}

	public Utleiekontor getUtleiekontor() {
		return utleiekontor;
	}

	public void setUtleiekontor(Utleiekontor utleiekontor) {
		this.utleiekontor = utleiekontor;
	}

	public String getFarge() {
		return farge;
	}

	public void setFarge(String farge) {
		this.farge = farge;
	}

	public List<Reservasjon> getReservasjoner() {
		return reservasjoner;
	}

	public void setReservasjoner(List<Reservasjon> reservasjoner) {
		this.reservasjoner = reservasjoner;
	}

}

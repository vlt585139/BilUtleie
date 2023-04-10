package no.hvl.dat109.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(schema = "bilutleie", name = "utleiegruppe")
public class Utleiegruppe {

	@Id
	private char utleiegruppe;
	private int pris;

	@OneToMany(mappedBy = "modell", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Modell> modeller = new ArrayList<Modell>();

	public Utleiegruppe() {

	}

	public Utleiegruppe(char utleiegruppe, int pris) {
		this.utleiegruppe = utleiegruppe;
		this.pris = pris;
	}

	public char getUtleiegruppe() {
		return utleiegruppe;
	}

	public void setUtleiegruppe(char utleiegruppe) {
		this.utleiegruppe = utleiegruppe;
	}

	public int getPris() {
		return pris;
	}

	public void setPris(int pris) {
		this.pris = pris;
	}

	public List<Modell> getModeller() {
		return modeller;
	}

	public void setModeller(List<Modell> modeller) {
		this.modeller = modeller;
	}

}

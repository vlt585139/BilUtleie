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
@Table(schema = "bilutleie", name = "modell")
public class Modell {

	@Id
	private String modell;
	private String merke;
	
	@ManyToOne 
	@JoinColumn(name = "utleiegruppe", referencedColumnName = "utleiegruppe")
	private Utleiegruppe utleiegruppe;
	
	@OneToMany (mappedBy = "modell", fetch = FetchType.EAGER)
	private List<Bil> biler = new ArrayList<Bil>();

	public Modell() {

	}

	public Modell(String modell, String merke, Utleiegruppe utleiegruppe) {
		this.modell = modell;
		this.merke = merke;
		this.utleiegruppe = utleiegruppe;
	}

	public String getModell() {
		return modell;
	}

	public void setModell(String modell) {
		this.modell = modell;
	}

	public String getMerke() {
		return merke;
	}

	public void setMerke(String merke) {
		this.merke = merke;
	}

	public Utleiegruppe getUtleiegruppe() {
		return utleiegruppe;
	}

	public void setUtleiegruppe(Utleiegruppe utleiegruppe) {
		this.utleiegruppe = utleiegruppe;
	}

	public List<Bil> getBiler() {
		return biler;
	}

	public void setBiler(List<Bil> biler) {
		this.biler = biler;
	}

}

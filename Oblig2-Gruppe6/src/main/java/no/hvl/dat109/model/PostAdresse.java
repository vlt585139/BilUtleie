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
@Table(schema = "bilutleie", name = "postadresse")
public class PostAdresse {

	@Id
	private String postnummer;
	private String poststed;

	@OneToMany(mappedBy = "postnummer", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Utleiekontor> kontorer = new ArrayList<Utleiekontor>();

	@OneToMany(mappedBy = "postnummer", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Kunde> kunder = new ArrayList<Kunde>();

	public PostAdresse() {

	}

	public PostAdresse(String postnummer, String postadresse) {
		this.postnummer = postnummer;
		this.poststed = postadresse;
	}

	public String getPostnummer() {
		return postnummer;
	}

	public void setPostnummer(String postnummer) {
		this.postnummer = postnummer;
	}

	public String getPoststed() {
		return poststed;
	}

	public void setPoststed(String poststed) {
		this.poststed = poststed;
	}

	public List<Utleiekontor> getKontorer() {
		return kontorer;
	}

	public void setKontorer(List<Utleiekontor> kontorer) {
		this.kontorer = kontorer;
	}

	public List<Kunde> getKunder() {
		return kunder;
	}

	public void setKunder(List<Kunde> kunder) {
		this.kunder = kunder;
	}

}

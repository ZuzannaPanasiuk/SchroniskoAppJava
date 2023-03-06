package schronisko.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Wolontariusze 
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idw;
	
	private String imie;
	private String nazwisko;
	private String nr_tel;
	private String rola;
	
	@OneToMany(mappedBy="idt")
	private List<Tymczas> tymczas;

	public Long getIdw() {
		return idw;
	}

	public void setIdw(Long idw) {
		this.idw = idw;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getNr_tel() {
		return nr_tel;
	}

	public void setNr_tel(String nr_tel) {
		this.nr_tel = nr_tel;
	}

	public String getRola() {
		return rola;
	}

	public void setRola(String rola) {
		this.rola = rola;
	}

	public List<Tymczas> getTymczas() {
		return tymczas;
	}

	public void setTymczas(List<Tymczas> tymczas) {
		this.tymczas = tymczas;
	}

	public Wolontariusze() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

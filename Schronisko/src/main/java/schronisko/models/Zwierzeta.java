package schronisko.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Zwierzeta {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idz;
	
	private String imie;
	private String gatunek;
	private String plec;
	private String rasa;
	private String wiek;
	private String historia;
	
	@OneToMany(mappedBy="ida")
	private List<Adopcje> adopcje;
	
	@OneToMany(mappedBy="idt")
	private List<Tymczas> tymczas;

	public Long getIdz() {
		return idz;
	}

	public void setIdz(Long idz) {
		this.idz = idz;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getGatunek() {
		return gatunek;
	}

	public void setGatunek(String gatunek) {
		this.gatunek = gatunek;
	}

	public String getPlec() {
		return plec;
	}

	public void setPlec(String plec) {
		this.plec = plec;
	}

	public String getRasa() {
		return rasa;
	}

	public void setRasa(String rasa) {
		this.rasa = rasa;
	}

	public String getWiek() {
		return wiek;
	}

	public void setWiek(String wiek) {
		this.wiek = wiek;
	}

	public String getHistoria() {
		return historia;
	}

	public void setHistoria(String historia) {
		this.historia = historia;
	}

	public List<Adopcje> getAdopcje() {
		return adopcje;
	}

	public void setAdopcje(List<Adopcje> adopcje) {
		this.adopcje = adopcje;
	}

	public List<Tymczas> getTymczas() {
		return tymczas;
	}

	public void setTymczas(List<Tymczas> tymczas) {
		this.tymczas = tymczas;
	}

	public Zwierzeta() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}

package schronisko.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Klienci {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idk;
	
	@NotNull @NotEmpty 
	@Size(min=3, max=10, message="Imię musi mieć conajmniej 3 symbole, a zarazem maksymalnie 10 znaków")
	@Pattern(regexp="[A-ZŻŹĆĄŚĘŁÓŃ]{1}[a-zżźćńółęąś]{1,}", message="Imię musi odpowiadać schematowi - Jedna wielka litera i reszta małych")
	private String imie;
	
	
	private String nazwisko;
	private String email;
	
	@OneToMany(mappedBy="ida")
	private List<Adopcje> adopcje;

	public Long getIdk() {
		return idk;
	}

	public void setIdk(Long idk) {
		this.idk = idk;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Adopcje> getAdopcje() {
		return adopcje;
	}

	public void setAdopcje(List<Adopcje> adopcje) {
		this.adopcje = adopcje;
	}

	public Klienci() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}

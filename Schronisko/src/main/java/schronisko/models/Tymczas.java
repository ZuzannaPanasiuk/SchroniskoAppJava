package schronisko.models;


import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Tymczas {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idt;
	
	@ManyToOne
	private Wolontariusze wolontariusz;
	
	@ManyToOne
	private Zwierzeta zwierze;
	
	private Date data_poczatkowa;
	
	private Date data_koncowa;

	public Long getIdt() {
		return idt;
	}

	public void setIdt(Long idt) {
		this.idt = idt;
	}

	public Wolontariusze getWolontariusz() {
		return wolontariusz;
	}

	public void setWolontariusz(Wolontariusze wolontariusz) {
		this.wolontariusz = wolontariusz;
	}

	public Zwierzeta getZwierze() {
		return zwierze;
	}

	public void setZwierze(Zwierzeta zwierze) {
		this.zwierze = zwierze;
	}

	public Date getData_poczatkowa() {
		return data_poczatkowa;
	}

	public void setData_poczatkowa(Date data_poczatkowa) {
		this.data_poczatkowa = data_poczatkowa;
	}

	public Date getData_koncowa() {
		return data_koncowa;
	}

	public void setData_koncowa(Date data_koncowa) {
		this.data_koncowa = data_koncowa;
	}

	public Tymczas() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

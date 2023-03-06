package schronisko.models;


import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class Adopcje {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long ida;
	
	@ManyToOne
	private Klienci klient;
	
	@ManyToOne
	private Zwierzeta zwierze;
	
	private Date data;

	public Long getIda() 
	{
		return ida;
	}

	public void setIda(Long ida) {
		this.ida = ida;
	}

	public Klienci getKlient() 
	{
		return klient;
	}

	public void setKlient(Klienci klient) 
	{
		this.klient = klient;
	}

	public Zwierzeta getZwierze() 
	{
		return zwierze;
	}

	public void setZwierze(Zwierzeta zwierze) 
	{
		this.zwierze = zwierze;
	}

	public Date getData() 
	{
		return data;
	}

	public void setData(Date data) 
	{
		this.data = data;
	}

	public Adopcje() 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}

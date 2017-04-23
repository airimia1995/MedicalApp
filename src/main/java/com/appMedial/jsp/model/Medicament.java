package com.appMedial.jsp.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name="MEDICAMENT")
public class Medicament {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="MEDICAMENT_ID")
	private int medicament_id;
	
	@Column(name="NUME")
	private String nume;
	
	@Column(name="TIP")
	private String tip;
	
	@Column(name="FORMA")
	private String forma;
	
	@Column(name="CONCENTRATIE")
	private int concentratie;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "retetaMedicament", 
    joinColumns = @JoinColumn(name = "medicament_id", referencedColumnName = "medicament_id"), 
    inverseJoinColumns = @JoinColumn(name = "reteta_id", referencedColumnName = "reteta_id"))
	Set<Reteta> retetaList;


	public int getMedicament_id() {
		return medicament_id;
	}

	public void setMedicament_id(int medicament_id) {
		this.medicament_id = medicament_id;
	}

	public Set<Reteta> getRetetaList() {
		return retetaList;
	}

	public void setRetetaList(Set<Reteta> retetaList) {
		this.retetaList = retetaList;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getForma() {
		return forma;
	}

	public void setForma(String forma) {
		this.forma = forma;
	}

	public int getConcentratie() {
		return concentratie;
	}

	public void setConcentratie(int concentratie) {
		this.concentratie = concentratie;
	}
	
}

package com.appMedial.jsp.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="MEDICAMENT")
public class Medicament {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="MEDICAMENT_ID")
	private int medicacament_id;
	
	@Column(name="NUME")
	private String nume;
	
	@Column(name="TIP")
	private String tip;
	
	@Column(name="FORMA")
	private String forma;
	
	@Column(name="CONCENTRATIE")
	private int concentratie;
	
	@OneToMany(mappedBy = "medicament", cascade = CascadeType.ALL, orphanRemoval = true)
	Set<RetetaMedicament> retetaMedicament;

	public int getMedicacament_id() {
		return medicacament_id;
	}

	public void setMedicacament_id(int medicacament_id) {
		this.medicacament_id = medicacament_id;
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

	public Set<RetetaMedicament> getRetetaMedicament() {
		return retetaMedicament;
	}

	public void setRetetaMedicament(Set<RetetaMedicament> retetaMedicament) {
		this.retetaMedicament = retetaMedicament;
	}
	
}

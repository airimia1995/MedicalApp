package com.appMedial.jsp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="RETETA_MEDICAMENT")
public class RetetaMedicament {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="RETETA_MEDICAMENT_ID")
	private int reteta_medicament_id;
	
	
	 @ManyToOne
	 @JoinColumn(name = "reteta_id")
	 private Reteta reteta;
	 
	 
	 @ManyToOne
	 @JoinColumn(name = "medicament_id")
	 private Medicament medicament;


	public int getReteta_medicament_id() {
		return reteta_medicament_id;
	}


	public void setReteta_medicament_id(int reteta_medicament_id) {
		this.reteta_medicament_id = reteta_medicament_id;
	}


	public Reteta getReteta() {
		return reteta;
	}


	public void setReteta(Reteta reteta) {
		this.reteta = reteta;
	}


	public Medicament getMedicament() {
		return medicament;
	}


	public void setMedicament(Medicament medicament) {
		this.medicament = medicament;
	}
	 
	 
}

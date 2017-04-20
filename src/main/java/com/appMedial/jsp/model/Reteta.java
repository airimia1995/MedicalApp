package com.appMedial.jsp.model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;





@Entity
@Table(name="RETETA")
public class Reteta {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="RETETA_ID")
	private int reteta_id;
	
	@Column(name="BOALA")
	private String boala;
	
	@Column(name = "START_DATE", columnDefinition="DATETIME")
	private Date startDate;
	
	@Column(name = "END_DATE", columnDefinition="DATETIME")
	private Date endDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MEDIC_ID", nullable = false)
	private Medic medic;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PACIENT_ID", nullable = false)
	private Pacient pacient;
	
	@OneToMany(mappedBy = "reteta", cascade = CascadeType.ALL, orphanRemoval = true)
	Set<RetetaMedicament> retetaMedicament;

	public int getReteta_id() {
		return reteta_id;
	}

	public void setReteta_id(int reteta_id) {
		this.reteta_id = reteta_id;
	}

	public String getBoala() {
		return boala;
	}

	public void setBoala(String boala) {
		this.boala = boala;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Medic getMedic() {
		return medic;
	}

	public void setMedic(Medic medic) {
		this.medic = medic;
	}

	public Pacient getPacient() {
		return pacient;
	}

	public void setPacient(Pacient pacient) {
		this.pacient = pacient;
	}

	public Set<RetetaMedicament> getRetetaMedicament() {
		return retetaMedicament;
	}

	public void setRetetaMedicament(Set<RetetaMedicament> retetaMedicament) {
		this.retetaMedicament = retetaMedicament;
	}
	
	
	
}

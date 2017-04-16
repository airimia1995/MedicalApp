package com.appMedial.jsp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="PACIENT")
public class Pacient {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="PACIENT_ID")
	private int pacient_id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMAIL", nullable = false)
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MEDIC_ID", nullable = false)
	private Medic medic;

	public int getPacient_id() {
		return pacient_id;
	}

	public void setMedic_id(int pacient_id) {
		this.pacient_id = pacient_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Medic getMedic() {
		return medic;
	}

	public void setMedic(Medic medic) {
		this.medic = medic;
	}
	
	
}

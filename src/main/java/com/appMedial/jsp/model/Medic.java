package com.appMedial.jsp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="MEDIC")
public class Medic {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="MEDIC_ID")
	private int medic_id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMAIL", nullable = false)
	private User user;
	
	@Column(name="ROLE_MEDIC")
	private String role;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "medic")
	private Set<Pacient> pacient = new HashSet<Pacient>(0);
	public int getMedic_id() {
		return medic_id;
	}

	public void setMedic_id(int medic_id) {
		this.medic_id = medic_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
}

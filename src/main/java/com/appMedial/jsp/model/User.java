package com.appMedial.jsp.model;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="USER")
public class User {
	@Id 
	@Column(name="EMAIL")
	private String email;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
	private Medic medic ;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
	private Pacient pacient;
	
	@Column(name="PASSWORD")
	private String password;
		
	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="LAST_NAME")
	private String lastName;


	
	@Column(name="PROFILE_TYPE")
	private String profile;
	
	public Pacient getPacient() {
		return pacient;
	}


	public void setPacient(Pacient pacient) {
		this.pacient = pacient;
	}


	
	public String getProfile() {
		return profile;
	}


	public void setProfile(String profile) {
		this.profile = profile;
	}


	public void setMedic(Medic medic) {
		this.medic=medic;
	}
	

	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Medic getMedic() {
		return medic;
	}

}

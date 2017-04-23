package com.appMedial.jsp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MESAJE")
public class Mesaje {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="MESAJE_ID")
	private int mesaje_id;
	
	@Column(name="SENDER_EMAIL")
	private String sender_email;
	
	@Column(name="RECEIVER_EMAIL")
	private String receiver_email;
	
	@Column(name="MESAJ")
	private String mesaj;

	public int getMesaje_id() {
		return mesaje_id;
	}

	public void setMesaje_id(int mesaje_id) {
		this.mesaje_id = mesaje_id;
	}

	public String getSender_email() {
		return sender_email;
	}

	public void setSender_email(String sender_email) {
		this.sender_email = sender_email;
	}

	public String getReceiver_email() {
		return receiver_email;
	}

	public void setReceiver_email(String receiver_email) {
		this.receiver_email = receiver_email;
	}

	public String getMesaj() {
		return mesaj;
	}

	public void setMesaj(String mesaj) {
		this.mesaj = mesaj;
	}
	
	
}

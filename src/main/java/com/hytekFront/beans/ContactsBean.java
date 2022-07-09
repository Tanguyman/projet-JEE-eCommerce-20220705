package com.hytekFront.beans;

import java.sql.Date;

public class ContactsBean {

	private int id;
	private int fk_user;
	private String nom;
	private String email;
	private String sujet;
	private String message;
	private Date date;
	private int etat;
	private boolean archiver;

	public ContactsBean() {
		super();
	}

	public ContactsBean(int id, int fk_user, String nom, String email, String sujet, String message, Date date,
			int etat, boolean archiver) {
		super();
		this.id = id;
		this.fk_user = fk_user;
		this.nom = nom;
		this.email = email;
		this.sujet = sujet;
		this.message = message;
		this.date = date;
		this.etat = etat;
		this.archiver = archiver;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFk_user() {
		return fk_user;
	}

	public void setFk_user(int fk_user) {
		this.fk_user = fk_user;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSujet() {
		return sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

	public boolean isArchiver() {
		return archiver;
	}

	public void setArchiver(boolean archiver) {
		this.archiver = archiver;
	}

	@Override
	public String toString() {
		return "ContactsBean [id=" + id + ", fk_user=" + fk_user + ", nom=" + nom + ", email=" + email + ", sujet="
				+ sujet + ", message=" + message + ", date=" + date + ", etat=" + etat + ", archiver=" + archiver + "]";
	}

}
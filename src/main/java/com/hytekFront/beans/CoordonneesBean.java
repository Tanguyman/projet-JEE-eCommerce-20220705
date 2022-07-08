package com.hytekFront.beans;

public class CoordonneesBean {

	private int id;
	private String nom;
	private String adresse;
	private String telephone;
	private String email;
	private String logo;
	private boolean archiver;

	public CoordonneesBean() {
		super();
	}

	public CoordonneesBean(int id, String nom, String adresse, String telephone, String email, String logo,
			boolean archiver) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
		this.logo = logo;
		this.archiver = archiver;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public boolean isArchiver() {
		return archiver;
	}

	public void setArchiver(boolean archiver) {
		this.archiver = archiver;
	}

}

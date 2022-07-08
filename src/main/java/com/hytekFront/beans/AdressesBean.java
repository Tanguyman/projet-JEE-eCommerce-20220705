package com.hytekFront.beans;

public class AdressesBean {

	private int id;
	private int fk_user;
	private String adresse;
	private String cp;
	private String ville;
	private String pays;
	private boolean archiver;

	public AdressesBean() {
		super();
	}

	public AdressesBean(int id, int fk_user, String adresse, String cp, String ville, String pays, boolean archiver) {
		super();
		this.id = id;
		this.fk_user = fk_user;
		this.adresse = adresse;
		this.cp = cp;
		this.ville = ville;
		this.pays = pays;
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public boolean isArchiver() {
		return archiver;
	}

	public void setArchiver(boolean archiver) {
		this.archiver = archiver;
	}

	@Override
	public String toString() {
		return "Adresses [id=" + id + ", fk_user=" + fk_user + ", adresse=" + adresse + ", cp=" + cp + ", ville="
				+ ville + ", pays=" + pays + ", archiver=" + archiver + "]";
	}

}

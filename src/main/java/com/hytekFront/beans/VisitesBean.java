package com.hytekFront.beans;

import java.sql.Date;

public class VisitesBean {

	private int id;
	private int fk_prod;
	private int fk_user;
	private Date date;
	private boolean archiver;

	private ProduitsBean produit;
	private UtilisateursBean utilisateur;

	public VisitesBean() {
		super();
	}

	public VisitesBean(int id, int fk_prod, int fk_user, Date date, boolean archiver, ProduitsBean produit,
			UtilisateursBean utilisateur) {
		super();
		this.id = id;
		this.fk_prod = fk_prod;
		this.fk_user = fk_user;
		this.date = date;
		this.archiver = archiver;
		this.produit = produit;
		this.utilisateur = utilisateur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFk_prod() {
		return fk_prod;
	}

	public void setFk_prod(int fk_prod) {
		this.fk_prod = fk_prod;
	}

	public int getFk_user() {
		return fk_user;
	}

	public void setFk_user(int fk_user) {
		this.fk_user = fk_user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isArchiver() {
		return archiver;
	}

	public void setArchiver(boolean archiver) {
		this.archiver = archiver;
	}

	public ProduitsBean getProduit() {
		return produit;
	}

	public void setProduit(ProduitsBean produit) {
		this.produit = produit;
	}

	public UtilisateursBean getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(UtilisateursBean utilisateur) {
		this.utilisateur = utilisateur;
	}

	@Override
	public String toString() {
		return "VisitesBean [id=" + id + ", fk_prod=" + fk_prod + ", fk_user=" + fk_user + ", date=" + date
				+ ", archiver=" + archiver + ", produit=" + produit + ", utilisateur=" + utilisateur + "]";
	}

}
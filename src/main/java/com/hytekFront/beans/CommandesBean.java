package com.hytekFront.beans;

import java.sql.Date;
import java.util.ArrayList;

public class CommandesBean {

	private int id;
	private int fk_utilisateur;
	private Date date;
	private Double total;
	private int fk_adresse;
	private int etat; 
		// Soit la commande est traité par l’admin
		// Soit non
	private boolean archiver;
	
	private ArrayList<Details_CommandeBean> details;

	public CommandesBean() {
		super();
	}

	public CommandesBean(int fk_utilisateur, Date date, Double total, int fk_adresse, int etat, boolean archiver) {
		super();
		this.fk_utilisateur = fk_utilisateur;
		this.date = date;
		this.total = total;
		this.fk_adresse = fk_adresse;
		this.etat = etat;
		this.archiver = archiver;
	}

	public CommandesBean(int id, int fk_utilisateur, Date date, Double total, int fk_adresse, int etat,
			boolean archiver, ArrayList<Details_CommandeBean> details) {
		super();
		this.id = id;
		this.fk_utilisateur = fk_utilisateur;
		this.date = date;
		this.total = total;
		this.fk_adresse = fk_adresse;
		this.etat = etat;
		this.archiver = archiver;
		this.details = details;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFk_utilisateur() {
		return fk_utilisateur;
	}

	public void setFk_utilisateur(int fk_utilisateur) {
		this.fk_utilisateur = fk_utilisateur;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public int getFk_adresse() {
		return fk_adresse;
	}

	public void setFk_adresse(int fk_adresse) {
		this.fk_adresse = fk_adresse;
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

	public ArrayList<Details_CommandeBean> getDetails() {
		return details;
	}

	public void setDetails(ArrayList<Details_CommandeBean> details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "CommandesBean [id=" + id + ", fk_utilisateur=" + fk_utilisateur + ", date=" + date + ", total=" + total
				+ ", fk_adresse=" + fk_adresse + ", etat=" + etat + ", archiver=" + archiver + ", details=" + details
				+ "]";
	}
	
}
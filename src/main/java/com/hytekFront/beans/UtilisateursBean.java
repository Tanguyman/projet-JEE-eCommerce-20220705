package com.hytekFront.beans;

import java.sql.Date;
import java.util.ArrayList;

public class UtilisateursBean {

	private int id;
	private String nom;
	private String prenom;
	private Date date_inscription;
	private String email;
	private String password;
	private boolean archiver;

	private ArrayList<CommentairesBean> commentaires;
	/*
	 * private ArrayList<Adresses_livraisonBean> adresses; private
	 * ArrayList<FavorisBean> favoris; private ArrayList<Visites> visites;
	 */

	public UtilisateursBean() {
		super();
	}

	/*
	 * public UtilisateursBean(int id, String nom, String prenom, Date
	 * date_inscription, String email, String password, boolean archiver,
	 * ArrayList<Adresses_livraison> adresses, ArrayList<CommentairesBean>
	 * commentaires, ArrayList<Favoris> favoris, ArrayList<Visites> visites) {
	 * super(); this.id = id; this.nom = nom; this.prenom = prenom;
	 * this.date_inscription = date_inscription; this.email = email; this.password =
	 * password; this.archiver = archiver; this.adresses = adresses;
	 * this.commentaires = commentaires; this.favoris = favoris; this.visites =
	 * visites; }
	 */

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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDate_inscription() {
		return date_inscription;
	}

	public void setDate_inscription(Date date_inscription) {
		this.date_inscription = date_inscription;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isArchiver() {
		return archiver;
	}

	public void setArchiver(boolean archiver) {
		this.archiver = archiver;
	}

	public ArrayList<CommentairesBean> getCommentaires() {
		return commentaires;
	}
	
	public void setCommentaires(ArrayList<CommentairesBean> commentaires) {
		this.commentaires = commentaires;
	}
	
	/*
	 * public ArrayList<Adresses_livraisonBean> getAdresses() { return adresses; }
	 * 
	 * public void setAdresses(ArrayList<Adresses_livraisonBean> adresses) {
	 * this.adresses = adresses; }
	 * 
	 * public ArrayList<FavorisBean> getFavoris() { return favoris; }
	 * 
	 * public void setFavoris(ArrayList<FavorisBean> favoris) { this.favoris =
	 * favoris; }
	 * 
	 * public ArrayList<VisitesBean> getVisites() { return visites; }
	 * 
	 * public void setVisites(ArrayList<VisitesBean> visites) { this.visites =
	 * visites; }
	 */
	@Override
	public String toString() {
		return "UtilisateursBean [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", date_inscription="
				+ date_inscription + ", email=" + email + ", password=" + password + ", archiver=" + archiver + "]";
	}

}

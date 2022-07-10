package com.hytekFront.beans;

import java.util.ArrayList;

public class ProduitsBean {

	private int id;
	private String titre;
	private String description;
	private Double prix;
	private String image;
	private int fk_sous_categorie;
	private int stock;
	private int stock_min;
	private boolean archiver;

	private SousCategoriesBean sous_categorie;
	private ArrayList<CommentairesBean> commentaires;
	private int note_moyenne;
	private ArrayList<ImagesBean> images;

	public ProduitsBean() {
		super();
	}

	public ProduitsBean(int id, String titre, String description, Double prix, String image, int fk_sous_categorie,
			int stock, int stock_min, boolean archiver, SousCategoriesBean sous_categorie,
			ArrayList<CommentairesBean> commentaires, int note_moyenne) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.prix = prix;
		this.image = image;
		this.fk_sous_categorie = fk_sous_categorie;
		this.stock = stock;
		this.stock_min = stock_min;
		this.archiver = archiver;
		this.sous_categorie = sous_categorie;
		this.commentaires = commentaires;
		this.note_moyenne = note_moyenne;
	}



	public ProduitsBean(int id, String titre, String description, Double prix, String image, int fk_sous_categorie,
			int stock, int stock_min, boolean archiver, SousCategoriesBean sous_categorie,
			ArrayList<CommentairesBean> commentaires, int note_moyenne, ArrayList<ImagesBean> images) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.prix = prix;
		this.image = image;
		this.fk_sous_categorie = fk_sous_categorie;
		this.stock = stock;
		this.stock_min = stock_min;
		this.archiver = archiver;
		this.sous_categorie = sous_categorie;
		this.commentaires = commentaires;
		this.note_moyenne = note_moyenne;
		this.images = images;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getFk_sous_categorie() {
		return fk_sous_categorie;
	}

	public void setFk_sous_categorie(int fk_sous_categorie) {
		this.fk_sous_categorie = fk_sous_categorie;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getStock_min() {
		return stock_min;
	}

	public void setStock_min(int stock_min) {
		this.stock_min = stock_min;
	}

	public boolean isArchiver() {
		return archiver;
	}

	public void setArchiver(boolean archiver) {
		this.archiver = archiver;
	}

	public SousCategoriesBean getSous_categorie() {
		return sous_categorie;
	}

	public void setSous_categorie(SousCategoriesBean sous_categorie) {
		this.sous_categorie = sous_categorie;
	}

	public ArrayList<CommentairesBean> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(ArrayList<CommentairesBean> commentaires) {
		this.commentaires = commentaires;
	}

	public int getNote_moyenne() {
		return note_moyenne;
	}

	public void setNote_moyenne(int note_moyenne) {
		this.note_moyenne = note_moyenne;
	}

	public ArrayList<ImagesBean> getImages() {
		return images;
	}

	public void setImages(ArrayList<ImagesBean> images) {
		this.images = images;
	}

	@Override
	public String toString() {
		return "ProduitsBean [id=" + id + ", titre=" + titre + ", description=" + description + ", prix=" + prix
				+ ", image=" + image + ", fk_sous_categorie=" + fk_sous_categorie + ", stock=" + stock + ", stock_min="
				+ stock_min + ", archiver=" + archiver + ", sous_categorie=" + sous_categorie + ", commentaires="
				+ commentaires + ", note_moyenne=" + note_moyenne + ", images=" + images + "]";
	}

}

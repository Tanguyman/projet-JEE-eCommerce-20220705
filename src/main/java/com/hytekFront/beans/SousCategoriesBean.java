package com.hytekFront.beans;

import java.util.ArrayList;

public class SousCategoriesBean {

	// ATTRIBUTES
	private int id;
	private String titre;
	private int fk_categorie;
	private boolean archiver;
	
	private CategoriesBean categorie;
	private ArrayList<ProduitsBean> produitsCollection;

	// CONSTRUCTORS
	public SousCategoriesBean() {

	}

	public SousCategoriesBean(int id, String titre) {
		super();
		this.setId(id);
		this.setTitre(titre);
	}
	
	public SousCategoriesBean(int id, String titre, boolean archiver) {
		super();
		this.id = id;
		this.titre = titre;
		this.archiver = archiver;
	}

	public SousCategoriesBean(int id, String titre, int fk_categorie, boolean archiver) {
		super();
		this.id = id;
		this.titre = titre;
		this.fk_categorie = fk_categorie;
		this.archiver = archiver;
	}

	public SousCategoriesBean(int id, String titre, int fk_categorie, boolean archiver, CategoriesBean categorie) {
		super();
		this.id = id;
		this.titre = titre;
		this.fk_categorie = fk_categorie;
		this.archiver = archiver;
		this.categorie = categorie;
	}

	public SousCategoriesBean(int id, String titre, int fk_categorie, boolean archiver, CategoriesBean categorie,
			ArrayList<ProduitsBean> produitsCollection) {
		super();
		this.id = id;
		this.titre = titre;
		this.fk_categorie = fk_categorie;
		this.archiver = archiver;
		this.categorie = categorie;
		this.produitsCollection = produitsCollection;
	}

	// PROPERTIES	
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

	public int getFk_categorie() {
		return fk_categorie;
	}

	public void setFk_categorie(int fk_categorie) {
		this.fk_categorie = fk_categorie;
	}

	public boolean isArchiver() {
		return archiver;
	}

	public void setArchiver(boolean archiver) {
		this.archiver = archiver;
	}

	public CategoriesBean getCategorie() {
		return categorie;
	}

	public void setCategorie(CategoriesBean categorie) {
		this.categorie = categorie;
	}

	public ArrayList<ProduitsBean> getProduitsCollection() {
		return produitsCollection;
	}

	public void setProduitsCollection(ArrayList<ProduitsBean> produitsCollection) {
		this.produitsCollection = produitsCollection;
	}

	@Override
	public String toString() {
		return "SousCategoriesBean [id=" + id + ", titre=" + titre + ", fk_categorie=" + fk_categorie + ", archiver="
				+ archiver + ", categorie=" + categorie + ", produitsCollection=" + produitsCollection + "]";
	}
}

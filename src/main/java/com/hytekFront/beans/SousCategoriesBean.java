package com.hytekFront.beans;

public class SousCategoriesBean {

	// ATTRIBUTES
	private int id;
	private String titre;
	private int fk_categorie;
	private boolean archiver;

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

	@Override
	public String toString() {
		return "SousCategoriesBean [id=" + id + ", titre=" + titre + ", fk_categorie=" + fk_categorie + ", archiver="
				+ archiver + "]";
	}
}

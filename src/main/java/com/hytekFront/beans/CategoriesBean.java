package com.hytekFront.beans;

import java.util.ArrayList;

public class CategoriesBean {

	// ATTRIBUTES
	private int id;
	private String titre;
	private ArrayList<SousCategoriesBean> sousCategories;
	private boolean archiver;

	// CONSTRUCTORS
	public CategoriesBean() {

	}

	public CategoriesBean(int id, String titre) {
		this.setId(id);
		this.setTitre(titre);
	}
	
	public CategoriesBean(int id, String titre, boolean archiver) {
		this.id = id;
		this.titre = titre;
		this.archiver = archiver;
	}

	public CategoriesBean(int id, String titre, ArrayList<SousCategoriesBean> sousCategories, boolean archiver) {
		this.id = id;
		this.titre = titre;
		this.sousCategories = sousCategories;
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

	public ArrayList<SousCategoriesBean> getSousCategories() {
		return sousCategories;
	}

	public void setSousCategories(ArrayList<SousCategoriesBean> sousCategories) {
		this.sousCategories = sousCategories;
	}

	public boolean isArchiver() {
		return archiver;
	}

	public void setArchiver(boolean archiver) {
		this.archiver = archiver;
	}

	@Override
	public String toString() {
		return "CategoriesBean [id=" + id + ", titre=" + titre + ", sousCategories=" + sousCategories + ", archiver="
				+ archiver + "]";
	}

}

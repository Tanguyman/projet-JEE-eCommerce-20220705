package com.hytekFront.beans;

import java.util.ArrayList;

public class FavorisBean {

	private int id;
	private int fk_prod;
	private int fk_user;
	private boolean archiver;

	ArrayList<ProduitsBean> produits;

	public FavorisBean() {
		super();
	}

	public FavorisBean(int id, int fk_prod, int fk_user, boolean archiver, ArrayList<ProduitsBean> produits) {
		super();
		this.id = id;
		this.fk_prod = fk_prod;
		this.fk_user = fk_user;
		this.archiver = archiver;
		this.produits = produits;
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

	public boolean isArchiver() {
		return archiver;
	}

	public void setArchiver(boolean archiver) {
		this.archiver = archiver;
	}

	public ArrayList<ProduitsBean> getProduits() {
		return produits;
	}

	public void setProduits(ArrayList<ProduitsBean> produits) {
		this.produits = produits;
	}

	@Override
	public String toString() {
		return "FavorisBean [id=" + id + ", fk_prod=" + fk_prod + ", fk_user=" + fk_user + ", archiver=" + archiver
				+ ", produits=" + produits + "]";
	}

}
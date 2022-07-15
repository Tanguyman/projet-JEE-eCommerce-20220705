package com.hytekFront.beans;

public class FavorisBean {

	private int id;
	private int fk_prod;
	private int fk_user;
	private boolean archiver;

	private ProduitsBean produit;

	public FavorisBean() {
		super();
	}

	public FavorisBean(int id, int fk_prod, int fk_user, boolean archiver, ProduitsBean produit) {
		super();
		this.id = id;
		this.fk_prod = fk_prod;
		this.fk_user = fk_user;
		this.archiver = archiver;
		this.produit = produit;
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

	public ProduitsBean getProduit() {
		return produit;
	}

	public void setProduit(ProduitsBean produit) {
		this.produit = produit;
	}

	@Override
	public String toString() {
		return "FavorisBean [id=" + id + ", fk_prod=" + fk_prod + ", fk_user=" + fk_user + ", archiver=" + archiver
				+ ", produit=" + produit + "]";
	}

}
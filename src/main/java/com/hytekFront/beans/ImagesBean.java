package com.hytekFront.beans;

public class ImagesBean {

	private int id;
	private int fk_produit;
	private String url;
	private boolean archiver;

	public ImagesBean() {
		super();
	}

	public ImagesBean(int id, int fk_produit, String url, boolean archiver) {
		super();
		this.id = id;
		this.fk_produit = fk_produit;
		this.url = url;
		this.archiver = archiver;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFk_produit() {
		return fk_produit;
	}

	public void setFk_produit(int fk_produit) {
		this.fk_produit = fk_produit;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isArchiver() {
		return archiver;
	}

	public void setArchiver(boolean archiver) {
		this.archiver = archiver;
	}

	@Override
	public String toString() {
		return "Images [id=" + id + ", fk_produit=" + fk_produit + ", url=" + url + ", archiver=" + archiver + "]";
	}

}
package com.hytekFront.beans;

public class Panier_DetailsBean {

	private ProduitsBean produit;
	private int quantite;

	public Panier_DetailsBean() {
		super();
	}

	public Panier_DetailsBean(ProduitsBean produit, int quantite) {
		super();
		this.produit = produit;
		this.quantite = quantite;
	}

	public ProduitsBean getProduit() {
		return produit;
	}

	public void setProduit(ProduitsBean produit) {
		this.produit = produit;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	@Override
	public String toString() {
		return "Panier_Details [produit=" + produit + ", quantite=" + quantite + "]";
	}

}
package com.hytekFront.beans;

public class Details_CommandeBean {

	private int id;
	private int fk_commande;
	private int fk_produit;
	private int qte;
	private Double prix;
	private boolean archiver;

	private ProduitsBean produit;

	public Details_CommandeBean() {
		super();
	}

	public Details_CommandeBean(int id, int fk_commande, int fk_produit, int qte, Double prix, boolean archiver,
			ProduitsBean produit) {
		super();
		this.id = id;
		this.fk_commande = fk_commande;
		this.fk_produit = fk_produit;
		this.qte = qte;
		this.prix = prix;
		this.archiver = archiver;
		this.produit = produit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFk_commande() {
		return fk_commande;
	}

	public void setFk_commande(int fk_commande) {
		this.fk_commande = fk_commande;
	}

	public int getFk_produit() {
		return fk_produit;
	}

	public void setFk_produit(int fk_produit) {
		this.fk_produit = fk_produit;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
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
		return "Details_CommandeBean [id=" + id + ", fk_commande=" + fk_commande + ", fk_produit=" + fk_produit
				+ ", qte=" + qte + ", prix=" + prix + ", archiver=" + archiver + ", produit=" + produit + "]";
	}

}
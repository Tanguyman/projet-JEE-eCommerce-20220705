package com.hytekFront.beans;

import java.util.ArrayList;

public class PanierBean {

	private ArrayList<Panier_DetailsBean> panierDetails = new ArrayList<>();

	public PanierBean() {
		super();
	}

	public PanierBean(ArrayList<Panier_DetailsBean> panierDetail) {
		super();
		this.panierDetails = panierDetail;
	}

	public ArrayList<Panier_DetailsBean> getPanierDetails() {
		return panierDetails;
	}

	public void setPanierDetails(ArrayList<Panier_DetailsBean> panierDetail) {
		this.panierDetails = panierDetail;
	}

	@Override
	public String toString() {
		return "PanierBean [panierDetail=" + panierDetails + "]";
	}

	// Compte le nombre de références contenues dans le panier
	public int countReferencesPanier() { // nommage : countReferencesInBag
		return this.getPanierDetails().size();
	}
	
	// Compte le nombre d’articles contenus dans le panier
	public int countProduitsPanier() {
		int numberOfProducts = 0;
		for (Panier_DetailsBean pdB : getPanierDetails()) {
			numberOfProducts += pdB.getQuantite();
		}
		return numberOfProducts;
	}
	
	// Calcul la valeur total en € du panier
	public double total() { // nommage : amountBag()
		double total = 0;
		
		for ( Panier_DetailsBean pdB : getPanierDetails() ) {
			total += pdB.getQuantite() * pdB.getProduit().getPrix();
		}
		return total;
	}
	
	// Ajoute une ligne au panier
	public void addLineToBag(Panier_DetailsBean p) { // AddProductToOrder

		boolean lignePanierExist = false;

		for (Panier_DetailsBean searchLineInBag : getPanierDetails()) {
			if (searchLineInBag.getProduit().getId() == p.getProduit().getId()) {
				lignePanierExist = true;
				searchLineInBag.setQuantite(
						searchLineInBag.getQuantite() + p.getQuantite());
			}
		}
		
		if (!lignePanierExist) { // <=> false
			getPanierDetails().add(p);
		}
	}
	
	// Remove Product From ShoppingCart ou ShoppingBag
	public void removeProduitFromPanier (int id_Produit) {
		Panier_DetailsBean pdB = new Panier_DetailsBean();
		for ( Panier_DetailsBean sl_temp : getPanierDetails() ) {
			if ( sl_temp.getProduit().getId() == id_Produit ) {
				pdB = sl_temp;
			}
		}
		panierDetails.remove(pdB);
	}
	
	// Vider le panier
	public void clearPanier () {
		panierDetails = new ArrayList<Panier_DetailsBean>();
	}
}

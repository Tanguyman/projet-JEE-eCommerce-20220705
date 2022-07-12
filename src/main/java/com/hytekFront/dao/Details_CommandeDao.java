package com.hytekFront.dao;

import java.sql.PreparedStatement;

import com.hytekFront.beans.Details_CommandeBean;



public class Details_CommandeDao {

	// SAVE OR UPDATE
	public void save( Details_CommandeBean o ) {

		try {

			if (o.getId() != 0) {
				
				PreparedStatement ps = Database.connexion
						.prepareStatement("UPDATE details_commande SET fk_commande=?, fk_produit=?, qte=?, prix=?, archiver=? WHERE id=?");
				ps.setInt(1, o.getFk_commande());
				ps.setInt(2, o.getFk_produit());
				ps.setInt(3, o.getQte());
				ps.setDouble(4, o.getPrix());
				ps.setBoolean(5, o.isArchiver());
				
				ps.setInt(6, o.getId());
				
				ps.executeUpdate();
				
			} else {
				
				PreparedStatement ps = Database.connexion
						.prepareStatement("INSERT INTO details_commande (fk_commande, fk_produit, qte, prix, archiver) VALUES(?,?,?,?,?)");
				ps.setInt(1, o.getFk_commande());
				ps.setInt(2, o.getFk_produit());
				ps.setInt(3, o.getQte());
				ps.setDouble(4, o.getPrix());
				ps.setBoolean(5, o.isArchiver());
				
				ps.executeUpdate();
				
			}
			
			System.out.println("SAVED OK");

		} catch (Exception ex) {
			
			ex.printStackTrace();
			System.out.println("SAVED NO");
			
		}
	}
}

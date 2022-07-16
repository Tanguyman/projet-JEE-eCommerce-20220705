package com.hytekFront.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
	
	// READ / RETRIEVE ALL FROM USER
	public ArrayList<Details_CommandeBean> getAllByFk_commande (int id) {
		
		ArrayList<Details_CommandeBean> list = new ArrayList<Details_CommandeBean>();
		
		try {
	
			PreparedStatement ps = Database.connexion.
					prepareStatement("SELECT * FROM `details_commande` WHERE fk_commande=?");
			ps.setInt(1, id);
	
			ResultSet rs = ps.executeQuery();
	
			while (rs.next()) {
				
				Details_CommandeBean o = new Details_CommandeBean();
				
				o.setId(rs.getInt("id"));
				o.setFk_commande(rs.getInt("fk_commande"));
				o.setFk_produit(rs.getInt("fk_produit"));
				o.setQte(rs.getInt("qte"));
				o.setPrix(rs.getDouble("prix"));
				o.setArchiver(rs.getBoolean("archiver"));
				
//				ProduitsDao pd = new ProduitsDao();
//				o.setProduit( pd.getById( rs.getInt( "fk_produit" ) ) );
				
				list.add(o);
			}
	
			return list;
	
		} catch (Exception ex) {
			
			ex.printStackTrace();
			return null;
			
		}
	}
}

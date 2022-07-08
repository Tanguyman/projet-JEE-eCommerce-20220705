package com.hytekFront.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.hytekFront.beans.CategoriesBean;
import com.hytekFront.beans.SousCategoriesBean;

public class CategoriesDao {

	// CREATE if !exist else UPDATE
	public void save(CategoriesBean o) {
		try {

			if (o.getId() != 0) {
				
				PreparedStatement ps = Database.connexion
						.prepareStatement("UPDATE categories set titre=? WHERE id=?");
				ps.setString(1, o.getTitre());
				ps.setInt(2, o.getId());
				ps.executeUpdate();
				
			} else {
				
				PreparedStatement ps = Database.connexion
						.prepareStatement("INSERT INTO categories (titre) VALUES(?)");
				ps.setString(1, o.getTitre());
				ps.executeUpdate();
				
			}
			System.out.println("SAVED OK");

		} catch (Exception ex) {
			
			ex.printStackTrace();
			System.out.println("SAVED NO");
			
		}
	}

	// READ / RETRIEVE ONE LINE BY ID
	public CategoriesBean getById(int id) {
		try {

			PreparedStatement ps = Database.connexion
					.prepareStatement("SELECT * FROM categories WHERE id=?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			CategoriesBean u = new CategoriesBean();
			
			rs.next();
			
			u.setId(rs.getInt("id"));
			u.setTitre(rs.getString("titre"));
			
			return u;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	// READ / RETRIEVE ALL
	public ArrayList<CategoriesBean> getAll() {
		
		ArrayList<CategoriesBean> list = new ArrayList<CategoriesBean>();
		
		try {

			SousCategoriesDao sousCategoriesDao = new SousCategoriesDao();
			
			PreparedStatement ps = Database.connexion.prepareStatement("SELECT * FROM categories");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
								
				CategoriesBean o = new CategoriesBean();
				int id = rs.getInt("id"); 
				o.setId(id);
				o.setTitre(rs.getString("titre"));
				
				ArrayList<SousCategoriesBean> colSousCat = sousCategoriesDao.getByFk_categorie(id);
				o.setSousCategories(colSousCat);
								
				o.setArchiver(rs.getBoolean("archiver"));
				
				list.add(o);
				
			}

			return list;

		} catch (Exception ex) {
			
			ex.printStackTrace();
			return null;
			
		}
	}

	// READ / RETRIEVE COUNT of PRODUITS in a CATEGORIE
	// rien à foutre ici / j'interroge  la table produits !!!
	public int countProductsByIdCategories(int id) {
		try {
			
			PreparedStatement pS = Database.connexion
					.prepareStatement("SELECT COUNT(*) as numberOfProducts FROM produits WHERE categorie_id = ?");
			pS.setInt(1, id);

			ResultSet result = pS.executeQuery();
			result.next();

			int numberOfProducts = result.getInt("numberOfProducts");
			return numberOfProducts;
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
			return 0;
			
		}
	}

	// DELETE
	public void deleteById(int id) {
		try {

			PreparedStatement ps = Database.connexion
					.prepareStatement("DELETE FROM categories WHERE id=?");
			ps.setInt(1, id);

			ps.executeUpdate();

			System.out.println("DELETED OK");

		} catch (Exception ex) {
			
			ex.printStackTrace();
			System.out.println("DELETED NO");
			
		}
	}

}

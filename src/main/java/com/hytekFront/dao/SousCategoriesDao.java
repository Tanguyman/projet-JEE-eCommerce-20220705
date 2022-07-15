package com.hytekFront.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.hytekFront.beans.CategoriesBean;
import com.hytekFront.beans.ProduitsBean;
import com.hytekFront.beans.SousCategoriesBean;

public class SousCategoriesDao {

	// CREATE if !exist else UPDATE
	public void save(SousCategoriesBean o) {
		try {

			if (o.getId() != 0) {
				
				PreparedStatement ps = Database.connexion
						.prepareStatement("UPDATE sous_categories SET titre=? WHERE id=?");
				
				ps.setString(1, o.getTitre());
				
				ps.setInt(2, o.getId());
				
				ps.executeUpdate();
				
			} else {
				
				PreparedStatement ps = Database.connexion
						.prepareStatement("INSERT INTO sous_categories (titre) VALUES(?)");
				
				ps.setString(1, o.getTitre());
				
				ps.executeUpdate();
				
			}
			System.out.println("SAVED OK");

		} catch (Exception ex) {
			
			ex.printStackTrace();
			System.out.println("SAVED NO");
			
		}
	}

	// READ / RETRIEVE ONE BY ID
	public SousCategoriesBean getById(int id) {
		try {

			PreparedStatement ps = Database.connexion
					.prepareStatement("SELECT * FROM sous_categories WHERE id=?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			SousCategoriesBean o = new SousCategoriesBean();
			
			rs.next();
			
			o.setId(rs.getInt("id"));
			o.setTitre(rs.getString("titre"));
			o.setFk_categorie(rs.getInt("fk_categorie"));
			o.setArchiver(rs.getBoolean("archiver"));
			
			CategoriesDao cd = new CategoriesDao();
			CategoriesBean cb = cd.getById( rs.getInt("fk_categorie") );
			
			o.setCategorie(cb);
			
			return o;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	// READ / RETRIEVE ALL sous_categories FOR A categorie
	public ArrayList<SousCategoriesBean> getByFk_categorie(int id) {
		
		ArrayList<SousCategoriesBean> list = new ArrayList<SousCategoriesBean>();
		ProduitsDao pd = new ProduitsDao();
		
		try {

			PreparedStatement ps = Database.connexion
					.prepareStatement("SELECT * FROM sous_categories WHERE fk_categorie=?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				SousCategoriesBean o = new SousCategoriesBean();
				o.setId(rs.getInt("id"));
				o.setTitre(rs.getString("titre"));
				o.setFk_categorie(rs.getInt("fk_categorie"));
				o.setArchiver(rs.getBoolean("archiver"));
				
				ArrayList<ProduitsBean> pb = pd.getAllProductsForProduitsList( rs.getInt("id") );
				o.setProduitsCollection(pb);
				
				list.add(o);
				
			}

			return list;


		} catch (Exception ex) {
			
			ex.printStackTrace();
			return null;
			
		}
	}

	// READ / RETRIEVE ALL
	public ArrayList<SousCategoriesBean> getAll() {
		
		ArrayList<SousCategoriesBean> list = new ArrayList<SousCategoriesBean>();
		
		try {

			PreparedStatement ps = Database.connexion.prepareStatement("SELECT * FROM sous_categories");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				SousCategoriesBean o = new SousCategoriesBean();
				o.setId(rs.getInt("id"));
				o.setTitre(rs.getString("titre"));
				o.setFk_categorie(rs.getInt("fk_categorie"));
				
				list.add(o);
				
			}

			return list;

		} catch (Exception ex) {
			
			ex.printStackTrace();
			return null;
			
		}
	}
	
	// READ / RETRIEVE ALL + CATEGORIE N-1 NAME
	public ArrayList<SousCategoriesBean> getAllWithCategorieName() {
		
		ArrayList<SousCategoriesBean> list = new ArrayList<SousCategoriesBean>();
		CategoriesDao cd = new CategoriesDao();
		
		try {

			PreparedStatement ps = Database.connexion.prepareStatement("SELECT * FROM sous_categories");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				SousCategoriesBean o = new SousCategoriesBean();
				o.setId(rs.getInt("id"));
				o.setTitre(rs.getString("titre"));
				o.setFk_categorie(rs.getInt("fk_categorie"));
				
				CategoriesBean cb = cd.getById( rs.getInt("fk_categorie") );
				
				o.setCategorie(cb);
				
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
	public int countProductsByIdSousCategories(int id) {
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
					.prepareStatement("DELETE FROM sous_categories WHERE id=?");
			ps.setInt(1, id);

			ps.executeUpdate();

			System.out.println("DELETED OK");

		} catch (Exception ex) {
			
			ex.printStackTrace();
			System.out.println("DELETED NO");
			
		}
	}

}

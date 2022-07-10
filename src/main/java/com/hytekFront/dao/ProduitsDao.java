package com.hytekFront.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hytekFront.beans.ProduitsBean;

public class ProduitsDao {

	// READ / RETRIEVE ALL PRODUCTS OF A Sous Catégorie
	public ArrayList<ProduitsBean> getAllProductsForProduitsList( int fk_sous_categorie ) {
		
		ArrayList<ProduitsBean> list = new ArrayList<ProduitsBean>();
		
		try {

			PreparedStatement ps = Database.connexion
					.prepareStatement("SELECT * FROM produits WHERE fk_sous_categorie=?");
			ps.setInt(1, fk_sous_categorie);

			ResultSet rs = ps.executeQuery();

			SousCategoriesDao scd = new SousCategoriesDao();
			CommentairesDao cd = new CommentairesDao();
			
			while (rs.next()) {
				
				ProduitsBean o = new ProduitsBean();
				
				o.setId(rs.getInt("id"));
				o.setTitre(rs.getString("titre"));
				o.setDescription(rs.getString("description"));
				o.setPrix(rs.getDouble("prix"));
				o.setImage(rs.getString("image"));
				o.setFk_sous_categorie(rs.getInt("fk_sous_categorie"));
				o.setStock(rs.getInt("stock"));
				o.setStock_min(rs.getInt("stock_min"));
				o.setArchiver(rs.getBoolean("archiver"));
				
				o.setSous_categorie( scd.getById( rs.getInt( "fk_sous_categorie" ) ) );
				o.setCommentaires( cd.getByFk_prod( rs.getInt( "id" ) ) );
				o.setNote_moyenne( cd.avrScoreProduct( rs.getInt( "id" ) ) );
				

				list.add(o);
				
			}

			return list;

		} catch (Exception ex) {
			
			ex.printStackTrace();
			return null;
			
		}
	}
		

		
	// READ / RETRIEVE THE LAST 10 PRODUCTS
	public ArrayList<ProduitsBean> getAllProduitForHomePage() {
		
		ArrayList<ProduitsBean> list = new ArrayList<ProduitsBean>();
		
		try {

			PreparedStatement preparedStatement = Database.connexion
					.prepareStatement("SELECT * FROM produits ORDER BY ID DESC LIMIT 10");

			ResultSet rs = preparedStatement.executeQuery();

			SousCategoriesDao scd = new SousCategoriesDao();
			CommentairesDao cd = new CommentairesDao();
			
			while (rs.next()) {
				
				ProduitsBean o = new ProduitsBean();
				
				o.setId(rs.getInt("id"));
				o.setTitre(rs.getString("titre"));
				o.setDescription(rs.getString("description"));
				o.setPrix(rs.getDouble("prix"));
				o.setImage(rs.getString("image"));
				o.setFk_sous_categorie(rs.getInt("fk_sous_categorie"));
				o.setStock(rs.getInt("stock"));
				o.setStock_min(rs.getInt("stock_min"));
				o.setArchiver(rs.getBoolean("archiver"));
				
				o.setSous_categorie( scd.getById( rs.getInt( "fk_sous_categorie" ) ) );
				o.setCommentaires( cd.getByFk_prod( rs.getInt( "id" ) ) );
				o.setNote_moyenne( cd.avrScoreProduct( rs.getInt( "id" ) ) );
				

				list.add(o);
				
			}

			return list;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	// READ / RETRIEVE ONE LINE BY ID
	public ProduitsBean getById(int id) {
		try {

			PreparedStatement ps = Database.connexion
					.prepareStatement("SELECT * FROM produits WHERE id=?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			ProduitsBean o = new ProduitsBean();
			SousCategoriesDao scd = new SousCategoriesDao();
			CommentairesDao cd = new CommentairesDao();
			ImagesDao iDao = new ImagesDao();
			
			rs.next();
			
			o.setId(rs.getInt("id"));
			o.setTitre(rs.getString("titre"));
			o.setDescription(rs.getString("description"));
			o.setPrix(rs.getDouble("prix"));
			o.setImage(rs.getString("image"));
			o.setFk_sous_categorie(rs.getInt("fk_sous_categorie"));
			o.setStock(rs.getInt("stock"));
			o.setStock_min(rs.getInt("stock_min"));
			o.setArchiver(rs.getBoolean("archiver"));
			
			o.setSous_categorie( scd.getById( rs.getInt( "fk_sous_categorie" ) ) );
			o.setCommentaires( cd.getByFk_prod( id ) );
			o.setNote_moyenne( cd.avrScoreProduct( rs.getInt( "id" ) ) );
			o.setImages( iDao.getAllByFk_produit( id ) );
			
			return o;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	// SEARCH A WORD IN THE TITLE AND THE DESCRIPTION 
	public ArrayList<ProduitsBean> searchWordInName (String word) {
		
		ArrayList<ProduitsBean> list = new ArrayList<ProduitsBean>();
		
		PreparedStatement ps;
		
		try {
			
			ps = Database.connexion
					.prepareStatement("SELECT * FROM produits WHERE titre like ? OR description like ?");
			ps.setString(1, "%" + word + "%");
			ps.setString(2, "%" + word + "%");
			
			ResultSet rs = ps.executeQuery();
			
			SousCategoriesDao scd = new SousCategoriesDao();
			CommentairesDao cd = new CommentairesDao();
			
			while ( rs.next() ) {
				
				ProduitsBean o = new ProduitsBean();
				
				o.setId( rs.getInt("id") );
				o.setTitre( rs.getString( "titre" ) );
				o.setDescription( rs.getString( "description" ) );
				o.setPrix( rs.getDouble( "prix" ) );
				o.setImage( rs.getString( "image" ) );
				o.setFk_sous_categorie(rs.getInt("fk_sous_categorie"));
				o.setStock( rs.getInt( "stock" ) );
				o.setStock_min( rs.getInt( "stock_min" ) );
				o.setArchiver( rs.getBoolean( "archiver" ) ); // setRemovedFromSale
				// o.setRemovedFromHomePage( rs.getBoolean( "removedFromSale" ) );
				
				o.setSous_categorie( scd.getById( rs.getInt( "fk_sous_categorie" ) ) );
				o.setCommentaires( cd.getByFk_prod( rs.getInt( "id" ) ) );
				o.setNote_moyenne( cd.avrScoreProduct( rs.getInt( "id" ) ) );
				
				list.add(o);
				
			}
			
			return list;
		} catch ( SQLException e ) {
			
			e.printStackTrace();
			return null;
			
		}
	}

}

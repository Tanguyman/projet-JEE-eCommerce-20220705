package com.hytekFront.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.hytekFront.beans.ProduitsBean;

public class ProduitsDao {
	
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
}

package com.hytekFront.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.hytekFront.beans.CommentairesBean;

public class CommentairesDao {

	// READ / RETRIEVE ALL commentaires FOR ONE produit
	public ArrayList<CommentairesBean> getByFk_prod (int id) {
		
		ArrayList<CommentairesBean> list = new ArrayList<CommentairesBean>();
		
		try {

			PreparedStatement ps = Database.connexion
					.prepareStatement("SELECT * FROM commentaires WHERE fk_prod=?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				CommentairesBean o = new CommentairesBean();
				o.setId(rs.getInt("id"));
				o.setCommentaire(rs.getString("commentaire"));
				o.setNote(rs.getInt("note"));
				o.setDate(rs.getDate("date"));
				o.setFk_prod(rs.getInt("fk_prod"));
				o.setFk_user(rs.getInt("fk_user"));
				o.setArchiver(rs.getBoolean("archiver"));
				
				list.add(o);
				
			}

			return list;


		} catch (Exception ex) {
			
			ex.printStackTrace();
			return null;
			
		}
	}
	
	// CALCULER LA MOYENNE DES ÉTOILES
	public int avrScoreProduct(int id) {
		
		ArrayList<CommentairesBean> commentBean = getByFk_prod(id);
		
		Double totalScore = 0.0;
		
		for ( CommentairesBean c : commentBean ) {
			totalScore += c.getNote();
		}
		
		Double avrScore = totalScore / commentBean.size();
		long roundScore = Math.round(avrScore);
		
		return (int) roundScore;
	}
}

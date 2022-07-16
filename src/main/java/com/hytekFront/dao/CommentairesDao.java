package com.hytekFront.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.hytekFront.beans.CommentairesBean;
import com.hytekFront.beans.UtilisateursBean;

public class CommentairesDao {

	// CREATE if !exist else UPDATE
	public void save(CommentairesBean o) {
		try {

			if (o.getId() != 0) {
				
				PreparedStatement ps = Database.connexion
						.prepareStatement("UPDATE commentaires SET commentaire=?, note=?, date=?, fk_prod=?, "
								+ "fk_user=?, archiver=? WHERE id=?");
				
				ps.setString(1, o.getCommentaire());
				ps.setInt(2, o.getNote());
				ps.setDate(3, o.getDate());
				ps.setInt(4, o.getFk_prod());
				ps.setInt(5, o.getFk_user());
				ps.setBoolean(6, o.isArchiver());
				
				ps.setInt(7, o.getId());
				
				ps.executeUpdate();
				
			} else {
				
				PreparedStatement ps = Database.connexion
						.prepareStatement(
								"INSERT INTO commentaires (commentaire, note, date, fk_prod, fk_user, archiver) "
								+ "VALUES(?,?,?,?,?,?)");
				
				ps.setString(1, o.getCommentaire());
				ps.setInt(2, o.getNote());
				ps.setDate(3, o.getDate());
				ps.setInt(4, o.getFk_prod());
				ps.setInt(5, o.getFk_user());
				ps.setBoolean(6, o.isArchiver());
				
				ps.executeUpdate();
				
			}
			
			System.out.println("SAVED OK");
			

		} catch (Exception ex) {
			
			ex.printStackTrace();
			System.out.println("SAVED NO");
			
		}

	}
	
	// READ / RETRIEVE ALL commentaires FOR ONE produit
	public ArrayList<CommentairesBean> getByFk_prod (int id) {
		
		ArrayList<CommentairesBean> list = new ArrayList<CommentairesBean>();
		UtilisateursDao ud = new UtilisateursDao();
		
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
				
				UtilisateursBean ub = ud.getById(rs.getInt("fk_user"));
				o.setUtilisateur(ub);
				
				list.add(o);
				
			}

			return list;


		} catch (Exception ex) {
			
			ex.printStackTrace();
			return null;
			
		}
	}
	
	// READ / RETRIEVE ALL commentaires FOR ONE user
	public ArrayList<CommentairesBean> getByFk_user (int id) {
		
		ArrayList<CommentairesBean> list = new ArrayList<CommentairesBean>();
		UtilisateursDao ud = new UtilisateursDao();
		
		try {

			PreparedStatement ps = Database.connexion
					.prepareStatement("SELECT * FROM commentaires WHERE fk_user=?");
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
				
				UtilisateursBean ub = ud.getById(rs.getInt(id));
				o.setUtilisateur(ub);
				
				list.add(o);
				
			}

			return list;


		} catch (Exception ex) {
			
			ex.printStackTrace();
			return null;
			
		}
	}
	
	// READ / RETRIEVE THE commentaires OF A THE user
	public CommentairesBean getByFk_prodAndFk_user (int fk_prod, int fk_user) {
		// SELECT * FROM `commentaires` WHERE fk_prod=18 AND fk_user=3
		
		UtilisateursDao ud = new UtilisateursDao();
		
		try {

			PreparedStatement ps = Database.connexion
					.prepareStatement("SELECT * FROM commentaires WHERE fk_prod=? AND fk_user=?");
			ps.setInt(1, fk_prod);
			ps.setInt(2, fk_user);

			ResultSet rs = ps.executeQuery();

			rs.next();
				
			CommentairesBean o = new CommentairesBean();
			
			o.setId(rs.getInt("id"));
			o.setCommentaire(rs.getString("commentaire"));
			o.setNote(rs.getInt("note"));
			o.setDate(rs.getDate("date"));
			o.setFk_prod(rs.getInt("fk_prod"));
			o.setFk_user(rs.getInt("fk_user"));
			o.setArchiver(rs.getBoolean("archiver"));
			
			UtilisateursBean ub = ud.getById(rs.getInt("fk_user"));
			o.setUtilisateur(ub);
			
			return o;


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

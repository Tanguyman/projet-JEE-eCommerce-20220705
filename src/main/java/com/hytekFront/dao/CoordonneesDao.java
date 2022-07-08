package com.hytekFront.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hytekFront.beans.CoordonneesBean;

public class CoordonneesDao {

	// CREATE if !exist else UPDATE
//	public void save(CoordonneesBean o) {
//		try {
//
//			if (o.getId() != 0) {
//				
//				PreparedStatement ps = Database.connexion
//						.prepareStatement("UPDATE coordonnees set titre=? WHERE id=?");
//				ps.setString(1, o.getTitre());
//				ps.setInt(2, o.getId());
//				ps.executeUpdate();
//				
//			} else {
//				
//				PreparedStatement ps = Database.connexion
//						.prepareStatement("INSERT INTO coordonnees (titre) VALUES(?)");
//				ps.setString(1, o.getTitre());
//				ps.executeUpdate();
//				
//			}
//			System.out.println("SAVED OK");
//
//		} catch (Exception ex) {
//			
//			ex.printStackTrace();
//			System.out.println("SAVED NO");
//			
//		}
//	}
	
	public CoordonneesBean getById(int id) {
		try {

			PreparedStatement ps = Database.connexion
					.prepareStatement("SELECT * FROM coordonnees WHERE id=?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			
			CoordonneesBean o = new CoordonneesBean();
			
			rs.next();
			
			o.setId(rs.getInt("id"));
			o.setNom(rs.getString("nom"));
			o.setAdresse(rs.getString("adresse"));
			o.setTelephone(rs.getString("telephone"));
			o.setEmail(rs.getString("email"));
			o.setLogo(rs.getString("logo"));
			o.setArchiver(rs.getBoolean("archiver"));
							
			return o;

		} catch (Exception ex) {
			
			ex.printStackTrace();
			return null;
			
		}
	}
}

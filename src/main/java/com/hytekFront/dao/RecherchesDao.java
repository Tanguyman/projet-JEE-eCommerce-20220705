package com.hytekFront.dao;

import java.sql.PreparedStatement;

import com.hytekFront.beans.RecherchesBean;

public class RecherchesDao {

	public void save(RecherchesBean o) {
		
		try {

			if (o.getId() != 0) {
				
				PreparedStatement ps = Database.connexion
						.prepareStatement("UPDATE recherches SET fk_user=?, motcle=?, date=?, archiver=? WHERE id=?");
				
				ps.setInt(1, o.getFk_user());
				ps.setString(2, o.getMotcle());
				ps.setDate(3, o.getDate());
				ps.setBoolean(4, o.isArchiver());
				
				ps.setInt(5, o.getId());
				
				ps.executeUpdate();
				
			} else {
				PreparedStatement ps = Database.connexion
						.prepareStatement("INSERT INTO recherches (fk_user, motcle, date, archiver) VALUES(?,?,?,?)");
				
				ps.setInt(1, o.getFk_user());
				ps.setString(2, o.getMotcle());
				ps.setDate(3, o.getDate());
				ps.setBoolean(4, o.isArchiver());
				
				ps.executeUpdate();
				
			}
			System.out.println("SAVED OK");

		} catch (Exception ex) {
			
			ex.printStackTrace();
			System.out.println("SAVED NO");
			
		}
	}
}

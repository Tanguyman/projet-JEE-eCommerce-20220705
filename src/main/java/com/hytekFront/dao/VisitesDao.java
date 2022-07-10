package com.hytekFront.dao;

import java.sql.PreparedStatement;

import com.hytekFront.beans.VisitesBean;

public class VisitesDao {

	public void save(VisitesBean o) {
		try {

			if (o.getId() != 0) {
				
				PreparedStatement ps = Database.connexion
						.prepareStatement("UPDATE visites SET fk_prod=?, fk_user=?, date=?, archiver=? WHERE id=?");
				
				ps.setInt(1, o.getFk_prod());
				ps.setInt(2, o.getFk_user());
				ps.setDate(3, o.getDate());
				ps.setBoolean(4, o.isArchiver());
				
				ps.setInt(4, o.getId());
				
				ps.executeUpdate();
				
			} else {
				
				PreparedStatement ps = Database.connexion
						.prepareStatement("INSERT INTO visites (fk_prod, fk_user, date, archiver) VALUES(?,?,?,?)");
				
				ps.setInt(1, o.getFk_prod());
				ps.setInt(2, o.getFk_user());
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

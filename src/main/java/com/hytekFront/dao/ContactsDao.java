package com.hytekFront.dao;

import java.sql.PreparedStatement;

import com.hytekFront.beans.ContactsBean;

public class ContactsDao {

	
	// CREATE if !exist else UPDATE
	public void save( ContactsBean o ) {
		try {
			
			if (o.getId() != 0) {
				
				PreparedStatement ps = Database.connexion
						.prepareStatement("UPDATE contacts SET fk_user=?, nom=?, "
								+ "email=?, sujet=?, message=?, date=?, etat=?, archiver=? WHERE id=?");

				ps.setInt(1, o.getFk_user());
				ps.setString(2, o.getNom());
				ps.setString(3, o.getEmail());
				ps.setString(4, o.getSujet());
				ps.setString(5, o.getMessage());
				ps.setDate(6, o.getDate());
				ps.setInt(7, o.getEtat());
				ps.setBoolean(8, o.isArchiver());
				
				ps.setInt(9, o.getId());
				
				ps.executeUpdate();
				
			} else {
				
				PreparedStatement ps = Database.connexion
						.prepareStatement("INSERT INTO contacts "
								+ "(fk_user, nom, email, sujet, message, date, etat, archiver) "
								+ "VALUES(?,?,?,?,?,?,?,?)");
				
				ps.setInt(1, o.getFk_user());
				ps.setString(2, o.getNom());
				ps.setString(3, o.getEmail());
				ps.setString(4, o.getSujet());
				ps.setString(5, o.getMessage());
				ps.setDate(6, o.getDate());
				ps.setInt(7, o.getEtat());
				ps.setBoolean(8, o.isArchiver());
				
				ps.executeUpdate();
			}
			
			System.out.println("SAVED OK");

		} catch (Exception ex) {
			
			ex.printStackTrace();
			System.out.println("SAVED NO");
			
		}
	}
}

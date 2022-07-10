package com.hytekFront.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hytekFront.beans.UtilisateursBean;


public class UtilisateursDao {
	
	// CREATE if !exist else UPDATE
	public void save(UtilisateursBean o) {
		try {

			if (o.getId() != 0) {
				
				PreparedStatement ps = Database.connexion
						.prepareStatement("UPDATE utilisateurs SET nom=?, prenom=?, "
								+ "date_inscription=?, email=?, password=?, archiver=? WHERE id=?");

				ps.setString(1, o.getNom());
				ps.setString(2, o.getPrenom());
				ps.setDate(3, o.getDate_inscription());
				ps.setString(4, o.getEmail());
				ps.setString(5, o.getPassword());
				ps.setBoolean(6, o.isArchiver());
				
				ps.setInt(7, o.getId());
				
				ps.executeUpdate();
				
			} else {
				
				PreparedStatement ps = Database.connexion
						.prepareStatement("INSERT INTO utilisateurs "
								+ "(nom, prenom, date_inscription, email, password, archiver) "
								+ "VALUES(?,?,?,?,?,?)");
				
				ps.setString(1, o.getNom());
				ps.setString(2, o.getPrenom());
				ps.setDate(3, o.getDate_inscription());
				ps.setString(4, o.getEmail());
				ps.setString(5, o.getPassword());
				ps.setBoolean(6, o.isArchiver());
				
				ps.executeUpdate();
			}
			
			System.out.println("SAVED OK");

		} catch (Exception ex) {
			
			ex.printStackTrace();
			System.out.println("SAVED NO");
			
		}
	}
	
	// READ / RETRIEVE ONE LINE BY mail
	public UtilisateursBean getByMail(String mail) {
		
		try {
			
			PreparedStatement ps = Database.connexion
					.prepareStatement("SELECT * FROM utilisateurs WHERE email=?");
			ps.setString(1, mail);

			ResultSet rs = ps.executeQuery();
			// System.out.println(rs);
			
			if (rs.next()) {
				
				UtilisateursBean u = new UtilisateursBean();
				u.setEmail(rs.getString("email"));
				u.setNom(rs.getNString("nom"));
				return u;
				
			} else {
				
				return null;
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
			
		}
		
	}
	
	// READ / RETRIEVE ONE LINE BY id
	public UtilisateursBean getById( int id ) {
		
		try {
			
			PreparedStatement ps = Database.connexion
					.prepareStatement("SELECT * FROM utilisateurs WHERE id=?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			// System.out.println(rs);
			
			if (rs.next()) {
				
				UtilisateursBean u = new UtilisateursBean();
				
				u.setId(rs.getInt("id"));
				u.setNom(rs.getString("nom"));
				u.setPrenom(rs.getString("prenom"));
				u.setDate_inscription(rs.getDate("date_inscription"));
				u.setEmail(rs.getString("email"));
				u.setArchiver(rs.getBoolean("archiver"));
				
				return u;
				
			} else {
				
				return null;
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
			
		}
		
	}
		
	// PASSWORD VERIFICATION
	public UtilisateursBean passwordVerification(String mail, String password) {
		try {

			PreparedStatement ps = Database.connexion
					.prepareStatement("SELECT * FROM utilisateurs WHERE email=? AND password=?");
			ps.setString(1, mail);
			ps.setString(2, password);
			// preparedStatement.setString(2,"123");

			ResultSet rs = ps.executeQuery();
			// System.out.println("Resultset de connectionUser() next : " +
			// resultat.next());

			if (rs.next()) {
				UtilisateursBean o = new UtilisateursBean();
				o.setId(rs.getInt("id"));
				o.setPrenom(rs.getString("prenom"));
				o.setEmail(rs.getString("email"));
				o.setPassword(rs.getString("password"));

				return o;
				
			} else {
				return null;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}

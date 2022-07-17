package com.hytekFront.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.hytekFront.beans.AdressesBean;

public class AdressesDao {

	public static void save(AdressesBean o) {
		
		try {

			if (o.getId() != 0) {
				
				PreparedStatement ps = Database.connexion
						.prepareStatement("UPDATE adresses_livraison SET fk_user=?, adresse=?, "
								+ "cp=?, ville=?, archiver=? WHERE id=?");
				
				ps.setInt(1, o.getFk_user());
				ps.setString(2, o.getAdresse());
				ps.setString(3, o.getCp());
				ps.setString(4, o.getVille());
				ps.setBoolean(5, o.isArchiver());
				
				ps.setInt(6, o.getId());
				
				ps.executeUpdate();
				
			} else {
				
				PreparedStatement ps = Database.connexion
						.prepareStatement("INSERT INTO adresses_livraison "
								+ "(fk_user, adresse, cp, ville, archiver) "
								+ "VALUES(?,?,?,?,?)");
				
				ps.setInt(1, o.getFk_user());
				ps.setString(2, o.getAdresse());
				ps.setString(3, o.getCp());
				ps.setString(4, o.getVille());
				ps.setBoolean(5, o.isArchiver());
				
				ps.executeUpdate();
			}
			
			System.out.println("SAVED OK");

		} catch (Exception ex) {
			
			ex.printStackTrace();
			System.out.println("SAVED NO");
			
		}
		
	}
	
	// READ / RETRIEVE ALL ADDRESS FROM USER
	public ArrayList<AdressesBean> getAllByUserId(int id) {
		
		ArrayList<AdressesBean> list = new ArrayList<AdressesBean>();
		
		try {

			PreparedStatement ps = Database.connexion.
					prepareStatement("SELECT * FROM `adresses_livraison` WHERE fk_user=?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				AdressesBean o = new AdressesBean();
				
				o.setId(rs.getInt("id"));
				o.setFk_user(rs.getInt("fk_user"));
				o.setAdresse(rs.getString("adresse"));
				o.setCp(rs.getString("cp"));
				o.setVille(rs.getString("ville"));
				o.setPays(rs.getString("pays"));
				o.setArchiver(rs.getBoolean("archiver"));
				
				list.add(o);
			}

			return list;

		} catch (Exception ex) {
			
			ex.printStackTrace();
			return null;
			
		}
		
	}
	
	// DELETE
	public static void deleteById (int id) {
		
		try {

			PreparedStatement ps = Database.connexion
					.prepareStatement("DELETE FROM adresses_livraison WHERE id=?");
			
			ps.setInt(1, id);

			ps.executeUpdate();

			System.out.println("DELETED OK");
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
			System.out.println("DELETED NO");
			
		}
		
	}
		
}

package com.hytekFront.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.hytekFront.beans.AdressesBean;

public class AdressesDao {

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
		
}

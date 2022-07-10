package com.hytekFront.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.hytekFront.beans.ImagesBean;

public class ImagesDao {

	// READ / RETRIEVE ALL BY fk_produit
	public ArrayList<ImagesBean> getAllByFk_produit( int id ) {
		ArrayList<ImagesBean> list = new ArrayList<ImagesBean>();
		try {

			PreparedStatement ps = Database.connexion.prepareStatement("SELECT * FROM images WHERE fk_produit=?");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ImagesBean o = new ImagesBean();
				o.setId(rs.getInt("id"));
				o.setFk_produit(rs.getInt("fk_produit"));
				o.setUrl(rs.getString("url"));
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

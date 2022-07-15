package com.hytekFront.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.hytekFront.beans.FavorisBean;

public class FavorisDao {

	// CREATE if !exist else UPDATE
	public void save(FavorisBean o) {
		
		try {

			if (o.getId() != 0) {
				
				PreparedStatement ps = Database.connexion
						.prepareStatement("UPDATE favoris SET fk_prod=?, fk_user=?, archiver=? WHERE id=?");
				
				ps.setInt(1, o.getFk_prod());
				ps.setInt(2, o.getFk_user());
				ps.setBoolean(3, o.isArchiver());
				
				ps.setInt(4, o.getId());
				
				ps.executeUpdate();
				
			} else {
				
				PreparedStatement ps = Database.connexion
						.prepareStatement("INSERT INTO favoris (fk_prod, fk_user, archiver) VALUES(?,?,?)");
				
				ps.setInt(1, o.getFk_prod());
				ps.setInt(2, o.getFk_user());
				ps.setBoolean(3, o.isArchiver());
				
				ps.executeUpdate();
				
			}
			System.out.println("SAVED OK");

		} catch (Exception ex) {
			
			ex.printStackTrace();
			System.out.println("SAVED NO");
			
		}
	}
	
	// READ / RETRIEVE ONE BY fk_user AND fk_prod
	public FavorisBean getByFk_userAndFk_prod (int fk_user, int fk_prod) {
		
		FavorisBean o = new FavorisBean();
		
		try {
			
			PreparedStatement ps = Database.connexion
					.prepareStatement("SELECT * FROM favoris WHERE fk_user=? AND fk_prod=?");
			
			ps.setInt(1, fk_user);
			ps.setInt(2, fk_prod);
			
			ResultSet rs = ps.executeQuery();
			
			ProduitsDao pd = new ProduitsDao();
			
			rs.next();
			
			o.setId(rs.getInt("id"));
			o.setFk_prod(rs.getInt("fk_prod"));
			o.setFk_user(rs.getInt("fk_user"));
			o.setArchiver(rs.getBoolean("archiver"));
			
			o.setProduit( pd.getById( rs.getInt("fk_prod") ) );
			
			return o;

		} catch (Exception ex) {
			
			ex.printStackTrace();
			return null;
			
		}
		
	}
	
	// READ / RETRIEVE ALL BY fk_user
	public ArrayList<FavorisBean> getByFk_user(int fk_user) {

		ArrayList<FavorisBean> list = new ArrayList<FavorisBean>();
	
		try {
			
			PreparedStatement ps = Database.connexion
					.prepareStatement("SELECT * FROM favoris WHERE fk_user=?");
			
			ps.setInt(1, fk_user);
			
			ResultSet rs = ps.executeQuery();
			
			ProduitsDao pd = new ProduitsDao();
			
			while ( rs.next() ) {
				
				FavorisBean o = new FavorisBean();
				
				o.setId(rs.getInt("id"));
				o.setFk_prod(rs.getInt("fk_prod"));
				o.setFk_user(rs.getInt("fk_user"));
				o.setArchiver(rs.getBoolean("archiver"));
				
				o.setProduit( pd.getById( rs.getInt("fk_prod") ) );
				
				list.add(o);
			}
			
			return list;

		} catch (Exception ex) {
			
			ex.printStackTrace();
			return null;
			
		}
	}
}
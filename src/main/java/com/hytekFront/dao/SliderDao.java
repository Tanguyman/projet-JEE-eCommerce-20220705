package com.hytekFront.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.hytekFront.beans.SliderBean;

public class SliderDao {

	public void save(SliderBean o) {
		try {

			if (o.getId() != 0) {
				PreparedStatement ps = Database.connexion
						.prepareStatement("UPDATE slider set titre=? WHERE id=?");
				ps.setString(1, o.getTitre());
				ps.setInt(2, o.getId());
				ps.executeUpdate();
			} else {
				PreparedStatement ps = Database.connexion
						.prepareStatement("INSERT INTO slider (titre) VALUES(?)");
				ps.setString(1, o.getTitre());
				ps.executeUpdate();
			}
			System.out.println("SAVED OK");

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("SAVED NO");
		}
	}

	// READ / RETRIEVE ONE LINE BY ID
	public SliderBean getById(int id) {
		try {

			PreparedStatement ps = Database.connexion
					.prepareStatement("SELECT * FROM slider WHERE id=?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			SliderBean u = new SliderBean();
			while (rs.next()) {
				u.setId(rs.getInt("id"));
				u.setTitre(rs.getString("titre"));
			}
			return u;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	// READ / RETRIEVE ALL
	public ArrayList<SliderBean> getAll() {
		ArrayList<SliderBean> list = new ArrayList<SliderBean>();
		try {

			PreparedStatement preparedStatement = Database.connexion.prepareStatement("SELECT * FROM slider");

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				SliderBean o = new SliderBean();
				o.setId(rs.getInt("id"));
				o.setTitre(rs.getString("titre"));
				o.setDescription(rs.getString("description"));
				o.setTitreBouton(rs.getString("titreBouton"));
				o.setUrl(rs.getString("url"));
				o.setImage(rs.getString("image"));
				o.setArchiver(rs.getBoolean("archiver"));
				
				list.add(o);
			}

			return list;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	// READ / RETRIEVE COUNT of PRODUITS in a CATEGORIE
	public int countProductsByIdSlider(int id) {
		try {
			PreparedStatement pS = Database.connexion
					.prepareStatement("SELECT COUNT(*) as numberOfProducts FROM produits WHERE categorie_id = ?");
			pS.setInt(1, id);

			ResultSet result = pS.executeQuery();
			result.next();

			int numberOfProducts = result.getInt("numberOfProducts");
			return numberOfProducts;
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	// DELETE
	public void deleteById(int id) {
		try {

			PreparedStatement preparedStatement = Database.connexion
					.prepareStatement("DELETE FROM slider WHERE id=?");
			preparedStatement.setInt(1, id);

			preparedStatement.executeUpdate();

			System.out.println("DELETED OK");

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("DELETED NO");
		}
	}

}

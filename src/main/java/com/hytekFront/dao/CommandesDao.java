package com.hytekFront.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.hytekFront.beans.CommandesBean;

public class CommandesDao {

	// CREATE OR UPDATE
	public int save(CommandesBean o) {
		
		int newId = 0; // Pour récupèrer l’id de la Commande créée
		
		try {
			if (o.getId() != 0) {
				
				PreparedStatement ps = Database.connexion
						.prepareStatement("UPDATE `commandes` SET fk_utilisateur=?, date=?, "
								+ "total=?, fk_adresse=?, etat=?, archiver=? WHERE id=?");
				
				ps.setInt(1, o.getFk_utilisateur());
				ps.setDate(2, o.getDate());
				ps.setDouble(3, o.getTotal());
				ps.setInt(4, o.getFk_adresse());
				ps.setInt(5, o.getEtat());
				ps.setBoolean(6, o.isArchiver());
				
				ps.setInt(7, o.getId());
				
				ps.executeUpdate();
				
				newId = o.getFk_utilisateur();
				
			} else {
				PreparedStatement ps = Database.connexion
						.prepareStatement("INSERT INTO `commandes` (fk_utilisateur,date,total,fk_adresse,etat,archiver) "
								+ "VALUES(?,?,?,?,?,?)", 
								Statement.RETURN_GENERATED_KEYS);
				
				ps.setInt(1, o.getFk_utilisateur());
				ps.setDate(2, o.getDate());
				ps.setDouble(3, o.getTotal());
				ps.setInt(4, o.getFk_adresse());
				ps.setInt(5, o.getEtat());
				ps.setBoolean(6, o.isArchiver());
				
				ps.executeUpdate();

				ResultSet resultat = ps.getGeneratedKeys();
				resultat.next();
				newId = resultat.getInt(1);
			}
			System.out.println("SAVED OK");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("SAVED NO");
		}
		return newId;
	}
	
	// READ / RETRIEVE ALL FROM USER
	public ArrayList<CommandesBean> getAllByUserId(int id) {
		
		ArrayList<CommandesBean> list = new ArrayList<CommandesBean>();
		
		try {

			PreparedStatement ps = Database.connexion.
					prepareStatement("SELECT * FROM `commandes` WHERE fk_utilisateur=?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				CommandesBean o = new CommandesBean();
				
				o.setId(rs.getInt("id"));
				o.setFk_utilisateur(rs.getInt("fk_utilisateur"));
				o.setDate(rs.getDate("date"));
				o.setTotal(rs.getDouble("total"));
				o.setFk_adresse(rs.getInt("fk_adresse"));
				o.setEtat(rs.getInt("etat"));
				o.setArchiver(rs.getBoolean("archiver"));
				
//				Details_CommandeDao dcd = new Details_CommandeDao();
//				o.setDetails( dcd.getAllByFk_commande( rs.getInt("id") ) );
				
				list.add(o);
			}

			return list;

		} catch (Exception ex) {
			
			ex.printStackTrace();
			return null;
			
		}
	}
}

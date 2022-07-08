package com.hytekFront.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

	private static String dburl = "jdbc:mysql://localhost:8889/projetdeux_tangflo";
	private static String dbuser = "root";
	private static String dbpass = "root";
	public static Connection connexion = null;

	public static void Connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance(); // .newInstance()
			System.out.println("Driver JDBC OK");
			connexion = DriverManager.getConnection(dburl, dbuser, dbpass);

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("PROBLEME MYSQL DRIVER");
		}
	}
	
}

package com.hytekFront.servlets;

import java.io.IOException;
import java.util.ArrayList;

import com.hytekFront.beans.CategoriesBean;
import com.hytekFront.beans.CoordonneesBean;
import com.hytekFront.beans.PanierBean;
import com.hytekFront.beans.SousCategoriesBean;
import com.hytekFront.dao.CategoriesDao;
import com.hytekFront.dao.CoordonneesDao;
import com.hytekFront.dao.Database;
import com.hytekFront.dao.SousCategoriesDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Header
 */
public class Header extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Header() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session = request.getSession(true);
		session.setMaxInactiveInterval(600);
		if (session.getAttribute("isConnected") == null) {
			session.setAttribute("isConnected", false);
		}
		
		if ((PanierBean) session.getAttribute("panier") == null ) {
			PanierBean panier = new PanierBean();
			System.out.println("panier : " + panier);
			session.setAttribute("panier", panier); 
		}
		  
		// if favoris
		  
		 
		
		String names[] = session.getValueNames();
		for ( int i = 0, n = names.length; i < n; i++ ) {
			String key = names[i];
			System.out.println("Session key (Header) : " + key + "-> Session value : " + session.getValue(key));
		}
		
		Database.Connect();
		
		CategoriesDao categoriesDao = new CategoriesDao();
		SousCategoriesDao sousCategoriesDao = new SousCategoriesDao();
		CoordonneesDao coordonneesDao = new CoordonneesDao();
		
		ArrayList<CategoriesBean> colCats = categoriesDao.getAll();
		ArrayList<SousCategoriesBean> colSousCats = sousCategoriesDao.getAll();
		CoordonneesBean coordonnee = coordonneesDao.getById(1);
		
		request.setAttribute("cats", colCats);
		request.setAttribute("sousCats", colSousCats);
		request.setAttribute("coordonnee", coordonnee);
		request.getRequestDispatcher("/header.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

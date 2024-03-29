package com.hytekFront.servlets;

import java.io.IOException;
import java.util.ArrayList;

import com.hytekFront.beans.ProduitsBean;
import com.hytekFront.beans.SousCategoriesBean;
import com.hytekFront.dao.Database;
import com.hytekFront.dao.ProduitsDao;
import com.hytekFront.dao.SousCategoriesDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Produits_List
 */
public class Produits_List extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Produits_List() {
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
		
		int idSousCat = Integer.parseInt( request.getParameter("idSousCat") );
		
		Database.Connect();
		
		ProduitsDao pd = new ProduitsDao();
		SousCategoriesDao scd = new SousCategoriesDao();
		
		ArrayList<ProduitsBean> pb = pd.getAllProductsForProduitsList(idSousCat);
		SousCategoriesBean scb = scd.getById(idSousCat);
		System.out.println(scb);
		
		request.setAttribute("produits", pb);
		request.setAttribute("sousCategorie", scb);
		request.getRequestDispatcher("produits_List.jsp").forward(request, response);
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

package com.hytekFront.servlets;

import java.io.IOException;
import java.util.ArrayList;

import com.hytekFront.beans.CategoriesBean;
import com.hytekFront.beans.ProduitsBean;
import com.hytekFront.beans.SousCategoriesBean;
import com.hytekFront.dao.CategoriesDao;
import com.hytekFront.dao.Database;
import com.hytekFront.dao.ProduitsDao;
import com.hytekFront.dao.SousCategoriesDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Produits_Per_CategorieN0
 */
public class Produits_Per_CategorieN0 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Produits_Per_CategorieN0() {
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
		
		int idCatN0 = Integer.parseInt( request.getParameter( "idCatN0" ) );
		System.out.println(idCatN0);
		
		Database.Connect();
		
		CategoriesDao cd = new CategoriesDao();
		SousCategoriesDao sousCategoriesDao = new SousCategoriesDao();
		ProduitsDao p = new ProduitsDao();
		
		CategoriesBean cb = cd.getById(idCatN0);
		ArrayList<SousCategoriesBean> colSousCats = sousCategoriesDao.getByFk_categorie(idCatN0);
		ArrayList<ProduitsBean> colProds = p.getAllProduitForHomePage();
		
		request.setAttribute("categorie", cb);
		request.setAttribute("categories", colSousCats);
		request.setAttribute("produits", colProds);
		request.getRequestDispatcher("produits_Per_CategorieN0.jsp").forward(request, response);
		
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

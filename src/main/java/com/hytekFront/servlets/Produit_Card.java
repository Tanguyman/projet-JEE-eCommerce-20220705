package com.hytekFront.servlets;

import java.io.IOException;
import java.util.ArrayList;

import com.hytekFront.beans.ProduitsBean;
import com.hytekFront.dao.Database;
import com.hytekFront.dao.ProduitsDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Produit_Card
 */
public class Produit_Card extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Produit_Card() {
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
		
		int id = Integer.parseInt( request.getParameter( "id"));
		
		Database.Connect();
		
		ProduitsDao pd = new ProduitsDao();
		
		ProduitsBean pb = pd.getById(id);
		ArrayList<ProduitsBean> pbCol = pd.getAllProductsForProduitsList( pb.getFk_sous_categorie() );
		System.out.println(pbCol);
		
		request.setAttribute("produit", pb);
		request.setAttribute("produitsList", pbCol);
		request.getRequestDispatcher("produit_Card.jsp").forward(request, response);
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

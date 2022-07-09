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
 * Servlet implementation class Recherches
 */
public class Recherches extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Recherches() {
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
		
		String word = request.getParameter("word");
		System.out.println(word);
		
		Database.Connect();
		
		ProduitsDao pd = new ProduitsDao();
		
		ArrayList<ProduitsBean> collectionProductName = pd.searchWordInName(word);
		
		System.out.println("word dans titre : " + collectionProductName);
		
		request.setAttribute("word", word);
		request.setAttribute("collectionProductName", collectionProductName);
		
		request.getRequestDispatcher("recherche.jsp").forward(request, response);
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

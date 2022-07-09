package com.hytekFront.servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import com.hytekFront.beans.ProduitsBean;
import com.hytekFront.beans.RecherchesBean;
import com.hytekFront.dao.Database;
import com.hytekFront.dao.ProduitsDao;
import com.hytekFront.dao.RecherchesDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
		
		HttpSession session = request.getSession(true); // Retourne ou crée la session
		
		String word = request.getParameter("word");
		System.out.println(word);
		
		Database.Connect();
		
		ProduitsDao pd = new ProduitsDao();
		RecherchesDao rd = new RecherchesDao();
		
		ArrayList<ProduitsBean> collectionProductName = pd.searchWordInName(word);
		
		if ( (boolean) session.getAttribute("isConnected") ) {
			// enregistrer le lead : id_User, dateArrival, product_Id
			
			RecherchesBean rb = new RecherchesBean();
			
			rb.setFk_user((int) session.getAttribute("userId"));
			long millis = System.currentTimeMillis();
			Date date = new Date(millis);
			rb.setDate( date );
			rb.setMotcle(word);
			rb.setArchiver(false);
			System.out.println(rb);				
			rd.save(rb);
			
		} else {
			
			// enregistrer le lead : id_User == null car est un visiteur pas connecté, dateArrival, product_Id
			RecherchesBean rb = new RecherchesBean();
			
			rb.setFk_user(1);
			long millis = System.currentTimeMillis();
			Date date = new Date(millis);
			rb.setDate( date );
			rb.setMotcle(word);
			rb.setArchiver(false);
			System.out.println(rb);				
			rd.save(rb);
		}
		
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

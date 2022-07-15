package com.hytekFront.servlets;

import java.io.IOException;

import com.hytekFront.beans.FavorisBean;
import com.hytekFront.dao.FavorisDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Favoris
 */
public class Favoris extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Favoris() {
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
		
		if ( request.getParameter("loginFrom") != null ) {
			
			int idProduct = Integer.parseInt( request.getParameter("idProduct") );
			String loginFrom = request.getParameter("loginFrom");
			int userId = (int) session.getAttribute("userId");
			
			FavorisDao fd = new FavorisDao();
			
			/*
			 * Le User vient de la page d’accueil
			 */
			// Se connecter et persister le favoris
			// en cliquant sur ajouter aux favoris
			if ( loginFrom.equals( "indexFavoris" ) ) {	
				
				if ( fd.getByFk_userAndFk_prod(userId, idProduct) != null ) {
					
					response.sendRedirect("Index");
					
				} else {
					
					FavorisBean fb = new FavorisBean();
					fb.setFk_prod(idProduct);
					fb.setFk_user(userId);
					
					fd.save(fb);
					
					response.sendRedirect("Index");
					
				}
				
			}
			
			// Effacer le favoris depuis la page d’accueil
			if ( loginFrom.equals( "delete" ) ) {
				
				fd.deleteByFk_prodAndFk_user(idProduct, userId);
				
				response.sendRedirect("Index");
			}
			
			// Ajouter le favoris depuis la page d’accueil
			if ( loginFrom.equals( "save" ) ) {	
				
				FavorisBean fb = new FavorisBean();
				fb.setFk_prod(idProduct);
				fb.setFk_user(userId);
				
				fd.save(fb);
				
				response.sendRedirect("Index");
				
			}
		}
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

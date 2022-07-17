package com.hytekFront.servlets;

import java.io.IOException;

import com.hytekFront.dao.FavorisDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class FavorisPage
 */
public class FavorisPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FavorisPage() {
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
		int fk_user = (int) session.getAttribute("userId");
		System.out.println(fk_user);
		
		FavorisDao fd = new FavorisDao();
		
		// SUPPRIMER UN FAVORI : DELETE
		if (request.getParameter("idProduct") != null) { // id du panier
			
			int idProduct = Integer.valueOf(request.getParameter("idProduct"));
			FavorisDao.deleteByFk_prodAndFk_user(idProduct, fk_user);
			
		}
		
		request.setAttribute( "favoris", fd.getByFk_user(fk_user) );
		request.getRequestDispatcher("favoris.jsp").forward(request, response);
		
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

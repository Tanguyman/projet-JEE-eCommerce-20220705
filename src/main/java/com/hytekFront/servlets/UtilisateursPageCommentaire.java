package com.hytekFront.servlets;

import java.io.IOException;

import com.hytekFront.dao.CommentairesDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class UtilisateursPageCommentaire
 */
public class UtilisateursPageCommentaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UtilisateursPageCommentaire() {
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
		
		CommentairesDao cd = new CommentairesDao();
		
		if ( request.getParameter("idCommentaire") != null ) {
			
			int i = Integer.parseInt( request.getParameter("idCommentaire") );
			
			CommentairesDao.deleteById(i);
			
		}
		
		request.setAttribute( "commentaires", cd.getByFk_user(fk_user) );
		request.getRequestDispatcher("user_PageCommentaires.jsp").forward(request, response);
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

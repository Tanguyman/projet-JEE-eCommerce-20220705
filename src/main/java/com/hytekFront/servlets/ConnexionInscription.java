package com.hytekFront.servlets;

import java.io.IOException;

import com.hytekFront.beans.UtilisateursBean;
import com.hytekFront.dao.Database;
import com.hytekFront.dao.UtilisateursDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ConnexionInscription
 */
public class ConnexionInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnexionInscription() {
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

		String loginFrom = request.getParameter("loginFrom");
		System.out.println("Login from : " + loginFrom + " (methode GET)");
		request.setAttribute("loginFrom", loginFrom);
		
		if (loginFrom.equals("index")) {
			request.getRequestDispatcher("ConnexionInscription.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		
		Database.Connect();

		// BOUTON LOGIN
		if (request.getParameter("buttonConnection") != null) {

			String loginFrom = request.getParameter("loginFrom");
			String mail = request.getParameter("mail");
			String password = request.getParameter("password");
			System.out.println("Login from : " + loginFrom + " (methode POST)");
		
			UtilisateursDao utilisateursDao = new UtilisateursDao();
			
			UtilisateursBean passwordVerification = utilisateursDao.passwordVerification(mail, password);
			
			if ( passwordVerification != null ) {
				
				System.out.println("mdp OK");
				
				HttpSession session = request.getSession();
				session.setAttribute("isConnected", true);
				session.setAttribute("userId", passwordVerification.getId());
				session.setAttribute("userNameBySession", passwordVerification.getPrenom());
				
				if (loginFrom.equals("index")) {
//					response.sendRedirect("User_Home");
					request.getRequestDispatcher("ConnexionInscription.jsp").forward(request, response);
					System.out.println("User_Home");
				}
				
			} else {

				String message = "Identifiants incorrects";
				System.out.println(message);

				request.setAttribute("message", message);
				request.getRequestDispatcher("ConnexionInscription.jsp").forward(request, response);
				
			}
		
		}

	}

}

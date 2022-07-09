package com.hytekFront.servlets;

import java.io.IOException;
import java.sql.Date;

import com.hytekFront.beans.ContactsBean;
import com.hytekFront.dao.ContactsDao;
import com.hytekFront.dao.Database;
import com.hytekFront.tools.RegexValidator;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Contact
 */
public class Contact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Contact() {
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
		
		request.getRequestDispatcher("contact.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		
		String nom = request.getParameter("nom");
		String mail = request.getParameter("mail");
		String sujet = request.getParameter("sujet");
		String message = request.getParameter("text-area");
		
		boolean isAnEmail = RegexValidator.emailValidator(mail);
		
		System.out.println("param : " + isAnEmail + nom + mail + sujet + message);
		
		if ( nom.isBlank() || !isAnEmail || sujet.isBlank() || message.isBlank() ) {
		
			if ( nom.isBlank() || sujet.isBlank() || message.isBlank() ) {
				request.setAttribute("message", "Vous avez oublié de remplir un champ...");				
			}
			
			if ( !isAnEmail ) {
				request.setAttribute("message2", "Votre email n’est pas au bon format...");
			}
			request.getRequestDispatcher("contact.jsp").forward(request, response);
			
		} else {
			
			HttpSession session = request.getSession(true);
			
			Database.Connect();
			
			ContactsDao cd = new ContactsDao();
			
			if ( (boolean) session.getAttribute("isConnected") ) {
				System.out.println("Utilisateur");
				
				ContactsBean cb = new ContactsBean();
				
				cb.setFk_user( (int) session.getAttribute("userId"));
				cb.setNom(nom);
				cb.setEmail(mail);
				cb.setSujet(sujet);
				cb.setMessage(message);
				long millis = System.currentTimeMillis();
				Date date = new Date(millis);
				cb.setDate( date );
				cb.setEtat(0);
				cb.setArchiver(false);
				
				System.out.println(cb);
				cd.save(cb);
				
				request.setAttribute("message3", "Votre message a bien été enregistré. Nous allons le traiter dans les plus brefs délais.");
				request.getRequestDispatcher("contact.jsp").forward(request, response);
			} else {
				System.out.println("Visiteur");
				
				ContactsBean cb = new ContactsBean();
				
				cb.setFk_user( 1 );
				cb.setNom(nom);
				cb.setEmail(mail);
				cb.setSujet(sujet);
				cb.setMessage(message);
				long millis = System.currentTimeMillis();
				Date date = new Date(millis);
				cb.setDate( date );
				cb.setEtat(0);
				cb.setArchiver(false);
				
				System.out.println(cb);
				cd.save(cb);
				
				request.setAttribute("message3", "Votre message a bien été enregistré. Nous allons le traiter dans les plus brefs délais.");
				request.getRequestDispatcher("contact.jsp").forward(request, response);
			}
			
		}
	}

}

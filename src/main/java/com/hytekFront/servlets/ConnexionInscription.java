package com.hytekFront.servlets;

import java.io.IOException;

import com.hytekFront.beans.UtilisateursBean;
import com.hytekFront.dao.Database;
import com.hytekFront.dao.UtilisateursDao;
import com.hytekFront.tools.RegexValidator;

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
		// System.out.println("Login from : " + loginFrom + " (methode GET)");
		request.setAttribute("loginFrom", loginFrom);
		
		if (loginFrom.equals("index")) {
			request.getRequestDispatcher("connexionInscription.jsp").forward(request, response);
		}
		
		if (loginFrom.equals("commandes")) {
			request.getRequestDispatcher("connexionInscription.jsp").forward(request, response);
		}
		
		if (loginFrom.equals("produitCard")) {
			
			String idProduct = request.getParameter("idProduct");
			
			request.setAttribute("idProduct", idProduct);
			request.getRequestDispatcher("connexionInscription.jsp").forward(request, response);
			
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
		
			UtilisateursDao utilisateursDao = new UtilisateursDao();
			
			UtilisateursBean passwordVerification = utilisateursDao.passwordVerification(mail, password);
			
			if ( passwordVerification != null ) {
				
				HttpSession session = request.getSession();
				session.setAttribute("isConnected", true);
				session.setAttribute("userId", passwordVerification.getId());
				session.setAttribute("userLastNameBySession", passwordVerification.getPrenom());
				session.setAttribute("userMailBySession", passwordVerification.getEmail());
				
				if (loginFrom.equals("index")) {
					
					request.getRequestDispatcher("connexionInscription.jsp").forward(request, response);
					
				}
				
				if (loginFrom.equals("commandes")) {
					
					response.sendRedirect("Commandes");
					
				}
				
				if (loginFrom.equals("produitCard")) {
					
					String idProduct = request.getParameter("idProduct");
					
					response.sendRedirect("Produit_Card?id=" + idProduct);
					
				}
				
			} else {

				String message = "Identifiants incorrects";

				request.setAttribute("message", message);
				request.getRequestDispatcher("connexionInscription.jsp").forward(request, response);
				
			}
		
		}
		
		// BOUTON INSCRIPTION
		if (request.getParameter("signInButton") != null) {
			
			// Récupéerer les paramètres du Header (POST)
			String nom = request.getParameter("firstName");
			String prenom = request.getParameter("lastName");
			String email = request.getParameter("mail");
			String password = request.getParameter("password");
			String passwordConfirmation = request.getParameter("password2");
			
			// TEST DE SÉCURITÉ
			boolean isFirstNameValide = RegexValidator.nameValidator(nom);
			boolean isLastNameValide = RegexValidator.nameValidator(prenom);
			boolean isAnEmail = RegexValidator.emailValidator(email);
			UtilisateursDao user = new UtilisateursDao();
			UtilisateursBean isEmailInDatabase = user.getByMail(email);
			boolean isPasswordValide = RegexValidator.passwordValidator(password);
			boolean arePasswordsEquals = password.equals(passwordConfirmation);
			
			if (isFirstNameValide && isLastNameValide && isAnEmail && isPasswordValide && arePasswordsEquals && isEmailInDatabase == null) {
				
				String messageInscriptionValidated = "Un email de confirmation vient de vous être envoyé.";

				request.setAttribute("messageInscriptionValidated", messageInscriptionValidated);
				request.getRequestDispatcher("connexionInscription.jsp").forward(request, response);

			} else if (isEmailInDatabase != null) {

				String messageEmailIsInDatabase = "Cette email existe déjà";

				request.setAttribute("messageEmailIsInDatabase", messageEmailIsInDatabase);
				request.getRequestDispatcher("connexionInscription.jsp").forward(request, response);

			} else {
				if (!isFirstNameValide) {
					
					String messageInvalidName = "Votre nom de famille peut être composé de 3 noms au maximum "
							+ "que vous pouvez séparer par un espace ou un tiret (-).<br>"
							+ "Votre nom de famille doit commencer et terminer par une lettre "
							+ "et ne doit pas contenir de chiffres ou de caractères spéciaux.";

					request.setAttribute("messageInvalidName", messageInvalidName);

				}
				
				if (!isLastNameValide) {
					
					String messageInvalidName = "Votre prénom de famille peut être composé de 3 noms au maximum "
							+ "que vous pouvez séparer par un espace ou un tiret (-).<br>"
							+ "Votre nom de famille doit commencer et terminer par une lettre "
							+ "et ne doit pas contenir de chiffres ou de caractères spéciaux.";

					request.setAttribute("messageInvalidName", messageInvalidName);
					
				}
				
				if (!isAnEmail) {
					
					String messageInvalidEmail = "Votre email n’est pas conforme.";
					
					request.setAttribute("messageInvalidEmail", messageInvalidEmail);
					
				}
				if (!isPasswordValide) {
					
					String messageInvalidPassword = "Politique de sécurité concernant les mots de passe :<br>"
							+ "- au moins un chiffre <br>"
							+ "- au moins une lettre minuscule <br>"
							+ "- au moins une lettre majuscule <br>"
							+ "- au moins un caractère spécial @ # $ % ^ & + = <br>"
							+ "- minimum 8 caractères <br>"
							+ "- aucun espace";
					
					request.setAttribute("messageInvalidPassword", messageInvalidPassword);
					
				}
				if (!arePasswordsEquals) {
					
					String messagePasswordNotEqual = "Les mots de passe saisis ne sont pas identiques.";
					
					request.setAttribute("messagePasswordNotEqual", messagePasswordNotEqual);
					
				}
				
				request.getRequestDispatcher("connexionInscription.jsp").forward(request, response);
				
			}
		}

	}

}

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
		System.out.println("Login from : " + loginFrom + " (methode GET)");
		request.setAttribute("loginFrom", loginFrom);
		
		if (loginFrom.equals("index")) {
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
			System.out.println("Login from login Button : " + loginFrom + " (methode POST)");
		
			UtilisateursDao utilisateursDao = new UtilisateursDao();
			
			UtilisateursBean passwordVerification = utilisateursDao.passwordVerification(mail, password);
			
			if ( passwordVerification != null ) {
				
				System.out.println("mdp OK");
				
				HttpSession session = request.getSession();
				session.setAttribute("isConnected", true);
				session.setAttribute("userId", passwordVerification.getId());
				session.setAttribute("userLastNameBySession", passwordVerification.getPrenom());
				session.setAttribute("userMailBySession", passwordVerification.getEmail());
				
				if (loginFrom.equals("index")) {
//					response.sendRedirect("User_Home");
					request.getRequestDispatcher("connexionInscription.jsp").forward(request, response);
					System.out.println("User_Home");
				}
				
			} else {

				String message = "Identifiants incorrects";
				System.out.println(message);

				request.setAttribute("message", message);
				request.getRequestDispatcher("connexionInscription.jsp").forward(request, response);
				
			}
		
		}
		
		// BOUTON INSCRIPTION
		if (request.getParameter("signInButton") != null) {
			// System.out.println("Inscription ok");
			
			// Récupéerer les paramètres du Header (POST)
			String nom = request.getParameter("firstName");
			String prenom = request.getParameter("lastName");
			String email = request.getParameter("mail");
			String password = request.getParameter("password");
			String passwordConfirmation = request.getParameter("password2");
			
			// System.out.println(nom + prenom + email + password + passwordConfirmation);
			
			// TEST DE SÉCURITÉ
			boolean isFirstNameValide = RegexValidator.nameValidator(nom);
			boolean isLastNameValide = RegexValidator.nameValidator(prenom);
			boolean isAnEmail = RegexValidator.emailValidator(email);
			UtilisateursDao user = new UtilisateursDao();
			UtilisateursBean isEmailInDatabase = user.getByMail(email);
			boolean isPasswordValide = RegexValidator.passwordValidator(password);
			boolean arePasswordsEquals = password.equals(passwordConfirmation);
			
			if (isFirstNameValide && isLastNameValide && isAnEmail && isPasswordValide && arePasswordsEquals && isEmailInDatabase == null) {

				System.out.println("Inscription OK");
				String messageInscriptionValidated = "Un email de confirmation vient de vous être envoyé.";

				request.setAttribute("messageInscriptionValidated", messageInscriptionValidated);
				request.getRequestDispatcher("connexionInscription.jsp").forward(request, response);

			} else if (isEmailInDatabase != null) {

				System.out.println("EmailInDatabase !");
				String messageEmailIsInDatabase = "Cette email existe déjà";

				request.setAttribute("messageEmailIsInDatabase", messageEmailIsInDatabase);
				request.getRequestDispatcher("connexionInscription.jsp").forward(request, response);

			} else {
				if (!isFirstNameValide) {

					System.out.println("InvalidFirstName !");
					String messageInvalidName = "Votre nom de famille peut être composé de 3 noms au maximum "
							+ "que vous pouvez séparer par un espace ou un tiret (-).<br>"
							+ "Votre nom de famille doit commencer et terminer par une lettre "
							+ "et ne doit pas contenir de chiffres ou de caractères spéciaux.";

					request.setAttribute("messageInvalidName", messageInvalidName);

				}
				
				if (!isLastNameValide) {

					System.out.println("InvalidLastName !");
					String messageInvalidName = "Votre prénom de famille peut être composé de 3 noms au maximum "
							+ "que vous pouvez séparer par un espace ou un tiret (-).<br>"
							+ "Votre nom de famille doit commencer et terminer par une lettre "
							+ "et ne doit pas contenir de chiffres ou de caractères spéciaux.";

					request.setAttribute("messageInvalidName", messageInvalidName);
				}
				
				if (!isAnEmail) {

					System.out.println("InvalidMail !");
					String messageInvalidEmail = "Votre email n’est pas conforme.";
					request.setAttribute("messageInvalidEmail", messageInvalidEmail);
				}
				if (!isPasswordValide) {

					System.out.println("InValidePassword");
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

					System.out.println("PasswordNotEqual");
					String messagePasswordNotEqual = "Les mots de passe saisis ne sont pas identiques.";
					request.setAttribute("messagePasswordNotEqual", messagePasswordNotEqual);
				}

				// Appeler la vue
				request.getRequestDispatcher("connexionInscription.jsp").forward(request, response);
			}
		}

	}

}

package com.hytekFront.servlets;

import java.io.IOException;

import com.hytekFront.beans.UtilisateursBean;
import com.hytekFront.dao.CommentairesDao;
import com.hytekFront.dao.Database;
import com.hytekFront.dao.FavorisDao;
import com.hytekFront.dao.UtilisateursDao;
import com.hytekFront.tools.RegexValidator;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Utilisateurs_Index
 */
public class Utilisateurs_Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Utilisateurs_Index() {
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
		
		// int idUserForm = Integer.parseInt( request.getParameter("userId") );
		
		HttpSession session = request.getSession();
		
		// SÉCURITÉ 1
		if ( (boolean) session.getAttribute("isConnected") ) {
			
			int idUserSession = (int) session.getAttribute("userId");
			
			// SÉCURITÉ 2
//			if ( idUserForm == idUserSession) {
				
				Database.Connect();
				UtilisateursDao ud = new UtilisateursDao();
//				AdressesDao ad = new AdressesDao();
//				CommandesDao cd = new CommandesDao();
				CommentairesDao cd = new CommentairesDao();
//				Details_CommandeDao dcd = new Details_CommandeDao();
				FavorisDao fd = new FavorisDao();
//				ProduitsDao pd = new ProduitsDao();
				
				UtilisateursBean ub = ud.getById(idUserSession);
				System.out.println(ub);
				
				request.setAttribute("user", ub);
				request.getRequestDispatcher("user_Index.jsp").forward(request, response);
				
//			}
			
		} else {
			
			System.out.println("Sécurité Ok");
			
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		
		HttpSession session = request.getSession(true);
		
//		Database.Connect();
		
		UtilisateursDao ud = new UtilisateursDao();
		UtilisateursBean ub = ud.getById( (int) session.getAttribute("userId") );
		
		// BOUTON MODIFIER PROFILE
		if (request.getParameter("buttonEditProfile") != null) {
			
			// Récupérer les paramètres du Header (POST)
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String email = request.getParameter("mail");
			System.out.println(firstName + lastName + email);

			// TEST DE SÉCURITÉ
			boolean isFirstNameValide = RegexValidator.nameValidator(firstName);
			boolean isLastNameValide = RegexValidator.nameValidator(lastName);
			boolean isAnEmail = RegexValidator.emailValidator(email);
			
			UtilisateursBean isEmailInDatabase = ud.getByMail(email);
			
			if ( !email.equals( ub.getEmail() ) ) {
				
				System.out.println("email différent");
				
				if ( isEmailInDatabase != null ) {
					
					System.out.println("EmailInDatabase !");
					String messageEmailIsInDatabase = "Vous ne pouvez pas prendre cet email car il existe déjà";
					
					request.setAttribute("messageEmailIsInDatabase", messageEmailIsInDatabase);
					
				} else if ( isFirstNameValide && isLastNameValide && isAnEmail ) {
					
					System.out.println("Modification OK");
					
					ub.setNom(firstName);
					ub.setPrenom(lastName);
					ub.setEmail(email);
					System.out.println(ub);
					
					ud.save(ub);
					
					String messageInscriptionValidated = "Votre profil a bien été mis à jour.";
					request.setAttribute("messageInscriptionValidated", messageInscriptionValidated);
					
				} else {
					
					if (!isAnEmail) {
						
						System.out.println("InvalidMail !");
						String messageInvalidEmail = "Votre email n’est pas conforme.";
						request.setAttribute("messageInvalidEmail", messageInvalidEmail);
					}
					
					if (!isFirstNameValide) {
						
						System.out.println("InvalidName !");
						String messageInvalidFirstName = "Votre nom de famille peut être composé de 3 noms au maximum "
								+ "que vous pouvez séparer par un espace ou un tiret (-).<br>"
								+ "Votre nom de famille doit commencer et terminer par une lettre "
								+ "et ne doit pas contenir de chiffres ou de caractères spéciaux.";
						
						request.setAttribute("messageInvalidFirstName", messageInvalidFirstName);
					}
					
					if (!isLastNameValide) {
						
						System.out.println("InvalidName !");
						String messageInvalidLastName = "Votre prénom peut être composé de 3 prénoms au maximum "
								+ "que vous pouvez séparer par un espace ou un tiret (-).<br>"
								+ "Votre prénom doit commencer et terminer par une lettre "
								+ "et ne doit pas contenir de chiffres ou de caractères spéciaux.";
						
						request.setAttribute("messageInvalidLastName", messageInvalidLastName);
					}
				}
				
				
				request.setAttribute("user", ub);
				request.getRequestDispatcher("user_Index.jsp").forward(request, response);
				
			} else {
				
				System.out.println("email identique");
				
				if (!isFirstNameValide) {

					System.out.println("InvalidName !");
					
					String messageInvalidFirstName = "Votre nom de famille peut être composé de 3 noms au maximum "
							+ "que vous pouvez séparer par un espace ou un tiret (-).<br>"
							+ "Votre nom de famille doit commencer et terminer par une lettre "
							+ "et ne doit pas contenir de chiffres ou de caractères spéciaux.";

					request.setAttribute("messageInvalidFirstName", messageInvalidFirstName);

				} else {
					
					System.out.println("firstName Valid");
					
					ub.setNom(firstName);
					System.out.println(ub);
					
					ud.save(ub);
					
					String messageInscriptionValidated = "Votre profil a bien été mis à jour.";
					
					request.setAttribute("messageInscriptionValidated", messageInscriptionValidated);
					
				}
				
				if (!isLastNameValide) {

					System.out.println("InvalidName !");
					
					String messageInvalidLastName = "Votre prénom peut être composé de 3 prénoms au maximum "
							+ "que vous pouvez séparer par un espace ou un tiret (-).<br>"
							+ "Votre prénom doit commencer et terminer par une lettre "
							+ "et ne doit pas contenir de chiffres ou de caractères spéciaux.";

					request.setAttribute("messageInvalidLastName", messageInvalidLastName);

				} else {
					
					System.out.println("Name Valid");
					
					ub.setPrenom(lastName);
					System.out.println(ub);
					
					ud.save(ub);
					
					String messageInscriptionValidated = "Votre profil a bien été mis à jour.";
					
					request.setAttribute("messageInscriptionValidated", messageInscriptionValidated);
					
				}
				
				request.setAttribute("user", ub);
				request.getRequestDispatcher("user_Index.jsp").forward(request, response);
			}
			
		}

	}

}

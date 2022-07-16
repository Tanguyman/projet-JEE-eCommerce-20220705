package com.hytekFront.servlets;

import java.io.IOException;
import java.sql.Date;

import com.hytekFront.beans.CommandesBean;
import com.hytekFront.beans.Details_CommandeBean;
import com.hytekFront.beans.PanierBean;
import com.hytekFront.beans.Panier_DetailsBean;
import com.hytekFront.beans.ProduitsBean;
import com.hytekFront.beans.UtilisateursBean;
import com.hytekFront.dao.AdressesDao;
import com.hytekFront.dao.CommandesDao;
import com.hytekFront.dao.Database;
import com.hytekFront.dao.Details_CommandeDao;
import com.hytekFront.dao.ProduitsDao;
import com.hytekFront.dao.UtilisateursDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Commandes
 */
public class Commandes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Commandes() {
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
		PanierBean panier = (PanierBean) session.getAttribute("panier");
		
		Database.Connect();
		UtilisateursDao ud = new UtilisateursDao();
		CommandesDao cd = new CommandesDao();
		AdressesDao ad = new AdressesDao();
		Details_CommandeDao dcd = new Details_CommandeDao();
		ProduitsDao pd = new ProduitsDao();
		
		// RETRIEVE USER
		if ( (boolean) session.getAttribute("isConnected") ) {
			
			int id = (int) session.getAttribute("userId");
			
			UtilisateursBean u = ud.getById(id);
			request.setAttribute("client", u);
			
			// VALIDER LA COMMANDE
			if (request.getParameter("commande") != null) {
				
				if ( request.getParameter("idAdresse") != null ) {
					
					int idAdresse = Integer.parseInt( request.getParameter("idAdresse") );
					System.out.println(idAdresse);
					double total = panier.total();
					long millis = System.currentTimeMillis();
					Date date = new Date(millis);
					
					CommandesBean commande = new CommandesBean(id, date, total, idAdresse, 0, false);
					int commandeId = cd.save(commande);
					
					// ENREGISTRER LES « DÉTAILS ( + primary key order table ) DE LA COMMANDE » 
					for ( Panier_DetailsBean pdB : panier.getPanierDetails() ) {
						
						Details_CommandeBean dcB = new Details_CommandeBean();
						
						dcB.setFk_commande(commandeId);
						dcB.setFk_produit(pdB.getProduit().getId());
						dcB.setQte(pdB.getQuantite());
						dcB.setPrix(pdB.getProduit().getPrix());
						dcB.setArchiver(false);
						
						// VÉRIFIER QTÉ STOCK
						ProduitsBean pb =  pd.getById(pdB.getProduit().getId());
						
						if ( pb.getStock() - pdB.getQuantite() < 0 ) {
							
							String ruptureStock = "Vous a commandé " + pdB.getQuantite() + " "
									+ pdB.getProduit().getSous_categorie().getTitre()
									+ " mais nous n’en n’avons que " + pdB.getProduit().getStock() + " en stock. <br>"
									+ " Désolé... <br>"
									+ "Ceci dit vous avez tripoté le formulaire 😡🤬";
							request.setAttribute("ruptureStock", ruptureStock);
							
						} else {
							
							// METTRE À JOUR LE STOCK
							pb.setStock( pb.getStock() - pdB.getQuantite() );
							
							pd.save(pb);
							dcd.save(dcB);
							
							// NOUVEAU PANIER DE SESSION == VIDER LE PANIER
							panier.clearPanier();
							request.setAttribute("panier", panier);
							
							// INFORMER CLIENT
							String orderValid = "Votre commande a bien été enregistré.<br>"
									+ "Merci et à bientôt.";
							request.setAttribute("orderValid", orderValid);
							
						}
						
					}
										
				} else {
					
					String msg = "Vous n’avez pas sélectionné d’adresse !";
					request.setAttribute("msg", msg);
					System.out.println( msg );
					
				}
			}
			
		}
		
		request.setAttribute("panier", panier);
		request.getRequestDispatcher("commande.jsp").forward(request, response);
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

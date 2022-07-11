package com.hytekFront.servlets;

import java.io.IOException;

import com.hytekFront.beans.PanierBean;
import com.hytekFront.beans.Panier_DetailsBean;
import com.hytekFront.beans.ProduitsBean;
import com.hytekFront.dao.Database;
import com.hytekFront.dao.ProduitsDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Panier
 */
public class Panier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Panier() {
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
		
		Database.Connect();

		// SUPPRIMER UN PRODUIT (ligne) DU PANIER
		if (request.getParameter("id") != null) { // id du panier
			
			int id = Integer.valueOf(request.getParameter("id"));
			PanierBean panier = new PanierBean();
			panier = (PanierBean) session.getAttribute("panier");
			panier.removeProduitFromPanier(id);
			
			session.setAttribute("panier", panier);
			
		}
		
		// METTRE À JOUR LA QUANTITÉ PRODUIT
		if ( request.getParameter("quantite") != null ) {
			
			int qte = Integer.valueOf( request.getParameter("quantite") );
			int id = Integer.valueOf( request.getParameter("idProduit") );
			
			System.out.println(id + " " + qte);
			
			PanierBean panier = new PanierBean();
			panier = (PanierBean) session.getAttribute("panier");
			panier.removeProduitFromPanier(id);
			
			
			ProduitsDao pd = new ProduitsDao();
			ProduitsBean pb = pd.getById(id);
			Panier_DetailsBean pdB = new Panier_DetailsBean( pb, qte );
			
			System.out.println(pdB);
			
			panier.addLineToBag(pdB);
			
			session.setAttribute("panier", panier);
		}
		
		request.getRequestDispatcher("panier.jsp").forward(request, response);
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

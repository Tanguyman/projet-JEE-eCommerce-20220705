package com.hytekFront.servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import com.hytekFront.beans.CommentairesBean;
import com.hytekFront.beans.PanierBean;
import com.hytekFront.beans.Panier_DetailsBean;
import com.hytekFront.beans.ProduitsBean;
import com.hytekFront.beans.VisitesBean;
import com.hytekFront.dao.CommentairesDao;
import com.hytekFront.dao.Database;
import com.hytekFront.dao.ProduitsDao;
import com.hytekFront.dao.VisitesDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Produit_Card
 */
public class Produit_Card extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Produit_Card() {
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
		
		int id = Integer.parseInt( request.getParameter( "id") );
		HttpSession session = request.getSession(true);
		Database.Connect();
		
		ProduitsDao pd = new ProduitsDao();
		VisitesDao vd = new VisitesDao();
		
		ProduitsBean pb = pd.getById(id);
		ArrayList<ProduitsBean> pbCol = pd.getAllProductsForProduitsList( pb.getFk_sous_categorie() );
		
		// VISITES
		if ( (boolean) session.getAttribute("isConnected") ) {
			
			VisitesBean vb = new VisitesBean();
			
			vb.setFk_user( (int) session.getAttribute("userId") );
			long millis = System.currentTimeMillis();
			Date date = new Date( millis );
			vb.setDate( date );
			vb.setFk_prod( id );
			
			vd.save( vb );
			
		} else {
			
			VisitesBean vb = new VisitesBean();
			
			vb.setFk_user( 1 ); // id Visiteur
			long millis = System.currentTimeMillis();
			Date date = new Date( millis );
			vb.setDate( date );
			vb.setFk_prod( id );
			
			vd.save( vb );
		}
		
		// AJOUTER UN PRODUIT AU PANIER DEPUIS LA FICHE PRODUIT : Produit_Card
		if ( request.getParameter("quantite") != null ) {
			
			int qte = Integer.valueOf( request.getParameter("quantite") );
			
			Panier_DetailsBean pdB = new Panier_DetailsBean( pb, qte);
			PanierBean pB = new PanierBean();
			
			pB = (PanierBean) session.getAttribute("panier");
			pB.removeProduitFromPanier(id);
			pB.addLineToBag(pdB);
			
			session.setAttribute("panier", pB);
		}
		
		// AJOUTER UN PRODUIT AU PANIER DEPUIS LES PAGES : Index, Produits_List, Recherche
		if ( request.getParameter("qtePageProduit") != null ) {
			
			int qte = Integer.valueOf( request.getParameter("qtePageProduit") );
			
			Panier_DetailsBean pdB = new Panier_DetailsBean( pb, qte);
			PanierBean pB = new PanierBean();
			
			pB = (PanierBean) session.getAttribute("panier");
			pB.removeProduitFromPanier(id);
			pB.addLineToBag(pdB);
			
			session.setAttribute("panier", pB);
		}
		
		// AJOUTER UN COMMENTAIRE
		if ( request.getParameter("commentaireForm") != null ) {
			
			int note = Integer.parseInt( request.getParameter("note") );
			String story = request.getParameter("story");
			System.out.println( note + " " + story);
			int userId = (int) session.getAttribute("userId");
			
			CommentairesDao cd = new CommentairesDao();
			CommentairesBean commenetaireUser = cd.getByFk_prodAndFk_user(id, userId);
			
			if ( note > 0 && note < 6) {
				
				CommentairesBean cb = new CommentairesBean();
				
				cb.setFk_user( userId );
				cb.setFk_prod(id);
				
				long millis = System.currentTimeMillis();
				Date date = new Date(millis);
				cb.setDate(date);
				
				cb.setCommentaire(story);
				cb.setNote(note);
				
				cd.save(cb);
				
			}
		}
		
//		request.setAttribute("produit", pb); // les commentaires ne se mettent pas à jour
		request.setAttribute("produit", pd.getById(id)); // commentaires se MAJ
		request.setAttribute("produitsList", pbCol);
		request.getRequestDispatcher("produit_Card.jsp").forward(request, response);
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

package com.hytekFront.servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import com.hytekFront.beans.ProduitsBean;
import com.hytekFront.beans.VisitesBean;
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
		
		int id = Integer.parseInt( request.getParameter( "id"));
		
		Database.Connect();
		
		ProduitsDao pd = new ProduitsDao();
		VisitesDao vd = new VisitesDao();
		
		ProduitsBean pb = pd.getById(id);
		ArrayList<ProduitsBean> pbCol = pd.getAllProductsForProduitsList( pb.getFk_sous_categorie() );
		
		// VISITES
		HttpSession session = request.getSession(true);
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
		
		request.setAttribute("produit", pb);
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

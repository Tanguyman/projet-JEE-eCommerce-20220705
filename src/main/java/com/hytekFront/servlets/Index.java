package com.hytekFront.servlets;

import java.io.IOException;
import java.util.ArrayList;

import com.hytekFront.beans.FavorisBean;
import com.hytekFront.beans.ProduitsBean;
import com.hytekFront.beans.SliderBean;
import com.hytekFront.dao.Database;
import com.hytekFront.dao.FavorisDao;
import com.hytekFront.dao.ProduitsDao;
import com.hytekFront.dao.SliderDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Index
 */
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
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
		
		SliderDao sliderDao = new SliderDao();
		ProduitsDao pd = new ProduitsDao();
		
		ArrayList<SliderBean> colSlider = sliderDao.getAll();
		ArrayList<ProduitsBean> productsForHomePage = pd.getAllProduitForHomePage();
		
		if ( session.getAttribute("isConnected") != null ) {
			
			if ( (boolean) session.getAttribute("isConnected") ) {
				
				int userId = (int) session.getAttribute("userId");
				FavorisDao fd = new FavorisDao();
				
				if ( fd.getByFk_user( userId ) != null ) {
					
					ArrayList<FavorisBean> fbCol = fd.getByFk_user( userId );
					//System.out.println("fao bean Col : " + fbCol.size());
					
					ArrayList<ProduitsBean> productsFavoris = new ArrayList<ProduitsBean>();
					for ( FavorisBean f : fbCol) {
						
						productsFavoris.add( f.getProduit() );
						//System.out.println("contains :" + productsForHomePage.contains(f.getProduit()) );
						
					}
					// System.out.println("Fav Prod Col : " + productsFavoris.size());
					
					ArrayList<ProduitsBean> favForHomePage = new ArrayList<>();
					for ( ProduitsBean pb : productsForHomePage ) {
						
						for ( ProduitsBean pbFavoris : productsFavoris ) {
							
							if ( pbFavoris.getId() == pb.getId() ) {
								
								favForHomePage.add(pb);
								
							}
							
						}
					}
					
					productsForHomePage.removeAll(favForHomePage);
					
					request.setAttribute("productsFavoris", favForHomePage);
					request.setAttribute("produits", productsForHomePage);
					
				} else { // si la liste est vide
					
					request.setAttribute("produits", productsForHomePage);
					
				}
				
				
			} else { // Si n’est pas connecté
				
				request.setAttribute("produits", productsForHomePage);
				
			}
			
		} else { // Si la session est nulle
			
			request.setAttribute("produits", productsForHomePage);
			
		}
		
		request.setAttribute("sliders", colSlider);
		request.getRequestDispatcher("index.jsp").forward(request, response);
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

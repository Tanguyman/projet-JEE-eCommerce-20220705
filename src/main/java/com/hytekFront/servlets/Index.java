package com.hytekFront.servlets;

import java.io.IOException;
import java.util.ArrayList;

import com.hytekFront.beans.ProduitsBean;
import com.hytekFront.beans.SliderBean;
import com.hytekFront.dao.Database;
import com.hytekFront.dao.ProduitsDao;
import com.hytekFront.dao.SliderDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
		
		Database.Connect();
		
		SliderDao sliderDao = new SliderDao();
		ProduitsDao p = new ProduitsDao();
		
		ArrayList<SliderBean> colSlider = sliderDao.getAll();
		ArrayList<ProduitsBean> colProds = p.getAllProduitForHomePage();
		System.out.println(colSlider);
		
		request.setAttribute("produits", colProds);
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

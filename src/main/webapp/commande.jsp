<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@page import="com.hytekFront.beans.PanierBean"%>
<%@page import="com.hytekFront.beans.Panier_DetailsBean"%>
<%@page import="com.hytekFront.beans.UtilisateursBean"%>
<%@page import="com.hytekFront.beans.AdressesBean"%>
<%
PanierBean panier = (PanierBean) request.getAttribute("panier");
UtilisateursBean client = (UtilisateursBean) request.getAttribute("client");
%>
<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="shop, ecommerce, store, multipurpose, shopify, woocommerce, html5, css3, sass">

    <!-- fav -->
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">

	<!-- FONTAWESOME -->
	<script src="https://kit.fontawesome.com/bff2375f4b.js" crossorigin="anonymous"></script>
	
    <!-- title -->
    <title>Commande</title>

    <!-- stylesheets -->
    <link rel="stylesheet" href="assets/css/vendor/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/vendor/font-awesome.min.css">
    <link rel="stylesheet" href="assets/css/vendor/animate.css">
    <link rel="stylesheet" href="assets/css/vendor/owl.carousel.min.css">
    <link rel="stylesheet" href="assets/css/vendor/slick.css">
    <link rel="stylesheet" href="assets/css/vendor/magnific-popup.css">
    <link rel="stylesheet" href="assets/css/vendor/normalize.css">
    <link rel="stylesheet" href="assets/css/mean-menu.css">
    <link rel="stylesheet" href="assets/css/default.css">
    <link rel="stylesheet" href="assets/css/style.css">

</head>

<body>


	<!-- ================= Include Area Starts================= -->

	<jsp:include page="/Header" />
	
	<!-- 
				Preloader
		
				Autopopup
				
				Header
				
					TableDao coordonnées
				
					TableDao catégorie
				
					Session Panier 
	-->
    <!-- ================= Include Area Ends================= -->





    <!-- =================Page Title Area Starts================= -->

    <div class="page-title-area pt-130 pb-120 " style="background-image: url(assets/img/bg/chechout-page-bg.jpg);">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="page-titel-detalis  ">
                        <div class="page-title position-relative">
                            <h2>Commande</h2>
                        </div>
                        <div class="page-bc">
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="Index"> <i
                                                class="fas fa-home "></i>Home</a></li>
                                    <li class="breadcrumb-item active" aria-current="page"><a
                                            href="#">Commande</a></li>
                                </ol>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- =================Page Title Area ends================= -->

    <!-- =================Checkout  Area Starts================= -->
    <div class="cart-page-area checkout-page pt-50">
        <div class="container">
            <div class="row justify-content-center justify-content-md-start">
                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-10">
                    <div class="buyer-info check-border pb-30 mb-50 mb-md-0">
                    <%
                    if ( (boolean) session.getAttribute("isConnected") ) {
                    %>
                        <div class="section-title">
                            <h6>choisir une adresse de livraison</h6>
                            <!-- <h6 class="float-right">Login Here</h6> -->
                        </div>
                        
                        <%
                        if ( request.getAttribute("msg") != null ) {
                        %>
                        <div class="pl-45 pt-25 pr-45" > <!-- pr-100 -->
	                        <p class="alert alert-danger" role="alert"><%= request.getAttribute("msg") %></p>
						</div>
                        <%
                        }
                        %>
                        <%
                        if ( request.getAttribute("ruptureStock") != null ) {
                        %>
                        <div class="pl-45 pt-25 pr-45" > <!-- pr-100 -->
	                        <p class="alert alert-danger" role="alert"><%= request.getAttribute("ruptureStock") %></p>
						</div>
                        <%
                        }
                        %>
                        <% 
                        if ( request.getAttribute("orderValid") != null ) {
                        %>
                        <div class="pl-45 pt-25 pr-45" > <!-- pr-100 -->
	                        <p class="alert alert-success" role="alert"><%= request.getAttribute("orderValid") %></p>
						</div>
                        <%
                        } else {
                        %>
                        
	                        <form method="post" action="Commandes" class="pl-45 pt-30 pr-100" >
	                        <%
	                        int i = 1;
	                        for ( AdressesBean a : client.getAdresses() ) {
	                        %>
								<div class="form-check">
									<input id="flexRadioDefault<%= i %>" class="form-check-input" type="radio" 
										name="idAdresse"
										value="<%= a.getId() %>"	
									>
									<label class="form-check-label" for="flexRadioDefault<%= i %>">
								    <%= a.getAdresse() %> <%= a.getCp() %> <%= a.getVille() %>
								    </label>
								</div>
                    	<%
    	                		i++;
	                        }
	                    %>
	                    	<div class="col-xl-12">
                    			<div class="table-button text-center pt-30">
                       		 	<!-- <a href="#" class="b-btn  pl-45 pr-45 pb-15 pt-15">Place Order</a> -->
									<input name="commande" class="b-btn  pl-45 pr-45 pb-15 pt-15" type="submit" value="COMMANDER">
                    			</div>
							</div>
	                    <%										
                    	}
	                    %>
                        </form>
                    
					<%                        
                    } else {
                    %>
	                        <div class="section-title">
	                            <h6>vous n’êtes pas connecté(e).</h6>
	                            <!-- <h6 class="float-right">Login Here</h6> -->
	                        </div>
	                        <!-- <form action="#" class="pl-45 pt-50 pr-100" > -->
	                        
	                        <div class="pl-45 pt-25" > <!-- pr-100 -->	
	                        </div>
	                        
	                        <div class="pl-45 pt-25 pr-45" > <!-- pr-100 -->
	                        	<p class="alert alert-danger" role="alert">Vous devez créer un compte ou vous connectez pour passer commande.</p>
	                        </div>
	                        
	                        <div class="pl-45 pt-25" > <!-- pr-100 -->	
	                        </div>
	                        
	                        <div class="d-grid gap-2 col-6 mx-auto">
	                        	<a href="ConnexionInscription?loginFrom=commandes" class="btn btn-danger btn-sm btn-block ">Créer un compte / Se connecter</a>
	                        </div>
	                       
                        <%
                        }
                        %>
                    </div>
                </div>
                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-10">
                    <div class="billing-detalis check-border ">
                        <div class="section-title">
                            <h6>Détails Facture</h6>
                        </div>
                        <div class="row">
                            <div class="col-xl-10 col-lg-10 col-md-10 col-sm-10 col-10 offset-xl-1 offset-lg-1 offset-md-1 offset-sm-1 offset-1">
                                <div class="checkout-product-detalis pt-40 pb-45">
                                    <div class="product-title pb-5">
                                        <span>Product</span>
                                        <span class="float-right">Total</span>
                                    </div>
                                    <hr>
        
                                    <ul class="product-total pt-20 pb-15">
                                    <%
                                    for ( Panier_DetailsBean pdB : panier.getPanierDetails() ) {
                                    %>
                                        <li>
                                        	<span><%= pdB.getProduit().getTitre().substring(0, 8) %>... (<%= pdB.getProduit().getPrix() %>€ x <%= pdB.getQuantite() %>)</span>
                                            <span class="float-right">
                                            	<% double t = pdB.getQuantite() * pdB.getProduit().getPrix(); %>
                                            	<%= t %>€
                                            </span>
                                        </li>
                                        <!-- <li>
                                            <span class="pr-50">Size</span>
                                            <span>Xl</span>
                                        </li>
                                        <li>
                                            <span class="pr-50">Color</span>
                                            <span>RED</span>
                                        </li>
                                        <li>
                                            <span>Delivary Cost</span>
                                            <span class="float-right">$9.0</span>
                                        </li> -->
                                    <%
                                    }
                                    %>
                                    </ul>
                                    <hr>
                                    <div class="oreder-total pt-10">
                                        <span>TOTAL COMMANDE</span>
                                        <span class="float-right">${ panier.total() }€</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- <div class="payment-method check-border mt-50 pb-20">
                        <div class="section-title mb-40">
                            <h6>
                                Payment Methods
                            </h6>
                        </div>
                        <div class="row">
                            <div class="col-xl-10 col-lg-10 col-md-10 col-sm-10 col-10 offset-xl-1 offset-lg-1 offset-md-1 offset-sm-1 offset-1">
                                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry lorem.</p>
                                <div class="paymen-icon pb-40">
                                    <ul class=" d-flex">
                                        <li><a href="#"><i class="fab fa-cc-paypal" aria-hidden="true"></i></a></li>
                                        <li><a href="#"><i class="fab fa-cc-stripe" aria-hidden="true"></i></a></li>
                                        <li><a href="#"><i class="fab fa-cc-visa" aria-hidden="true"></i></a></li>
                                        <li><a href="#"><i class="fab fa-cc-mastercard" aria-hidden="true"></i></a></li>
                                        <li><a href="#"><i class="fab fa-cc-amex" aria-hidden="true"></i></a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <form action="#">
                            <div class="row">
                                <div class="col-xl-3 col-lg-4 col-md-5 col-sm-4 col-5">
                                    <div class="payment-label text-right">
                                        <label for="card-number">Card Number :</label>
                                        <label for="cvv">CVV :</label>
                                        <label for="month">Month:</label>
                                        <label class="d-lg-none" for="year">Year:</label>
                                    </div>

                                </div>
                                <div class="col-xl-6 col-lg-7 col-md-7 col-sm-8 col-7">
                                    <div class="payment-input mr-10 mr-lg-0">
                                        <input type="text" id="card-number">
                                        <input type="text" id="cvv">
                                        <input class="d-block d-lg-inline" type="text" id="month">
                                        <input class="float-lg-right" type="text" id="year">
                                        <label class="d-none d-lg-inline-block float-lg-right pr-15 pt-5" for="year">Year:</label>
                                        
                                    </div>
                                </div>

                            </div>

                        </form>
                    </div> -->
                </div>
                <div class="col-xl-12">
                    <div class="table-button text-center pt-30">
                        <!-- <a href="#" class="b-btn  pl-45 pr-45 pb-15 pt-15">Place Order</a> -->
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- =================Checkout  Area Ends================= -->
    
    
    
    
 
    <!-- =================Footer Include Starts================= -->
    
	<jsp:include page="/Footer" />
	
	<!-- =================Footer Include Ends================= -->

    <!-- scripts -->
    
    <script src="assets/js/vendor/jquery.min.js"></script>
    <script src="assets/js/vendor/modernizr-3.7.1.min.js"></script>
    <script src="assets/js/vendor/bootstrap.min.js"></script>
    <script src="assets/js/vendor/popper.min.js"></script>
    <script src="assets/js/vendor/jquery-mean-menu.min.js"></script>
    <script src="assets/js/vendor/owl.carousel.min.js"></script>
    <script src="assets/js/vendor/isotope.pkgd.min.js"></script>
    <script src="assets/js/countdown.js"></script>
    <script src="assets/js/vendor/jquery.nice-number.js"></script>  
    <script src="assets/js/vendor/slick.min.js"></script>
    <script src="assets/js/vendor/jquery.magnific-popup.min.js"></script>
    <script src="assets/js/vendor/wow-1.3.0.min.js"></script>  
    <script src="assets/js/main.js"></script>

</body>

</html>

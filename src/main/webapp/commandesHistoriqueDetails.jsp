<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@page import="com.hytekFront.beans.Details_CommandeBean"%>
<%@page import="com.hytekFront.tools.DateManipulator"%>
<%
ArrayList<Details_CommandeBean> commandes = (ArrayList) request.getAttribute("commandes");
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
    <title>Détails Commande</title>

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

	<!-- DATATABLE -->
	<link rel="stylesheet" type="text/css" href="assets/plugins/table/datatable/datatables.css">
	<link rel="stylesheet" type="text/css" href="assets/plugins/table/datatable/dt-global_style.css">
	<link rel="stylesheet" type="text/css" href="assets/plugins/table/datatable/custom_dt_multiple_tables.css">

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

    <div class="page-title-area pt-130 pb-120 " style="background-image: url(assets/img/bg/contact-bg.png);">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="page-titel-detalis  ">
                        <div class="page-title position-relative">
                            <h2>Commandes</h2>
                        </div>
                        <div class="page-bc">
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item">
                                    	<a href="Index"><i class="fas fa-home "></i>Page d’accueil</a>
                                    </li>
                                    <li class="breadcrumb-item">
                                    	<a href="Utilisateurs_Index"></i>Dashboard</a>
                                    </li>
                                    <li class="breadcrumb-item" aria-current="page">
                                    	<a href="CommandesHistorique">Historique des commandes</a>
                                    </li>
                                    <li class="breadcrumb-item active" aria-current="page">
                                    	<a href="#">Détails commande</a>
                                    </li>
                                </ol>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- =================Page Title Area Ends================= -->
    
    
    

    <!-- =================Page Title Area Starts================= -->
    <div class="product-area product-detalis-page cart-page-area  pt-50">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="cart-table table-responsive">
                        <table id="clicFavoris-search" class="display"> <!-- table table-bordered text-center -->
                            <thead>
                                <tr>
                                    <!-- <th scope="col">Model</th> -->
                                    <th>Produit</th>
                                    <th>Quantité</th>
                                    <th>Prix</th>
                                    <th class="text-center dt-no-sorting" >Détail</th> <!-- poubelle -->
                                </tr>
                            </thead>
                            <tbody>
                            
                            <%
                            for ( Details_CommandeBean p : commandes ) {
                            %>
                                <tr>
                                    <%-- <td>
                                        <div class="cart-img">
                                            <img src="<%= p.getProduit().getImage() %>" alt="product" style="height: 120px; width: 120px;">
                                        </div>
                                    </td> --%>
                                    <%-- <td>
                                        <div class="cart-model">
                                            <span>Product-23</span>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="product-number ">
                                        </div>
                                    </td> --%>
                                    
                                    <td class="td-width">
                                        <div class="cart-description text-left pl-20">
                                            <span><%= p.getFk_produit() %></span>
                                        </div>
                                    </td>
                                    <td class="td-width">
                                        <div class="cart-description text-left pl-20">
                                            <span><%= p.getQte() %></span>
                                        </div>
                                    </td>
                                    <td class="td-width">
                                        <div class="cart-description text-left pl-20">
                                            <span><%= p.getPrix() %>€</span>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="cart-edit">
                                            <!-- <a href="#"> <i class="fas fa-pencil-alt"></i> </a> -->
                                            <a class="btn btn-primary btn-block" href="Commande_Details?idCommande=<%= p.getId() %>"><i class="fa-solid fa-eye"></i></i></a>
                                        </div>
                                    </td>
                                </tr>
                            <%
                            }
                            %>    
                            </tbody>
                            <!-- <tfoot>
                                <tr>
                                    <td colspan="7">
                                        <div class="table-button text-left">
                                            <a class="b-btn pr-15 pl-15 pt-15 pb-15" href="#">CONTINUE SHOPPING </a>
                                            <a class="b-btn pr-15 pl-15 pt-15 pb-15 float-right" href="#">UPDATE SHOPPING CART</a>
                                        </div>
                                    </td>
                                </tr>
                            </tfoot> -->
                        </table>
                    </div>
                </div>
            </div>
            <div class="product-cart pt-35">
            </div>
        </div>
    </div>
	<!-- =================Page Title Area Ends================= -->
	
	
	
	
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

	<!-- BEGIN PAGE LEVEL SCRIPTS -->
   	<script src="assets/plugins/table/datatable/datatables.js"></script>
   	<!-- TABLEAU PERMETTANT D’AFFICHER LES FAVORIS -->
    <script>
	    $(document).ready(function() {
            var table = $('#clicFavoris-search').DataTable({
             	"dom": 
            		"<'dt--top-section'<'row'<'col-12 col-sm-6 d-flex justify-content-sm-start justify-content-center'l><'col-12 col-sm-6 d-flex justify-content-sm-end justify-content-center mt-sm-0 mt-3'f>>>" +
            		"<'table-responsive'tr>" + 
            		"<'dt--bottom-section d-sm-flex justify-content-sm-between text-center'<'dt--pages-count  mb-sm-0 mb-3'i><'dt--pagination'p>>",
                "oLanguage": {
                    "oPaginate": { 
                 		"sPrevious": '<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-arrow-left"><line x1="19" y1="12" x2="5" y2="12"></line><polyline points="12 19 5 12 12 5"></polyline></svg>', "sNext": '<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-arrow-right"><line x1="5" y1="12" x2="19" y2="12"></line><polyline points="12 5 19 12 12 19"></polyline></svg>' 
                 	},
					"sInfo": "Showing page _PAGE_ of _PAGES_",
					"sSearch": '<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-search"><circle cx="11" cy="11" r="8"></circle><line x1="21" y1="21" x2="16.65" y2="16.65"></line></svg>',
					"sSearchPlaceholder": "Search...",
					"sLengthMenu": "Results :  _MENU_",
                },
            	"stripeClasses": [],
                "lengthMenu": [5, 10, 20, 40, 80],
                "pageLength": 5
            });             
        });
    </script>

</body>

</html>
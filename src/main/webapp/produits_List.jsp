<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@page import="com.hytekFront.beans.ProduitsBean"%>
<%@page import="com.hytekFront.beans.SousCategoriesBean"%>
<%
ArrayList<ProduitsBean> produits = (ArrayList) request.getAttribute("produits");
SousCategoriesBean sousCategorie = (SousCategoriesBean) request.getAttribute("sousCategorie");
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
    <title><%= sousCategorie.getTitre() %></title>

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

    <div class="page-title-area pt-130 pb-120 " style="background-image: url(assets/img/bg/contact-bg.png);">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="page-titel-detalis  ">
                        <div class="page-title position-relative">
                            <h2><%= sousCategorie.getTitre() %></h2>
                        </div>
                        <div class="page-bc">
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item p-1"><a href="Index"><i class="fas fa-home "></i>Page d’accueil</a></li>
                                    <li class="breadcrumb-item p-1"><a href="#"><%= sousCategorie.getCategorie().getTitre() %></a></li>
                                    <li class="breadcrumb-item active p-1" aria-current="page"><a href="shop-list-page.html"><%= sousCategorie.getTitre() %></a></li>
                                </ol>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- =================Page Title Area Starts================= -->

    <!-- =================Product Area Starts================= -->

    <div class="product-area product-shop-page  product-list-page  pt-50 ">
        <div class="container">
            <div class="row">
                <div class="col-xl-12 pb-50">
                    <div class="toolbar-navi d-inline-block ">
                        <div class="toolbar d-flex">
                            <!-- <div class="view-as d-flex mr-30">
                                <span>View as:</span>
                                <div class="view-as-button ml-10">
                                    <a href="#"><i class="fab fa-microsoft"></i></a>
                                    <a href="#"><i class="fas fa-list-ul"></i></a>
                                    
                                </div>
                            </div> -->
                            <div class="sort-by d-flex mr-30">
                                <span class="mr-10">Trier par :</span>
                                <div class="sort-by-option position-relative">
                                    <button id="sort-option" class="sort-option">Plus récent <i class="fas fa-caret-down"></i></button>
    
                                    <div id="sub-sort-option" class="sub-sort-option  position-absolute " >
                                        <a href="#">Alphabétique</a>
                                        <a href="#">Plus cher</a>
                                        <a href="#">Moins cher</a>
                                        
                                    </div>
                                </div>
    
                            </div>
                            <div class="show-option d-flex">
                                <span class="mr-10">Montrer :</span>
                                <div class="show-option-list position-relative">
                                    <button id="show-option-numbe" class="show-option-number">Max <i class="fas fa-caret-down"></i></button>
                                    <div id="sub-show-option" class="sub-show-option">
                                        <a href="#">10</a>
                                        <a href="#">20</a>
                                        <a href="#">40</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <nav class="construction-pagination float-right" aria-label="Page navigation example">
                        <ul class="pagination justify-content-center">
                            <li class="page-item">
                                <a class="page-link" href="#"><i class="fas fa-chevron-left"></i></a>
                            </li>
                            <li class="page-item active">
                                <a class="page-link" href="#">1</a>
                            </li>
                            <li class="page-item">
                                <a class="page-link" href="#">2</a>
                            </li>
                            <li class="page-item">
                                <a class="page-link" href="#">3</a>
                            </li>
                            <li class="page-item">
                                <a class="page-link" href="#"><i class="fas fa-chevron-right"></i></a>
                            </li>
                        </ul>
                    </nav>
                 </div>
            </div>
            <div class="row">
                <div class="col-xl-11 col-lg-12 col-md-12 col-sm-12 col-12">
                    <div class="product-sidebar">
                        
                        
                        
					<% for ( ProduitsBean pb : produits ) { %>    
                        <div class="product-wrapper mb-30 d-flex">
                            <div class="product-img mt-md-auto mb-md-auto mt-lg-0 mb-lg-0 ">
                                <img src="<%= pb.getImage() %>" alt="product" style=" width: 270px; height: 270px" >
                                <ul class="social-icon">
                                    <!-- <li><a href="#"><i class="fa fa-retweet" aria-hidden="true"></i></a></li> -->
                                    <li><a href="Produit_Card?id=<%= pb.getId() %>"><i class="fa fa-eye" aria-hidden="true"></i></a></li>
                                    <li><a href="#"><i class="far fa-heart" aria-hidden="true"></i></a></li>
                                </ul>
                            </div>
                            <div class="product-detalis pt-15 pl-20  pb-25">
                                <!-- <span>Men Fashion</span> -->
                            <% 
                            if ( pb.getTitre().length() > 80 ) { 
                            %>
                                <h6><a href="Produit_Card?id=<%= pb.getId() %>"><%= pb.getTitre().substring(0, 80) %>...</a></h6>
                            <%
                            } else {
                            %>
                                <h6><a href="Produit_Card?id=<%= pb.getId() %>"><%= pb.getTitre() %>.</a></h6>
                            <%
                            }
                            %>
                                <div class="price-rating d-flex">
                                    <div class="price d-inline-block">
                                        <span><%= pb.getPrix() %>€</span>
                                        <!-- <del>$899</del> -->
                                    </div>
                                    <ul class="rating d-flex">
                                    <%
                                    ArrayList commentaire = pb.getCommentaires();
                                    if ( commentaire.isEmpty() ){
                                    %>
                                    	<li>Nouveau <i class="fa-solid fa-seedling"></i></li>
                                    <%
                                    } else {
                                    	for ( int i=0; i < pb.getNote_moyenne(); i++ ) {
                                    %>
                                    	<!-- <li><i class="fa-solid fa-star" aria-hidden="true"></i></li> -->
										<li>⭐️</li>
                                    <%
                                    	}
                                    }
                                    %>
                                    </ul>
                                </div>
                                <% if ( pb.getDescription().length() > 400 ) { %>
                                <p><%= pb.getDescription().substring(0, 400) %>...</p>
                                <%
                                } else {
                                %>
                                <p><%= pb.getDescription() %></p>
                                <%
                                }
                                %>
                                <div class="cart ">
                                	<form id="panierForm" method="post">
	                                    <a id="panierButton2" href="Produit_Card?id=<%= pb.getId() %>&qtePageProduit=1">
	                                    	<img class="cart-img-black" src="assets/img/icon/cart-black.png" alt="">
	                                    	<img class="cart-img-red d-none" src="assets/img/icon/cart-red.png" alt=""> Ajouter
										</a>
									</form>
                                </div>
                            </div>
                        </div>
					<%
					}
					%> 
                        
                        
                	</div>
            	</div>
            </div>
        </div>
    </div>

    <!-- =================Product Area Ends================= -->

    


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

	<script type="text/javascript">
		document.getElementById("panierButton").onclick = function() {
			document.getElementById("panierForm").submit();
		}
	</script>
</body>

</html>
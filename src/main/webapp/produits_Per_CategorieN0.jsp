<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@page import="com.hytekFront.beans.CategoriesBean"%>
<%@page import="com.hytekFront.beans.SousCategoriesBean"%>
<%@page import="com.hytekFront.beans.ProduitsBean"%>
<%
CategoriesBean categorieBean = (CategoriesBean) request.getAttribute("categorie");
ArrayList<SousCategoriesBean> categories = (ArrayList) request.getAttribute("categories");
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
    <title><%= categorieBean.getTitre() %></title>

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
                            <h2><%= categorieBean.getTitre() %></h2>
                        </div>
                        <div class="page-bc">
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item p-1"><a href="Index"><i class="fas fa-home "></i>Page d’accueil</a></li>
                                    <li class="breadcrumb-item p-1"><a href="#"><%= categorieBean.getTitre() %></a></li>
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

	<%
	for ( SousCategoriesBean categorie : categories) {
	%>
        <div class="product-area product-area-2 hot-todys-deal pt-10 ">
            <div class="container">
                <div class="row">
                    <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12">
                        <div class="section-title">
                            <h3>
                                <%= categorie.getTitre() %>
                            </h3>
                        </div>
                    </div>
                    <!-- 
                    <div class="col-xl-4 col-lg-5 col-md-6 col-sm-12 offset-xl-4 offset-md-1">
                        <div id="countdown" class="d-flex">
                            <div class="cd-box">
                                <span class="numbers days">00</span>
                                <span class="strings timeRefDays">Days</span>
                            </div>
                            <div class="cd-box">
                                <span class="numbers hours">00</span>
                                <span class="strings timeRefHours">Hours</span>
                            </div>
                            <div class="cd-box">
                                <span class="numbers minutes">00</span>
                                <span class="strings timeRefMinutes">Mins</span>
                            </div>
                            <div class="cd-box">
                                <span class="numbers seconds">00</span>
                                <span class="strings timeRefSeconds">Secs</span>
                            </div>
                        </div>
                    </div>
                     -->
                </div>
                <hr>
            </div>
            <div class="container pl-0 pr-0">
                <div class="custom-row ">
                    <div class="product-active  pt-30">
                    
                    
                    <%
					for ( ProduitsBean pb : categorie.getProduitsCollection() ) {
					%>
                        <div class="col-xl-3 ">
                            <div class="product-wrapper">
                                <div class="product-img ">
                                    <img src="<%= pb.getImage() %>" alt="product" width="100" height="200">
                                    <ul class="social-icon">
                                        <!-- <li><a href="#"><i class="fa fa-retweet" aria-hidden="true"></i></a></li> -->
                                        <li><a href="#"><i class="far fa-heart" aria-hidden="true"></i></a></li>
                                        <li><a href="Produit_Card?id=<%= pb.getId() %>"><i class="fa fa-eye" aria-hidden="true"></i></a></li>
                                    </ul>
                                </div>
                                <div class="flip-box">
                                    <div class="product-detalis pt-15 pl-20 pr-20 pb-25">
                                        <span><%= pb.getSous_categorie().getTitre() %></span>
                                        <% if ( pb.getTitre().length() > 70 ) { %>
                                        <h6><a href="Produit_Card?id=<%= pb.getId() %>"><%= pb.getTitre().substring(0, 70) %>...</a></h6>
                                        <%
                                        } else {
                                        %>
                                        <h6><a href="Produit_Card?id=<%= pb.getId() %>"><%= pb.getTitre() %>.</a></h6>
                                        <%
                                        }
                                        %>
                                        <div class="price-color ">
                                            <div class="price d-inline-block">
                                                <span><%= pb.getPrix() %>€</span>
                                                <!-- <del>$899</del> -->
                                            </div>
                                            <!-- <div class="color float-right d-flex">
                                                <span>Color:</span>
                                                <div class="color-set">
        
                                                </div>
                                            </div> -->
                                        </div>
                                    </div>
                                    <div class="product-detalis product-detalis-2 pt-15 pl-20 pr-20 pb-25">
                                        <span><%= pb.getCommentaires().size() %> avis</span>
                                        <h6><a href="Produit_Card?id=<%= pb.getId() %>"><%= pb.getStock() %> en stock</a></h6>
                                        <div class="buy-info ">
                                            <div class="cart float-left">
                                            	<form id="panierForm2" method="post">
	                                                <a id="panierButton2" href="Produit_Card?id=<%= pb.getId() %>&qtePageProduit=1"><i class="fa fa-shopping-cart" aria-hidden="true"></i>
    	                                            Ajouter
        	                                        </a>
												</form>
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
                                    </div>
                                </div>
                            </div>
                        </div>
					<%
					}
					%>
<!-- 
                        <div class="col-xl-3 ">
                            <div class="product-wrapper">
                                <div class="product-img sale-product ">
                                    <img src="assets/img/product/product-54.png" alt="product">
                                    <ul class="social-icon">
                                        <li><a href="#"><i class="fa fa-retweet" aria-hidden="true"></i></a></li>
                                        <li><a href="#"><i class="far fa-heart" aria-hidden="true"></i></a></li>
                                        <li><a href="#"><i class="fa fa-eye" aria-hidden="true"></i></a></li>
                                    </ul>
                                </div>
                                <div class="flip-box">
                                    <div class="product-detalis pt-15 pl-20 pr-20 pb-25">
                                        <span>Men Fashion</span>
                                        <h6><a href="shop-detalis-page.html">Military Patch Pocket Blazer</a></h6>
                                        <div class="price-color ">
                                            <div class="price d-inline-block">
                                                <span>$999</span>
                                                <del>$899</del>
                                            </div>
                                            <div class="color float-right d-flex">
                                                <span>Color:</span>
                                                <div class="color-set">
        
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="product-detalis product-detalis-2 pt-15 pl-20 pr-20 pb-25">
                                        <span>Men Fashion</span>
                                        <h6><a href="shop-detalis-page.html">Military Patch Pocket Blazer</a></h6>
                                        <div class="buy-info ">
                                            <div class="cart float-left">
                                                <a href="#"><i class="fa fa-shopping-cart" aria-hidden="true"></i> Add To
                                                    Cart</a>
                                            </div>
                                            <ul class="rating d-flex">
                                                <li><i class="far fa-star" aria-hidden="true"></i></li>
                                                <li><i class="far fa-star" aria-hidden="true"></i></li>
                                                <li><i class="far fa-star" aria-hidden="true"></i></li>
                                                <li><i class="far fa-star" aria-hidden="true"></i></li>
                                                <li><i class="far fa-star" aria-hidden="true"></i></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-xl-3 ">
                            <div class="product-wrapper">
                                <div class="product-img ">
                                    <img src="assets/img/product/product-55.png" alt="product">
                                    <ul class="social-icon">
                                        <li><a href="#"><i class="fa fa-retweet" aria-hidden="true"></i></a></li>
                                        <li><a href="#"><i class="far fa-heart" aria-hidden="true"></i></a></li>
                                        <li><a href="#"><i class="fa fa-eye" aria-hidden="true"></i></a></li>
                                    </ul>
                                </div>
                                <div class="flip-box">
                                    <div class="product-detalis pt-15 pl-20 pr-20 pb-25">
                                        <span>Women Fashion</span>
                                        <h6><a href="shop-detalis-page.html">Military Patch Pocket Blazer</a></h6>
                                        <div class="price-color ">
                                            <div class="price d-inline-block">
                                                <span>$999</span>
                                                <del>$899</del>
                                            </div>
                                            <div class="color float-right d-flex">
                                                <span>Color:</span>
                                                <div class="color-set color-black">
        
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="product-detalis product-detalis-2 pt-15 pl-20 pr-20 pb-25">
                                        <span>Men Fashion</span>
                                        <h6><a href="shop-detalis-page.html">Military Patch Pocket Blazer</a></h6>
                                        <div class="buy-info ">
                                            <div class="cart float-left">
                                                <a href="#"><i class="fa fa-shopping-cart" aria-hidden="true"></i> Add To
                                                    Cart</a>
                                            </div>
                                            <ul class="rating d-flex">
                                                <li><i class="far fa-star" aria-hidden="true"></i></li>
                                                <li><i class="far fa-star" aria-hidden="true"></i></li>
                                                <li><i class="far fa-star" aria-hidden="true"></i></li>
                                                <li><i class="far fa-star" aria-hidden="true"></i></li>
                                                <li><i class="far fa-star" aria-hidden="true"></i></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-3 ">
                            <div class="product-wrapper">
                                <div class="product-img new-product">
                                    <img src="assets/img/product/product-56.png" alt="product">
                                    <ul class="social-icon">
                                        <li><a href="#"><i class="fa fa-retweet" aria-hidden="true"></i></a></li>
                                        <li><a href="#"><i class="far fa-heart" aria-hidden="true"></i></a></li>
                                        <li><a href="#"><i class="fa fa-eye" aria-hidden="true"></i></a></li>
                                    </ul>
                                </div>
                                <div class="flip-box">
                                    <div class="product-detalis pt-15 pl-20 pr-20 pb-25">
                                        <span>Women Fashion</span>
                                        <h6><a href="shop-detalis-page.html">Military Patch Pocket Blazer</a></h6>
                                        <div class="price-color ">
                                            <div class="price d-inline-block">
                                                <span>$999</span>
                                                <del>$899</del>
                                            </div>
                                            <div class="color float-right d-flex">
                                                <span>Color:</span>
                                                <div class="color-set color-white">
        
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="product-detalis product-detalis-2 pt-15 pl-20 pr-20 pb-25">
                                        <span>Men Fashion</span>
                                        <h6><a href="shop-detalis-page.html">Military Patch Pocket Blazer</a></h6>
                                        <div class="buy-info ">
                                            <div class="cart float-left">
                                                <a href="#"><i class="fa fa-shopping-cart" aria-hidden="true"></i> Add To
                                                    Cart</a>
                                            </div>
                                            <ul class="rating d-flex">
                                                <li><i class="far fa-star" aria-hidden="true"></i></li>
                                                <li><i class="far fa-star" aria-hidden="true"></i></li>
                                                <li><i class="far fa-star" aria-hidden="true"></i></li>
                                                <li><i class="far fa-star" aria-hidden="true"></i></li>
                                                <li><i class="far fa-star" aria-hidden="true"></i></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-3 ">
                            <div class="product-wrapper">
                                <div class="product-img ">
                                    <img src="assets/img/product/product-54.png" alt="product">
                                    <ul class="social-icon">
                                        <li><a href="#"><i class="fa fa-retweet" aria-hidden="true"></i></a></li>
                                        <li><a href="#"><i class="far fa-heart" aria-hidden="true"></i></a></li>
                                        <li><a href="#"><i class="fa fa-eye" aria-hidden="true"></i></a></li>
                                    </ul>
                                </div>
                                <div class="flip-box">
                                    <div class="product-detalis pt-15 pl-20 pr-20 pb-25">
                                        <span>Men Fashion</span>
                                        <h6><a href="shop-detalis-page.html">Military Patch Pocket Blazer</a></h6>
                                        <div class="price-color ">
                                            <div class="price d-inline-block">
                                                <span>$999</span>
                                                <del>$899</del>
                                            </div>
                                            <div class="color float-right d-flex">
                                                <span>Color:</span>
                                                <div class="color-set">
        
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="product-detalis product-detalis-2 pt-15 pl-20 pr-20 pb-25">
                                        <span>Men Fashion</span>
                                        <h6><a href="shop-detalis-page.html">Military Patch Pocket Blazer</a></h6>
                                        <div class="buy-info ">
                                            <div class="cart float-left">
                                                <a href="#"><i class="fa fa-shopping-cart" aria-hidden="true"></i> Add To
                                                    Cart</a>
                                            </div>
                                            <ul class="rating d-flex">
                                                <li><i class="far fa-star" aria-hidden="true"></i></li>
                                                <li><i class="far fa-star" aria-hidden="true"></i></li>
                                                <li><i class="far fa-star" aria-hidden="true"></i></li>
                                                <li><i class="far fa-star" aria-hidden="true"></i></li>
                                                <li><i class="far fa-star" aria-hidden="true"></i></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
 -->

                    </div>
                </div>
            </div>
        </div>
	<%
	}
	%>
    
    <!-- =================Product Area Ends================= -->



    <!-- =================man-collection Area Starts================= -->
<!--     
        <div class="man-collection-area pt-10">
            <div class="container">
                <div class="man-collection-active">
                    <div class="collection-area pt-50 pb-35" style="background-image: url(assets/img/product/product-bg-4.png);">
                        <div class="row">
                            <div class="col-xl-3 col-lg-5 col-md-7 col-sm-10 col-10 offset-xl-6 offset-lg-4 offset-md-1">
                                <a href="shop-detalis-page.html">Men Collection UP TO 30% Footwear</a>
                            </div>
                        </div>
                    </div>
                    <div class="collection-area pt-50 pb-35" style="background-image: url(assets/img/product/product-bg-4.png);">
                        <div class="row">
                            <div class="col-xl-3 col-lg-5 col-md-7 col-sm-10  offset-xl-6 offset-lg-4 offset-md-1">
                                <a href="shop-detalis-page.html">Men Collection UP TO 30% Footwear</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
-->       
    <!-- =================Men-collection Area Ends================= -->



    <!-- =================Blog Area Starts================= -->
<!-- 
        <div class="blog-area">
            <div class="container">
                <div class="row">
                    <div class="col-xl-12">
                        <div class="section-title ">
                            <h3>
                                Letest Blog
                            </h3>
                            <hr>
                        </div>
                    </div>
                </div>

            </div>
            <div class="container pl-0 pr-0">
                <div class="custom-row">
                    <div class="blog-active pt-30">
                        <div class="col-xl-3">
                            <div class="blog-wrapper">
                                <div class="blog-img">
                                    <img src="assets/img/blog/blog-3.png" alt="product">
                                </div>
                                <div class="blog-detalis">
                                    <span>Admin By <span>- Alamgir Joy</span></span>
                                    <a href="shop-detalis-page.html">Nulla in consectetur ligula. In in cursus sapien.</a>
                                    <p>In vitae convallis diam. Nulla pellentesqu nulla sed tellus maximus molestie. </p>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-3">
                            <div class="blog-wrapper">
                                <div class="blog-img">
                                    <img src="assets/img/blog/blog-4.png" alt="product">
                                </div>
                                <div class="blog-detalis">
                                    <span>Admin By <span>- Alamgir Joy</span></span>
                                    <a href="shop-detalis-page.html">Nulla in consectetur ligula. In in cursus sapien.</a>
                                    <p>In vitae convallis diam. Nulla pellentesqu nulla sed tellus maximus molestie. </p>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-3">
                            <div class="blog-wrapper">
                                <div class="blog-img">
                                    <img src="assets/img/blog/blog-5.png" alt="product">
                                </div>
                                <div class="blog-detalis">
                                    <span>Admin By <span>- Alamgir Joy</span></span>
                                    <a href="shop-detalis-page.html">Nulla in consectetur ligula. In in cursus sapien.</a>
                                    <p>In vitae convallis diam. Nulla pellentesqu nulla sed tellus maximus molestie. </p>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-3">
                            <div class="blog-wrapper">
                                <div class="blog-img">
                                    <img src="assets/img/blog/blog-6.png" alt="product">
                                </div>
                                <div class="blog-detalis">
                                    <span>Admin By <span>- Alamgir Joy</span></span>
                                    <a href="shop-detalis-page.html">Nulla in consectetur ligula. In in cursus sapien.</a>
                                    <p>In vitae convallis diam. Nulla pellentesqu nulla sed tellus maximus molestie. </p>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-3">
                            <div class="blog-wrapper">
                                <div class="blog-img">
                                    <img src="assets/img/blog/blog-4.png" alt="product">
                                </div>
                                <div class="blog-detalis">
                                    <span>Admin By <span>- Alamgir Joy</span></span>
                                    <a href="shop-detalis-page.html">Nulla in consectetur ligula. In in cursus sapien.</a>
                                    <p>In vitae convallis diam. Nulla pellentesqu nulla sed tellus maximus molestie. </p>
                                </div>
                            </div>
                        </div>
        
                    </div>
                </div>
            </div>
        </div>
-->       
    <!-- =================Blog Area Ends================= -->

 
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
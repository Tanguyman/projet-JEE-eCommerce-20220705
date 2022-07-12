<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@page import="com.hytekFront.beans.PanierBean"%>
<%@page import="com.hytekFront.beans.Panier_DetailsBean"%>
<%
PanierBean panier = (PanierBean) session.getAttribute("panier");
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
    <title>Panier</title>

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
                            <h2>Panier</h2>
                        </div>
                        <div class="page-bc">
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="Index"> <i
                                                class="fas fa-home "></i>Page d’accueil</a></li>
                                    <li class="breadcrumb-item active" aria-current="page"><a
                                            href="#">Panier</a></li>
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
                        <table class="table table-bordered text-center">
                            <thead>
                                <tr>
                                    <th scope="col">Produit</th>
                                    <th scope="col">Nom</th>
                                    <!-- <th scope="col">Model</th> -->
                                    <th scope="col">Quantite</th>
                                    <th scope="col">Prix Unitaire</th>
                                    <th scope="col">Total</th>
                                    <th scope="col">Retirer</th> <!-- poubelle -->
                                </tr>
                            </thead>
                            <tbody>
                            
                            <%
                            for ( Panier_DetailsBean p : panier.getPanierDetails() ) {
                            %>
                                <tr>
                                    <td>
                                        <div class="cart-img">
                                            <img src="<%= p.getProduit().getImage() %>" alt="product" style="height: 120px; width: 120px;">
                                        </div>
                                    </td>
                                    <td class="td-width">
                                        <div class="cart-description text-left pl-20">
                                            <a href="Produit_Card?id=<%= p.getProduit().getId() %>"><span><%= p.getProduit().getTitre() %></span></a>
                                            <!-- <p>Lorem Ipsum is simply dummy text of the type setting.</p> -->
                                        </div>
                                    </td>
                                    <!-- <td>
                                        <div class="cart-model">
                                            <span>Product-23</span>
                                        </div>
                                    </td> -->
                                    <td>
                                        <div class="product-number ">
                                            <div class="quty">
	                                            <form method="post" action="Panier">
	                                            	<input type="hidden" name="idProduit" value="<%= p.getProduit().getId() %>">
	                                                <input class="qty" type="number" value="<%= p.getQuantite() %>" min="1" max="<%= p.getProduit().getStock() %>" style="text-align:center;" name="quantite"  >
	                                                <button type="submit" class="btn btn-primary" >Modifier</button>                                       
                                            	</form>
                                            </div>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="cart-price">
                                            <span><%= p.getProduit().getPrix() %></span>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="cart-price">
                                            <span>
                                            	<% double t = p.getProduit().getPrix() * p.getQuantite(); %>
                                            	<%= t %>
                                            </span>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="cart-edit">
                                            <!-- <a href="#"> <i class="fas fa-pencil-alt"></i> </a> -->
                                            <a href="Panier?id=<%= p.getProduit().getId() %>"><i class="fas fa-trash-alt"></i></a>
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
                <div class="row justify-content-center justify-content-lg-start">
                    <!-- <div class="col-xl-4 col-lg-4 col-md-8 col-sm-9 col-12">
                        <div class="cart-wrapper pl-20 pt-30 pr-20 pb-30">
                            <div class="section-title">
                                <h6>
                                    Estimate Shopping And Tax
                                </h6>
                            </div>
                            <div class="country pt-15">
                                <span>Country</span>
                                <input type="text" placeholder="United States">
                            </div>
                            <div class="state pt-15">
                                <span>State/Province</span>
                                <input type="text" placeholder="Please select region, state or province">
                            </div>
                            <div class="zip-code pt-15 pb-20">
                                <span>Zip/Postal Code</span>
                                <input type="text">
                            </div>
                            <div class="table-button d-flex justify-content-end">
                                <a href="#" class="b-btn  pl-20 pr-20 pb-15 pt-15">GET QUOTE</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-4 col-lg-4 col-md-8 col-sm-9 col-12">
                        <div class="cart-wrapper pl-20 pt-30 pr-20 pb-30 mt-50 mb-50 mt-lg-0 mb-lg-0">
                            <div class="section-title">
                                <h6>
                                    Discount Code
                                </h6>
                            </div>
                            <div class="country pt-15 pb-20">
                                <span class="pb-10">Enter your coupon code if you have one.</span>
                                <input type="text" >
                            </div>
                            <div class="table-button d-flex justify-content-end ">
                                <a href="#" class="b-btn  pt-15 pb-15 pr-30 pl-30 ">APPLY</a>
                            </div>

                        </div>
                    </div> -->
                    <div class="col-xl-8 col-lg-8 col-md-8 col-sm-9 col-12">
                    </div>
                    <div class="col-xl-4 col-lg-4 col-md-8 col-sm-9 col-12">
                        <div class="cart-wrapper pl-20 pt-30 pr-20 pb-50">
                            <div class="cart-price-area text-right">
                                <!-- <p>Subtotal <span class="d-inline-block"> $999.00</span></p> -->
                                <p>Total  <span class="d-inline-block">${ panier.total() }</span></p>
                            </div>

                            <div class="table-button d-flex justify-content-end pt-20">
                                <a href="Commandes" class="b-btn  pt-20 pb-20 pr-50 pl-50 ">COMMANDER</a>
                            </div>

                        </div>
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

	<script type="text/javascript">
		document.getElementById("panierButton").onclick = function() {
			document.getElementById("panierForm").submit();
		}
	</script>
</body>

</html>
    
    
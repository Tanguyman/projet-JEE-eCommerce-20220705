<%@page import="javax.crypto.interfaces.PBEKey"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@page import="com.hytekFront.beans.ProduitsBean"%>
<%@page import="com.hytekFront.beans.SousCategoriesBean"%>
<%@page import="com.hytekFront.beans.CommentairesBean"%>
<%@page import="com.hytekFront.beans.ImagesBean"%>
<%
ProduitsBean p = (ProduitsBean) request.getAttribute("produit");
SousCategoriesBean sousCategorie = (SousCategoriesBean) request.getAttribute("sousCategorie");
ArrayList<ImagesBean> images = p.getImages();
ArrayList<CommentairesBean> commentaire = p.getCommentaires();
ArrayList<ProduitsBean> produits = (ArrayList) request.getAttribute("produitsList");
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
    <title>Page produit</title>

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
                            <h2>Page Produit</h2>
                        </div>
                        <div class="page-bc">
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb">
                                	<li class="breadcrumb-item p-1"><a href="Index"><i class="fas fa-home "></i>Page d’accueil</a></li>
                                    <li class="breadcrumb-item p-1"><a href="#"><%= p.getSous_categorie().getCategorie().getTitre() %></a></li>
                                    <li class="breadcrumb-item active p-1"><a href="Produits_List?idSousCat=<%= p.getFk_sous_categorie() %>"><%= p.getSous_categorie().getTitre() %></a></li>
                                    <li class="breadcrumb-item active p-1" aria-current="page"><a href="#">Page produit</a></li>
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

    <div class="product-area product-shop-page  product-list-page product-detalis-page  pt-50 ">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-xl-4 col-lg-6 col-md-6 col-sm-8 col-11 col offset-xl-1 offset-lg-1">
                    <div class=" slider-nav-thumbnails product-list-active d-md-none">
                    
                    <%-- 
                    <%
                    for ( ImagesBean image : images) {
                    %>
                        <!-- <a class="active"><img src="assets/img/product/product-62.png" alt=""></a> --> <!-- 570x470 -->
                        <a class="active" ><img src="<%= image.getUrl() %>" alt="" style="width: 90px; height: 90px;"></a>  
					<%
                    }
					%>
                    
                         --%>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-xl-6 col-lg-7 col-md-6 col-sm-12">
                    <div class="product-list-slider">
                    
                    
					<%
                    for ( ImagesBean image : images) {
                    %>
                        <div class="product-img">
                            <img src="<%= image.getUrl() %>" alt="" style="height: 470px; width: 470px;"> <!-- 570x470 --> <!-- 90x90 -->
                        </div>
					<%
                    }
					%>
                    
                    
                    </div>
                </div>
                <div class="col-xl-5 col-lg-5 col-md-6 col-sm-12">
                    <div class="product-wrapper product-wrapper-2 pt-60">
                        <div class="product-detalis">
                            <h6><%= p.getTitre() %></h6>
                            <ul class="rating d-flex pl-0 pt-10 pb-10">
							<%
							if ( commentaire.isEmpty() ){
							%>
								<li>Nouveau <i class="fa-solid fa-seedling"></i></li>
							<%
							} else {
								for ( int i=0; i < p.getNote_moyenne(); i++ ) {
							%>
								<!-- <li><i class="fa-solid fa-star" aria-hidden="true"></i></li> -->
								<li>⭐️</li>
							<%
								}
							}
							%>
                            </ul>
                            <div class="product-interested pb-20">
                                <!-- <span class="pr-10">Interested : 05</span> -->
                                <span><%= p.getCommentaires().size() %> Avi(s)</span>
                            </div>
                            <div class="price d-inline-block pb-25">
                                <span><%= p.getPrix() %>€</span>
                                <!-- <del>$899</del> -->
                            </div>
                            <form id="panierForm" method="post" action="Produit_Card"> <!--  -->
	                            <div class="product-number d-flex pb-30">
	                                <div class="quty">
	                                    <span class="pr-10">Quantité :</span>
	                                    <input class="qty" type="number" value="1" min="1" max="<%= p.getStock() %>" style="text-align:center;" name="quantite">                                       
	                                </div>
	                                <div class="availabillity pl-20">
	                                    <span><span class="pl-5"><%= p.getStock() %> EN STOCK</span> </span>
	                                </div>
	                            </div>
                            	<hr>
	                            <div class="page-share-icon  d-flex pt-15 pb-20"> <!-- pt-25 -->
	                            <!-- 
	                                <span>Share:</span>
	                                <ul class="icon pl-15  d-flex" >
	                                  <li><a href="#"><i class="fab fa-facebook-square"></i></a></li>
	                                  <li><a href="#"><i class="fab fa-google-plus-g"></i></a></li>
	                                  <li><a href="#"><i class="fab fa-twitter"></i></a></li>
	                                  <li><a href="#"><i class="fab fa-skype"></i></a></li>
	                                  <li><a href="#"><i class="fas fa-rss"></i></a></li>
	                                </ul>
	                            -->
	                            </div> 
	                            <div class="cart-view d-flex">
	                                <div class="cart ">
	                                	<input type="hidden" name="id" value="<%= p.getId() %>">
	                                    <a id="panierButton" tabindex="0"><img class="p-2" src="assets/img/icon/cart-red.png" alt="ajouter au panier">Ajouter</a>
	                               </div>
	                               <ul class="social-icon d-flex align-items-center pl-20">
	                                <!-- <li><a href="#" tabindex="0"><i class="fa fa-retweet" aria-hidden="true"></i></a></li> -->
	                                <li><a href="#" tabindex="0"><i class="far fa-heart" aria-hidden="true"></i></a></li>
	                                <!-- <li><a class="popup-img" href="assets/img/product/product-61.png"><i class="fa fa-eye" aria-hidden="true"></i></a></li> -->
	                                
		                            </ul>
	                            </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-xl-4 col-lg-6 col-md-6 col-sm-7 col offset-xl-1 offset-lg-1">
                    <div class=" slider-nav-thumbnails product-list-active d-none d-md-block">
                    <%
                    for ( ImagesBean image : images) {
                    %>
                        <!-- <a class="active"><img src="assets/img/product/product-62.png" alt=""></a> --> <!-- 570x470 -->
                        <a><img src="<%= image.getUrl() %>" alt="" ></a>  
					<%
                    }
					%>
                    </div>
                    
                </div>
            </div>

        </div>
    </div>

    <div class="description-area pt-10">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="description-tab pt-50 pl-50 pr-50 pb-40">
                        <nav>
                          <div class="nav nav-tabs " id="approach-tabs" role="tablist">
                            <a class="nav-item nav-link active" id="nav-description-tab" data-toggle="tab" href="#nav-description" role="tab" aria-controls="nav-description" aria-selected="true">description</a>
                            <a class="nav-item nav-link" id="nav-comment-tab" data-toggle="tab" href="#nav-comment" role="tab" aria-controls="nav-comment" aria-selected="false">COMMENTAIRES</a>
                            <!-- <a class="nav-item nav-link" id="nav-review-tab" data-toggle="tab" href="#nav-review" role="tab" aria-controls="nav-review" aria-selected="false">review</a> -->
                          </div>
                        </nav>
                        <div class="tab-content mt-25 " id="nav-tabContents">
							<div class="tab-pane  active " id="nav-description" role="tabpanel" aria-labelledby="nav-description-tab">
	                            <p><%= p.getDescription() %></p>
	                            <!-- <div class="item-features">
	                                <div class="section-title">
	                                    <h5>Item Features</h5>
	
	                                </div>
	                                <ul class="item-features-list pl-35">
	
	                                    <li>Perfect unique design</li>
	                                    <li>Fully responsive</li>
	                                    <li>Amazing parallax effects</li>
	                                    <li>SEO friendly</li>
	                                    <li>Well organized and valid code</li>
	                                    <li>Google fonts</li>
	                                    <li>WPML ready</li>
	                                </ul>
	                            </div> -->
							</div>
							
							
							
						<%
						if ( (boolean) session.getAttribute("isConnected") ) {
							/* p. */
						%>
							<div class="tab-pane " id="nav-comment" role="tabpanel" aria-labelledby="nav-comment-tab">
								<div class="item-features">
									<div class="section-title">
										<form>
	                                    	<h4>AJOUTER VOTRE AVIS</h4>
	                                    	<input 
	                                    		type="hidden" 
	                                    		name="id" 
	                                    		value="<%= p.getId() %>" 
	                                    	/>
	                                    	<input 
	                                    		type="hidden" 
	                                    		name="commentaireForm" 
	                                    		value="commentaireForm" 
	                                    	/>
											<div class="form-group col-md-2">
												<label for="inputState">Note</label>
												<select id="inputState" class="form-control" name="note">
													<option value="1">⭐</option>
													<option value="2">⭐⭐</option>
													<option value="3">⭐⭐⭐</option>
													<option value="4">⭐⭐⭐⭐</option>
													<option value="5">⭐⭐⭐⭐⭐</option>
												</select>
											</div>
											<div class="form-group col-md-2">							
												<label for="story">Commentaire</label>
												<textarea id="story" name="story" rows="7" cols="46"></textarea>
											</div>						
	                                    	<!-- <p class="p-2">Commentaire</p> -->
	                                    	<button type="submit" class="btn btn-primary">ENREGISTRER</button>
										</form>
									</div>
								</div>
								<br>
								<hr>
								<br>
						<%
						} else {
						%>
							<div class="tab-pane pt-10" id="nav-comment" role="tabpanel" aria-labelledby="nav-comment-tab">
								<div class="item-features">
									<div class="section-title">
										<form method="get" action="ConnexionInscription">
	                                    	<h5>Pour ajouter votre avis il faut être connecté(e).</h5>					
	                                    	<!-- <p class="p-2">Commentaire</p> -->
	                                    	<input type="hidden" name="loginFrom" value="produitCard">
	                                    	<input type="hidden" name="idProduct" value="<%= p.getId() %>">
	                                    	<button type="submit" class="btn btn-outline-primary btn-sm" name="buttonConnection" value="toto">SE CONNECTER ou S'INSCRIRE</button>
										</form>
									</div>
								</div>
								<br>
								<hr>
								<br>
						<%
						}
						%>
						<%
						if ( commentaire.isEmpty() ) {
						%>
								<div class="item-features">
									<div class="section-title">
                                    	<h5>Aucune personne n’a donné son avis pour l’instant.</h5>
									</div>
								</div>
						<%
						} else {
						%>
							<% 
							for ( CommentairesBean c : commentaire) {
								SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                               	String strDate = formatter.format( c.getDate() );
                               	String strDate2 = formatter.format( c.getUtilisateur().getDate_inscription() );
							%>
								<div class="item-features">
									<div class="section-title">
                                    	<h5><%= c.getUtilisateur().getPrenom().toUpperCase() %> inscrit(e) depuis le <%= strDate2 %></h5>
                                    	<p> a donné 
                                    	<%
	                                    for ( int j = 0; j < c.getNote(); j++) {
	                                    %>
	                                    ⭐️
	                                    <%
	                                    }
	                                    %>
	                                    le <b><%= strDate %></b>
                                    	</p>
                                    	<p class="p-2"><%= c.getCommentaire() %></p>
	                                </div>
	                            </div> 
						<%
							}
						}
						%>
						
						
                          </div>
                          <!-- <div class="tab-pane fade" id="nav-review" role="tabpanel" aria-labelledby="nav-review-tab">
                            <p>MOVIE STAR – Online Movie,Video & TV Show PSD Template is a the best design for 2017. any kinds of online video Template Based on Bootstrap, 12 column Responsive grid Template. “MOVIE STAR” is a smooth and colorful online video PSD Template, perfect suitable for , Businesses or Personal One page Template. It includes everything you need for the website development such as online Movie,Video & TV Show Template .PSD files are well organized also you can customize very easy . we have include 21 psd file for you. Please, don’t forget to leave a stars rating for this Template! <br>
                                MOVIE STAR – Online Movie,Video & TV Show PSD Template is a the best design for 2017. any kinds of online video Template Based on Bootstrap, 12 column Responsive grid Template. “MOVIE STAR” is a smooth and colorful online video PSD Template, perfect suitable for , Businesses or Personal One page Template. It includes everything you need for the website development such as online Movie,Video & TV Show Template.</p>
                            <div class="item-features">
                                <div class="section-title">
                                    <h5>Item Features</h5>

                                </div>
                                <ul class="item-features-list pl-35">

                                    <li>Perfect unique design</li>
                                    <li>Fully responsive</li>
                                    <li>Amazing parallax effects</li>
                                    <li>SEO friendly</li>
                                    <li>Well organized and valid code</li>
                                    <li>Google fonts</li>
                                    <li>WPML ready</li>
                                </ul>
                            </div>
                          </div> -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- =================Product Area Ends================= -->
    <!-- =================Product Area Starts================= -->

    <div class="product-area pt-50 ">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="section-title">
                        <h3>
                            Articles similairses dans la catégorie <%= p.getSous_categorie().getTitre().toUpperCase() %>
                        </h3>
                    </div>
                </div>
            </div>
            <hr>

        </div>
        <div class="container pl-0 pr-0">
            <div class="custom-row ">
                <div class="product-active pt-30">
                    
                    <% for ( ProduitsBean pb : produits ) { %>
                    <div class="col-xl-3">
                        <div class="product-wrapper">
                            <div class="product-img ">
                                <img src="<%= pb.getImage() %>" alt="product" style=" width: 270px; height: 270px" >
                                <ul class="social-icon">
                                    <!-- <li><a href="#"><i class="fa fa-retweet" aria-hidden="true"></i></a></li> -->
                                    <li><a href="#"><i class="far fa-heart" aria-hidden="true"></i></a></li>
                                    <li><a href="Produit_Card?id=<%= pb.getId() %>"><i class="fa fa-eye" aria-hidden="true"></i></a></li>
                                </ul>
                            </div>
                            <div class="flip-box">
                                <div class="product-detalis pt-15 pl-20 pr-20 pb-25">
                                    <!-- <span>Men Fashion</span> -->
								<% 
	                            if ( pb.getTitre().length() > 80 ) { 
	                            %>
	                                <h6><a href="Produit_Card?id=<%= pb.getId() %>"><%= pb.getTitre().substring(0, 75) %>...</a></h6>
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
                                    <div class="product-info">
                                     <span><%= pb.getCommentaires().size() %> avis</span>
                                    <h6><a href="Produit_Card?id=<%= pb.getId() %>"><%= pb.getStock() %> en stock</a></h6>
                                    <div class="buy-info ">
                                        <div class="cart float-left">
                                        	<form id="panierForm2" method="post">
	                                            <a id="panierButton2" href="Produit_Card?id=<%= pb.getId() %>&qtePageProduit=1"><img src="assets/img/icon/cart-red.png" alt="" class="p-1">Ajouter</a>
                                        	</form>
                                        </div>
                                        <ul class="rating d-flex">
                                        <%
                                        ArrayList commentaires = pb.getCommentaires();
                                        if ( commentaires.isEmpty() ){
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
                    </div>
					<%
					}
					%>
                        
                        
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
		
		document.getElementById("panierButton2").onclick = function() {
			document.getElementById("panierForm2").submit();
		}
	</script>
</body>

</html>
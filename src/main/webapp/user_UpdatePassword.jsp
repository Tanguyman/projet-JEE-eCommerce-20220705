<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.hytekFront.beans.UtilisateursBean"%>
<%
UtilisateursBean client = (UtilisateursBean) request.getAttribute("user");
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
	    <title>Mot de passe</title>
	
	    <!-- stylesheets -->
	    <link rel="stylesheet" href="assets/css/vendor/bootstrap.min.css">
	    <link rel="stylesheet" href="assets/css/vendor/font-awesome.min.css">
	    <link rel="stylesheet" href="assets/css/vendor/animate.css">
	    <link rel="stylesheet" href="assets/css/vendor/owl.carousel.min.css">
	    <link rel="stylesheet" href="assets/css/vendor/slick.css">
	    <link rel="stylesheet" href="assets/css/vendor/magnific-popup.css">
	    <link rel="stylesheet" href="assets/css/vendor/normalize.css">
	    <link rel="stylesheet" href="assets/css/vendor/jquery.nice-number.css">
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
	
	    <div class="page-title-area pt-130 pb-120" style="background-image: url(assets/img/bg/chechout-page-bg.jpg); opacity: 0.6;">
	        <div class="container">
	            <div class="row">
	                <div class="col-xl-12">
	                    <div class="page-titel-detalis  ">
	                        <div class="page-title position-relative">
	                            <h2>Mot de passe</h2>
	                        </div>
	                        <div class="page-bc">
	                            <nav aria-label="breadcrumb">
	                                <ol class="breadcrumb">
	                                    <li class="breadcrumb-item"><a href="Index"><i class="fas fa-home "></i>Page d’accueil</a></li>
	                                    <li class="breadcrumb-item"><a href="Utilisateurs_Index"><i class="fas fa-home "></i><%= client.getPrenom() %></a></li>
	                                    <li class="breadcrumb-item active" aria-current="page">Mot de passe</li>
	                                </ol>
	                            </nav>
	                        </div>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	
	    <!-- =================Page Title Area End================= -->
	    <!-- =================Login Area Starts================= -->
	
	    <div class="login-page-area pt-50">
	        <div class="container">
	            <div class="row justify-content-center">
	                
	                <div class="col-xl-5 col-lg-6 col-md-8 col-sm-12">
	                    <div class="login-detalis pt-40 pr-40 pl-40 pb-40">
	                        <h4 class="pb-30">Nouveau mot de passe : </h4>
	                        <!-- <p>Assurez-vous que votre nouveau mot de passe soit fort</p> -->
	                        <form class="user-form" method="post" action="Utilisateurs_Index">
                                <div class="form-group">
                                    <input type="password" class="form-control" placeholder="ancien mot de passe" name="passwordOld">
                                </div>
                                <div class="form-group">
                                    <input type="password" class="form-control" placeholder="nouveau mot de passe" name="passwordNew">
                                </div>
                                <div class="form-group">
                                    <input type="password" class="form-control" placeholder="confirmez votre nouveau mot de passe" name="passwordConfirmation">
                                </div>
                                <div class="form-button">
                                    <button type="submit" name="buttonUpdatePassword" class="btn btn-primary btn-block">enregistrer le nouveau mot de passe</button>
                                </div>
                            </form>
                            <div class="login-information pt-25">
	                            <div class="remember-me">
	                                <span class="float-right"><span>Mot de passe</span> oublié ?</span>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	                
	         <div class="container pl-0 pr-0">
                <div class="custom-row ">
                    <div class="product-active pt-30">
                    </div>
				</div>
			</div>  
	    </div>
	
	    <!-- =================Login Area Ends================= -->
	
	
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
	     document.getElementById("decoButton").onclick = function() {
	    	 document.getElementById("decoForm").submit();
	   	 }
	     </script>
	     <script type="text/javascript">
	     document.getElementById("loginButton").onclick = function() {
	    	 document.getElementById("loginForm").submit();
	   	 }
	     </script>
	
	</body>

</html>
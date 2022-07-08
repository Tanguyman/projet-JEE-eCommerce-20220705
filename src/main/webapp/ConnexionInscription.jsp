<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

	<head>
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <meta name="description" content="shop, ecommerce, store, multipurpose, shopify, woocommerce, html5, css3, sass">
	
	    <!-- fav -->
	  
	  <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
	
	    <!-- title -->
	    <title>Connexion / Inscription</title>
	
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
	                            <h2>Page de connexion</h2>
	                        </div>
	                        <div class="page-bc">
	                            <nav aria-label="breadcrumb">
	                                <ol class="breadcrumb">
	                                    <li class="breadcrumb-item"><a href="Index"><i class="fas fa-home "></i>Page d’accueil</a></li>
	                                    <li class="breadcrumb-item active" aria-current="page">Connexion</li>
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
	                
	                <div class="col-xl-5 col-lg-6 col-md-8 col-sm-9">
	                    <div class="login-detalis pt-40 pr-40 pl-40 pb-40">
	                        <h4>Connexion</h4>
                        	<%
							if (request.getAttribute("message") != null) {
							%>
							<div class="pt-20">
								<div class="alert alert-danger text-center" role="alert">
									<%=request.getAttribute("message")%>
								</div>
							</div>	
							<%
							}
							%>
	                        <form method="post" action="ConnexionInscription">
	                        	<input type="hidden" class="form-control"
									name="loginFrom" 
									value="<%= request.getAttribute("loginFrom") %>"
								/>
		                        <div class="login-input pt-20">
		                            <input type="text" placeholder="Entrer votre email..." value="dj.tanguy.paris@gmail.com" name="mail">
		                            <input type="text" placeholder="Entrez votre mot de passe..." value="11aaAA@@" name="password">
		                        </div>
		                        <div class="or text-center">
		                            <span>OU</span>
		                        </div>
		                        <div class="login-account text-center pt-20">
		                            <a href="#"><i class="fab fa-facebook-f"></i>Facebook</a>
		                            <a href="#"><i class="fab fa-google"></i>Google</a>
		                        </div>
		                        <div class="login-button text-center pt-30">
			                        <button type="submit" name="buttonConnection">Se connecter</button>
		                        </div>
	                        </form>
		                        <div class="login-information pt-25">
		                            <div class="remember-me">
		                                <input type="checkbox" id="checkbox-1"><label for="checkbox-1">Se rappeler de moi</label>
		                                <span class="float-right"><span>Mot de passe</span> oublié ?</span>
		                            </div>
		                        </div>
	                    </div>
	                </div>
	                
	                <div class="col-xl-5 col-lg-6 col-md-8 col-sm-9">
	                    <div class="login-detalis pt-40 pr-40 pl-40 pb-40">
	                        <h4>Inscription</h4>
	                        <div class="login-input pt-20">
	                            <input type="text" placeholder="Full Name...">
	                            <input type="text" placeholder="Enter your email....">
	                            <input type="text" placeholder="Enter your Password....">
	                            <input type="text" placeholder="(+99) 00000000000">
	                            
	                        </div>
	                        <div class="or text-center">
	                            <span>OU</span>
	                        </div>
	                        <div class="login-account text-center pt-20">
	                            <a href="#"><i class="fab fa-facebook-f"></i>Facebook</a>
	                            <a href="#"><i class="fab fa-google-plus-g"></i>Google</a>
	                        </div>
	                        <div class="login-button text-center pt-30">
	                            <a href="#" >Inscription</a>
	                        </div>
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
	
	</body>

</html>
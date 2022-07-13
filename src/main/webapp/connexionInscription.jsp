<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	                        <form id="loginForm" method="post" action="ConnexionInscription">
								<input type="hidden" name="buttonConnection">
	                        	<input type="hidden" class="form-control"
									name="loginFrom" 
									value="<%= request.getAttribute("loginFrom") %>"
								/>
								<%
								if ( request.getAttribute("loginFrom").equals("produitCard") ) {
								%>
								<input type="hidden" class="form-control"
									name="idProduct" 
									value="<%= request.getAttribute("idProduct") %>" 
								/>
                                <%
                                }
                                %>
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
		                        <!-- <div class="login-button text-center pt-30">
			                        <button type="submit" name="buttonConnection">Se connecter</button>
		                        </div> -->
		                        <div class="login-button text-center pt-30">
		                            <a id="loginButton" href="#">connexion</a>
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
	                        <%
							if (request.getAttribute("messageInscriptionValidated") != null) {
							%>
							<div class="form-group">
								<div class="alert alert-success text-center" role="alert">
									<br>
									<%=request.getAttribute("messageInscriptionValidated")%><br>
									<br>
								</div>
							</div>
							<%
							}
							%>
                              	<%
							if (request.getAttribute("messageEmailIsInDatabase") != null) {
							%>
							<div class="form-group">
								<div class="alert alert-danger text-center" role="alert">
									
									<%=request.getAttribute("messageEmailIsInDatabase")%><br>
									<a href="#"> Avez-vous oublié votre mot de passe ? </a>
									<br>
									
								</div>
							</div>
							<%
							}
							%>
							<%
							if (request.getAttribute("messageInvalidName") != null) {
							%>
							<div class="form-group">
								<div class="alert alert-danger" role="alert">
									
									<%=request.getAttribute("messageInvalidName")%>
									<br>
									
								</div>
							</div>
							<%
							}
							%>
							<%
							if (request.getAttribute("messageInvalidEmail") != null) {
							%>
							<div class="form-group">
								<div class="alert alert-danger text-center" role="alert">
									
									<%=request.getAttribute("messageInvalidEmail")%>
									<br>
									
								</div>
							</div>	
							<%
							}
							%>
							<%
							if (request.getAttribute("messageInvalidPassword") != null) {
							%>
							<div class="form-group">
								<div class="alert alert-danger" role="alert">
									
									<%=request.getAttribute("messageInvalidPassword")%>
									<br>
									
								</div>
							</div>
							<%
							}
							%>
							<%
							if (request.getAttribute("messagePasswordNotEqual") != null) {
							%>
							<div class="form-group">
								<div class="alert alert-danger text-center" role="alert">
									
									<%=request.getAttribute("messagePasswordNotEqual")%>
									<br>
									
								</div>
							</div>
							<%
							}
							%>
	                        <form id="decoForm" method="post" action="ConnexionInscription">
		                        <div class="login-input pt-20">
		                        	<input type="hidden" name="signInButton">
		                            <input type="text" placeholder="Entrez votre nom" name="firstName">
		                            <input type="text" placeholder="Entrez votre prénom" name="lastName">
		                            <input type="email" placeholder="Entrez votre e-mail" name="mail">
		                            <input type="password" placeholder="Entrez votre mot de passe" name="password">
		                            <input type="password" placeholder="Confirmez votre mot de passe" name="password2">
		                        </div>
		                        <div class="or text-center">
		                            <span>OU</span>
		                        </div>
		                        <div class="login-account text-center pt-20">
		                            <a href="#"><i class="fab fa-facebook-f"></i>Facebook</a>
		                            <a href="#"><i class="fab fa-google-plus-g"></i>Google</a>
		                        </div>
		                        <div class="login-button text-center pt-30">
		                            <a id="decoButton" href="#">Inscription</a>
		                        </div>
							</form>
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
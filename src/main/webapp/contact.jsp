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
    <title>Contact</title>

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

    <div class="page-title-area pt-130 pb-120" style="background-image: url(assets/img/bg/contact-bg.png);">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="page-titel-detalis  ">
                        <div class="page-title position-relative">
                            <h2>Contact</h2>
                        </div>
                        <div class="page-bc">
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="Index"> <i
                                                class="fas fa-home "></i>Page d’accueil</a></li>
                                    <li class="breadcrumb-item active" aria-current="page"><a
                                            href="contact-page.html">Contact</a></li>
                                </ol>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- =================Page Title Area Ends================= -->

    <!-- =================Map Area Starts================= -->

    <!-- <div class="map-area pt-50 ">
        <div class="container">
            <div id="map-container-googl" class="map-container ">
                <iframe
                    src="https://maps.google.com/maps?q=manhatan&amp;t=&amp;z=13&amp;ie=UTF8&amp;iwloc=&amp;output=embed"
                    style="border:0" allowfullscreen=""></iframe>
            </div>
        </div>
    </div> -->
    <!-- =================Map Area Ends================= -->

    <!-- =================Comment  Area Starts================= -->

    <div class="contact-page comment-area pt-50">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-xl-9 col-lg-8 col-md-8 col-sm-7 col-12">
                    <div class="comment-sidebar">
                        <div class="section-title d-inline-block">
                            <h3>
                                Message
                            </h3>
                        </div>
                        <div class="post-comment pt-25 ">
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
							<%
							if (request.getAttribute("message2") != null) {
							%>
							<div class="pt-20">
								<div class="alert alert-danger text-center" role="alert">
									<%=request.getAttribute("message2")%>
								</div>
							</div>	
							<%
							}
							%>
							<%
							if (request.getAttribute("message3") != null) {
							%>
							<div class="pt-20">
								<div class="alert alert-success text-center" role="alert">
									<%=request.getAttribute("message3")%>
								</div>
							</div>	
							<%
							}
							%>
                            <form method="post" action="Contact">
                                <div class="row">
                                <%
                                if ( (boolean) session.getAttribute("isConnected") ) {
                                %>
                                    <div class="col-xl-6 col-lg-6">
                                        <ul class="name">
                                            <li><label for="name">Votre nom, prénom ou pseudo</label></li>
                                            <li><input type="text" id="name" name="nom" value="<%= session.getAttribute("userLastNameBySession") %>"></li>
                                        </ul>
                                    </div>
                                    <div class="col-xl-6 col-lg-6">
                                        <ul class="email pt-15 pt-sm-0">
                                            <li><label for="email">Votre email</label></li>
                                            <li><input type="email" id="email" name="mail" value="<%= session.getAttribute("userMailBySession") %>"></li>
                                        </ul>
                                    </div>
								<%
                                } else {
                                %>
                                	<div class="col-xl-6 col-lg-6">
                                        <ul class="name">
                                            <li><label for="name">Votre nom, prénom ou pseudo</label></li>
                                            <li><input type="text" id="name" name="nom"></li>
                                        </ul>
                                    </div>
                                    <div class="col-xl-6 col-lg-6">
                                        <ul class="email pt-15 pt-sm-0">
                                            <li><label for="email">Votre email</label></li>
                                            <li><input type="email" id="email" name="mail"></li>
                                        </ul>
                                    </div>
                                <%	
                                }
								%>
									<div class="col-xl-12">
                                        <ul class="name pt-10">
                                            <li><label for="name">Objet</label></li>
                                            <li><input type="text" id="subject" name="sujet"></li>
                                        </ul>
                                    </div>
                                    <div class="col-xl-12">
                                        <ul class="text-area pt-10">
                                            <li><label for="text-area">Votre message</label></li>
                                            <li>
                                                <textarea name="text-area" id="text-area" cols="30"
                                                    rows="10"></textarea>
                                            </li>
                                        </ul>
                                        <div class="submit pt-30">
                                            <input type="submit" name="envoyer">
                                        </div>
                                    </div>
                                </div>
                            </form>
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

    <!-- =================Comment  Area Ends================= -->

    
    
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
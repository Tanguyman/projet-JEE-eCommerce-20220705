<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.hytekFront.beans.UtilisateursBean"%>
<%@ page import="com.hytekFront.beans.AdressesBean"%>
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
    <title><%= client.getPrenom() %></title>

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

    <div class="page-title-area pt-130 pb-120 " style="background-image: url(assets/img/bg/chechout-page-bg.jpg);">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="page-titel-detalis  ">
                        <div class="page-title position-relative">
                            <h2><%= client.getPrenom() %> <%= client.getNom() %></h2>
                        </div>
                        <div class="page-bc">
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="Index"> <i
                                                class="fas fa-home "></i>Page d’accueil</a></li>
                                    <li class="breadcrumb-item active" aria-current="page"><a
                                            href="#"><%= client.getPrenom() %></a></li>
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
        
        <%
        if(request.getAttribute("messageInscriptionValidated") != null) {
        %>
			<div class="row">
				<div class="col-lg-12">
					<div class="alert alert-success text-center" role="alert">
						<%=request.getAttribute("messageInscriptionValidated")%>
					</div>
				</div>
			</div>
		<%
		}
        %>
        <%
        if(request.getAttribute("messageEmailIsInDatabase") != null) {
        %>
			<div class="row">
				<div class="col-lg-12">
					<div class="alert alert-danger text-center" role="alert">
						<%=request.getAttribute("messageEmailIsInDatabase")%>
					</div>
				</div>
			</div>
		<%
		}
        %>
        <%
        if(request.getAttribute("messageInvalidEmail") != null) {
        %>
			<div class="row">
				<div class="col-lg-12">
					<div class="alert alert-danger text-center" role="alert">
						<%=request.getAttribute("messageInvalidEmail")%>
					</div>
				</div>
			</div>
		<%
		}
        %>
        <%
        if(request.getAttribute("messageInvalidFirstName") != null) {
        %>
			<div class="row">
				<div class="col-lg-12">
					<div class="alert alert-danger text-center" role="alert">
						<%=request.getAttribute("messageInvalidFirstName")%>
					</div>
				</div>
			</div>
		<%
		}
        %>
        <%
        if(request.getAttribute("messageInvalidLastName") != null) {
        %>
			<div class="row">
				<div class="col-lg-12">
					<div class="alert alert-danger text-center" role="alert">
						<%=request.getAttribute("messageInvalidLastName")%>
					</div>
				</div>
			</div>
		<%
		}
        %>
		<%
		if(request.getAttribute("messagePasswordUpdated") != null) {
		%>
	    	<div class="row">
	   			<div class="col-lg-12">
	   				<div class="alert alert-success text-center" role="alert">
	    				<%=request.getAttribute("messagePasswordUpdated")%>
	    			</div>
	    		</div>
	    	</div>
		<%
		}
		%>
		<%
		if(request.getAttribute("messageInvalidPassword") != null) {
		%>
	    	<div class="row">
	   			<div class="col-lg-12">
	   				<div class="alert alert-danger text-center" role="alert">
	    				<%=request.getAttribute("messageInvalidPassword")%>
	    			</div>
	    		</div>
	    	</div>
		<%
		}
		%>
		<%
		if(request.getAttribute("messagePasswordNotEqual") != null) {
		%>
	    	<div class="row">
	   			<div class="col-lg-12">
	   				<div class="alert alert-danger text-center" role="alert">
	    				<%=request.getAttribute("messagePasswordNotEqual")%>
	    			</div>
	    		</div>
	    	</div>
		<%
		}
		%>
		<%
		if(request.getAttribute("messageNotUserPassword") != null) {
		%>
	    	<div class="row">
	   			<div class="col-lg-12">
	   				<div class="alert alert-danger text-center" role="alert">
	    				<%=request.getAttribute("messageNotUserPassword")%>
	    			</div>
	    		</div>
	    	</div>
		<%
		}
		%>
			<div class="row">
				<div class="mx-auto">
					<a href="Utilisateurs_Index" class="btn btn-outline-primary" role="button" ">Liste des favoris</a>
					<a href="Utilisateurs_Index" class="btn btn-outline-secondary" role="button" >Historique des commandes</a>
					<a href="Utilisateurs_Index" class="btn btn-outline-info" role="button" >Liste des commentaires</a>
				</div>	
			</div> 
			
			<div class="row pt-30">
			 
			</div>
			
			<div class="row"> 
                <div class="col-12">
                    <div class="billing-detalis check-border ">
                        <div class="section-title">
                            <h6>mon profil</h6>
                        </div>
                        <div class="row">
                            <div class="col-xl-10 col-lg-10 col-md-10 col-sm-10 col-10 offset-xl-1 offset-lg-1 offset-md-1 offset-sm-1 offset-1">
                                <div class="checkout-product-detalis pt-40 pb-45">
									<form method="post" action="Utilisateurs_Index">
										<div class="form-row">
	    									<div class="form-group col-md-4">
											
												<label for="firstName">Nom</label>
												<input type="text" class="form-control" id="firstName" 
													name="firstName" value="<%= client.getNom() %>">
											</div>
										
	    									<div class="form-group col-md-4">
												<label for="lastName">Prenom</label>
												<input type="text" class="form-control" id="lastName"
													name="lastName" value="<%= client.getPrenom() %>">
											</div>
										
	    									<div class="form-group col-md-4">
												<label for="exampleInputEmail1">Adresse mail</label>
												<input type="email" class="form-control" id="exampleInputEmail1"
													name="mail" value="<%= client.getEmail() %>">
											</div>
										</div>
										<button type="submit" class="btn btn-primary btn-block" name="buttonEditProfile">Mettre à jour votre profil</button>
										<a href="Utilisateurs_UpdatePassword" class="btn btn-warning btn-block" role="button">Modifier votre mot de passe</a>
									</form>
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
			</div>
			
			<div class="row pt-30">
			 
			</div>
			
            <div class="row justify-content-center justify-content-md-start"> 
                <div class="col-xl-4 col-lg-4 col-md-10 col-sm-10">
                    <div class="billing-detalis check-border ">
                        <div class="section-title">
                            <h6>Ajouter une adresse</h6>
                        </div>
                        <div class="row">
                            <div class="col-xl-10 col-lg-10 col-md-10 col-sm-10 col-10 offset-xl-1 offset-lg-1 offset-md-1 offset-sm-1 offset-1">
                                <div class="checkout-product-detalis pt-40 pb-45">
									<form method="post" action="Utilisateurs_Index">
										<div class="form-group">
											<label for="firstName">Adresse</label>
											<input type="text" class="form-control" 
												name="address" value="98 rue de Conflans">
										</div>
										<div class="form-group">
											<label for="cp">Code postal</label>
											<input type="text" class="form-control"
												name="cp" value="95220">
										</div>
										<div class="form-group">
											<label for="city">Ville</label>
											<input type="text" class="form-control"
												name="city" value="Herblay">
										</div>
										<div class="form-group">
											<label for="country">Pays</label>
											<input type="text" class="form-control"
												name="country" value="France">
										</div>
										<button type="submit" class="btn btn-primary btn-block" name="buttonCreateAddress">Enregistrer</button>
									</form>
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
                <div class="col-xl-8 col-lg-8 col-md-10 col-sm-10">
                
                    <div class="buyer-info check-border pb-30 mb-50 mb-md-0">
                    <%
                    if ( (boolean) session.getAttribute("isConnected") ) {
                    %>
                        <div class="section-title">
                            <h6>mes adresses de livraison</h6>
                            <!-- <h6 class="float-right">Login Here</h6> -->
                        </div>
                        
                       <%--  <%
                        if ( request.getAttribute("msg") != null ) {
                        %>
                        <div class="pl-45 pt-25 pr-45" > <!-- pr-100 -->
	                        <p class="alert alert-danger" role="alert"><%= request.getAttribute("msg") %></p>
						</div>
                        <%
                        }
                        %> --%>
						<form method="post" action="Utilisateurs_Index">
	                        <div class="table-scroll">
	                            <table id="clicAdresse-search" class="multi-table table table-hover" style="width:100%">
	                                <thead>
	                                    <tr>
	                                        <th>Adresse</th>
	                                        <th>CP</th>
	                                        <th>Ville</th>
	                                        <th>Pays</th>
	                                        <th class="text-center dt-no-sorting">Actions</th>
	                                    </tr>
	                                </thead>
	                                <tbody>
	                                <%
			                        for ( AdressesBean a : client.getAdresses() ) {
			                        %>
			                        	<tr>
			                        		<td>
			                        			<input type='text' class='form-control form-control-sm' value='<%= a.getAdresse() %>' name='<%= a.getAdresse() %>'>
			                        		</td>
			                        		<td>
			                        			<input type='text' class='form-control' value='<%= a.getCp() %>' name='<%= a.getCp() %>'>
			                        		</td>
			                        		<td>
			                        			<input type='text' class='form-control' value='<%= a.getVille() %>' name='<%= a.getVille() %>'>
			                        		</td>
			                        		<td>
			                        			<input type='text' class='form-control' value='<%= a.getPays() %>' name='<%= a.getPays() %>'>
			                        		</td>
			                        		<td class="text-center">
			                        			<%-- <button data-bs-toggle="modal" data-bs-target="#comment-edit<%=i%>" class="btn-primary btn-sm btn-block">Modifier</button> --%>
			                        			<button type="submit" name="updateAddress" class="btn btn-primary btn-sm">Modifier</button><!-- class="btn btn-outline-primary btn-sm -->
		                                        <!-- <button onclick="window.location.href='Index';" class="btn-danger btn-sm btn-block">Supprimer</button> -->
		                                        <a href="Utilisateurs_Index?deleteAddress=<%= a.getId() %>" class="btn btn-danger btn-sm" role="button">Éffacer</a>
											</td>
			                        	</tr>
			                        <%
			                        }
			                        %>
			                        </tbody>
								</table>
							</div>
						</form>
                                
                                
                       <%--  <form method="post" action="Commandes" class="pl-45 pt-30 pr-100" >
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
									<input name="commande" class="b-btn  pl-45 pr-45 pb-15 pt-15" type="submit" value="COMMANDER" >
                    			</div>
							</div>
                        </form> --%>
                    
					<%                        
                    }
                    %>
                    </div>
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

	<!-- BEGIN PAGE LEVEL SCRIPTS -->
   	<script src="assets/plugins/table/datatable/datatables.js"></script>
   	<!-- TABLEAU PERMETTANT D’AFFICHER LE NOMBRE DE COMMANDES -->
    <script>
	    $(document).ready(function() {
            var table = $('#clicAdresse-search').DataTable({
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

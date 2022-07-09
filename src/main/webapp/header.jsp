<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.hytekFront.beans.CategoriesBean" %>
<%@ page import="com.hytekFront.beans.SousCategoriesBean" %>
<%@ page import="com.hytekFront.beans.CoordonneesBean"%>
<%-- 
<%@ page import="fr.commerceFront.beans.Shopping_ListBean" %>
<%@ page import="fr.commerceFront.beans.Shopping_LineBean" %> 
--%>
<%
ArrayList<CategoriesBean> cats = (ArrayList) request.getAttribute("cats");
CoordonneesBean coordonnee = (CoordonneesBean) request.getAttribute("coordonnee");
/* Shopping_ListBean shoppingBag_tmp = (Shopping_ListBean) session.getAttribute("shoppingBag"); */
%>

    <!-- =============Preloader Starts=============-->
    <div class="loader">
        <div class="loding-cricle"></div>
    </div>
    <!-- =============Preloader Ends=============-->


    <!-- =================Autopopup Area Starts================= -->
<!-- 
        <div id="autopopup-option" class="subscribe-area newsletter-page wow fadeIn bg-transparent">
                <div class="subscribe-detalis pt-90 pr-90 pl-90 pb-80" style="background-image: url(assets/img/bg/subscribe-bg.png);">
                    <div id="close-button" >
                        <button><i class="fas fa-times"></i></button>
                    </div>
                    <div class="mess-icon text-center pb-30">
                        <img src="assets/img/icon/email-red.png" alt="messages">
                    </div>
                    
                    <div class="discount-text text-center pb-15 ">
                        <span>Newsletter</span>
                        <p>Get Discount 30% Off !</p>
                    </div>
                    <form action="#" class="text-center">
                        <input type="email" placeholder="Enter Your Email...">
                        <button>Subscribe</button>
                        
                    </form>
                    <div class="news-checkbox text-center pt-25">
                        <input type="checkbox"  id="checkbox"><label for="checkbox">Do not show this popup again !</label>
                    </div>
    
                </div>
        </div>
         -->
    <!-- =================Autopopup Area ends================= -->
        


    <!-- =================Header Area Starts================= -->

        <header>
            <div class="header-area header-2 header-5 header-8 pb-5  pl-65 pr-65 pt-30">
                <div class="header-top">
                    <div class="container-fluid">
                        <div class="header-top">
                            <div class="row">
                                <div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-12">
                                    <div class="logo d-none pb-15 mt-15">
                                        <h5><a href="Index">Hytek</a></h5>
                                    </div>

    <!-- =================Page Area Starts================= -->
                                    <ul class="user-info d-flex ">
                                    	<li>
		                                    <div class="logo ">
		                                        <a href="Index"><img src="assets/img/logo/logo.png" alt="Hytek-logo" height="30px" width="100%" ></a>
		                                    </div>
                                    	</li>
                                    	<%
                                    	if ( (boolean)session.getAttribute("isConnected") ) {
                                    	%>
                                        <li><a href="#"><i class="fa-solid fa-user p-1"></i><%= session.getAttribute("userNameBySession")  %></a></li>
                                        <li><a href="Deconnexion"><i class="fa-solid fa-up-right-from-square p-1"></i>Déconnexion</a></li>
                                        <%
                                        } else {
                                        %>
                                        <li><a href="ConnexionInscription?loginFrom=index"><i class="fa-solid fa-arrow-right-to-bracket p-1"></i>Connexion / Inscription</a></li>
                                        <%
                                        }
                                        %>
                                        <li><a href="cart-page.html"><i class="fa-solid fa-heart p-1"></i>Favoris</a></li>
                                        <li><a href="#"><img src="assets/img/icon/bag.png" alt="" height="25px" class="align-top p-1">Pannier</a></li>
                                        <li><a href="checkout-page.html"><i class="fa-solid fa-credit-card p-1"></i>Commande</a></li>

                                    </ul>
                                </div>
    <!-- =================Page Area Ends================= -->


    <!-- =================TableDao coordonnees Area Starts================= -->
                                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12 col-12">
                                    <div class="discount-mess text-right">
                                        <i class="fa-solid fa-phone-volume"></i>
                                        <span><%= coordonnee.getTelephone() %>
	                                        <span class="p-2">
	                                        	<i class="fa-solid fa-at"></i>
	                                        	<%= coordonnee.getEmail() %>
	                                        </span>
                                        <i class="fa-solid fa-location-dot"></i>
                                        <%= coordonnee.getAdresse() %></span>
                                    </div>
                                </div>
    <!-- =================TableDao coordonnees Area Ends================= -->


								<!-- 
                                <div class="col-xl-2 col-lg-2 col-md-6 col-sm-4 col-12">
                                    <div class="header-top-right d-flex justify-content-end">
                                        <ul class="language">
                                            <li><a href="#"><img src="assets/img/icon/flag.png" alt="flag">English</a>
                                                <ul class="sub-language">
                                                    <li><a href="#"> <img src="assets/img/icon/china.png" alt=""> Chinese</a></li>
                                                    
                                                    <li><a href="#"><img src="assets/img/icon/russia.png" alt=""> Russian</a></li>
                                                </ul>
                                            </li>
                                        </ul>
                                        <ul class="mony">
                                            <li><a href="#"><i class="fas fa-dollar-sign"></i> USD</a>
                                                <ul class="sub-mony">
                                                    <li><a href="#"><i class="fas fa-euro-sign"></i>ERO</a></li>
                                                    <li><a href="#"><i class="fas fa-yen-sign"></i>CNY</a></li>
                                                </ul>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                                 -->
                            </div>
                        </div>
                        <hr class="mt-20">
                        <div class="header-menu bg-transparent pt-25">
                            <div class="row">
                                    <!-- 
                                <div class="col-xl-2 col-lg-2 col-md-2 col-sm-3 col-12 offset-xl-0 offset-lg-0 offset-md-5 offset-sm-4 ">
                                    <div class="logo ">
                                        <a href="Index"><img src="assets/img/logo/logo.png" alt="Hytek-logo" width="100%" ></a>
                                    </div>
                                </div>
                                    -->
                                <div class="col-xl-10 col-lg-10 d-none d-lg-block">
                                    <div class="main-menu pt-5">
                                        <nav id="mobile-menu">
                                            <ul>
                                                <li><a href="index.html">Page d’accueil</a></li>
<!-- 
                                                <li><a href="blog-page.html">Features</a>
                                                    <div class="badge">New</div>
                                                </li>
                                                <li><a href="blog-page.html">Fashion</a></li>
                                                <li><a href="404-page.html">Software</a></li>
                                                <li><a href="#">Page</a>
                                                    <div class="badge">Sale</div>
                                                    <ul class="sub-menu">
                                                        <li><a href="login-page.html">Login</a></li>
                                                        <li><a href="register-page.html">Register</a></li>
                                                        <li><a href="cart-page.html">Cart</a></li>
                                                        <li><a href="checkout-page.html">Checkout</a></li>
                                                        <li><a href="about-page.html">About Us</a></li>
                                                        <li><a href="404-page.html">404-page</a></li>
                                                    </ul>
                                                </li>
  -->                                               


    <!-- =================TableDao catégorie Area Starts================= -->
    
    										<%
    										for ( CategoriesBean cb : cats ) {
    										%>
    										
                                                <li><a href="shop-detalis-page.html"><%= cb.getTitre() %></a>
                                                    <ul class="sub-menu">
                                                    
												<%
	    										for ( SousCategoriesBean scb : cb.getSousCategories() ) {
	    										%>
                                                        <li><a href="shop-grid-page.html"><%= scb.getTitre() %></a>
                                                    <!--                                                 
                                                            <ul class="sub-menu">
                                                                <li><a href="shop-grid-page.html">Shop Grid</a>
                                                                <li><a href="shop-grid-page-2.html">Shop Grid 2</a>
                                                                <li><a href="shop-grid-page-3.html">Shop Grid 3</a>
                                                                <li><a href="shop-grid-left-sidebar-page.html">Shop Grid Left Sidebar</a>
                                                                <li><a href="shop-grid-right-sidebar-page.html">Shop Grid Right Sidebar</a>
                                                            </ul>
                                                        </li>
                                                        <li><a href="shop-list-page.html">Shop-List</a>
                                                            <ul class="sub-menu">
                                                                <li><a href="shop-list-left-sidebar-page.html">Shop List Left
                                                                        Sidebar</a></li>
                                                                <li><a href="shop-list-right-sidebar-page.html">Shop List Right
                                                                        Sidebar</a></li>
                                                            </ul>
                                                        </li>
                                                        <li><a href="shop-detalis-page.html">Shop Detalis</a>
                                                            <ul class="sub-menu">
                                                                <li><a href="shop-detalis-left-sidebar-page.html">Shop Detalis
                                                                        Left Sidebar</a></li>
                                                                <li><a href="shop-detalis-right-sidebar-page.html">Shop Detalis
                                                                        Right Sidebar</a></li>
                                                            </ul>
                                                     -->
                                                        </li>
												<%
	    										}
	    										%>
                                                    </ul>
                                                </li>
											<%
    										}
    										%>
    <!-- =================TableDao catégorie Area Ends================= -->


<!--                                                 
                                                <li><a href="blog-page.html">Blog</a>
                                                    <ul class="sub-menu">
                                                        <li><a href="blog-page-2.html">Blog</a></li>
                                                        <li><a href="blog-detalis-page.html">Blog Detalis</a></li>
                                                        <li><a href="blog-left-sidebar-page.html">Blog Left Sidebar</a></li>
                                                        <li><a href="blog-right-sidebar-page.html">Blog Right Sidebar</a></li>
                                                    </ul>
                                                </li>
 -->


                                                <li><a href="contact-page.html">Nous Contacter</a></li>
                                            </ul>
                                        </nav>
                                    </div>
                                </div>
                                <div class="col-xl-2 col-lg-2 col-md-5 col-sm-5 col-12">
                                    <div class="site-info  d-flex justify-content-end">
                                        <div class="search mt-10 position-relative  ">
                                            <a href="#" class="bg-transparent"><img src="assets/img/icon/search.png" alt=""></a>
                                            <div class="search-form">
                                                <form action="Recherches">
                                                    <input type="text" placeholder="Tapez un mot clé pour trouver un produit." name="word">
                                                </form>
                                            </div>
                                        </div>
                                        <div class="react pt-10 position-relative mr-15">
                                            <a href="#" onClick="showh();"><i class="far fa-heart"></i></a>
                                            <div class="badge">0</div>
<!-- 
                                            <div id="cart-showh"  class="product-area  product-shop-page "  style="display:none;">
                                                <div class="hot-sale-product-area "  >
                                                    <div class="hot-lookbook pt-10 pb-30">
                                                        <div class="product-wrapper d-flex">
                                                            <div class="product-img pr-15">
                                                                <img src="assets/img/product/product-23.png" alt="product">
                                                                <div class="cart-icon">
                                                                    <img src="assets/img/icon/cart-white.png" alt="cart">
                                                                </div>
                                                            </div>
                                                            <div class="product-detalis">
                                                                <span>Men Dress</span>
                                                                <h6><a href="shop-detalis-page.html">Military Patch Pocket Blazer</a></h6>
                                                                <div class="price d-flex">
                                                                    <span>$999</span>
                                                                    <del>$899</del>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="product-wrapper mt-10 d-flex">
                                                            <div class="product-img pr-15">
                                                                <img src="assets/img/product/product-27.png" alt="product">
                                                                <div class="cart-icon">
                                                                    <img src="assets/img/icon/cart-white.png" alt="cart">
                                                                </div>
                                                            </div>
                                                            <div class="product-detalis ">
                                                                <span>Men Dress</span>
                                                                <h6><a href="shop-detalis-page.html">Military Patch Pocket Blazer</a></h6>
                                                                <div class="price d-flex">
                                                                    <span>$999</span>
                                                                    <del>$899</del>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="cart-price-area text-right pt-15 pr-20">
                                                            <p>Sub total: <span class="d-inline-block pl-30"> $999.00</span></p>
                                                            <p>Total:  <span class="d-inline-block pl-30"> $999.00</span></p>
                                                        </div>
                                                        <div class="table-button mini-cart-btn text-center pt-5">
                                                            <a class="b-btn pt-15 pb-15 pr-20 pl-20" href="#">View Cart</a>
                                                            <a class="b-btn pt-15 pb-15 pr-20 pl-20" href="#">Checkout</a>
                                                        </div>

                                                    </div>
                                                </div>
                                            </div>


                                            <script>
                                                function showh(){
                                                    document.getElementById("cart-showh").style.display="block";
                                                }
                                            </script>
 -->







    <!-- =================Session panier Area Starts================= -->
                                        </div>
                                        <div class="cart pt-10 position-relative mr-10">
                                            <a href="#"><img src="assets/img/icon/bag.png" alt=""></a>
                                            <div class="badge">0</div>


                                            <div id="cart-show"  class="product-area product-shop-page mini-cart-product-page " >
                                                <div class="hot-sale-product-area "  >
                                                    <div class="hot-lookbook pt-10 pb-30">




                                                        <div class="product-wrapper d-flex">
                                                            <div class="product-img pr-15">
                                                                <img src="assets/img/product/product-23.png" alt="product">
                                                                <div class="cart-icon">
                                                                    <img src="assets/img/icon/cart-white.png" alt="cart">
                                                                </div>
                                                            </div>
                                                            <div class="product-detalis">
                                                                <span>Men Dress</span>
                                                                <h6><a href="shop-detalis-page.html">Military Patch Pocket Blazer</a></h6>
                                                                <div class="price d-flex">
                                                                    <span>$999</span>
                                                                    <del>$899</del>
                                                                </div>
                                                            </div>
                                                        </div>
<!-- =================Session panier Area Ends================= -->



                                                        <div class="cart-price-area text-right pt-15 pr-20">
                                                            <p>Sub total: <span class="d-inline-block pl-30"> $999.00</span></p>
                                                            <p>Total:  <span class="d-inline-block pl-30"> $999.00</span></p>
                                                        </div>
                                                        <div class="table-button mini-cart-btn text-center pt-5">
                                                            <a class="b-btn pt-15 pb-15 pr-20 pl-20" href="#">View Cart</a>
                                                            <a class="b-btn pt-15 pb-15 pr-20 pl-20" href="#">Checkout</a>
                                                        </div>

                                                    </div>
                                                </div>
                                            </div>




                                        </div>
                                    </div>
                                </div>
                                
                            </div>
                        </div>
                        <div class="mobile-menu"></div>
                    </div>
                </div>

            </div>
        </header>

    <!-- =================Header Area Ends================= -->

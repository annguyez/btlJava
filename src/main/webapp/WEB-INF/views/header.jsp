    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <header class="header_area">
        <div class="classy-nav-container breakpoint-off d-flex align-items-center justify-content-between">
            <!-- Classy Menu -->
            <nav class="classy-navbar" id="essenceNav">
                <!-- Logo -->
                <a class="nav-brand" href='<c:url value="/home"></c:url>'><img src='<c:url value="/resources/home/img/core-img/logo.png"></c:url>' alt=""></a>
                <!-- Navbar Toggler -->
                <div class="classy-navbar-toggler">
                    <span class="navbarToggler"><span></span><span></span><span></span></span>
                </div>
                <!-- Menu -->
                <div class="classy-menu">
                    <!-- close btn -->
                    <div class="classycloseIcon">
                        <div class="cross-wrap"><span class="top"></span><span class="bottom"></span></div>
                    </div>
                    <!-- Nav Start -->
                    <div class="classynav">
                        <ul>
                            <li><a href="#">Danh mục</a>
                                <div class="megamenu">
                                <c:set var="index" value="0"/>
                                  <c:forEach var="sp" items="${category }">
                                    <c:if test="${(index % 4)==0 }">  
                                    	<ul class="single-mega cn-col-4">
                                    </c:if>  	
                                        <li><a href='<c:url value="/search/${sp.getCategory_id() }/0/0//1/1"></c:url>'>${sp.category_name }</a></li>
   
                                	<c:if test="${(index % 4)==3 }"></ul></c:if>
                                     <c:set var="index" value="${index+1 }"/>
                                    </c:forEach>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <!-- Nav End -->
                </div>
            </nav>

            <!-- Header Meta Data -->
            <div class="header-meta d-flex clearfix justify-content-end">
                <!-- Search Area -->
                <div class="search-area">
                    <form action='<c:url value="/searchByLikeName"></c:url>' method="post">
                        <input type="search" name="name" id="headerSearch" placeholder="Nhập tên sản phẩm ">
                        <button type="submit"><i class="fa fa-search" aria-hidden="true"></i></button>
                    </form>
                </div>
                <!-- Favourite Area -->
                <!-- User Login Info -->
                <div class="user-login-info">
                    <a href='<c:url value="/login"></c:url>'><img src='<c:url value="/resources/home/img/core-img/user.svg"></c:url>' alt=""></a>
                </div>
                <!-- Cart Area -->
                <div class="cart-area">
                    <a href='<c:url value="/cart"></c:url>' id="essenceCartBtn"><img src='<c:url value="/resources/home/img/core-img/bag.svg"></c:url>' alt=""><span class="countCart"></span></a>
                </div>
            </div>

        </div>
    </header>
    <!-- ##### Header Area End ##### -->

    <!-- ##### Right Side Cart Area ##### -->
    <div class="cart-bg-overlay"></div>

    <div class="right-side-cart-area">

        <!-- Cart Button -->
        <div class="cart-button">
            <a href="#" id="rightSideCart"><img src='<c:url value="/resources/home/img/core-img/bag.svg"></c:url>' alt=""> <span>${countProduct }</span></a>
        </div>

        
    </div>

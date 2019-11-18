<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<link rel="stylesheet" href='<c:url value="/resources/Styles/css/test.css"/>'/>

<!-- Fontfaces CSS-->
    
    <link rel="stylesheet" href='<c:url value="/resources/Styles/css/font-face.css"/>'/>
    
    
    <link rel="stylesheet" href='<c:url value="/resources/Styles/vendor/font-awesome-4.7/css/font-awesome.min.css"/>'/>
    
    
    <link rel="stylesheet" href='<c:url value="/resources/Styles/vendor/font-awesome-5/css/fontawesome-all.min.css"/>'/>
    
    
	<link rel="stylesheet" href='<c:url value="/resources/Styles/vendor/mdi-font/css/material-design-iconic-font.min.css"/>'/>
	
    <!-- Bootstrap CSS-->
    
	<link rel="stylesheet" href='<c:url value="/resources/Styles/vendor/bootstrap-4.1/bootstrap.min.css"/>'/>
	
    <!-- Vendor CSS-->
    
    <link rel="stylesheet" href='<c:url value="/resources/Styles/vendor/animsition/animsition.min.css"/>'/>
    
    
    <link rel="stylesheet" href='<c:url value="/resources/Styles/vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css"/>'/>
    
    
    <link rel="stylesheet" href='<c:url value="/resources/Styles/vendor/wow/animate.css"/>'/>
    
    
    <link rel="stylesheet" href='<c:url value="/resources/Styles/vendor/css-hamburgers/hamburgers.min.css"/>'/>
    
    
    <link rel="stylesheet" href='<c:url value="/resources/Styles/vendor/slick/slick.css"/>'/>
    
    
    <link rel="stylesheet" href='<c:url value="/resources/Styles/vendor/select2/select2.min.css"/>'/>
    
    
	<link rel="stylesheet" href='<c:url value="/resources/Styles/vendor/perfect-scrollbar/perfect-scrollbar.css"/>'/>
	
    <!-- Main CSS-->
    
    <link rel="stylesheet" href='<c:url value="/resources/Styles/css/theme.css"/>'/>
<body class="animsition">
<div class="page-wrapper">
        <!-- HEADER MOBILE-->
        <header class="header-mobile d-block d-lg-none">
            <div class="header-mobile__bar">
                <div class="container-fluid">
                    <div class="header-mobile-inner">
                        <a class="logo" href="index.html">
                            <img src="images/icon/logo.png" alt="CoolAdmin" />
                        </a>
                        <button class="hamburger hamburger--slider" type="button">
                            <span class="hamburger-box">
                                <span class="hamburger-inner"></span>
                            </span>
                        </button>
                    </div>
                </div>
            </div>
            
        </header>
        <!-- END HEADER MOBILE-->

        <!-- MENU SIDEBAR-->
        <aside class="menu-sidebar d-none d-lg-block">
            <div class="logo">
                <a href="#">
                    <img src="http://localhost:8080/Shop/resources/Styles/images/icon/logo.png" alt="Cool Admin" />
                </a>
            </div>
            <div class="menu-sidebar__content js-scrollbar1" id="menu">
                 <nav class="navbar-sidebar">
                    <ul class="list-unstyled navbar__list">
                        
                        
                        <li class="has-sub">
                            <a class="js-arrow" href="#">
                                <i class="fas fa-tachometer-alt"></i>Thống kê</a>
                            <ul class="navbar-mobile-sub__list list-unstyled js-sub-list">
                            
                            	<li>
                                    <a href='<c:url value="/admin/statistics/category/all"></c:url>'>Thống kê toàn bộ danh mục</a>
                                </li>
                                <li>
                                    <a href='<c:url value="/admin/statistics/all/0/1/1"></c:url>'>Toàn bộ sản phẩm</a>
                                </li>
                                <li>
                                    <a href='<c:url value="/admin/statistics/shipped/0/1/1"></c:url>'>Các sản phẩm đã giao</a>
                                </li>
                                <li>
                                    <a href='<c:url value="/admin/statistics/singleproduct"></c:url>'>Tìm kiếm sản phẩm</a>
                                </li>
                                
                            </ul>
                        </li>
                        
                       
                        <li class="has-sub">
                            <a class="js-arrow" href="#">
                                <i class="fas fa-tachometer-alt"></i>Sản phẩm</a>
                            <ul class="navbar-mobile-sub__list list-unstyled js-sub-list">
                                <li>
                                    <a href='<c:url value="/admin/product"></c:url>'>Sản phẩm</a>
                                </li>
                                <li>
                                    <a href='<c:url value="/admin/color"></c:url>'>Màu sắc</a>
                                </li>
                                <li>
                                    <a href='<c:url value="/admin/size"></c:url>'>Kích Cỡ</a>
                                </li>
                                
                                
                            </ul>
                        </li>
                        <li>
                            <a href='<c:url value="/admin/category_ad"></c:url>'>
                                <i class="fas fa-calendar-alt"></i>Danh mục sản phẩm</a>
                        </li>
                        
                        <li class="has-sub">
                            <a class="js-arrow" href="#">
                                <i class="fas fa-copy"></i>Người sử dụng</a>
                            <ul class="navbar-mobile-sub__list list-unstyled js-sub-list">
                                
                                <li>
                                    <a href='<c:url value="/admin/role"></c:url>'>Chức vụ</a>
                                </li>
                                <li>
                                    <a href='<c:url value="/admin/employees"></c:url>'>Người dùng</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href='<c:url value="/admin/sale/0/0/1"></c:url>'>
                                <i class="fas fa-calendar-alt"></i>Chương trình giảm giá</a>
                        </li>
                        
                        <li class="has-sub">
                           <a class="js-arrow" href='<c:url value="/admin/order/1"></c:url>'>
                                <i class="far fa-check-square"></i>Hóa đơn</a>     
                            </ul>
                        </li>
                       
                    </ul>
                </nav>
            </div>
        </aside>
        <!-- END MENU SIDEBAR-->

        <!-- PAGE CONTAINER-->
        <div class="page-container">
            <!-- HEADER DESKTOP-->
            <header class="header-desktop">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                        <div class="header-wrap">
                            
                            <div class="header-button">
                          
                                <div class="account-wrap" style="float:right">
                                    <div class="account-item clearfix js-item-menu">
                                        <div class="image">
                                            <img src="http://localhost:8080/Shop/resources/Styles/images/icon/avatar-01.jpg" alt="John Doe" />
                                        </div>
                                        <div class="content">
                                        <security:authentication property="principal" var="user"/>
                                                        
                                            <a class="js-acc-btn" href="#">${user.username }</a>
                                        </div>
                                        <div class="account-dropdown js-dropdown">
                                            <div class="info clearfix">
                                                <div class="image">
                                                    <a href="#">
                                                        <img src="http://localhost:8080/Shop/resources/Styles/images/icon/avatar-01.jpg" alt="John Doe" />
                                                    </a>
                                                </div>
                                                <div class="content">
                                                    <h5 class="name">
                                                    	
                                                        <a href="#">${user.username }</a>
                                                    </h5>
                                                   
                                                </div>
                                            </div>
                                            <div class="account-dropdown__body">
                                                <div class="account-dropdown__item">
                                                    <a href="#">
                                                        <i class="zmdi zmdi-account"></i>Account</a>
                                                </div>
                                             
                                            </div>
                                            <div class="account-dropdown__footer">
                                            
                                            <security:authorize access="isAuthenticated()">
                                            	 <a href='<c:url value="/logout"></c:url>'>
                                                    <i class="zmdi zmdi-power"></i>Logout</a>
                                            </security:authorize>
                                               
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </header>
            <!-- END HEADER DESKTOP-->

</body>
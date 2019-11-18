<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<meta name="description" content="">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport"
		content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	
	<!-- Title  -->
	<title>Thanh toán</title>
	
	<!-- Favicon  -->
	<link rel="icon" href='<c:url value="/resources/home/img/core-img/favicon.ico" />'/>
	
	<!-- Core Style CSS -->
	<link rel="stylesheet" href='<c:url value="/resources/home/css/core-style.css"/>'/>
	<link rel="stylesheet" href='<c:url value="/resources/home/css/style.css"/>'/>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="breadcumb_area bg-img" style="background-image: url('<c:url value="/resources/home/img/bg-img/breadcumb.jpg"/>')">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <div class="page-title text-center">
                        <h2 >Thanh Toán</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- ##### Breadcumb Area End ##### -->

    <!-- ##### Checkout Area Start ##### -->
    <div class="checkout_area section-padding-80">
        <div class="container">
            <div class="row">

                <div class="col-12 col-md-6">
                    <div class="checkout_details_area mt-50 clearfix">

                        <div class="cart-page-heading mb-30">
                            <h5>Thông tin khách hàng</h5>
                        </div>

                        <form action="checkout" method="post">
                            <div class="row">
                                <div class="col-md-6 mb-3">
                                    <label for="customer_name">TÊN KHÁCH HÀNG <span>*</span></label>
                                    <input type="text" class="form-control" name="customer_name" id="first_name" value="" required>
                                </div>
                                <div class="col-12 mb-3">
                                    <label for="address">ĐỊA CHỈ NHẬN HÀNG<span>*</span></label>
                                    <input type="text" class="form-control" name="address" id="last_name" value="" required>
                                </div>
                                <div class="col-12 mb-3">
                                    <label for="phone">SỐ ĐIỆN THOẠI</label>
                                    <input type="text" class="form-control" name="phone"  value="" required> 
                                </div>
                                
                         
                                <div class="col-12 mb-3">
                                    <label for="note">GHI CHÚ <span>*</span></label>
                                    <input type="text" class="form-control" name="note" id="postcode" value="">
                                </div>
                                
                                
                               
                                <div>
                               		 <input type="submit" class="btn essence-btn right-order" value="ĐẶT HÀNG NGAY"/>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>

                <div class="col-12 col-md-6 col-lg-5 ml-lg-auto">
                    <div class="order-details-confirmation">

                        <div class="cart-page-heading">
                            <h5>Thông tin đơn hàng</h5>
                          
                        </div>
						<c:forEach var="cart" items="${cart}"> 
						<div>
	                        <ul class="order-details-form mb-4">
	                            <li ${cart.product_detail_id }><span>Tên sản phẩm</span> <span>${cart.product_name }</span></li>
	                            <li><span>Số lượng mua</span> <span>${cart.quantity }</span></li>
	                            <li><span>Giá tiền</span> <span>${cart.price }</span></li>
	                        </ul><br><br>	
                        </div>
						</c:forEach>
                        
                        <a href="home" type="submit" class="btn essence-btn">Tiếp tục mua hàng</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
	
	<jsp:include page="footer.jsp"></jsp:include>
	<script src='<c:url value="/resources/home/js/jquery/jquery-2.2.4.min.js"/>'></script>
    <!-- Popper js -->
    <script src='<c:url value="/resources/home/js/popper.min.js"/>'></script>
    <!-- Bootstrap js -->
    <script src='<c:url value="/resources/home/js/bootstrap.min.js"/>'></script>
    <!-- Plugins js -->
    <script src='<c:url value="/resources/home/js/plugins.js"/>'></script>
    <!-- Classy Nav js -->
    <script src='<c:url value="/resources/home/js/classy-nav.min.js"/>'></script>
    <!-- Active js -->
    <script src='<c:url value="/resources/home/js/active.js"/>'></script>
    <script src='<c:url value="/resources/home/js/cart.js"/>'></script>
</body>
</html>
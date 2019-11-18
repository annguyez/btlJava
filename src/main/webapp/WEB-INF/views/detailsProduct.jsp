<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Ensence</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link href="https://fonts.googleapis.com/css?family=Rubik:400,700"
	rel="stylesheet">
<link rel="stylesheet"
	href='<c:url value="/resources/home/fonts/icomoon/style.css"/>' />

<link rel="stylesheet"
	href='<c:url value="/resources/cart/css/bootstrap.min.css"/>' />
<link rel="stylesheet"
	href='<c:url value="/resources/cart/css/magnific-popup.css"/>' />
<link rel="stylesheet"
	href='<c:url value="/resources/cart/css/jquery-ui.css"/>' />
<link rel="stylesheet"
	href='<c:url value="/resources/cart/css/owl.carousel.min.css"/>' />
<link rel="stylesheet"
	href='<c:url value="/resources/cart/css/owl.theme.default.min.css"/>' />


<link rel="stylesheet"
	href='<c:url value="/resources/cart/css/aos.css"/>' />

<link rel="stylesheet"
	href='<c:url value="/resources/cart/css/style.css"/>' />
<!--     header -->

<link rel="icon" href="img/core-img/favicon.ico">

<!-- Core Style CSS -->
<link rel="stylesheet"
	href='<c:url value="/resources/home/css/core-style.css"/>' />
<link rel="stylesheet"
	href='<c:url value="/resources/home/css/style.css"/>' />



<!-- 	header -->

<style>
</style>

</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<section class="single_product_details_area d-flex align-items-center">

		<!-- Single Product Thumb -->

		<div class="single_product_thumb clearfix">
			<div class="product_thumbnail_slides owl-carousel">
				<img src='<c:url value="/${pr.image }"></c:url> ' alt=""> <img
					src='<c:url value="/${pr.image }" ></c:url>' alt=""> <img
					src='<c:url value="/${pr.image }"  ></c:url>' alt="">
			</div>
		</div>

		<input class="image" data-image="/${pr.image }" hidden="hidden">
		<!-- Single Product Description -->
		<div class="single_product_desc clearfix">
			<a href="">
				<h2 class="product_id" data-product_id="${pr.product_id }">${pr.product_name }</h2>
			</a> <input type="text" value="${pr.product_id }" id="product_id"
				hidden="">
			<c:if test="${discount>0 }">
				<p class="product-price" id="price"
					data-price="${(100-discount)*pr.price/100 }">

					<span class="old-price money">${pr.price}</span><b class="money">${(100-discount)*pr.price/100 }</b>
					đ
				</p>
			</c:if>
			<c:if test="${discount<=0 }">
				<p class="product-price " id="price" data-price="${pr.price} ">

					<b class="money">${pr.price} </b>đ</p>
			</c:if>



			<!-- Form -->
			<div class="select-box d-flex mt-50 mb-30">


				<select class="open nice-select  form-control" name="select"
					id="productColor">
					<c:forEach var="color" items="${colors}">
						<option value="${color.getColor_id() }">Color:
							${color.getColor_name() }</option>
					</c:forEach>
				</select> <select class="open nice-select mr-5 form-control" name="select" id="productSize"
					class="nice-select mr-5 open">
					<c:forEach var="sp" items="${pr.products_detail}">
						<option value="${sp.size.size_id }">Size: ${sp.size.size }</option>
					</c:forEach>
				</select>

			</div>
			<button class="btn essence-btn btn-cart">Thêm vào giỏ</button>

			<div class="product-desc" style="margin-top: 50px">${pr.descriptions }</div>
		</div>
	</section>

	
	<jsp:include page="footer.jsp"></jsp:include>
	<script src='<c:url value="/resources/js/format-money.js"/>'></script>
</body>
</html>
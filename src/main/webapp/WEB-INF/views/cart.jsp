<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Giỏ hàng</title>
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


</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="site-section">
		<div class="container">
			<div class="row mb-5">
				<form class="col-md-12" method="post">
					<div class="site-blocks-table">
						<table class="table table-bordered">
							<thead>
								<tr>
									<th class="product-thumbnail">Hình ảnh</th>
									<th class="product-name">Tên sản phẩm</th>
									<th class="product-price">Giá tiền</th>
									<th>Kích cỡ</th>
									<th>Màu sắc</th>
									<th class="product-quantity">Số lượng</th>
									<th class="product-total">Tổng tiền</th>
									<th class="product-remove">Xóa</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="cart" items="${cart}">
									<tr data-product_detail_id="${cart.product_detail_id }"
										class="product">
										<td class="product-thumbnail"><img
											src='<c:url value="/${cart.image}"/>' alt="Image"
											class="img-fluid"></td>
										<td class="product_id" data-product_id="${cart.product_id }">
											<h4 
												class="h5 text-black">${cart.product_name }</h4>
										</td>
										<td class="price money">${cart.price }</td>
										<td class="size" data-size_id="${cart.size_id }">${cart.size }</td>
										<td class="color" data-color_id="${cart.color_id }">${cart.color_name }</td>
										<td>
											<div class="input-group mb-3" style="max-width: 120px;">
												<input class="detail_id" value="${cart.product_detail_id }"
													hidden=""> <input class="old_quantity"
													value="${cart.quantity }" hidden=""> <input
													type="number" class="form-control  quantity"
													value="${cart.quantity }" min="1">

											</div>

										</td>
										<td class="total money">${cart.price}</td>
										<td><a href="#"
											class="btn btn-primary height-auto btn-sm delete-cart">Xóa</a></td>
									</tr>
								</c:forEach>


							</tbody>
						</table>
					</div>
				</form>
			</div>

			<div class="row">
				<div class="col-md-6">
					<div class="row mb-5">
						<div class="col-md-6 mb-3 mb-md-0">
							<a href='<c:url value="/cart"></c:url>'><button
									class="btn btn-primary btn-sm btn-block">Cập nhật</button></a>
						</div>
						<div class="col-md-6">

							<a href='<c:url value="/home"></c:url>'><button
									class="btn btn-outline-primary btn-sm btn-block">Quay
									lại cửa hàng</button></a>
						</div>
					</div>

				</div>
				<div class="col-md-6 pl-5">
					<div class="row justify-content-end">
						<div class="col-md-7">
							<div class="row">
								<div class="col-md-12 text-right border-bottom mb-5">
									<h3 class="text-black h4 text-uppercase"><span class="countCart"></span>
										sản phẩm</h3>
								</div>
							</div>
							<div class="row mb-5">
								<div class="col-md-6">
									<b>Tổng</b>
								</div>
								<div class="col-md-6 text-left">
									<strong class="text-black totalCart money">0</strong> <strong
										class="text-black ">đ</strong>
								</div>
							</div>

							<div class="row">
								<div class="col-md-12">
									<a class="btn btn-primary btn-lg btn-block" href="checkout">Thanh
										toán</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<jsp:include page="footer.jsp"></jsp:include>
	<script src='<c:url value="/resources/cart/js/jquery-3.3.1.min.js"/>'></script>
	<script src='<c:url value="/resources/cart/js/jquery-ui.js"/>'></script>
	<script src='<c:url value="/resources/cart/js/popper.min.js"/>'></script>
	<script src='<c:url value="/resources/cart/js/bootstrap.min.js"/>'></script>
	<script src='<c:url value="/resources/cart/js/owl.carousel.min.js"/>'></script>
	<script
		src='<c:url value="/resources/cart/js/jquery.magnific-popup.min.js"/>'></script>
	<script src='<c:url value="/resources/cart/js/aos.js"/>'></script>
	<script src='<c:url value="/resources/cart/js/test.js"/>'></script>
	<script src='<c:url value="/resources/cart/js/main.js"/>'></script>


	<script src='<c:url value="/resources/js/format-money.js"/>'></script>
</body>
</html>
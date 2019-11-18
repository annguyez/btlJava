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
<title>Essence</title>

<!-- Favicon  -->
<link rel="icon"
	href='<c:url value="/resources/home/img/core-img/favicon.ico" />' />

<!-- Core Style CSS -->
<link rel="stylesheet"
	href='<c:url value="/resources/home/css/core-style.css"/>' />
<link rel="stylesheet"
	href='<c:url value="/resources/home/css/style.css"/>' />
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<!-- ##### Breadcumb Area Start ##### -->
	<div class="breadcumb_area bg-img"
		style="background-image: url(img/bg-img/breadcumb.jpg);">
		<div class="container h-100">
			<div class="row h-100 align-items-center">
				<div class="col-12">
					<div class="page-title text-center">
						<c:if test="${category_id!=0 }">
							<h2>${category_name }</h2>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- ##### Breadcumb Area End ##### -->

	<!-- ##### Shop Grid Area Start ##### -->
	<section class="shop_grid_area section-padding-80">
		<div class="container">
			<div class="row">
				<div class="col-12 col-md-4 col-lg-3">
					<div class="shop_sidebar_area">

						<!-- ##### Single Widget ##### -->
						<div class="widget catagory">
							<!-- Widget Title -->
							<h6 class="widget-title"><label for="category_id">Danh mục</label></h6>	
										<input type="number" hidden="" id="category_id" value="${category_id }"/>				
										<select class="form-control" id="slcategory_id">
										<option value="0">Tất cả</option>
											<c:forEach var="cate" items="${category }">
												<option value="${cate.category_id }">${cate.category_name }</option>
											</c:forEach>

										</select>
							
						</div>

						<!-- ##### Single Widget ##### -->
						<div class="widget-title">
							<input type="text" class="form-control" id="name" placeholder="Tên sản phẩm" value="${name }">
							
						</div>
						
						<!-- ##### Single Widget ##### -->
						<div class="widget price mb-50">
							<!-- Widget Title -->
							<h6 class="widget-title">Giá tiền</h6>
							<!-- Widget Title 2 -->
							<p class="widget-title2"><input type="number" class="form-control" id="minPrice" placeholder="Giá thấp nhất" value="${minPrice }"></p>
							<p class="widget-title2"><input type="number" class="form-control" id="maxPrice" placeholder="Giá cao nhất" value="${maxPrice }"></p>
							<button type="button" id="btnSearch" class="form-control ">Tìm kiếm</button>
							<button type="button" id="btnReset" class="form-control  ">Đặt lại</button>
						</div>
						
						
					</div>
				</div>

				<div class="col-12 col-md-8 col-lg-9">
					<div class="shop_grid_product_area">
						<div class="row">
							<div class="col-12">
								<div
									class="product-topbar d-flex align-items-center justify-content-between">
									<!-- Total Products -->
									<div class="total-products">
										<p>
											<span>${total}</span> sản phẩm
										</p>
									</div>
									<!-- Sorting -->
									<div class="product-sorting d-flex">
									<input type="number" id="orderby" value="${orderby }" hidden="">
										<p>Xếp theo:</p>
											<select name="select" id="slorderby">
												<option value="1">Bán chạy nhất</option>
												<option value="2">Mới nhất</option>
												<option value="3">Giá từ thấp đến cao</option>
												<option value="4">Giá từ cao xuống thấp</option>
											</select> 
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<c:forEach var="pr" items="${product }">
								<!-- Single Product -->
								<div class="col-12 col-sm-6 col-lg-4">
									<div class="single-product-wrapper">
			
										<!-- Product Image -->
										<div class="product-img">
											<img src='<c:url value="/${pr.getImage() }"></c:url>' alt="">
											<!-- Hover Thumb -->
											<img class="hover-img" src='<c:url value="/${pr.getImage()  }"></c:url>'
												alt="">

											<!-- Product Badge -->
											<c:if test="${pr.getDiscount()>0 }">
												<div class="product-badge offer-badge">
													<span>&#8595; ${pr.getDiscount() }%</span>
												</div>
											</c:if>

										</div>

										<!-- Product Description -->

										<div class="product-description">
											<a href='<c:url value="/details/${pr.product_id }"></c:url>'>
												<h6>${pr.product_name }</h6>
											</a>

											<c:if test="${pr.getDiscount()>0 }">
												<c:set var="discount" value="${100-pr.getDiscount() }"></c:set>
												<p class="product-price">
													<span class="old-price money">${pr.price }</span> <b
														style="color: red"><b class="money">${discount*pr.price/100}</b> đ</b>
												</p>
											</c:if>
											<c:if test="${pr.getDiscount()<=0 }">
												<p class="product-price"><b class="money">${pr.price }</b> đ</p>
											</c:if>
											<!-- Hover Content -->
											<div class="hover-content">
												<!-- Add to Cart -->
												<div class="add-to-cart-btn">
													<a href='<c:url value="/details/${pr.product_id }"></c:url>' class="btn essence-btn  ">Mua ngay</a>
												</div>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
					<!-- Pagination -->
					<input type="number" id="page" value="${page }" hidden="">
					<nav aria-label="navigation">
						
						<ul class="pagination mt-50 mb-70">
                           
                           <c:if test="${page>1 }">
                            	 <li class="page-item"><a class="page-link" href='<c:url value="${url }/${page-1}"></c:url>'><i class="fa fa-angle-left"></i></a></li>
                            </c:if>
                           
                            <c:forEach begin="1" end="${totalpage }" var="i">
                            	
                            	<c:if test="${i==page }">
                            		<li class="page-item active"><a class="page-link" href='<c:url value="${url }/${i}"></c:url>'>${i }</a></li>
                            	</c:if>
                            	<c:if test="${i!=page }">
                            		<li class="page-item "><a class="page-link" href='<c:url value="${url }/${i}"></c:url>'>${i }</a></li>
                            	</c:if>
                            </c:forEach>
                            <c:if test="${page<totalpage }">
                            	<li class="page-item"><a class="page-link" href='<c:url value="${url }/${page+1}"></c:url>'><i class="fa fa-angle-right"></i></a></li>
                            </c:if>
                             
                        </ul>
						
						
						
					</nav>
				</div>
			</div>
		</div>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
	<script src='<c:url value="/resources/js/search.js"></c:url>'></script>
	<script src='<c:url value="/resources/js/format-money.js"/>'></script>
</body>
</html>
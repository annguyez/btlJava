


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sản phẩm</title>
<jsp:include page="header_admin.jsp"></jsp:include>
<link rel="stylesheet"
	href='<c:url value="/resources/home/css/bootstrap.min.css"/>' />
<link rel="stylesheet"
	href='<c:url value="/resources/css/responsived.css"/>' />
<c:url value="/admin/product" var="url"></c:url>
</head>

<body class="animsition">

	<!-- MAIN CONTENT-->
	<div class="main-content">
		<div class="section__content section__content--p30">
			<div class="container-fluid">

				<div class="container">
					<div class="row au-card">
						<div id="manage" class="c5 "></div>


						<div class="c6">



							<div class="row">
								<div class="c4 ">
									<button type="button" class="btn btn-outline-danger"
										id="delete">Xóa sản phẩm</button>
								</div>
								<div class="c4 ">
									<label for="product_name">Danh mục sản phẩm</label>
								</div>
								<div class="c4">
									<select id="slcategory_id" name="category_id" class="fields">
										<option value="0">Tất cả</option>
										<c:forEach items="${categories }" var="cat">
											<option value="${cat.getCategory_id() }">${cat.getCategory_name()}</option>
										</c:forEach>
									</select>
								</div>
								<div class="clr"></div>
							</div>
							<div class="row-heading">
								<div class="c1">
									<input id="chkAll" type="checkbox">
								</div>
								<div class="c2">Mã sản phẩm</div>
								<div class="c4">Tên sản phẩm</div>
								<div class="c3">Giá tiền</div>

								<div class="clr"></div>
							</div>


							<div id="listProduct"></div>

							<ul class="pagination">


							</ul>
						</div>
					</div>
				</div>




			</div>
		</div>

	</div>


	<jsp:include page="footer_admin.jsp"></jsp:include>
</body>
<script src='<c:url value="/resources/js/jquery-3.4.1.min.js"></c:url>'></script>
<script src='<c:url value="/resources/js/deleteProduct.js"></c:url>'></script>
<script src='<c:url value="/resources/js/format-money.js"/>'></script>
</html>
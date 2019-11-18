<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List" %>
<%@ page import="com.gr21.model.Product_detailDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Toàn bộ sản phẩm</title>
<jsp:include page="header_admin.jsp"></jsp:include>
</head>

<body class="animsition">

	<!-- MAIN CONTENT-->
	<div class="main-content">
		<div class="section__content section__content--p30">
			<div class="container-fluid">

				<form
					action='<c:url value="/admin/statistics/redirectSingleproduct"></c:url>'
					method="post" class="form-horizontal">
					<div class="row form-group">
						<div class="col col-md-12">
							<div class="input-group">
								<input type="text" name="product_id" placeholder="Mã sản phẩm"
									class="form-control" required="required"> <input
									type="month" name="month" class="form-control">
								<div class="input-group-btn">
									<button type="submit" class="btn btn-primary">
										<i class="fa fa-search"></i> Tìm kiếm
									</button>
								</div>
							</div>
						</div>
					</div>

				</form>
				<c:choose>
					<c:when test="${product==null}">
						<p style="color: red">Không có sản phẩm nào hiển thị</p>
					</c:when>
					<c:otherwise>
						<div id="product" >
							<p>Mã sản phẩm: ${product.getProduct_id()} Tên sản phẩm:
								${product.getProduct_name()} </p>
							<p>Danh mục: ${shipped.getCategory_name() }</p>
							<p>Số lượng đặt hàng: ${shipped.getTotal()+notShipped.getTotal()+canceled.getTotal()} || 
							Số đã giao:	${shipped.getTotal()} ||
							Số chưa giao: ${notShipped.getTotal()} ||
							Số đã hủy: ${canceled.getTotal() }</p>
							<p>Tổng số tiền đã thu: <b class="money">${shipped.getTotal_money()}</b></p>
							<p>Tổng số tiền dự kiến: <b class="money">${shipped.getTotal_money() + notShipped.getTotal_money()}</b></p>
						</div>


						
					
						<%
							List<Product_detailDTO> notShippedllDetails = (List<Product_detailDTO> )request.getAttribute("notShippedllDetails");
							List<Product_detailDTO> shippedDetails = (List<Product_detailDTO> )request.getAttribute("shippedDetails");
							List<Product_detailDTO> canceledDetails = (List<Product_detailDTO> )request.getAttribute("canceledDetails");
						
						%>
						
						<div >
							<table border="1">
								<thead>
									<tr>
										<th>Mã chi tiết</th>
										<th>Đặt hàng</th>
										<th>Đã giao</th>
										<th>Chưa giao</th>
										<th>Hủy</th>
										<th>Doanh thu hiện tại</th>
										<th>Doanh thu dự kiến</th>
									</tr>
								</thead>
								<tbody>

									<%
										long total;
										long total_money;
										for(int i=0;i<notShippedllDetails.size();i++){
												total=0;
												total_money=0;
												total=notShippedllDetails.get(i).getTotal()+shippedDetails.get(i).getTotal()+canceledDetails.get(i).getTotal();
												total_money=shippedDetails.get(i).getTotal_money()+notShippedllDetails.get(i).getTotal_money();
											%>
										<tr>
											<td><%=notShippedllDetails.get(i).getProduct_detail_id() %></td>
											<td><%=total%></td>
											<td><%=shippedDetails.get(i).getTotal() %></td>
											<td><%=notShippedllDetails.get(i).getTotal() %></td>
											<td><%=canceledDetails.get(i).getTotal() %></td>
											<td class="money"><%=shippedDetails.get(i).getTotal_money()%></td>
											<td class="money"><%=total_money %></td>
										</tr>
									<%} %>


								</tbody>
							</table>
						</div>
					</c:otherwise>
				</c:choose>


			</div>
		</div>

	</div>


	<jsp:include page="footer_admin.jsp"></jsp:include>
</body>
<script src='<c:url value="/resources/js/jquery-3.4.1.min.js"></c:url>'></script>
<script src='<c:url value="/resources/js/statistics.js"></c:url>'></script>
<script src='<c:url value="/resources/js/format-money.js"/>'></script>
</html>
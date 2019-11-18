<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List" %>
<%@ page import="com.gr21.model.Product_detailDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doanh thu từng danh mục</title>
<jsp:include page="header_admin.jsp"></jsp:include>
</head>

<body class="animsition">

	<!-- MAIN CONTENT-->
	<div class="main-content">
		<div class="section__content section__content--p30">
			<div class="container-fluid">

				<form
					action='<c:url value="/admin/statistics/category"></c:url>'
					method="post" class="form-horizontal">
					<div class="row form-group">
						<div class="col col-md-12">
							<div class="input-group">
								 <input type="month" name="month" class="form-control" value="${month }">
								<div class="input-group-btn">
									<button type="submit" class="btn btn-primary">
										<i class="fa fa-search"></i>Thống kê
									</button>
								</div>
							</div>
						</div>
					</div>

				</form>
				<div>
					
		
			</div>
			
			<div class="table-responsive m-b-40">
                                    <table class="table table-borderless table-data3">
                                        <thead>
                                            <tr>
                                                <th>Mã danh mục</th>
                                                <th>Tên danh mục</th>
                                                <th>Đã giao</th>
                                                <th>Chưa giao</th>
                                                <th>Đã hủy</th>
                                                <th>Tổng</th>
                                                <th>Doanh thu hiện tại</th>
                                                <th>Doanh thu dự kiến</th>
                                                
                                            </tr>
                                        </thead>
                                        <tbody>
                                        		<c:set var="TotalShipped" value="0"/>
                                        		<c:set var="TotalNotshipped" value="0"/>
                                        		<c:set var="TotalCanceled" value="0"/>
                                        		<c:set var="Total" value="0"/>
                                        		<c:set var="TotalShippedMoney" value="0"/>
                                        		<c:set var="TotalNotshippedMoney" value="0"/>
                                            <c:forEach items="${list }" var="category">
												<tr>
													<td>${category.getCategory_id() }</td>
													<td>${category.getCategory_name() }</td>
													<td>${category.getTotalShipped() }</td>
													<td>${category.getTotalNotshipped() }</td>
													<td>${category.getTotalCanceled() }</td>
													<td>${category.getTotalShipped()+category.getTotalNotshipped()+category.getTotalCanceled() }</td>
													<td class="money">${category.getTotalShippedMoney() }</td>
													<td class="money">${category.getTotalNotshippedMoney() }</td>
												</tr>
												
												
												<c:set var="TotalShipped" value="${TotalShipped + category.getTotalShipped()}"/>
                                        		<c:set var="TotalNotshipped" value="${TotalNotshipped + category.getTotalNotshipped()}"/>
                                        		<c:set var="TotalCanceled" value="${TotalCanceled + category.getTotalCanceled() }"/>
                                        		<c:set var="Total" value="${Total + category.getTotalShipped()+category.getTotalNotshipped()+category.getTotalCanceled() }"/>
                                        		<c:set var="TotalShippedMoney" value="${TotalShippedMoney +category.getTotalShippedMoney() }"/>
                                        		<c:set var="TotalNotshippedMoney" value="${TotalNotshippedMoney +category.getTotalNotshippedMoney() }"/>
											</c:forEach>
											 <tr>
                                              	  <td colspan="2" align="center">Tổng</td>
                                             	  <td>${TotalShipped }</td>
                                              	  <td>${TotalNotshipped }</td>
                                              	  <td>${TotalCanceled }</td> 
                                         	 	  <td>${Total }</td>
                                           		  <td><b class="money">${TotalShippedMoney }</b> đ</td>
                                            	  <td><b class="money">${TotalNotshippedMoney }</b> đ<td>
                                            </tr>
                                        </tbody>
                                        
                                        
                                    </table>
                                </div>
			
			
			</div>
		</div>

	</div>


	<jsp:include page="footer_admin.jsp"></jsp:include>
</body>
<script src='<c:url value="/resources/js/jquery-3.4.1.min.js"></c:url>'></script>
<script src='<c:url value="/resources/js/statistics.js"></c:url>'></script>
<script src='<c:url value="/resources/js/format-money.js"/>'></script>
</html>
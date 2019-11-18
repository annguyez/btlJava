
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sale </title>
<link rel="stylesheet" href='<c:url value="/resources/css/responsived.css"/>'/>
<jsp:include page="header_admin.jsp"></jsp:include>
</head>

<body class="animsition">
    
            <!-- MAIN CONTENT-->
            <div class="main-content">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                        
                               
                           
                     
                        <div id="container" class="">
								<div class="row" style="background: none;">
								
									
						
											
								
									<div id="sizemanage" class="c4" >
											<div class="row">
												<input type="number" name="search_id" id ="search_id" placeholder="Nhập mã sale để tìm">
												<button id="search">Tìm kiếm</button>
											</div>
										<form id="frmSale" style="padding:0 20px" id="frmSale" method="post" onsubmit="return false">
											<input id="command" value="add" hidden>
											<div id="forUpdate">
												<label for="sale_id">Mã giảm giá</label>
												<input type="number" id="sale_id" name="sale_name" disabled="disabled"><br>
											</div>
											<label for="sale_name">Tên giảm giá</label>
											<input type="text" id="sale_name" name="sale_name" required="required"><br>
											<label for="sale_start">Ngày bắt đầu</label>
											<input type="date" id="sale_start" name="sale_start" required="required"><br>
											<label for="sale_end">Ngày kết thúc</label>
											<input type="date" id="sale_end" name="sale_end" required="required"><br>
											<label></label></br>
											<label for="discount" required="required">Giảm giá</label>
											<input type="number" id="discount" name="discount" min="1" max="100"><br>
											<label for="descriptions">Mô tả</label><br>
											<textarea rows="5" cols="30" id="descriptions" name="descriptions"></textarea><br>
											<p>Danh sách sản phẩm khuyến mãi</p>
											<div id="sale_products" class="c8">
											</div>
											<div class="clr"></div>
											<button type="submit" id="btnAdd">Thêm</button>
											<button type="button" id="btnReset">Đặt lại</button>
											<button type="submit" id="btnUpdate">Cập nhật</button>
											<button type="button" id="btnCancle">Hủy</button>
										</form>	
										
									</div>
				
									<div class="c7">
									<input id="findby" value="${command }" hidden >
									<div class="row">
							
										<div class="c12" style="float:right;">
										<form method="post" action='<c:url value="/admin/sale/getsale"></c:url>'>
											<c:choose>
												<c:when test="${product_id==0 }">
													<input type="number" name="product_id" placeholder="Mã sản phẩm">
												</c:when>
												<c:otherwise>
													<input type="number" name="product_id" placeholder="Mã sản phẩm" value="${product_id }">
												</c:otherwise>
												
											</c:choose>
											<select name="command" id="slcommand" >
												<option value="0">Tất cả khuyến mãi</option>
												<option value="1">Đang tiến hành</option>
												<option value="2">Đã kết thúc</option>
												<option value="3">Chưa bắt đầu</option>
											</select>
											<button type="submit">Xem</button>
										</form>	
										<button type="button" class="btn btn-outline-danger" id="delete">Xóa khuyến mãi</button>
										</div>
										<div class="clr"></div>
										
									</div>
									<div id="listsale" class="row" style=";">
										<table id="tblSale" border="1" class="table-earning">
											<thead>
												<tr>
													<th><input id="chkAll" type="checkbox"></th>
													<th>Mã giảm giá</th>
													<th>Tên giảm giá</th>
													<th>Ngày bắt đầu</th>
													<th>Ngày kết thúc</th>
													<th>Giá giảm</th>
												</tr>
											</thead>
											<tbody id="tbSale">
												<c:forEach items="${sales }" var="sale">
													<tr class="sale">
														<td><input class='chkSale' name='sale_id' type='checkbox' value='${sale.getSale_id() }'></td>
														<td class="sale_id_search">${sale.getSale_id()}</td>
														<td>${sale.getSale_name()}</td>
														<td>${sale.getSale_start()}</td>
														<td>${sale.getSale_end()}</td>
														<td>${sale.getDiscount()}</td>
													<tr>
												</c:forEach>
												
									
											</tbody>
											
										</table>
										<ul class="pagination">
											<c:forEach begin="1" end="${totalpage }" var="i">
												<c:choose>
													<c:when test="${i==page}">
														<li class="page-item acitve"><a class="page-link"
															href='<c:url value="/admin/sale/${command }/${product_id }/${i }"></c:url>'>${i }</a></li>
													</c:when>
													<c:otherwise>
														<li class="page-item"><a class="page-link"
															href='<c:url value="/admin/sale/${command }/${product_id }/${i }"></c:url>'>${i }</a></li>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</ul>
							</div>
									
									
									
									
										
											<div class="row">
												<label for="product_name">Danh mục sản phẩm</label>
												<select  id="category_id" name="category_id">
															<option value="0">Tất cả</option>
															<c:forEach items="${categories }" var="cat">
																<option value="${cat.getCategory_id() }">${cat.getCategory_name()}</option>
															</c:forEach>
														</select><br>
												<table id="tbProduct" class="table table-borderless table-striped table-earning">
													<thead>
														<tr>
															<th style="width:20px;">Mã sản phẩm</th>
															<th>Tên sản phẩm</th>
															<th>Giá tiền</th>
														</tr>
													</thead>
													<tbody id="listProduct">
													
											
													</tbody>
													
												</table>
												<ul class="pagination" id="pag_product"></ul>
											</div>
										</div>
									</div>
									<div class="clr"></div>
								</div>
								
								
                        <div class="row">
								
								
								
								<div class="row">
								
                            <div class="col-md-12">
                               
                            </div>
                        </div>
                    </div>
                </div>
            </div>
    
	</div>
	
	<jsp:include page="footer_admin.jsp"></jsp:include>
</body>
<script src='<c:url value="/resources/js/jquery-3.4.1.min.js"></c:url>' ></script>
<script src='<c:url value="/resources/js/sale.js"></c:url>'></script>
</html>
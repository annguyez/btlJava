<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm sản phẩm</title>
<link rel="stylesheet"
	href='<c:url value="/resources/home/css/bootstrap.min.css"/>' />
<link rel="stylesheet"
	href='<c:url value="/resources/css/style.css"/>' />
<c:url value="/admin/product" var="url"></c:url>
</head>
<body style="font-size:15px;">
	<div style="witdh:300px; margin: 50px" id="product_info" >
		<form id="frmProduct"  method="post">
			
			<div class="row form-group">
                                                <div class="col col-md-12">
                                                    <div class="input-group">
                                                        <input type="number" id="product_id" placeholder="Nhập mã sản phẩm " class="form-control">
                                                        <button type="button" class="btn btn-primary btn-sm " id="getinfo"> <i class="fa fa-search"></i> Tìm </button>
                                                    </div>
                                                </div>
                                            </div>
				<label for="product_name">Tên sản phẩm</label><br>
				<input type="text" id="product_name" name="product_name" required="required" class="form-control"><br>
			
			
				<label for="inputGroupSelect01">Danh mục</label><br>
				<select  id="category_id" name="category_id" class="fields form-control" required="required">
					<c:forEach items="${categories }" var="cat">
						<option value="${cat.getCategory_id() }">${cat.getCategory_name()}</option>
					</c:forEach>
				</select><br>
				
				<label for="price">Giá</label><br>
				<input type="number" min="1" id="price" name="price" required="required" class="form-control"><br>
				
				<label for="descriptions">Mô tả</label><br>
				<textarea rows="5" cols="40" id="descriptions" name="descriptions" class="form-control"></textarea><br>
				
				<label for="price">Hình ảnh</label><br>
				<input id="oldimg" hidden class="form-control">
				<img alt="image" id="img-url" src="">
				<a id="url" hidden target="blank">Xem ảnh sản phẩm</a>
				<input type="file" id="image" name="image" class="form-control"><br>

			
		
		
		<div id="frmProduct_detail">		
				<!--Thông tin chi tiết-->
				<div id="detail_container">
					
				</div>
		</div>	
				
				
			
			<input value="add" id="command" hidden>
			<button id="addmore" class="btn btn-secondary btn-sm" type="button">Thêm chi tiết</button><br><br><br>
			<button type="submit" class="btn btn-success" id="btnadd" >Thêm sản phẩm</button>
			<button type="submit" class="btn btn-info" id="btnupdate" hidden="">Cập nhật</button>
			<button type="button" id="reset" class="btn btn-danger">Đặt lại</button>
			<button type="button" id="back" class="btn btn-danger" hidden="">Trở lại</button>
			</form>	
		
	</div>
		<!--Thông tin chi tiết clone-->
				<div id="product_detail" class="product_detail">
					<table>
						<tr>
						<td>
							<select  name="color_id" id="color_id" required="required" class="form-control">
								<c:forEach items="${colors }" var="color">
									<option value="${color.getColor_id() }">${color.getColor_name()}</option>
								</c:forEach>
							</select>
						<td/>
						<td>
						
							<select name="size_id" id="size_id" required="required" class="form-control" style="top: 10px">
								<c:forEach items="${sizes }" var="size">
									<option value="${size.getSize_id() }">${size.getSize()}</option>
								</c:forEach>
							</select>
						</td>
						
						<td rowspan="2">
							
							<button type="button" class="delete btn btn-outline-danger btn-sm zmdi zmdi-delete">
                                        
                            </button>
						</td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="number" min="0" name="quantity" id="quantity" value="1" required="required" class="form-control"><br>	
							</td>
						</tr>
					</table>
					
				</div>
	

</body>
<script src='<c:url value="/resources/js/jquery-3.4.1.min.js"></c:url>'></script>
<script src='<c:url value="/resources/js/addProduct.js"></c:url>'></script>
</html>
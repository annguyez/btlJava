<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Size</title>
<jsp:include page="header_admin.jsp"></jsp:include>
</head>

<body class="animsition">
    
            <!-- MAIN CONTENT-->
            <div class="main-content">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                        
                               
                           
                     
                        <div class="row">
                            <div class="col-md-12">
                                <!-- DATA TABLE -->
                                <h3 class="title-5 m-b-35">data table</h3>
                                <div style="witdh:300px; margin: 50px" id="size_info">
                                        <form id="frmCategory" style="margin-bottom: 10px;">
                                                <label for="category_name">Category_name</label><br>
                                                <input type="text" id="category_name" name="category_name" required="required"><br>
                                                
                                                
                                        </form>     
                                        <label for="price">Hình ảnh</label><br>
												<input id="oldimg" hidden >
												<a id="url" hidden target="blank">Xem ảnh sản phẩm</a>
												<input type="file" id="image" name="image"><br>
												
												
                                        <a href='<c:url value="/admin/category_ad"></c:url>' class="item" data-toggle="tooltip" data-placement="top"   id="btnadd" style="border-radius:5px;padding:5px; background-color:lightblue; margin-left:0px;">
                                                   Thêm mới
                                        </a>
                                        <button></button>
                                        <button type="button" id="reset" style="background: lightblue;padding: 5px;border-radius: 8px;" value="reset">Đặt lại</button>
                                </div>
                                	<form id="frmProduct_detail">		
											<!--Thông tin chi tiết-->
											<div id="detail_container">
												
											</div>
									</form>	
							                                
                                
                                <div class="table-responsive table-responsive-data2">
                                    <table class="table table-data2" id="tbCategory">
                                        <thead>
                                            <tr>
                                                <th>
                                                    <label class="au-checkbox">
                                                        <input type="checkbox" id="chkAll">
                                                        <span class="au-checkmark"></span>
                                                    </label>
                                                </th>
                                                <th>Category_id</th>
                                                <th>Category_name</th>
                                               	<th>Image</th>
                                                <th>Chức năng<button type="button" class=""" id="delete" style="border: 1px solid #000;padding:5px; background-color:lightblue; margin-left:40px;">Delete Category</button></th>
                                               
                                            </tr>
                                        </thead>
                                        <tbody id="listCategory">
                                  
                                            <c:forEach items="${list }" var="rs">
												<tr class="tr-shadow " >
													<td ><input class="chkCategory" type="checkbox" name="category_id"
														value="${rs.getCategory_id()}"></td>
													<td>${rs.getCategory_id()}</td>
													<td>${rs.getCategory_name()}</td>
													<td>${rs.getImage()}</td>
												    <td>  
												    	<div>   
                                                  		<button class="item edit" data-toggle="tooltip" data-placement="top"  value="${rs.getCategory_id() }">
                                                            Xem
                                                        </button>
                                                        <button class="item" data-toggle="tooltip" data-placement="top" title="view">
                                                            
                                                        </button>
                                                        
                                             
                                                        <button class="item update" data-toggle="tooltip" data-placement="top"  value="${rs.getCategory_id() }" id="btnupdate">
                                                            Cập nhật
                                                        </button>
                                                    </div>
                                                </td>
                                            </tr>
                                           </c:forEach>  
                                        </tbody>
                                    </table>
                                </div>
                                <!-- END DATA TABLE -->
                        
                        
                                <!-- END DATA TABLE-->
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="copyright">
                                    <p>Copyright © 2018 Colorlib. All rights reserved. Template by <a href="https://colorlib.com">Colorlib</a>.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>

	
	<jsp:include page="footer_admin.jsp"></jsp:include>
</body>

<script src='<c:url value="/resources/js/addCategory.js"></c:url>'></script>
</html>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Người dùng</title>
<jsp:include page="header_admin.jsp"></jsp:include>
<style type="text/css">
	button:hover{
	
		background: #ff0000;
	}
</style>
</head>

<body class="animsition">
    
            <!-- MAIN CONTENT-->
            <div class="main-content" >
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                        
                               
                           
                     
                        <div class="row">
                            <div class="col-md-12">
                                <!-- DATA TABLE -->
                                <h3 class="title-5 m-b-35">data table</h3>
                                <div style="witdh:300px; margin: 50px" id="size_info">
                               <h2 style="text-align: center;" id="result"></h2>
                                <form style="margin-bottom: 20px;margin-left:-50px;" id="searchEmp" action='<c:url value="/admin/employees/search"></c:url>' method="post">
									<label for="id_emp">Người dùng</label></br>
									<input id="id_emp" name="id_emp"  /></br>
									<button type="submit" class="search" id="search" style="background: lightblue;padding: 5px;border-radius: 8px; margin-right: 46px;">Tìm kiếm</button>
									
									
									
								</form>
                                

                                       
                                </div>

                                	<form id="frmEmp"  class="frmEmp">		
											<!--Thông tin chi tiết -->
											<div id="detail_container" class="detail_container" style="margin-bottom: 10px;">
												
													<table styel="background: lightblue;">
														<tr>
<!-- 															<td><label for="employee_id">Mã nhân viên</label></td> -->
<!-- 	                                                		<td><input type="text" id="employee_id" name="employee_id"  ></td> -->
	                                                		
	                                                		
	                                                		<td><label for="fullname">Tên nhân viên</label></td>
	                                                		<td><input type="text" id="fullname" name="fullname" id="fullname" ></td>
	                                                		
	                                                		
	                                                	</tr>
	                                                	<tr>
															
	                                                	
	                                                		<td><label for="address">Địa chỉ</label></td>
	                                                		<td><input type="text" id="address" name="address"  ></td>
	                                                		
	                                                		<td><label for="sex">Giới tính</label></td>
	                                                		<td>
	                                                			<select name="sex"  id="sex" style="width:202px;">
																		<option value="${rs.getSex()}" >
																			<c:choose>
																				<c:when test="${rs.getSex()==0}">Nam</c:when>
																				<c:when test="${rs.getSex()==1}">Nữ</c:when>
																				<c:when test="${rs.getSex()==2}">Giới tính khác</c:when>
																				
																			</c:choose>
																		</option>
																	
																		
																		<option value="0">Nam</option>
																		<option value="1">Nữ</option>
																		<option value="2">Giới tính khác</option>
																		
																</select>
	                                                		</td>
	                                                		
	                                                		
	                                                	</tr>
	                                                	<tr>
	                                                		<td><label for="idcard">Mã thẻ</label></td>
	                                                		<td><input type="text" id="idcard" name="idcard"  ></td>
	                                                	
	                                                	
															<td><label for="role_id">Chức vụ</label></td>
<!-- 	                                                		<td><input type="text" id="order_status" name="order_status" required="required"></td> -->



			                                             	<td>
<!-- 			                                             	<select name="role_id" style="width: 202px;"> -->
<!-- 			                                             			<option name="role_name" >Lựa chọn chức vụ</option> -->
<%-- 																<c:forEach items="${listRole }" var="listR"> --%>
<%-- 																	<option value="${listR.getRole_id()}" >${listR.getRole_name()}</option> --%>
																	
<%-- 																</c:forEach> --%>
<!-- 															</select> -->
<!-- 																<input type="text" id="role_name" name="role_name"  > -->

																<select name="role_name"  id="role_name" style="width:202px;">
																		<option value="${rs.getRoles().getRole_id()}" >
																			<c:choose>
																				<c:when test="${rs.getRoles().getRole_id()==1}">Quản trị viên</c:when>
																				<c:when test="${rs.getRoles().getRole_id()==2}">Bán hàng</c:when>
																				
																			</c:choose>
																		</option>
																	
																		
																		<option value="1">Quản trị viên</option>
																		<option value="2">Bán hàng</option>
																		
																</select>
																

															</td>
															
	                                                		
	                                                		
	                                                		
	                                                	</tr>
	                                                	<tr>
															<td><label for="email">Email</label></td>
	                                                		<td><input type="text" id="email" name="email"  ></td>
	                                                	
	                                                		<td><label for="username">Tài khoản</label></td>
	                                                		<td><input type="text" id="username" name="username" ></td>
	                                                		
	                                                		
	                                                		
	                                                	</tr>
	                                                	<tr>
	                                                		<td><label for="password">Mật khẩu</label></td>
	                                                		<td><input type="text" id="password" name="password"></td>
	                                                		
	                                                	</tr>
	                                                	
                                                	</table>
                                                	
                                                	
											</div>
									</form>	
									
                                	<div>
							            <a href='<c:url value="/admin/employees"></c:url>' class="item" data-toggle="tooltip" data-placement="top"   id="btnadd" style="border-radius:5px;padding:5px; background-color:lightblue; margin-left:0px;">
                                                   Thêm mới
                                        </a>
                                        <button></button>
                                        <a href='<c:url value="/admin/employees"></c:url>' class="item update" data-toggle="tooltip" data-placement="top"  value="${rs.getEmployee_id() }" id="btnupdate" style="border-radius:5px;padding:5px; background-color:lightblue; margin-left:13px;">
                                               Cập nhật
                                        </a>
                           		  		<button></button>
										<button type="button" id="resetText" style="background: lightblue;padding: 5px;border-radius: 8px;" value="đas">
										Đặt lại</button>
							            
							         </div>
                                <div class="table-responsive table-responsive-data2" style="overflow-x:scroll;">
                                    <table class="table table-data2" id="tbEmp">
                                        <thead>
                                            <tr>
                                                <th>
                                                    <label class="au-checkbox">
                                                        <input type="checkbox" id="chkAll">
                                                        <span class="au-checkmark"></span>
                                                    </label>
                                                </th>
                                                <th>Mã</th>
                                                <th>Tên nhân viên</th>
                                                <th>Địa chỉ</th>
                                                <th>Giới tính</th>
                                                <th>Mã thẻ</th>
                                                <th>Chức vụ</th>
                                                <th>Email</th>
                                                <th>Tài khoản</th>
                                                <th>Mật khẩu</th>
                                                <th>Chức năng<a href='<c:url value="/admin/employees"></c:url>' type="button" class="item" id="delete" style="border: 1px solid #000;padding:5px; background-color:lightblue; margin-left:0px;" value="${rs.getEmployee_id()}">
                                                Xóa</a></th>
                                               
                                            </tr>
                                        </thead>
                                        <tbody id="listEmp">
                                  
                                            <c:forEach items="${list }" var="rs">
												<tr class="tr-shadow" >
													<td ><input class="chkEmp" type="checkbox" name="employee_id"
														value="${rs.getEmployee_id()}"></td>
													<td >${rs.getEmployee_id()}</td>
													<td>${rs.getFullname()}</td>
													<td>${rs.getAddress()}</td>
													<td>
														<c:choose>
															<c:when test="${rs.getSex()==0}">Nam</c:when>
															<c:when test="${rs.getSex()==1}">Nữ</c:when>
															<c:when test="${rs.getSex()==2}">Giới tính :))</c:when>
															
														</c:choose>
													</td>
													<td style="display: none;">${rs.getSex()}</td>
													<td>${rs.getIdcard()}</td>


													<td>
														<select name="role_name"  id="role_name">
																<option value="${rs.getRoles().getRole_id()}" >
																	<c:choose>
																		<c:when test="${rs.getRoles().getRole_id()==1}">Quản trị viên</c:when>
																		<c:when test="${rs.getRoles().getRole_id()==2}">Bán hàng</c:when>
																		
																	</c:choose>
																</option>
															
																
																<option value="1">Quản trị viên</option>
																<option value="2">Bán hàng</option>
																
														</select>
													</td>
													<td style="display:none;">${rs.getRoles().getRole_id()}</td>
													<td>${rs.getEmail()}</td>
													<td>${rs.getUsername()}</td>
													<td>${rs.getPassword()}</td>
												    <td>  
												    	<div>   
                                                  		<button class="item edit" data-toggle="tooltip" data-placement="top"  value="${rs.getEmployee_id() }">
                                                            Xem
                                                        </button>
                                                        
                                                        
                                                       
                                             
                                                        <button class="item update" data-toggle="tooltip" data-placement="top"  value="${rs.getEmployee_id() }" id="btupdate">
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
                        		
<!--                         		<ul class="pagination"> -->
<%--                         			<c:forEach var="i" begin="1" end="${total }"> --%>
<%-- 								  <li class="page-item"><a class="page-link" href='<c:url value="/admin/order/${i }"></c:url>'>${i }</a></li> --%>
<%-- 									</c:forEach> --%>
<!-- 								</ul> -->
								                        
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
    

	
	<jsp:include page="footer_admin.jsp"></jsp:include>
</body>
<script src='<c:url value="/resources/js/jquery-3.4.1.min.js"></c:url>'></script>
<script src='<c:url value="/resources/js/employee.js"></c:url>'></script>
</html>
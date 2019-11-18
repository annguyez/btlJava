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
                                	

                                <div class="table-responsive table-responsive-data2" style="overflow-x:scroll;">
                                <h2 style="text-align: center;">${tb}</h2>
                                    <table class="table table-data2 " id="tbEmp">
                                        <thead>
                                            <tr>
                                             
                                                <th>Mã</th>
                                                <th>Tên nhân viên</th>
                                                <th>Địa chỉ</th>
                                                <th>Giới tính</th>
                                                <th>Mã thẻ</th>
                                                <th>Chức vụ</th>
                                                <th>Email</th>
                                                <th>Tài khoản</th>
                                                <th>Mật khẩu</th>
                                                
                                               
                                            </tr>
                                        </thead>
                                        <tbody id="listEmp">
                                  				
                                           
												<tr class="tr-shadow" >
													
													<td >${id}</td>
													<td>${full}</td>
													<td>${addr}</td>
													<td>
														<c:choose>
															<c:when test="${sex==0}">Nam</c:when>
															<c:when test="${sex==1}">Nữ</c:when>
															<c:when test="${sex==2}">Giới tính :))</c:when>
															
														</c:choose>
													</td>
													
													<td>${idcard}</td>


													<td >${role}</td>
													<td>${email}</td>
													<td>${us}</td>
													<td>${pa}</td>
												    <td>  

                                                </td>
                                            </tr>
                                           
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
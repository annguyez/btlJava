<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hóa đơn</title>
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
                                
                                <div class="table-responsive table-responsive-data2" >
                                <h1 style="text-align: center;">${tb}</h1>
                                    <table class="table table-data2 " id="tbRole">
                                        <thead>
                                            <tr>
                                                <th>
                                                    <label class="au-checkbox">
                                                        <input type="checkbox" id="chkAll">
                                                        <span class="au-checkmark"></span>
                                                    </label>
                                                </th>
                                                <th>Mã hóa đơn</th>
                                                <th>Tên khách hàng</th>
                                               <th>Số điện thoại</th>
                                               <th>Địa chỉ</th>
                                               <th>Trạng thái</th>
                                               <th>Ngày</th>
                                               
                                               <th>Ghi chú</th>
                                               
                                               
                                            </tr>
                                        </thead>
                                        <tbody id="listOrder">
                                  
                                            
												<tr class="tr-shadow" >
													<td ><input class="chkOrder" type="checkbox" name="order_id"
														value="${id}"></td>
													<td>${id}</td>
													<td>${name}</td>
													<td>${address}</td>
													<td>${phone}</td>
													

													<td class="order_status" >
														<c:choose> 
																<c:when test="${status==0}">Chưa xử lý</c:when>
																<c:when test="${status==1}">Đã giao</c:when>
																<c:when test="${status==2}">Hủy đơn</c:when>
														</c:choose>
														
													</td>
													
													<td>${date}</td>
													<td>${note}</td>

                                            </tr>
                                          
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
<script src='<c:url value="/resources/js/jquery-3.4.1.min.js"></c:url>'></script>
<script src='<c:url value="/resources/js/addColor.js"></c:url>'></script>
</html>
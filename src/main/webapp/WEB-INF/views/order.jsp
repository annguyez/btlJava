<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hóa Đơn</title>
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
                                	
                                <form style="margin-bottom: 20px;margin-left:-50px;" action='<c:url value="/admin/order/search"></c:url>' method="post">
									<label for="search_orderid">Hóa Đơn</label></br>
									<input id="search_orderid" name="search_orderid"  /></br>
									<button type="submit" class="search" id="search" style="background: lightblue;padding: 5px;border-radius: 8px; margin-right: 46px;">Tìm kiếm</button>
									<button></button>
									<button type="button" id="resetText" style="background: lightblue;padding: 5px;border-radius: 8px;" value="reset">Đặt lại</button>
									
									
								</form>
                                 <form style="margin-bottom: 20px;margin-left:-50px;" action='<c:url value="/admin/order/searchPr"></c:url>' method="post">
									<label for="pr_id">Sản phẩm</label></br>
									<input id="pr_id" name="pr_id"  /></br>
									<button type="submit" class="search" id="search1" style="background: lightblue;padding: 5px;border-radius: 8px; margin-right: 46px;">Tìm kiếm</button>
									<button></button>
									<button type="button" id="resetText" style="background: lightblue;padding: 5px;border-radius: 8px;" value="reset">Đặt lại</button>
									
									
								</form>

                                        
                                       
                                </div>
                                
	                                
                               
                                 
                                	<form id="frmOrder" style="display : none;" class="frmOrder_detail" action='<c:url value="/admin/order/update"></c:url>' method="post">		
											<!--Thông tin chi tiết -->
											<div id="detail_container" class="detail_container" style="margin-bottom: 10px;">
												
													<table styel="background: lightblue;">
														<tr>
															<td><label for="order_id">Mã hóa đơn</label></td>
	                                                		<td><input type="text" id="order_id" name="order_id" required="required" ></td>
	                                                		
	                                                		
	                                                		<td><label for="username">Tên Khách hàng</label></td>
	                                                		<td><input type="text" id="username" name="username" required="required" disabled="disabled"></td>
	                                                		
	                                                		
	                                                	</tr>
	                                                	<tr>
															
	                                                	
	                                                		<td><label for="phone">Số điện thoại</label></td>
	                                                		<td><input type="text" id="phone" name="phone" required="required" disabled="disabled"></td>
	                                                		
	                                                		<td><label for="address">Địa chỉ</label></td>
	                                                		<td><input type="text" id="address" name="address" required="required" disabled="disabled"></td>
	                                                		
	                                                		
	                                                	</tr>
	                                                	<tr>
															<td><label for="order_status">Trạng thái</label></td>
<!-- 	                                                		<td><input type="text" id="order_status" name="order_status" required="required"></td> -->



			                                                <td >
			                                                	<select name="order_status" style="width:202px;" id="order_status">
																	<option value="${rs.getOrders_status()}" >
																		<c:choose>
																			<c:when test="${rs.getOrders_status()==0}">Chưa xử lý</c:when>
																			<c:when test="${rs.getOrders_status()==1}">Đã giao</c:when>
																			<c:when test="${rs.getOrders_status()==2}">Hủy đơn</c:when>
																		</c:choose>
																	</option>
																
																	
																	<option value="0">Chưa xử lý</option>
																	<option value="1">Đã Giao</option>
																	<option value="2">Hủy Đơn</option>
																	
																</select>
															</td>
															
	                                                		<td><label for="order_date">Ngày</label></td>
	                                                		<td><input type="text" id="order_date" name="order_date" required="required" disabled="disabled"></td>
	                                                		
	                                                		
	                                                	</tr>
	                                                	<tr>
															<td><label for="note">Ghi chú</label></td>
	                                                		<td><input type="text" id="note" name="note" required="required" disabled="disabled"></td>
	                                                	
	                                                		
	                                                		
	                                                		
	                                                	</tr>
                                                	</table>
                                                	
                                                	<button class="item update" data-toggle="tooltip" data-placement="top"  value="${rs.getOrders_id() }" id="btnupdate" style="border-radius:5px;padding:5px; background-color:lightblue; margin-left:0px;">
                                                            Cập nhật
                                                     </button>
                                        		  
											</div>
									</form>	
                                
							            
							            
							         
                                <div class="table-responsive table-responsive-data2" style="overflow-x:scroll;">
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
                                                <th>Chức năng</br><button type="button" class=""" id="delete" style="border: 1px solid #000;padding:5px; background-color:lightblue; margin-left:0px;">Xóa</button></th>
                                              
                                            </tr>
                                           
                                        </thead>
                                        <tbody id="listOrder">
                                  
                                            <c:forEach items="${list }" var="rs">
												<tr class="tr-shadow" >
													<td ><input class="chkOrder" type="checkbox" name="order_id"
														value="${rs.getOrders_id()}"></td>
													<td>${rs.getOrders_id()}</td>
													<td>${rs.getCustomer_name()}</td>
													<td>${rs.getPhone()}</td>
													<td>${rs.getAddress()}</td>
													
<!-- 													<td><select name="order_status"> -->
<%-- 															<option value="${rs.getOrders_status()}"> --%>
<%-- 															<c:choose> --%>
<%-- 																<c:when test="${rs.getOrders_status()==0}">Chưa xử lý</c:when> --%>
<%-- 																<c:when test="${rs.getOrders_status()==1}">Đã giao</c:when> --%>
<%-- 																<c:when test="${rs.getOrders_status()==2}">Hủy đơn</c:when> --%>
<%-- 															</c:choose> --%>
<!-- 															</option> -->
														
															
<!-- 															<option value="0" name="order_status">Chưa xử lý</option> -->
<!-- 															<option value="1">Đã Giao</option> -->
<!-- 															<option value="2">Hủy Đơn</option> -->
															
<!-- 														</select> -->
<!-- 													</td> -->
													<td class="order_status" >
														<c:choose> 
																<c:when test="${rs.getOrders_status()==0}">Chưa xử lý</c:when>
																<c:when test="${rs.getOrders_status()==1}">Đã giao</c:when>
																<c:when test="${rs.getOrders_status()==2}">Hủy đơn</c:when>
														</c:choose>
														
													</td>
													<td style="display:none;">${rs.getOrders_status()}</td>
													<td>${rs.getOrders_date()}</td>
													<td>${rs.getNote()}</td>
												    <td>  
												    	<div>   
                                                  		<button class="item edit" data-toggle="tooltip" data-placement="top"  value="${rs.getOrders_id() }">
                                                            Xem
                                                        </button>
                                                        
                                                        <a href='<c:url value="/admin/order/info/${rs.getOrders_id() }"></c:url>' target="_blank">Xem chi tiết</a>
                                                       
                                             
<%--                                                         <button class="item update" data-toggle="tooltip" data-placement="top"  value="${rs.getOrders_id() }" id="btnupdate"> --%>
<!--                                                             Cập nhật -->
<!--                                                         </button> -->
                                                    </div>
                                                </td>
                                            </tr>
                                           </c:forEach>  
                                        </tbody>
                                    </table>
                                </div>
                                <!-- END DATA TABLE -->
                        		
                        		<ul class="pagination">
                        			<c:forEach var="i" begin="1" end="${total }">
								  <li class="page-item"><a class="page-link" href='<c:url value="/admin/order/${i }"></c:url>'>${i }</a></li>
									</c:forEach>
								</ul>
								                        
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
<script src='<c:url value="/resources/js/order.js"></c:url>'></script>
</html>
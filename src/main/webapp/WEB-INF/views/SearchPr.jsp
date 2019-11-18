<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ page import="java.util.List" %>
<%@ page import="com.gr21.entity.Orders_detail" %>
<%@ page import="com.gr21.entity.Product_detail" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Chi tiết hóa đơn</title>
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

                                <div class="table-responsive table-responsive-data2">
                                <button type="button" class=""" id="delete" style="border: 1px solid #000;padding:7px; background-color:lightblue; margin-left:0px;">Xóa chi tiết </button>
                                    <table class="table table-data2 " id="tbRole">
                                        <thead>
                                            <tr>
                                                <th>
                                                    <label class="au-checkbox">
                                                        <input type="checkbox" id="chkAll">
                                                        <span class="au-checkmark"></span>
                                                    </label>
                                                </th>
                                                <th>Stt</th>
                                                <th>Mã hóa đơn</th>
                                                <th>Mã sản phẩm</th>
                                               	<th>Tên sản phẩm</th>
                                               	<th>Màu sản phẩm</th>
                                               	<th>Size sản phẩm</th>
                                               	<th>Số lượng</th>
                                               	<th>Giá sản phẩm</th>
                                                
                                               
                                            </tr>
                                        </thead>
                                        <tbody id="listPr">
                                  			
                                  			<%
                                   
                                    List<Product_detail> product_detail = (List<Product_detail>)request.getAttribute("listPr");
                                    List<Orders_detail> orders_detail = (List<Orders_detail>)request.getAttribute("listOr");
                                
                                    for(int i=0;i<orders_detail.size();i++) {
                                    	 
                                    %>
                                   
                                  
                                        <tr>
                                        	<td ><input class="listPr" type="checkbox" name="ord"
														value="<%=orders_detail.get(i).getOrders_detail_id().getProduct_detail_id() %>"></td>
                                            <td><%=i+1 %></td>
                                             <td><%=orders_detail.get(i).getOrders_detail_id().getOrders_id() %></td>
                                             <td><%=product_detail.get(i).getProduct().getProduct_id() %></td>
                                            <td><%=product_detail.get(i).getProduct().getProduct_name() %></td>
                                            <td><%=product_detail.get(i).getColor().getColor_name() %></td>
                                             <td><%=product_detail.get(i).getSize().getSize() %></td>
                                             <td><%=orders_detail.get(i).getQuantity() %></td>
                                            <td><%=orders_detail.get(i).getPrice() %></td>
                                               
                                              
                                          
                                      		  </tr>
                                   		 <%} %>
                                            
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
    

	
	<jsp:include page="footer_admin.jsp"></jsp:include>
</body>
<script src='<c:url value="/resources/js/jquery-3.4.1.min.js"></c:url>'></script>
<script src='<c:url value="/resources/js/ordetail.js"></c:url>'></script>
</html>
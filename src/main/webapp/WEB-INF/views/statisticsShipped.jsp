<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
                        
                               
                           
                     
                        <div class="row">
                            <div class="col-md-12">
                                <!-- DATA TABLE -->
                                <h3 class="title-5 m-b-35">Các sản phẩm đã giao</h3>
                                <div style="witdh:300px; margin: 50px" id="size_info">
                                        <form id="frmStatistic" action='<c:url value="/admin/statistics/shipped"></c:url>'  method="post">
                                                <label for="month">Tháng</label><input type="month" id="month" name="month">
                                                <label for="orderby">Kiểu sắp xếp</label>     
                                                <select name="orderby">
                                                	<option value="1">Số lượng đặt hàng</option>
                                                	<option value="2">Doanh thu</option>
                                                	<option value="3">Mã sản phẩm</option>
                                                </select>
                                                <label for="category_id">Danh mục</label>
                                                <select id="category_id" name="category_id">
                                                	<option value="0">Toàn bộ</option>
                                                	<c:forEach items="${categories }" var="category">
                                                		<option value="${category.getCategory_id() }">${category.getCategory_name() }</option>
                                                	</c:forEach>
                                                </select>
                                              	<button type="submit">Xem</button>
                                        </form>     
                                </div>
                             
							                                
                                <p>${total }</p>
                                <div class="table-responsive table-responsive-data2">
                                    <table class="table table-data2" id="tbColor">
                                        <thead>
                                           	<tr>
                                           		<th>Số thứ tự</th>
                                           		<th>Mã sản phẩm</th>
                                           		<th>Tên sản phẩm</th>
                                           		<th>Danh mục</th>
                                           		<th>Số lượng đặt hàng</th>
                                           		<th>Doanh thu</th>
                                           	</tr>
                                        </thead>
                                        <tbody id="listProducts">
                                        	<%
                                        		int i = ((Integer)request.getAttribute("page")-1)*20+1;
                                        	%>
                                  			<c:forEach items="${products }" var="product" >
                                  				<tr>
                                  					<td><%=i++ %></td>
                                  					<td>${product.getProduct_id() }</td>
                                  					<td><a href='<c:url value="/admin/statistics/singleproduct/${product.getProduct_id() }/${month }"></c:url>'>${product.getProduct_name() }</a></td>
                                  					<td>${product.getCategory_name() }</td>
                                  					<td>${product.getTotal()}</td>
                                  					<td class="money">${product.getTotal_money()}</td>
                                  				</tr>
                                  			
                                  			 </c:forEach>
                                            
                                       
                                        </tbody>
                                    </table>
                                </div>
                                <!-- END DATA TABLE -->
                                	<ul class="pagination">
                        				<c:forEach begin="1" end="${totalpage }" var="i">
                        					  <c:choose>
                        					  		<c:when test="${i==page}">
                        					  			<li class="page-item acitve"><a class="page-link" href='<c:url value="${url }/${i }"></c:url>'>${i }</a></li>
                        					  		</c:when>
                        					  		<c:otherwise>
                        					  			<li class="page-item"><a class="page-link" href='<c:url value="${url }/${i }"></c:url>'>${i }</a></li>
                        					  		</c:otherwise>
                        					  </c:choose>
                        				</c:forEach>
                        			</ul>	
                                <!-- END DATA TABLE-->
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                              
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
<script src='<c:url value="/resources/js/statistics.js"></c:url>'></script>
<script src='<c:url value="/resources/js/format-money.js"/>'></script>
</html>
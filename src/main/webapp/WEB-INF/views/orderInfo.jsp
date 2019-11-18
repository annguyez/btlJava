<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" --%>
<%--     pageEncoding="ISO-8859-1"%> --%>
<%--     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<!-- <!DOCTYPE html> -->
<!-- <html> -->
<!-- <head> -->
<!-- <meta charset="ISO-8859-1"> -->
<!-- <title>Chi tiết hóa đơn</title> -->
<!-- </head> -->
<!-- <body> -->
<%-- 	<c:forEach items="${orders_detail }" var="od"> --%>
<%-- 		${od.getOrders_detail_id().getProduct_detail_id() } --%>
		
<%-- 	 </c:forEach> --%>
<!-- </body> -->
<!-- </html> -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ page import="java.util.List" %>
<%@ page import="com.gr21.entity.Orders_detail" %>
<%@ page import="com.gr21.entity.Product_detail" %>
 <!DOCTYPE html> 
<html>
<head>
    <title></title>

    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script type="text/javascript">
        $("#btnPrint").live("click", function () {
            var divContents = $("#dvContainer").html();
            var printWindow = window.open('', '', 'height=400,width=800');
            printWindow.document.write('<html><head><title>Hóa đơn </title>');
            printWindow.document.write('</head><body >');
            printWindow.document.write(divContents);
            printWindow.document.write('</body></html>');
            printWindow.document.close();
            printWindow.print();
        });
    </script>
    <jsp:include page="header_admin.jsp"></jsp:include>
</head>
<body>
    
    
        
     <div class="main-content" style="background: #fff;margin-left:1px;">
                <a style="position: relative; top: -26px; left: 73px;margin-top:50px;"
                    href='<c:url value="/admin/order/1"></c:url>' class="btn btn-primary">Quay Lai</a>
                    <input type="button" value="Xuất hóa đơn" id="btnPrint" 
                    style="margin-left:90px;" class="btn btn-primary"
                    />
                <div class="">
                    
                    
    				<div id="dvContainer">
                    <div class="container-fluid">
						
                        <div class="box" id="box">
                            <div class="box1">
                                <div
                                    style="width: 150px; height: 100px; float: left;margin-bottom:30px;">
                                    <img src="http://localhost:8080/Shop/resources/image/LOGO1.png" alt="logO" style = "width: 150px; height: 150px;"/>
                                </div>
                                
                                <div class="detail1">
                                    <h4>ADDITIONAL VALUE BILL</h4>
                                   
                                </div>
                                <div class="detail2">
                                    <b>Form</b> <em><span>01GTKT0/01</span></em><br> <b>Serial</b>
                                        <em><span>AB/17E</span></em><br> <b>No.</b> <em><span>00000</span></em><br>
                                </div>
                            </div>
                            <div class="box2">
                                <p>
                                    <em>Sale Department:</em><span style="margin-left: 30px">
                                        ENSENCE</span>
                                </p>
                                <p>
                                    <em>Tax code:</em><span style="margin-left: 30px">.....
                                        0104882322</span>
                                </p>
                                <p>
                                    <em>Address:</em><span style="margin-left: 30px">.....
                                        HA NOI</span>
                                </p>
                                <p>
                                    <em>Phone:</em><span style="margin-left: 30px">.....
                                        0948576867</span><span style="margin-left: 50px">
                                        Account No.:</span><span style="margin-left: 30px">
                                        1234567890912</span>
                                </p>
                            </div>
                        
                            <div class="box3">
                                <p>
                                    <em>Buyer name:</em><span style="margin-left: 30px">.....
                                        ${name}</span>
                                </p>
                                <p>
                                    <em>Phone number:</em><span style="margin-left: 30px">.....
                                        ${phone}</span>
                                </p>
<!--                                <p> -->
<!--                                    <em>Tax code:</em><span style="margin-left: 30px">..... -->
<!--                                        item.getCus_thue()%></span> -->
<!--                                </p> -->
                                <p>
                                    <em>Address:</em><span style="margin-left: 30px">..... ${addr}</span>
                                </p>
                                <p>
                                    <em>Payment method:</em><span style="margin-left: 30px">.....
                                        COD</span><span style="margin-left: 150px">
                                       
                                </p>
                                <p>
                                    <em>Note:</em><span style="margin-left: 30px">..... ${note }</span>
                                </p>
                            </div>
                            
                            <div class="box4">
                                <table border="2" class="table-earning">
                                    <thead>
                                        <tr>
                                            <th>STT</th>
                                            <th>Product's Name</th>
                                            <th>Color</th>
                                            <th>Size</th>
                                            <th>Quantity</th>
                                            <th>Price</th>
                                            <th>Totals</th>
                                        </tr>
                                    </thead>
                                	
                                	
                                
    								<%
                                    List<Orders_detail> orders_detail = (List<Orders_detail>)request.getAttribute("orders_detail");
                                    List<Product_detail> product_detail = (List<Product_detail>)request.getAttribute("product_details");
                                    
                                    float total=0;
                                    float totals=0;
                                    for(int i=0;i<orders_detail.size();i++) {
                                    	 total =orders_detail.get(i).getQuantity()*Float.parseFloat(orders_detail.get(i).getPrice()) ;
                                         totals=totals+total;
                                    %>
                                   
                                  
                                        <tr>
                                            <td><%=i+1 %></td>
                                            <td><%=product_detail.get(i).getProduct().getProduct_name() %></td>
                                            <td><%=product_detail.get(i).getColor().getColor_name() %></td>
                                             <td><%=product_detail.get(i).getSize().getSize() %></td>
                                             <td><%=orders_detail.get(i).getQuantity() %></td>
                                               <td><%=(long)Float.parseFloat(orders_detail.get(i).getPrice() )%></td>
                                              
                                                <td><%=(long)total %></td>
                                          
                                        </tr>
                                    <%} %>
                                    
                                   
                                    <tr>
                      
                                        <td colspan="6">Total Bill</td>
                                        
                                        <td><%=(long)totals %></td>
                                    
                                    </tr>

                                </table>
                            </div>
                            <div class="box5">
                                <div class="detail2" style="margin-left: 10px">
                                    <em>Seller</em><br> <em><b style="color: red">
                                                ESENCE</b></em>
                                </div>
                            </div>
                        </div>
                   
                    </div>
                </div>
            </div>
    
            <div class="row">
                  <div class="col-md-12">
                      <div class="copyright" style="background: #fff;">
                          
                      </div>
                  </div>
              </div>  
    </div>
    
    <jsp:include page="footer_admin.jsp"></jsp:include>
</body>
</html>


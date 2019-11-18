<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Chức vụ</title>
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
                                        <form id="frmRole" style="margin-bottom: 10px;">
                                                <label for="role_name">Chưc vụ</label><br>
                                                <input type="text" id="role" name="role_name" required="required"><br>
                                                
                                        </form>     
                                        
                                        <a href='<c:url value="/admin/role"></c:url>' class="item" data-toggle="tooltip" data-placement="top"   id="btnadd" style="border-radius:5px;padding:5px; background-color:lightblue; margin-left:0px;">
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
                                    <table class="table table-data2 " id="tbRole">
                                        <thead>
                                            <tr>
                                                <th>
                                                    <label class="au-checkbox">
                                                        <input type="checkbox" id="chkAll">
                                                        <span class="au-checkmark"></span>
                                                    </label>
                                                </th>
                                                <th>Mã Chưc vụ</th>
                                                <th>Chức Vụ</th>
                                               
                                                <th>Chức năng<button type="button" class=""" id="delete" style="border: 1px solid #000;padding:5px; background-color:lightblue; margin-left:40px;">Xóa Chức Vụ</button></th>
                                               
                                            </tr>
                                        </thead>
                                        <tbody id="listRole">
                                  
                                            <c:forEach items="${list }" var="rs">
												<tr class="tr-shadow" >
													<td ><input class="chkRole" type="checkbox" name="role_id"
														value="${rs.getRole_id()}"></td>
													<td>${rs.getRole_id()}</td>
													<td>${rs.getRole_name()}</td>
													
												    <td>  
												    	<div>   
                                                  		<button class="item edit" data-toggle="tooltip" data-placement="top"  value="${rs.getRole_id() }">
                                                            Xem
                                                        </button>
                                                        <button class="item" data-toggle="tooltip" data-placement="top" title="view">
                                                            
                                                        </button>
                                                        
                                             
                                                        <button class="item update" data-toggle="tooltip" data-placement="top"  value="${rs.getRole_id() }" id="btnupdate">
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
    

	
	<jsp:include page="footer_admin.jsp"></jsp:include>
</body>
<script src='<c:url value="/resources/js/jquery-3.4.1.min.js"></c:url>'></script>
<script src='<c:url value="/resources/js/addRole.js"></c:url>'></script>
</html>
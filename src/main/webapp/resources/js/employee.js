$("#resetText").click(function() {
	
	document.getElementById("frmEmp").reset();
	document.getElementById("searchEmp").reset();
});


$("#delete").click(function() {

	 if (confirm("Xác nhận xóa")) {
		 $("#listEmp input:checked").each(function() {
			 var id=$(this).val();
			var This = $(this);
		
			  $.ajax({
	                url: '/Shop/admin/employees/delete',
	                type: 'get',
	                data: {
	                	employee_id: id,
	                },
          		success: function(value){
          			This.closest("tr").remove();
              		},
          		error: function(){
						
						confirm("Xác nhận xóa");
              		}
              	
	            });
		})
	    }
	    return false;
	
});


$("#chkAll").change(function() {
	if(this.checked){
		$("#listEmp input").each(function() {
			$(this).attr("checked",true);
		})
		
	}else{
			$("#listEmp input").each(function() {
				$(this).attr("checked",false);
			})
		}
	
}
);

$(".edit").click(function(){
	var employee_id =$(this).attr("value");   
	var fullname =$(this).closest("tr").find("td:eq(2)").text();
	var address =$(this).closest("tr").find("td:eq(3)").text();
	var sex =$(this).closest("tr").find("td:eq(5)").text();
	var idcard =$(this).closest("tr").find("td:eq(6)").text();
	
	//var tt = $("#role_name").val();
	var role_id =$(this).closest("tr").find("td:eq(8)").text();
	var email =$(this).closest("tr").find("td:eq(9)").text();
	var username =$(this).closest("tr").find("td:eq(10)").text();
	var password =$(this).closest("tr").find("td:eq(11)").text();
	
	
	$("#employee_id").val(employee_id);
	$("#fullname").val(fullname);
	$("#address").val(address);
	$("#sex").val(sex);
//	if(sex==0){
//		$("#sex").val("Nam");
//	}else if(sex==1){
//		$("#sex").val("Nữ");
//	}else{
//		$("#sex").val("Giới tính :))");
//	}
//	
	
	$("#idcard").val(idcard);
	
	
	$("#role_name").val(role_id);
	
	$("#email").val(email);
	$("#username").val(username);
	$("#password").val(password);
});

//Thêm
$("#btnadd").click(function(event){
	event.preventDefault();
	var empFrm = $("#frmEmp").serializeArray();
	emp= {};
	
	$.each(frmEmp, function(i, field) {
		emp[field.name] = field.value;
	});
	
	$.ajax({
		url : '/Shop/admin/employees/add',
		type : 'POST',
		data : {
			employeeJson : JSON.stringify(emp), // ĐỔi kiểu mảng về kiểu String
		},
		success : function(value){
			
		},
		error : function(){
			alert("Thêm thất bại")
		},
	});
	console.log(JSON.stringify(emp));
//	location.reload();
});
$(".update").click(function(event){
	event.preventDefault();
	var employee_id = $(".chkEmp").val();
	var empFrm = $("#frmEmp").serializeArray();
	emp= {};
	
	$.each(frmEmp, function(i, field) {
		emp[field.name] = field.value;
	});
		emp["employee_id"] = employee_id;
	$.ajax({
		url : '/Shop/admin/employees/update',
		type : 'POST',
		data : {
			employeeJson : JSON.stringify(emp), // ĐỔi kiểu mảng về kiểu String
		},
		success : function(value){
			
		},
		error : function(){
			alert("Cập nhật thất bại")
		},
	});
	console.log(JSON.stringify(emp));
	location.reload();
});







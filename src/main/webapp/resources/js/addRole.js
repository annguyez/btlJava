

//Đặt lại thông tin form về ban đầu
$("#reset").click(function() {
	
	document.getElementById("frmRole").reset();
});

$("#btnadd")
		.click(
				function(event) {
					event.preventDefault();
					var roleFrm = $("#frmRole").serializeArray();
					role = {};
					
					$.each(frmRole, function(i, field) {
						role[field.name] = field.value;
					});
					
						$.ajax({

								url : ' /Shop/admin/role/role', 
								type : 'POST',
								data : {
									roleJson : JSON.stringify(role),
								},
								success : function(value) {
									
								},
								error : function() {
									alert("fail");
								}
							});
					console.log(JSON.stringify(role));
					
				});


$("#delete").click(function() {

	 if (confirm("Xác nhận xóa")) {
		 $("#listRole input:checked").each(function() {
			 var id=$(this).val();
			 alert(id);
			var This = $(this);
		
			  $.ajax({
	                url: '/Shop/admin/role/delete',
	                type: 'get',
	                data: {
	                	role_id: id,
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
		$("#listRole input").each(function() {
			$(this).attr("checked",true);
		})
		
	}else{
			$("#listRole input").each(function() {
				$(this).attr("checked",false);
			})
		}
	
}
);



//$("#getinfo").click(function(){
//	var size_id =$("#size_id").val();
//	
//	$.ajax({
//		url : '/Shop/admin/size/size',
//		type : 'get',
//		contentType : false,
//		data :{
//			size_id :size_id
//		},
//		success : function(size) {
//			console.log(size);
//			$("#szie_name").val( size.size_name);
//			
//		},
//		error : function() {
//			alert("không có sản phẩm này");
//		}
//
//	});
//	console.log(JSON.stringify(size));
//	
//});



$(".edit").click(function(){
	var role_id =$(this).attr("value");   
	var role =$(this).closest("tr").find("td:eq(2)").text();
	$("#role").val(role);
	

});

$(".update")// chỉ bắt cho class
.click(
		function(event) {
			event.preventDefault();
			var role_id =$(this).attr("value");  
			var roleFrm = $("#frmRole").serializeArray();
			size = {};
			var role_id =$(this).attr("value");   
			$.each(frmRole, function(i, field) {
				role[field.name] = field.value;
				//size["size_id"] = size_id;
			});
			role["role_id"] = role_id;
				$.ajax({

						url : ' /Shop/admin/role/update', 
						type : 'POST',
						data : {
							roleJson : JSON.stringify(role),
						},
						success : function(value) {
							
						},
						error : function() {
							alert("fail");
						}
					});
				
			console.log(JSON.stringify(role));
			
			alert(role_id);
			location.reload();
		});
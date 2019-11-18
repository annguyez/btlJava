$("#btnadd").click(function(event){
	event.preventDefault();//k load lại trang
	var colorFrm = $("#frmColor").serializeArray();// Lấy tất cả thông ti trong form có id:frmColor dưới dạng mảng
	color= {};
	//Duyệt vòng lặp gắn tên key thành tên trường
	$.each(frmColor, function(i, field) {
		color[field.name] = field.value;
	});
	
	$.ajax({
		url : ' /Shop/admin/color/color',
		type : 'POST',
		data : {
			colorJson : JSON.stringify(color), // ĐỔi kiểu mảng về kiểu String
		},
		success : function(value){
			
		},
		error : function(){
			alert("Thêm thất bại")
		},
	});
	console.log(JSON.stringify(color));
	location.reload();
});


//Đặt lại thông tin form về ban đầu
$("#reset").click(function() {
	
	document.getElementById("frmColor").reset();
});



$("#delete").click(function() {

	 if (confirm("Xác nhận xóa")) {
		 $("#listColor input:checked").each(function() {
			 var id=$(this).val();
			var This = $(this);
		
			  $.ajax({
	                url: '/Shop/admin/color/delete',
	                type: 'get',
	                data: {
	                	color_id: id,
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
		$("#listColor input").each(function() {
			$(this).attr("checked",true);
		})
		
	}else{
			$("#listColor input").each(function() {
				$(this).attr("checked",false);
			})
		}
	
}
);



//$("#getinfo").click(function(){
//	var size_id =$("#color_id").val();
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
	var color_id =$(this).attr("value");   
	var color_name =$(this).closest("tr").find("td:eq(2)").text();
	$("#color_name").val(color_name);

});

$(".update").click(function(event){
	event.preventDefault();
	var color_id =$(this).attr("value");  
	var color_name= $("#color_name").val();
	if(color_name==""){
		alert("Chưa nhập màu");
		return;
	}
	var colorFrm = $("#frmColor").serializeArray();
	color = {};
	
	$.each(frmColor, function(i, field) {
		color[field.name] = field.value;
		//size["size_id"] = size_id;
	});
	color["color_id"] = color_id;
		$.ajax({

				url : ' /Shop/admin/color/update', 
				type : 'POST',
				data : {
					colorJson : JSON.stringify(color),
				},
				success : function(value) {
					
				},
				error : function() {
					alert("fail");
				}
			});
		
	console.log(JSON.stringify(color));
	
	location.reload();

});


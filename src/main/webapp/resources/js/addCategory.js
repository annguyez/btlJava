$("#btnadd").click(function(event){
	event.preventDefault();//k load lại trang
	var categoryFrm = $("#frmCategory").serializeArray();// Lấy tất cả thông ti trong form có id:frmColor dưới dạng mảng
	category= {};
	//Duyệt vòng lặp gắn tên key thành tên trường
	$.each(frmCategory, function(i, field) {
		category[field.name] = field.value;
	});
	
	$.ajax({
		url : ' /Shop/admin/category_ad/category',
		type : 'POST',
		data : {
			categoryJson : JSON.stringify(category), // ĐỔi kiểu mảng về kiểu String
		},
		success : function(value){
			
		},
		error : function(){
			alert("Thêm thất bại")
		},
	});
	console.log(JSON.stringify(category));
	
});


//Đặt lại thông tin form về ban đầu
$("#reset").click(function() {
	
	document.getElementById("frmCategory").reset();
});



$("#delete").click(function() {

	 if (confirm("Xác nhận xóa")) {
		 $("#listCategory input:checked").each(function() {
			 var id=$(this).val();
	
			var This = $(this);
		
			  $.ajax({
	                url: '/Shop/admin/category_ad/delete',
	                type: 'get',
	                data: {
	                	category_id: id,
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
		$("#listCategory input").each(function() {
			$(this).attr("checked",true);
		})
		
	}else{
			$("#listCategory input").each(function() {
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
	var category_id =$(this).attr("value");   
	var category_name =$(this).closest("tr").find("td:eq(2)").text();
	$("#category_name").val(category_name);
	
	var image =$(this).closest("tr").find("td:eq(3)").text();
	$("#image").val(image);

});

$(".update").click(function(event){
	event.preventDefault();
	var category_id =$(this).attr("value");  
	var categoryFrm = $("#frmCategory").serializeArray();
	category = {};
	
	$.each(frmCategory, function(i, field) {
		category[field.name] = field.value;
		//size["size_id"] = size_id;
	});
	category["category_id"] = category_id;
	category["image"] = "";
		$.ajax({

				url : ' /Shop/admin/category_ad/update', 
				type : 'POST',
				data : {
					categoryJson : JSON.stringify(category),
				},
				success : function(value) {
					alert("Cập nhật thành công");
				},
				error : function() {
					alert("Cập nhật thất bại");
				}
			});
		
	console.log(JSON.stringify(category));
	
	

});


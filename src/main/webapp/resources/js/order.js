$("#resetText").click(function() {
	
	document.getElementById("Search").reset();
});


$("#delete").click(function() {

	 if (confirm("Xác nhận xóa")) {
		 $("#listOrder input:checked").each(function() {
			 var id=$(this).val();
			 alert(id);
			var This = $(this);
		
			  $.ajax({
	                url: '/Shop/admin/order/delete',
	                type: 'get',
	                data: {
	                	order_id: id,
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
		$("#listOrder input").each(function() {
			$(this).attr("checked",true);
		})
		
	}else{
			$("#listOrder input").each(function() {
				$(this).attr("checked",false);
			})
		}
	
}
);


$(".search").click(function(){
	$(".frmSearch").show();
});

$(".edit").click(function(){
	$(".frmOrder_detail").show();
	var order_id =$(this).attr("value");  
	$("#order_id").val(order_id);
	var username =$(this).closest("tr").find("td:eq(2)").text();
	$("#username").val(username);
	
	var phone =$(this).closest("tr").find("td:eq(3)").text();
	$("#phone").val(phone);
	
	var address =$(this).closest("tr").find("td:eq(4)").text();
	$("#address").val(address);
	
	
	
	//var order_status =$(".order_status").val()

	var order_status =$(this).closest("tr").find("td:eq(6)").text();
	
	$("#order_status").val(order_status);
//	if(order_status==0){
//		$("#order_status").val("Chưa xử lý");
//	}
//	if(order_status==1){
//		$("#order_status").val("Đã giao");
//	}if(order_status==2){
//		$("#order_status").val("Hủy đơn");
//	}
//	
	
	
	
	var order_date =$(this).closest("tr").find("td:eq(7)").text();
	$("#order_date").val(order_date);
	
	var note =$(this).closest("tr").find("td:eq(8)").text();
	$("#note").val(note);
	alert(order_status);

});



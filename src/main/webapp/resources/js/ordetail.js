$("#delete").click(function() {

	 if (confirm("Xác nhận xóa")) {
		 $("#listPr input:checked").each(function() {
			 var id=$(this).val(); 
			 alert(id);
			var This = $(this);
		
			  $.ajax({
	                url: '/Shop/admin/order/deletepr',
	                type: 'get',
	                data: {
	                	product_detail_id: id,
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
		$("#listPr input").each(function() {
			$(this).attr("checked",true);
		})
		
	}else{
			$("#listPr input").each(function() {
				$(this).attr("checked",false);
			})
		}
	
}
);
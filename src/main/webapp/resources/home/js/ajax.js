$("#productColor").change(function() {
	var color_id = $("#productColor").val();
	var product_id = $(".product_id").attr("data-product_id");
	alert(color_id  + product_id);
	
	$.ajax({
		url:"/Shop/details/changeSize",
		type: "GET",
		data: {
			product_id: product_id,
			color_id: color_id,
		},
		success: function(value){
			$("#productSize").html(value);
		}
	})

});

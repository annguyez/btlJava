$(".btn-cart").click(function() {
	
	var color_id =$("#productColor").val();
	var size_id = $("#productSize").val();
	var product_id = $(".product_id").attr("data-product_id");
	var quantity = 1;
	var product_detail_id = product_id+"-"+color_id+"-"+size_id;
	$.ajax({
		url:"/Shop/addCart",
		type: "GET",
		data: {
			quantity:quantity,
			product_detail_id:product_detail_id
		},	
		success:function(check){
			if(check=="true"){
				alert("Đã thêm vào giỏ hàng");
				count();
			}else{
				alert("Không đủ số lượng");
			}
		},
		error: function(){
		    alert('Có lỗi xảy ra');
		  }
	})
	
});


function sum() {
	var totalCart =0;
	var total
	$(".product").each(function() {
		 total = getMoneyValue($(this).find(".total").text());
		 totalCart +=parseInt(total);
	});
$(".totalCart").html(formatNumber(totalCart));	
}

$(".delete-cart").click(function() {
	var a = $(this);
	var product_id = $(this).closest("tr").find(".product_id").attr("data-product_id");
	var size_id = $(this).closest("tr").find(".size").attr("data-size_id");
	var color_id = $(this).closest("tr").find(".color").attr("data-color_id");
	$.ajax({
		url:"/Shop/deleteCart",
		type: "GET",
		data: {
			product_id: product_id,
			size_id: size_id,
			color_id: color_id
		},
		success: function(value){
			a.closest("tr").remove();	
			sum();
			
			count();
		}
	})
});





$(window).on('load',function(){
	
	var color_id = $("#productColor").val();
	var product_id = $("#product_id").val();
	 $.ajax({
         url: '/Shop/details/changeSize',
         type: 'get',
         data: {
        	color_id:color_id,
         	product_id: product_id,
         },
   		success: function(options){
   			$("#productSize").html(options);
       	}
     });
});


$("#productColor").change(function() {
	var color_id = $("#productColor").val();
	var product_id = $("#product_id").val();
	 $.ajax({
         url: '/Shop/details/changeSize',
         type: 'get',
         data: {
        	color_id:color_id,
         	product_id: product_id,
         },
   		success: function(options){
   			$("#productSize").html(options);
       	}
     });
});



function formatNumber(num) {
	  return num.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, '$1,')
	}

function getMoneyValue(formattedMoney){
	return parseFloat(formattedMoney.replace(/[,]+/g, ""));
}
$(".totalCart").click(function(){
	alert($(this).text());
	alert(getMoneyValue($(this).text()));
})


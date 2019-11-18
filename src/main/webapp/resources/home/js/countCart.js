
$(".quantity").change(function() {
		This = $(this);
		var quantity = $(this).val();
		var total = parseInt(getMoneyValue(This.closest("tr").find(".total").text()));
		
		var totalCart=parseInt(getMoneyValue($(".totalCart").text()))-total;
		var price = getMoneyValue($(this).closest("tr").find(".price").text());
			total = quantity * parseInt(price);
		totalCart+=total;
		

		var product_detail_id =$(this).closest("div").find(".detail_id").val();
		var old_quantity =$(this).closest("div").find(".old_quantity").val();
		$.ajax({
			url:"/Shop/addCart",
			type: "GET",
			data: {
				quantity:(quantity-old_quantity),
				product_detail_id:product_detail_id
			},	
			success:function(check){
				if(check=="true"){
					This.closest("div").find(".old_quantity").val(quantity);
					This.closest("tr").find(".total").html(formatNumber(total));
					$(".totalCart").html(formatNumber(totalCart));
					count();
					
				}else{
					alert("Không đủ số lượng");
					This.val(old_quantity);
				}
			},
			error: function(){
			    alert('Có lỗi xảy ra');
			  }
		})
		
		
		
		
	})



function sum() {
		var totalCart =0;
		var total
		$(".product").each(function() {
			 total = getMoneyValue($(this).find(".total").text());
			 totalCart +=parseInt(total);
		});
	$(".totalCart").html(formatNumber(totalCart));	
}

$(window).on("load", function() {
	$(".product").each(function() {
		var quantity = $(this).find(".quantity").val();
		var price = $(this).find(".price").text();
		var total = parseInt(quantity) * parseInt(price);
		$(this).find(".total").html(total)+"đ";	
	});
	sum();
	count()
})

function  count(){
	$.ajax({
		url:"/Shop/countCart",
		type: "GET",
		data: {
		},	
		success:function(value){
			if(value>0){
				$(".countCart").text(value);
			}else{
				$(".countCart").text("");
			}
			
		},
	})
	
}

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






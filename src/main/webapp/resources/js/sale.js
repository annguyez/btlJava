$(window).on("load", function() {
	$("#sale_products").empty();
	document.getElementById("frmSale").reset();
	$("#forUpdate").attr("hidden", true);
	$("#btnUpdate").attr("hidden", true);
	$("#btnCancle").attr("hidden", true);

	findby =$("#findby").val();	
	$("#slcommand").val(findby);

	
	current = 1;
	$.ajax({
		url : '/Shop/admin/product/getproductssale',
		type : 'get',
		data : {
			category_id : 0,
			page : 1,
			limit : 15,
		},
		success : function(data) {
			$("#tbProduct tbody").html(data.html);
			page(current, data.total);
		},

	});
	


});




$(document).on(
		"click",
		".btnAddTo",
		function() {
			var product_id = $(this).closest('tr').find("td:eq(0)").text();
			var product_name = $(this).closest('tr').find("td:eq(1)").text();
			var product = "";
			product += "<div class='row-bottom product'>";
			product += "<div class='c2 product_id'>" + product_id + "</div>";
			product += "<div class='c7 product_name'>" + product_name
					+ "</div>";
			product += "<div class='c1'>"
					+ "<button type='button' class='remove'>Xóa</button>"
					+ "</div>";
			product += "<div class='clr'></div>";
			product += "</div>";
			$("#sale_products").append(product);

		});

$(document).on("click", ".remove", function() {
	$(this).closest('.product').remove();
});

$("#btnReset").click(function() {

	$("#sale_products").empty();
	document.getElementById("frmSale").reset();

});

$("#btnCancle").click(function() {
	$("#sale_products").empty();
	document.getElementById("frmSale").reset();
	$("#forUpdate").attr("hidden", true);
	$("#btnUpdate").attr("hidden", true);
	$("#btnCancle").attr("hidden", true);
	$("#btnAdd").attr("hidden", false);
	$("#btnReset").attr("hidden", false);
	$("#command").val("add");

});

function add() {
	sale = {};
	sale["sale_name"] = $("#sale_name").val();
	sale["sale_start"] = $("#sale_start").val();
	sale["sale_end"] = $("#sale_end").val();
	sale["discount"] = $("#discount").val();
	if (validate(sale)) {
	sale["descriptions"] = $("#descriptions").val();
	product_list = [];

	$("#sale_products>.product").each(function() {

		product = {};

		product["product_id"] = $(this).find(".product_id").text();
		product_list.push(product);
	});

	sale["products"] = product_list;
	
		$
				.ajax({

					url : '/Shop/admin/sale/add',
					type : 'post',
					data : {
						saleJson : JSON.stringify(sale),
					},
					success : function(image) {
						alert("Thêm thành công khuyến mãi");

					},
					error : function() {
						alert("Thêm khuyến mãi thất bại, vui lòng kiểm tra lại thông tin sản phẩm");
					}
				});
	}
}

function getInfor(sale_id) {

	$.ajax({
		url : '/Shop/admin/sale/update',
		type : 'get',
		data : {
			sale_id : sale_id
		},
		success : function(sale) {
			$("#command").val("update");
			$("#forUpdate").attr("hidden", false);
			$("#btnUpdate").attr("hidden", false);
			$("#btnCancle").attr("hidden", false);
			$("#btnAdd").attr("hidden", true);
			$("#btnReset").attr("hidden", true);

			$("#sale_id").val(sale.sale_id);
			$("#sale_name").val(sale.sale_name);
			$("#sale_start").val(sale.sale_start);
			$("#sale_end").val(sale.sale_end);
			$("#discount").val(sale.discount);
			$("#descriptions").val(sale.descriptions);

			var details = sale.products;
			$("#sale_products").empty();
			for (i = 0; i < details.length; i++) {
				var product = "";
				product += "<div class='row-bottom product'>";
				product += "<div class='c2 product_id'>"
						+ details[i].product_id + "</div>";
				product += "<div class='c7 product_name'>"
						+ details[i].product_name + "</div>";
				product += "<div class='c1'>"
						+ "<button type='button' class='remove'>Xóa</button>"
						+ "</div>";
				product += "<div class='clr'></div>";
				product += "</div>";
				$("#sale_products").append(product);
			}
		},
		error : function() {
			alert("Không tìm thấy khuyến mãi này");
		}

	});

}

//$(".sale").click(function() {
//	var sale_id = $(this).closest('tr').find("td:eq(1)").text();
//	getInfor(sale_id);
//
//});

$(".sale_id_search").click(function() {
	var sale_id = $(this).text();
	getInfor(sale_id);

});

$("#search").click(function() {

	var sale_id = $("#search_id").val();
	getInfor(sale_id);
})

function update() {
	sale = {};
	sale["sale_id"] = $("#sale_id").val();
	sale["sale_name"] = $("#sale_name").val();
	sale["sale_start"] = $("#sale_start").val();
	sale["sale_end"] = $("#sale_end").val();
	sale["discount"] = $("#discount").val();
	if (validate(sale)) {
	sale["descriptions"] = $("#descriptions").val();
	product_list = [];

	$("#sale_products>.product").each(function() {

		product = {};

		product["product_id"] = $(this).find(".product_id").text();
		product_list.push(product);
	});

	sale["products"] = product_list;
	
		$.ajax({

			url : '/Shop/admin/sale/update',
			type : 'post',
			data : {
				saleJson : JSON.stringify(sale),
			},
			success : function(image) {
				alert("Cập nhật thành công khuyến mãi");

			},
			error : function() {
				alert("Kiếm tra lại thông tin");
			}
		});
	}

}

function validate(sale) {

	if (sale.sale_name == "")
		return false;
	if (sale.sale_start == "")
		return false;
	if (sale.sale_end == "")
		return false;
	if(sale.sale_start>sale.sale_end)
		{
			alert("Ngày bắt đầu phải nhỏ hơn hoặc bằng ngày kết thúc");
			return false;
		}
	if (sale.discount == "")
		return false;
	return true;

}

$("#frmSale").submit(function() {
	command = $("#command").val();
	if (command == "add") {
		add();
	} else {
		if (command == "update")
			update();
	}
	return false;
})

$("#category_id").change(function() {
	category_id = $("#category_id").val();
	current = 1;
	$.ajax({
		url : '/Shop/admin/product/getproductssale',
		type : 'get',
		data : {
			category_id : category_id,
			page : 1,
			limit : 15,
		},
		success : function(data) {
			$("#listProduct").html(data.html);
			page(current, data.total);
		},

	});
});

$(document).on("click", ".page-item", function() {
	current = $(this).find('a').text();
	current = parseInt(current);
	category_id = $("#slcategory_id").val();
	$.ajax({
		url : '/Shop/admin/product/getproductssale',
		type : 'get',
		data : {
			category_id : category_id,
			page : current,
			limit : 15,
		},
		success : function(data) {
			$("#listProduct").html(data.html);
			page(current, data.total);
		},

	});

});

// Xử lý phân trang
function page(current, total) {

	var i = current - 3;
	if (i < 1)
		i = 1;
	var j = current + 3;
	if (j > total)
		j = total;
	var pagination = "";
	$("#pag_product").empty();
	for (; i <= j; i++) {
		if (i == current)
			pagination += ' <li class="page-item active"><a class="page-link" href="#">'
					+ i + '</a></li>';
		else
			pagination += ' <li class="page-item"><a class="page-link" href="#">'
					+ i + '</a></li>';
	}
	$("#pag_product").append(pagination);
}




$("#chkAll").change(function() {
	if(this.checked){
		$("#tbSale input").each(function() {
			$(this).attr("checked",true);
		})
		
	}else{
			$("#tbSale input").each(function() {
				$(this).attr("checked",false);
			})
		}
}
);

$("#delete").click(function() {

	 if (confirm("Xác nhận xóa")) {
		 $("#tbSale input:checked").each(function() {
			 var id=$(this).val();
			var This = $(this)
			 This.closest("tr").remove;
			  $.ajax({
	                url: '/Shop/admin/sale/delete',
	                type: 'get',
	                data: {
	                	sale_id: id,
	                },
             		success: function(value){
             			This.closest(".sale").remove();
                 		},
             		error: function(){
					alert("Đã xảy ra lỗi");
                 		}
	            });
		})
	    }
	    return false;
	
});



$(window).on("load", function() {
	$(".sale").each(function() {
		var start_date = $(this).find("td:eq(3)").text();
		date = new Date(start_date)
		$(this).find("td:eq(3)").text(date.getDate()+"/"+(date.getMonth()+1)+"/"+date.getFullYear());
		var end_date = $(this).find("td:eq(4)").text();
		date = new Date(end_date)
		$(this).find("td:eq(4)").text(date.getDate()+"/"+(date.getMonth()+1)+"/"+date.getFullYear());
		

	
	})

});
$(window).on('load', function() {

	$.ajax({
		url : '/Shop/admin/product/add',
		success : function(data) {
			$("#manage").html(data);
			convertMoney();
		}
	});

	current = 1;
	$.ajax({
		url : '/Shop/admin/product/getproducts',
		type : 'get',
		data : {
			category_id : 0,
			page : 1,
			limit : 15,
		},
		success : function(data) {
			$("#listProduct").html(data.html);
			page(current, data.total);
		},

	});
});

$("#chkAll").change(function() {
	if (this.checked) {
		$("#listProduct input").each(function() {
			$(this).attr("checked", true);
		})

	} else {
		$("#listProduct input").each(function() {
			$(this).attr("checked", false);
		})
	}

});

$("#delete")
		.click(
				function() {

					if (confirm("Xác nhận xóa")) {
						$("#listProduct input:checked")
								.each(
										function() {
											var id = $(this).val();
											var This = $(this)
											This.closest("tr").remove;
											$
													.ajax({
														url : '/Shop/admin/product/delete',
														type : 'get',
														data : {
															product_id : id,
														},
														success : function(
																value) {
															This.closest(
																	".product")
																	.remove();
														},
														error : function() {
															alert("Sản phẩm có mã "
																	+ id
																	+ " đã được đặt hàng,\n cần xóa các đơn hàng của sản phẩm này trước");
															confirm("Xác nhận xóa");
														}
													});
										})
					}
					return false;

				});

$(document).on(
		"click",
		".view",
		function() {
			var product_id = $(this).closest("div").closest(".product").find(
					'.product_id').text();
			$("#product_id").val(product_id);
			getInfor(product_id);
		});

function getInfor(product_id) {
	$("#image").val("");
	$.ajax({
		url : '/Shop/admin/product/update',
		type : 'get',
		data : {
			product_id : product_id
		},
		success : function(product) {
			$("#command").val("update");
			$("#btnupdate").removeAttr("hidden");
			$("#back").removeAttr("hidden");

			$("#btnadd").attr("hidden", "true");
			$("#reset").attr("hidden", "true");
			$("#product_name").val(product.product_name);
			$("#category_id").val(product.category_id);
			$("#price").val(product.price);
			$("#descriptions").val(product.descriptions);
			$("#oldimg").val(product.image);
			$("#url").attr("href",
					'http://localhost:8080/Shop/' + product.image)
			$("#img-url").attr("src",
					'http://localhost:8080/Shop/' + product.image)
			$("#url").removeAttr("hidden");
			$("#detail_container").empty();
			var details = product.products_detail;
			for (i = 0; i < details.length; i++) {
				var clone = $("#product_detail").clone(true, true).removeAttr(
						"id");
				clone.find("#color_id").val(details[i].color_id);
				clone.find("#size_id").val(details[i].size_id);
				clone.find("#quantity").val(details[i].quantity);
				$("#detail_container").append(clone);
			}
		},
		error : function() {
			alert("không có sản phẩm này");
		}

	});

}

$(document).on("click", ".page-item", function() {
	current = $(this).find('a').text();
	current = parseInt(current);
	category_id = $("#slcategory_id").val();
	$.ajax({
		url : '/Shop/admin/product/getproducts',
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

$("#slcategory_id").change(function() {
	category_id = $("#slcategory_id").val();
	current = 1;
	$.ajax({
		url : '/Shop/admin/product/getproducts',
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

function page(current, total) {

	var i = current - 3;
	if (i < 1)
		i = 1;
	var j = current + 3;
	if (j > total)
		j = total;
	var pagination = "";
	$(".pagination").empty();
	for (; i <= j; i++) {
		if (i == current)
			pagination += ' <li class="page-item active"><a class="page-link" href="#">'
					+ i + '</a></li>';
		else
			pagination += ' <li class="page-item"><a class="page-link" href="#">'
					+ i + '</a></li>';
	}
	$(".pagination").append(pagination);
}

function formatNumber(num) {
	return num.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, '$1,')
}

function getMoneyValue(formattedMoney) {
	return parseFloat(formattedMoney.replace(/[,]+/g, ""));
}

function convertMoney() {

	$(".money").each(function() {
		$(this).html(formatNumber($(this).text()));
	})

}

$(document).on("change", "#listProduct", function() {
	alert("ok");
	convertMoney()
});
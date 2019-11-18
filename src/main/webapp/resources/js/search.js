$(window).on("load", function() {
	category_id =$("#category_id").val();
	$("#slcategory_id").val(category_id);
	orderby=$("#orderby").val();
	$("#slorderby").val(orderby);
})

$("#btnSearch").click(function(){
	
	var page=$("#page").val();
	if(page==""){
		page = 1;
	}
	
	var category_id=$("#slcategory_id").val();
	if(category_id==""){
		category_id =0;
	}
	
	var minPrice=$("#minPrice").val();
	if(minPrice==""||minPrice<0){
		minPrice = 0;
	}
	var maxPrice=$("#maxPrice").val();
	if(maxPrice==""||maxPrice<0){
		maxPrice = 0;
	}
	
	var orderby=$("#slorderby").val();
	if(orderby==""){
		orderby = 1;
	}

	var name=$("#name").val();
	if(name==""){
		name = "";
		var url = "/Shop/search/"+category_id+"/"+minPrice+"/"+maxPrice+"/"+orderby+"/"+page;
	}
	
	var url = "/Shop/search/"+category_id+"/"+minPrice+"/"+maxPrice+"/"+name+"/"+orderby+"/"+page;
	$(location).attr('href',url);
	
});



$("#slorderby").change(function(){
	
	var page=$("#page").val();
	if(page==""){
		page = 1;
	}
	
	var category_id=$("#slcategory_id").val();
	if(category_id==""){
		category_id =0;
	}
	
	var minPrice=$("#minPrice").val();
	if(minPrice==""||minPrice<0){
		minPrice = 0;
	}
	var maxPrice=$("#maxPrice").val();
	if(maxPrice==""||maxPrice<0){
		maxPrice = 0;
	}
	
	var orderby=$("#slorderby").val();
	if(orderby==""){
		orderby = 1;
	}

	var name=$("#name").val();
	if(name==""){
		name = "";
		var url = "/Shop/search/"+category_id+"/"+minPrice+"/"+maxPrice+"/"+orderby+"/"+page;
	}
	
	var url = "/Shop/search/"+category_id+"/"+minPrice+"/"+maxPrice+"/"+name+"/"+orderby+"/"+page;
	$(location).attr('href',url);
	
});
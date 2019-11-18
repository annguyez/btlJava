function formatNumber(num) {
  return num.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, '$1,')
}

function getMoneyValue(formattedMoney){
	return parseFloat(formattedMoney.replace(/[,]+/g, ""));
}



$(window).on("load", function() {

	
		$(".money").each(function(){
			$(this).html(formatNumber($(this).text()));
		})
	
})
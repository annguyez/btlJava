
$("#button").click(function(){
	files = $("#image")[0].files;
	forms = new FormData();   
	forms.append("file",files[0]);
	 $.ajax({
         url: '/Shop/upload/productImg',
         type: 'post',
         contentType: false,
         data: forms,
         enctype: 'multipart/form-data',
         processData:false,
         
   		success: function(){
   		
       		}
   		
     });
	 
});

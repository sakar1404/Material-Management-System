$(document).ready(function(){
	$.getJSON("GetAllEmployeeJSON",{ajax:true},function(data){
		
		$('#employeeid').append($('<option>').text('-Select-'));
		$.each(data,function(i,item){
			$('#employeeid').append($('<option>').text(item.EMPLOYEENAME).val(item.EMPLOYEEID));	
		});
	});	
$.getJSON("GetAllCategoryJSON",{ajax:true},function(data){
	
	$('#categoryid').append($('<option>').text('-Select-'));
	$.each(data,function(i,item){
		$('#categoryid').append($('<option>').text(item.CATEGORYNAME).val(item.CATEGORYID));	
	});
});	
$('#categoryid').change(function(){
	$.getJSON("GetAllSubCategoryJSON",{ajax:true,categoryid:$('#categoryid').val()},function(data){
		$('#subcategoryid').empty();
		$('#subcategoryid').append($('<option>').text('-Select-'));
		$.each(data,function(i,item){
			  
			$('#subcategoryid').append($('<option>').text(item.SUBCATEGORYNAME).val(item.SUBCATEGORYID));	
		});
	});
});
$('#subcategoryid').change(function(){
	$.getJSON("GetAllProductJSON",{ajax:true,subcategoryid:$('#subcategoryid').val()},function(data){
		$('#productid').empty();
		$('#productid').append($('<option>').text('-Select-'));
		$.each(data,function(i,item){
			  
			$('#productid').append($('<option>').text(item.PRODUCTNAME).val(item.PRODUCTID));	
		});
	});
});
	});
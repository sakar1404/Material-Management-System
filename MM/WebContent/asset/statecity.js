$(document).ready(function(){
$.getJSON("GetAllStatesJSON",{ajax:true},function(data){
	
	$('#epst').append($('<option>').text('-State-'));
	$('#ecst').append($('<option>').text('-State-'));
	$.each(data,function(i,item){
	  
		$('#epst').append($('<option>').text(item.STATENAME).val(item.STATEID));	
		$('#ecst').append($('<option>').text(item.STATENAME).val(item.STATEID));
	});
});	
$('#epst').change(function(){
	$.getJSON("GetAllCitiesJSON",{ajax:true,sid:$('#epst').val()},function(data){
		$('#epct').empty();
		$('#epct').append($('<option>').text('-City-'));
		$.each(data,function(i,item){
			  
			$('#epct').append($('<option>').text(item.CITYNAME).val(item.CITYID));	
		});
	});
});
$('#ecst').change(function(){
	$.getJSON("GetAllCitiesJSON",{ajax:true,sid:$('#ecst').val()},function(data){
		$('#ecct').empty();
		$('#ecct').append($('<option>').text('-City-'));
		$.each(data,function(i,item){
			  
			$('#ecct').append($('<option>').text(item.CITYNAME).val(item.CITYID));	
		});
	});
});
	});
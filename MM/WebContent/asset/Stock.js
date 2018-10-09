function makeTable(data) {
	let htm = '<table border=1>';
	htm += '<tr><th>Employee</th><th>Category</th><th>Sub Category</th><th>Product</th>' 
	htm += '<th>Model no</th><th>Model name</th><th>Rate</th><th>Quantity</th><th>Inventory Level</th>' 
	
	$.each(data, function(i, item) {
		htm+='<tr><td>'+item.EMPLOYEE+'</td><td>'+item.CATEGORY+'</td><td>'+item.SUBCATEGORY+'</td><td>'+item.PRODUCTNAME+'</td><td>'+item.MODELNO+'</td><td>'+item.MODELNAME+'</td><td>'+item.RATE+'</td><td>'+item.STOCK+'</td><td>'+item.INVENTORYLEVEL+'</td></tr>';
	})
	$('#result').html(htm)
}

$('document').ready(function() {
	
	$('#productid').change(function() {
		
		var url = 'FetchAllProductsByProductId?productid=' + $('#productid').val()
		$.getJSON(url, function(data) {
			makeTable(data)
		})
	})
	
});


function makeTable(data) {
	let htm = '<table border=1>';
	htm += '<tr><th>Category</th><th>Subcategory</th><th>Product</th><th>Issue Date</th>' 
	htm += '<th>Issue to</th><th>Purpose</th><th>Quantity</th>' 
	
	$.each(data, function(i, item) {
		htm+='<tr><td>'+item.CATEGORY+'</td><td>'+item.SUBCATEGORY+'</td><td>'+item.PRODUCT+'</td><td>'+item.ISSUEDATE+'</td><td>'+item.ISSUETO+'</td><td>'+item.PURPOSE+'</td><td>'+item.QUANTITY+'</td></tr>'
	})
	$('#result').html(htm)
}
$.getJSON("GetAllEmployeeJSON",{ajax:true},function(data){	
	$('#employeeid').append($('<option>').text('-Select-').val(""));
	$.each(data,function(i,item){
		$('#employeeid').append($('<option>').text(item.EMPLOYEENAME).val(item.EMPLOYEEID));	
	});
});	

$('document').ready(function() {
	
	$('#employeeid').change(function() {
		var url = 'FetchAllIssueByEmployeeId?employeeid=' + $('#employeeid').val()
		$.getJSON(url, function(data) {
			makeTable(data)
		})
	})
	$('#todate').change(function() {
		var url = 'FetchAllIssueByDate?fromdate=' + $('#fromdate').val()+'&todate=' + $('#todate').val()
		$.getJSON(url, function(data) {
			makeTable(data)
		})
	})
$('#productid').change(function() {
		var url = 'FetchAllIssueByProductId?productid=' + $('#productid').val()
		$.getJSON(url, function(data) {
			makeTable(data)
		})
	})
});
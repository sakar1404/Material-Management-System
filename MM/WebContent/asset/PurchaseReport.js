function makeTable(data) {
	let htm = '<table border=1>';
	htm += '<tr><th>Category</th><th>Subcategory</th><th>Product</th>' 
	htm += '<th>Invoice no</th><th>Date of Invoice</th><th>Firm name</th><th>Quantity</th><th>Batch number</th>' 
	htm += '<th>Price</th><th>Total Amount</th></tr>'
	var count=0
	var totalamount=0
	$.each(data, function(i, item) {
		htm+='<tr><td>'+item.CATEGORY+'</td><td>'+item.SUBCATEGORY+'</td><td>'+item.PRODUCT+'</td><td>'+item.INVOICENO+'</td><td>'+item.DATEOFINVOICE+'</td><td>'+item.FIRMNAME+'</td><td>'+item.QUANTITY+'</td><td>'+item.BATCHNO+'</td><td>'+item.PRICE+'</td><td>'+item.TOTALAMOUNT+'</td></tr>'
			count=parseInt(count)+parseInt(item.QUANTITY);
			totalamount=parseInt(totalamount)+parseInt(item.TOTALAMOUNT);
		
	})
	htm+='<tr><td>Quantity</td><td>'+count+'</td></tr>'
		htm+='<tr><td cellspacing=9>Total</td><td>'+totalamount+'</td></tr>'
	$('#result').html(htm)
}
$.getJSON("GetAllEmployeeJSON",{ajax:true},function(data){	
	$('#employeeid').empty();
	$('#employeeid').append($('<option>').text('-Select-').val(""));
	$.each(data,function(i,item){
		$('#employeeid').append($('<option>').text(item.EMPLOYEENAME).val(item.EMPLOYEEID));	
	});
});	

$('document').ready(function() {
	
	$('#employeeid').change(function() {
		var url = 'FetchAllPurchasesByEmployeeId?employeeid=' + $('#employeeid').val()
		$.getJSON(url, function(data) {
			makeTable(data)
		})
	})
	$('#productid').change(function() {
		var url = 'FetchAllPurchaseByProductId?productid=' + $('#productid').val()
		$.getJSON(url, function(data) {
			makeTable(data)
		})
	})
	$('#todate').change(function() {
		var url = 'FetchAllPurchaseByDate?fromdate=' + $('#fromdate').val()+'&todate=' + $('#todate').val()
		$.getJSON(url, function(data) {
			makeTable(data)
		})
	})

});

/* 
 * 
 * [{"TOTALAMOUNT":"225",
 * "FIRMNAME":"abc ltd","EMPLOYEEID":"2","INVOICENO":"abc",
 * "PRICE":"15","QUANTITY":"15","SUBCATEGORYID":"1",
 * "CATEGORYID":"1","DATEOFINVOICE":"2018-06-29","PRODUCTID":"1",
 * "TRANSACTIONID":"2","BATCHNO":"8"}] 
 * 
 */
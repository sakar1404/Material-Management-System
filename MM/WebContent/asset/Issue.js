var data = []
var selectedProductId = null
var availableStock = 0
var inventorylevel = 0

$.getJSON('GetProductQuantity', function(result){ 
	data = result
})

$('document').ready(function() {
	
	$('#productid').change(function() {
		selectedProductId =  $('#productid').val()
		$.each(data, function(i ,item) {
			if(item.PRODUCTID == selectedProductId) {	
				availableStock = item.STOCK
				inventorylevel = item.INVENTORYLEVEL
			}
		})
		$('#valid').html('Available Stock : ' + availableStock)
	})
	
	$('#quantity').keyup(function() {
		var desiredQuantity = $('#quantity').val()
		if(parseInt(availableStock) >= parseInt(desiredQuantity)) {
			if(parseInt(inventorylevel) >=  parseInt(availableStock) - parseInt(desiredQuantity)) {
				
				$('#valid').html('<font color=yellow>Stock Available, But Below Inventory Level</font>')
			} else {
				$('#valid').html('<font color=green>Stock Available</font>')
			}		
		} else {
			$('#valid').html('<font color=red>Not Available</font>')
			$('#btn').disabled=true;
		}
	})
})
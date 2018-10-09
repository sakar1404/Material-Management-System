$(document).ready(function(){
	$('#price').keyup(function(){
		c=($('#price').val())*($('#quantity').val());
		$('#totalamount').html(c)
		console.log(c);
	});
	$('#quantity').keyup(function(){
		c=($('#price').val())*($('#quantity').val());
		$('#totalamount').html(c)
		console.log(c);
	});
	
});

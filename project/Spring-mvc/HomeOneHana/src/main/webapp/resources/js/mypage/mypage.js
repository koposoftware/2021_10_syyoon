/**
 * 
 */



$(document).ready(function(){
	$('#Menu1').click(function(){
		$('#menu2').hide()
		$('#menu1').slideDown()
	})
	$('#Menu2').click(function(){
		$('#menu1').hide()
		$('#menu2').slideDown()
	})
	
})
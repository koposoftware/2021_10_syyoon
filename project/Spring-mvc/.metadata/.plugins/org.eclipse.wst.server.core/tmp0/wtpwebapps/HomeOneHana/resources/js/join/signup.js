/**
 * 
 */
$(document).ready(function(){
	// 전체선택 클릭시 전체선택
	$('#chkAll').click(function(){
		if($('#chkAll').prop("checked")){
			$('.chkEtc').prop("checked", true)
		}else{
			$('.chkEtc').prop("checked", false)
		}
	});
	
	// 체크박스 하나 해제시 전체 체크 해제
	$('.chkEtc').click(function(){
		if($('.chkEtc:checked').length == 4){
			$('#chkAll').prop('checked', true)
		}else{
			$('#chkAll').prop('checked', false)
		}
	});
	
	$('.fpmgBt2').click(function(){
		
		if($('#chkMust1').is(":checked") == true && $('#chkMust2').is(":checked") == true){
			$(location).attr('href', "/HomeOneHana/join"); // 여기 왜 ${}안먹냐
			
		}else{
			alert("필수항목에 반드시 동의하여야 합니다.");
		}
	})
	
})

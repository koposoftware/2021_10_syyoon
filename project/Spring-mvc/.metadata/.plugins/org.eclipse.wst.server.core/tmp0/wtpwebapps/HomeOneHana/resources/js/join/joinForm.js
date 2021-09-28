/**
 * 회원가입 제약사항
 */


$(document).ready(function() {
	$('#useBtn').hide()
	$('#errpwd').hide()
	$('#corpwd').hide()
	$('#errtel').hide()
	$('#cortel').hide()

	//한글입력 안되게 처리
	$("input[name=id]").keyup(function(event) {

		if (!(event.keyCode >= 37 && event.keyCode <= 40)) {
			var inputVal = $(this).val();
			$(this).val(inputVal.replace(/[^a-z0-9]/gi, ''));
		}
	});

	$('#idchkBtn').click(function() {
		//id가 숫자일때 에러처리
		var ckid = isNaN($('input[name=id]').val())
		var userid = $('input[name=id]').val()
		if (ckid == false) {
			$('.modal-body').empty()
			$('.modal-body').text('유효하지 않은 값입니다.ID는 영소문자로 시작해야합니다.')
			// 중복 에러처리
		} else {
			
			$.ajax({
				async: true,
				type: 'POST',
				data: { userId: userid }, // Controller 변수명과 같아야함
				url: '/HomeOneHana/join/idCheck',
				success: function(data) {

					if (data == 1) {
						$('#submitBtn').removeAttr('disabled')
						$('.modal-body').empty()
						$('.modal-body').text('사용중인 ID 입니다!')
						$('#useBtn').hide()

					} else {
						$('.modal-body').empty();
						$('.modal-body').text('사용가능한 ID 입니다.')
						$('#useBtn').show()
					}
				}, error: function() {
					console.log('실패')
				}
			});
		}
	});

	$('#useBtn').click(function() {
		$('input[name=id]').text(userid)
	})
	
	// 아이디 사용불가 시 해당아이디 제거
	$('#closeBtn').click(function() {
		$('input[name=id]').val('')
	})
	
	//비밀번호 일치 체크
	$('#ckpassword').keyup(function(){
		var password = $('#password').val()
		var ck = $('#ckpassword').val()
		if(password !="" && ck !=""){
			if(password == ck){
				$('#corpwd').show()
				$('#errpwd').hide()
				$('#submitBtn').removeAttr('disabled')	
			}else{
				$('#corpwd').hide()
				$('#errpwd').show()
				$('#submitBtn').attr("disabled", "disabled")
			}		
		}
	})
	
	$('#phoneckBtn').click(function(){
		$('#phoneckOkBtn').hide()
		var phNum = $('input[name=phoneNumber]').val()
		
		$.ajax({
			type:'GET'
			, url: '/HomeOneHana/check/sendSMS/'+phNum
			, success:function(data){
				var checkNum = data
				
				$('input[name=phonecertificate]').keyup(function(){
					var certiNum = $('input[name=phonecertificate]').val()
					if(certiNum==""){
						$('#errtel').hide()
						$('#cortel').hide()
						$('#phoneckOkBtn').hide()
					}else if(certiNum == checkNum){
						$('#errtel').hide()
						$('#cortel').show()
						$('#phoneckOkBtn').show()
						$('#submitBtn').removeAttr('disabled')
					}else{
						$('#errtel').show()
						$('#cortel').hide()
						$('#phoneckOkBtn').hide()
						$('#submitBtn').attr("disabled", "disabled")
					}
				})
			},error:function(){
				console.log('Err')
			}
		})
		
	})
	
	
	
	

});















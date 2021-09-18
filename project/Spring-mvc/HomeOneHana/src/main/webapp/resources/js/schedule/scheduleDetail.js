/**
 * 
 */

if(chkFavorite == "none"){
	$('#favorite').css({'background-color':'#e90061'})
	$('#favorite').children().attr('class', 'fas fa-heart fa-lg')
}else{
	$('#favorite').css({'background-color':'#b5b5b5'})
	$('#favorite').children().attr('class', 'far fa-heart fa-lg')
}





	var count=0
	let cnt=0
	for(let home of homenmSet){
		//console.log(home)
		//$('#imgBtns').append('<button id="img'+home+'" class="photobtn">'+home+'</button>')
		$('#mapBtnBox').append('<input type="button" id="'+home+'map" class="mapBtn" value="'+home+'">')
		$('#homemap').append('<p style="margin-right:7px;">'+'#'+home+'</p>')
		count+=1
	}
	
	for(let i in imgList){
		if(i == 0){
			$('.carousel-indicators').append('<li data-target="#carouselExampleIndicators" data-slide-to="'+i+' class="active"></li>')
			$('.carousel-inner').append('<div class="carousel-item active" style="height:100%;"><img class="d-block w-100" src="'+imgList[i].fileurl+'" alt="'+imgList[i].filenm+'"></div>')
		}else{
			$('.carousel-indicators').append('<li data-target="#carouselExampleIndicators" data-slide-to="'+i+'"></li>')
			$('.carousel-inner').append('<div class="carousel-item" style="height:100%;"><img class="d-block w-100" src="'+imgList[i].fileurl+'" alt="'+imgList[i].filenm+'"></div>')				
		}
			
	}
	

	
	
	function favorite(idnm){
		var heart = $('#'+idnm).children().attr('class')
		if(heart == 'far fa-heart fa-lg'){
			//좋아요 안누른 상태
			
			
			$.ajax({
				url:"/HomeOneHana/favorite/add/notice"
				, method:'Get'
				, data: favoriteParam
				, success:function(e){
	
					$('#'+idnm).css({'background-color':'#e90061'})
					$('#'+idnm).children().attr('class', 'fas fa-heart fa-lg')
				},error:function(){
					console.log("err!")
				}
			})
			
			
		}else{//좋아요누른상태
			//fas fa-heart fa-lg
			
			$.ajax({
				url:"/HomeOneHana/favorite/del/notice"
				, method:'Get'
				, data: favoriteParam
				, success:function(e){

					$('#'+idnm).css({'background-color':'#b5b5b5'})
					$('#'+idnm).children().attr('class', 'far fa-heart fa-lg')
				},error:function(){
					console.log("err!")
				}
			})
			
		}
	}
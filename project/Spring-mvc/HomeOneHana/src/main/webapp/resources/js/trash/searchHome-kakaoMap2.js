// 거리구하기
function getDistanceFromLatLonInKm(lat1,lng1,lat2,lng2) {
	function deg2rad(deg) {
		return deg * (Math.PI/180)
	}
	var R = 6371; // Radius of the earth in km
	var dLat = deg2rad(lat2-lat1); // deg2rad below
	var dLon = deg2rad(lng2-lng1);
	var a = Math.sin(dLat/2) * Math.sin(dLat/2) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.sin(dLon/2) * Math.sin(dLon/2);
	var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
	var d = R * c; // Distance in km
	 return d;
}


function getLatLng(addr){
	var geocoder = new kakao.maps.services.Geocoder();
	// 주소로 좌표를 검색합니다
	geocoder.addressSearch(addr, function(result, status) {

	// 정상적으로 검색이 완료됐으면 
	if (status === kakao.maps.services.Status.OK) {
		//좌표반환
		var addrlalo = []
		var coords = new kakao.maps.LatLng(result[0].y, result[0].x);		
		lat1 = result[0].y
		lng1 = result[0].x
		return [lat1, lng1]
	}
		return null
	});
}


/**
	kakao 지도 API
 */
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	mapOption = {
		center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
		level: 3 // 지도의 확대 레벨
	};

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption);

// 검색주소 입력
var addr = document.getElementById('searchAddr').value;
// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();




// 주소로 좌표를 검색합니다
geocoder.addressSearch(addr, function(result, status) {

	// 정상적으로 검색이 완료됐으면 
	if (status === kakao.maps.services.Status.OK) {
		//좌표반환
		var coords = new kakao.maps.LatLng(result[0].y, result[0].x);		
		lat1 = result[0].y
		lng1 = result[0].x
		
		if(searchinfo){// 값이 있으면
			var positions = []
			for (var h = 0; h<hlst.length; h++ ){
				var lat2 = hlst[h].lati
				var lng2 = hlst[h].longs
				var pos = {title: hlst[h].rnadres, latlng: new kakao.maps.LatLng(lat2, lng2)}
				positions.push(pos)
			}
			positions.push({title: addr, latlng:coords})		
			
		}else{ //DB에 값이 없으면
			var positions = []
			for (var h = 0; h<hlst.length; h++ ){
				var lat2 = hlst[h].lati
				var lng2 = hlst[h].longs
				var dist = getDistanceFromLatLonInKm(lat1,lng1,lat2,lng2)
				if(dist<800){
					var pos = {title: hlst[h].rnadres, latlng: new kakao.maps.LatLng(lat2, lng2)}
					positions.push(pos)					
				}
			}
			positions.push({title: addr, latlng:coords})
		}
		
		
		/* 마커그리기 */
		map.setCenter(coords);
		// 마커 이미지의 이미지 주소입니다
		var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
		    
		var marker = new kakao.maps.Marker({});
		
		for (var i = 0; i < positions.length; i ++) {
		    
		    // 마커 이미지의 이미지 크기 입니다
		    var imageSize = new kakao.maps.Size(24, 35); 
		    
		    // 마커 이미지를 생성합니다    
		    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 

			if(positions[i].latlng == coords){
				marker = new kakao.maps.Marker({
			        map: map, // 마커를 표시할 지도
			        position:coords // 마커를 표시할 위치
				 });
				// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
				map.setCenter(coords);
		
				var overlay = new daum.maps.CustomOverlay({
					position: coords,
					disabled: true
				});
		
		
				var wrap = document.createElement('div');
				wrap.className = 'wrap';
				var info = document.createElement('div');
				info.className = 'info';
				var title = document.createElement('div');
				title.className = 'title'
				var star = document.createElement('div');
				star.className = 'star'
		
				var starIcon = document.createElement('i')
				starIcon.classList.add('far')
				starIcon.classList.add('fa-star')
				starIcon.id = 'starIcon'
				star.onclick = function() {
		
					var cls = starIcon.classList.item(0)
					var btn = document.getElementById('starIcon')
					if (cls == 'far') {
						starIcon.classList.replace('far', 'fas')
						btn.style.color = "#fdce2a"
		
					} else {
						starIcon.classList.replace('fas', 'far')
						btn.style.color = "#000"
					}
		
				}
		
		
				var close = document.createElement('div');
				close.className = 'close'
				var closeIcon = document.createElement('i')
				closeIcon.classList.add('fas')
				closeIcon.classList.add('fa-times')
		
				close.onclick = function() {
					overlay.setMap(null);
				}
				var body = document.createElement('body')
				body.classname = "body";
				var desc = document.createElement('div');
				desc.className = 'desc';
				var ellipsis = document.createElement('div')
				ellipsis.className = 'ellipsis'
				ellipsis.innerHTML = addr
		
				desc.append(ellipsis)
				body.append(desc)
				star.append(starIcon)
				close.append(closeIcon)
				title.append(close, star)
				info.append(title, body)
				wrap.append(info)
		
				overlay.setContent(wrap)
		
				daum.maps.event.addListener(marker, 'click', function() {
					overlay.setMap(map);
				});
			}else{
				// 마커를 생성합니다
				marker = new kakao.maps.Marker({
					map: map, // 마커를 표시할 지도
					position: positions[i].latlng, // 마커를 표시할 위치
					title: positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
					image:markerImage
				});	
			}//주소 비교
		}
	
		
	}

});
	





	

		



		




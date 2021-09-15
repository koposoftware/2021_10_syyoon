<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>로드뷰 생성하기</title>
<style>


.roadviewimg {
	width: 1200px;
	height: 500px;
}
</style>

</head>
<body>
	<!-- 로드뷰를 표시할 div 입니다 -->

		<div class="roadviewout">
			<div class="roadviewimg" id="roadview" ></div>
		</div>

	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=fdb0fd8047707bf8af7800399c2f657d&libraries=services,clusterer,drawing"></script>
	<script>
		var roadviewContainer = document.getElementById('roadview'); //로드뷰를 표시할 div
		var roadview = new kakao.maps.Roadview(roadviewContainer); //로드뷰 객체
		var roadviewClient = new kakao.maps.RoadviewClient(); //좌표로부터 로드뷰 파노ID를 가져올 로드뷰 helper객체

		var position = new kakao.maps.LatLng(37.5513725315, 127.0229069644);

		// 특정 위치의 좌표와 가까운 로드뷰의 panoId를 추출하여 로드뷰를 띄운다.
		roadviewClient.getNearestPanoId(position, 50, function(panoId) {
			console.log(panoId)
			roadview.setPanoId(panoId, position); //panoId와 중심좌표를 통해 로드뷰 실행
		});
	</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Page Title</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/raphael_min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/raphael_path_s.korea.js"></script>
<script>
	var sca = '01';
</script>

<style>
#canvas {
	float: left;
	position: relative;
	width: 320px;
	height: 400px;
	margin: 0
}

#south {
	width: 320px;
	height: 400px;
	position: absolute;
	top: 0px;
	left: 0;
}

#canvas h2 {
	padding: 0;
	margin: 0;
	font-size: 12px;
}

#seoul, #gygg, #incheon, #gangwon, #chungbuk, #chungnam, #daejeon,
	#sejong, #jeonbuk, #jeonnam, #gwangju, #gyeongbuk, #gyeongnam, #daegu,
	#busan, #ulsan, #jeju {
	display: none;
	position: absolute;
	height: 16px;
	background-color: #000;
	color: #fff;
	padding: 2px 5px;
	text-align: center;
}

#seoul {
	left: 80px;
	top: 75px;
}

#gygg {
	left: 80px;
	top: 45px;
}

#incheon {
	left: 60px;
	top: 75px;
}

#gangwon {
	left: 150px;
	top: 45px;
}

#chungbuk {
	left: 120px;
	top: 145px;
}

#chungnam {
	left: 60px;
	top: 165px;
}

#daejeon {
	left: 80px;
	top: 165px;
}

#sejong {
	left: 70px;
	top: 145px;
}

#jeonbuk {
	left: 60px;
	top: 205px;
}

#jeonnam {
	left: 60px;
	top: 260px;
}

#gwangju {
	left: 60px;
	top: 260px;
}

#gyeongbuk {
	left: 150px;
	top: 165px;
}

#gyeongnam {
	left: 130px;
	top: 240px;
}

#daegu {
	left: 170px;
	top: 210px;
}

#busan {
	left: 190px;
	top: 250px;
}

#ulsan {
	left: 200px;
	top: 225px;
}

#jeju {
	left: 80px;
	top: 340px;
}
</style>
</head>

<body>
	<div style="width: 100%; height: 400px;">
		<div id="canvas">
			<div id="south"></div>
			<div id="seoul">
				<a href="${pageContext.request.contextPath}/content/springview?travel_season=1&travel_devide=서울"><h2>서울특별시</h2></a>
			</div>
			<div id="gygg">
				<a href="${pageContext.request.contextPath}/content/springview?travel_season=1&travel_devide=gygg"><h2>경기도</h2></a>
			</div>
			<div id="incheon">
				<h2>인천광역시</h2>
			</div>
			<div id="gangwon">
				<h2>강원도</h2>
			</div>
			<div id="chungbuk">
				<h2>충청북도</h2>
			</div>
			<div id="chungnam">
				<h2>충청남도</h2>
			</div>
			<div id="daejeon">
				<h2>대전광역시</h2>
			</div>
			<div id="sejong">
				<h2>세종특별자치시</h2>
			</div>
			<div id="gwangju">
				<h2>광주광역시</h2>
			</div>
			<div id="jeonbuk">
				<h2>전라북도</h2>
			</div>
			<div id="jeonnam">
				<h2>전라남도</h2>
			</div>
			<div id="gyeongbuk">
				<h2>경상북도</h2>
			</div>
			<div id="gyeongnam">
				<h2>경상남도</h2>
			</div>
			<div id="daegu">
				<h2>대구광역시</h2>
			</div>
			<div id="busan">
				<h2>부산광역시</h2>
			</div>
			<div id="ulsan">
				<h2>울산광역시</h2>
			</div>
			<div id="jeju">
				<h2>제주특별자치도</h2>
			</div>
		</div>
	</div>
</body>
</html>
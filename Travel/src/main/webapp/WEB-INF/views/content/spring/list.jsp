<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>□□□ 나의 JSP 페이지 □□□</title>
<link href="${rootPath}/css/top-scroll.css" rel="stylesheet"
	type="text/css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
p#insert {
	margin-left: 40px;
}
</style>
<script>
	$(function() {

		$(".content-body").click(function(e) {

			// id에 설정된 값을 가져오기
			let travel_seq = $(this).attr("id")

			// alert(d_code)
			// 현재 페이지를 /dept/view를 전환하라
			// 주소창에 /dept/view를 입력하여 서버에 전송하라
			// d_code 변수에 값을 실어서 보내라
			document.location.href = "${rootPath}/content/springview?travel_seq=" + travel_seq

		})
		// 현재 보고 있는 화면의 scrollTop 값을 추출하여
		// 변수에 임시 보관
		var preScroll = $(window).scrollTop();
		$(window).scroll(function(e) {
			let curScroll = $(window).scrollTop();
			// 아래방향으로 스크롤을 시도하면
			if (preScroll > curScroll) {
				$("ul.main-menu").css("top", 0)
			} else {
				$("ul.main-menu").css("top", -80)
			}
			preScroll = curScroll
		})

	})
</script>

</head>
<body>
	<section class="dept">
		<%@ include file="/WEB-INF/views/content/spring/list-body.jsp" %>
	</section>
</body>
</html>






<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>나의 홈페이지</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<link href="${rootPath}/css/rbook-main.css?ver=2020-01-14-002"
		rel="stylesheet">
<link href="${rootPath}/css/main-table.css?ver=2020-01-14-001"
		rel="stylesheet">
<link href="${rootPath}/css/color.css?ver=2020-01-14-001"
		rel="stylesheet">
<script>
$(function(){

	// $("#btn-write").click( function() {
	$("#btn-write").click( ()=> {
		document.location.href="${rootPath}/rbook/insert"
	})
	
})


</script>
</head>
<body>
<header>
	<h2>MY READ BOOK</h2>
</header>
<%@ include file="/WEB-INF/views/include/include-nav.jspf" %>
<section id="main-list">
	<table id="main-table">
		<thead>
			<tr>
				<th>사용자ID</th>
				<th>도서코드</th>
				<th>도서이름</th>
				<th>독서일자</th>
				<th>독서시간</th>
				<th>한줄평</th>
				<th>별점</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach begin="1" end="100">
			<tr>
				<td>사용자ID</td>
				<td>도서코드</td>
				<td>도서이름</td>
				<td>독서일자</td>
				<td>독서시간</td>
				<td>한줄평</td>
				<td>별점</td>
			</tr>
			</c:forEach>
		</tbody>
	
	</table>
</section>
<section>
	<div id="main-button">
		<button id="btn-write" 
			class="biz-blue flex-right">독서록 작성</button>
	</div>
</section>




</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>□□□ 나의 JSP 페이지 □□□</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://code.jquery.com/jquery-latest.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote.min.js"></script>
<script src="${rootPath}/js/summernote-ko-KR.min.js"></script>
<script>
$(function() {
	
	$("#btn-write").click(function() {
		document.location.href='${rootPath}/friend/input'
	})
})
</script>
</head>
<header class="jumbotron text-center">
	<h3>친구관리 프로젝트</h3>
</header>
	<ul class="nav">
		<li class="nav-item"><a class="nav-link" href="${rootPath}/">홈으로</a></li>
	</ul>
<body class="container-fluid">
<section>
	<c:choose>
		<c:when test="${BODY == 'FRIEND_INPUT'}">
			<%@ include file="/WEB-INF/views/include/friend_input.jsp" %>
		</c:when>
		<c:when test="${BODY == 'FRIEND_VIEW'}">
			<%@ include file="/WEB-INF/views/include/friend_view.jsp" %>
		</c:when>
		<c:otherwise>
			<%@ include file="/WEB-INF/views/include/friend_list.jsp" %>
			<div class="input-group">
				<div class="input-group-btn">
					<button class="btn btn-primary"
							id="btn-write"
							type="button">친구추가</button>
				</div>
			</div>
		</c:otherwise>
	</c:choose>
</section>

</body>
</html>
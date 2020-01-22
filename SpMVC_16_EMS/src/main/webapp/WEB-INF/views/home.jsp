<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>MY EMS</title>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<link rel="stylesheet" type="text/css" 
		href="${rootPath}/static/css/main.css?ver=2020-01-20-002">
<link rel="stylesheet" type="text/css" 
		href="${rootPath}/static/css/table-list.css?ver=2020-01-20">
<link rel="stylesheet" type="text/css" 
		href="${rootPath}/static/css/email-write.css?ver=2020-01-20">


</head>
<body>
<%@ include file="/WEB-INF/views/include/include-header.jspf" %>
<c:choose>
	<c:when test="${BODY == 'WRITE'}">
		<%@ include file="/WEB-INF/views/body/ems/write.jsp" %>
	</c:when>
	<c:when test="${BODY == 'VIEW'}">
		<%@ include file="/WEB-INF/views/body/ems/view-div.jsp" %>
	</c:when>
	
	
	<c:otherwise>
		<%@ include file="/WEB-INF/views/body/ems/list.jsp" %>
	</c:otherwise>
</c:choose>

</body>
</html>
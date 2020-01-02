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
<link rel="stylesheet" href="${rootPath}/css/main.css?ver=20191125001"
	type="text/css" >
</head>
<body>
<header class= "" id="abc" >
	<h3>매입매출관리</h3>
</header>
<%@ include file="/WEB-INF/views/include/include-nav.jspf" %>

</body>
</html>
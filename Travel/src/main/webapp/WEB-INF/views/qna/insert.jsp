<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />  
<%@ taglib 
	uri="http://www.springframework.org/tags/form" 
	prefix="form" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>□□□ 나의 JSP 페이지 □□□</title>
<style>
 fieldset {
 	width:70%;
 	margin:20px auto;
 	border:1px solid green;
 	border-radius: 10px;
 }
 
 legend {
 	font-weight: bold;
 	font-size:20px;
 }
 
 input,textarea {
 	display: inline-block;
 	width:90%;
 	padding:8px;
 	margin:5px;
 	border-radius: 20px;
 	
 }
 
 input:focus,textarea:focus,button {
 	border:2px solid blue;
 	outline: none;
 }

</style>
</head>
<body>
<fieldset>
	<legend>게시글 작성</legend>
	<form:form modelAttribute="qnaDTO"  autocomplete="on"  class="memo-form">
		<form:input path="qna_date" 
				class="in-box" placeholder="작성일자/작성시각"  /><br/>
		<form:input path="qna_id" 
				class="in-box" placeholder="작성자 id"  /><br/>
		<form:input path="qna_subject" 
				class="in-box" placeholder="제목을 입력하세요"  /><br/>
		<form:textarea path="qna_content" rows="5"/><br/>
		<button>저장</button>
	</form:form>
</fieldset>
</body>
</html>
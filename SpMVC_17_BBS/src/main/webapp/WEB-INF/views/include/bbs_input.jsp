<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form:form>
	<div class="input-group">
		<form:input class="form-control" 
			path="bbs_date" placeholder="날짜"/>
	</div>
	
	<div class="input-group">
		<form:input class="form-control" 
			path="bbs_time" placeholder="시간"/>
	</div>
	
	<div class="input-group">
		<form:input class="form-control" 
			path="bbs_writer" placeholder="작성자"/>
	</div>
	
	<div class="input-group">
		<form:input class="form-control" 
			path="bbs_subject" placeholder="제목"/>
	</div>
	
	
</form:form>
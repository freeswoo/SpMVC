<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table class="view-table">
	<tr>
		<th>받은 Email</th><td>${emailVO.to_email}</td>
		<th>받은사람</th><td>${emailVO.to_name}</td>
	</tr>
	<tr>
		<th>보낸 Email</th><td>${emailVO.fromEmail}</td>
		<th>보낸사람</th><td>${emailVO.fromName}</td>
	</tr>
	<tr>
		<th>보낸날짜</th><td>${emailVO.sendDate}</td>
		<th>보낸시각</th><td>${emailVO.sendTime}</td>
	</tr>
	<tr>
		<th>제목</th><td>${emailVO.subject}</td>
	</tr>
	<tr>
		<td>${emailVO.content}</td>
	</tr>
</table>
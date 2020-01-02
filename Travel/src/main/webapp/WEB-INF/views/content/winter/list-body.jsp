<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" type="text/css"
	href="${rootPath}/css/list-table.css?ver=2019-11-31-001" >
	
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
	div.s-box {
		width:95%;
		margin: 0 auto;
	}
	
	div.s-box input {
		padding:8px;
		width:100%;
	}
</style>	
<article>
	<div class="s-box">
		<form>
			<input name="strText">		
		</form>
	</div>
	<table>
		<tr>
			<th>NO</th>
			<th>장소명</th>
			<th>주소</th>
			<th>전화번호</th>
			<th>장소</th>
			<th>이미지</th>
		</tr>
		<c:choose>
			<c:when test="${empty cList}">
				<tr>
					<td colspan="6">데이터가 없음</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${cList}" var="dto" varStatus="info">
					<tr class="content-body" id="${dto.travel_seq}">
						<td>${info.count}</td>
						<td>${dto.travel_name}</td>
						<td>${dto.travel_addr}</td>
						<td>${dto.travel_tel}</td>
						<td>${dto.travel_devide}</td>
						<td><img src="${dto.travel_imgurl}" /></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
</article>

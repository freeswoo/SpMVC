<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
$(function(){

	$(".bbs_tr").click(function(){
		
		let id = $(this).data('bbs-id')
		document.location.href = "${rootPath}/bbs/view?bbs_id=" + id;
	})
	
})

</script>


<article class="container-fluid">
	<div class='table-responsive'>
	<table class="table table-dark table-striped table-hover">
		<thead>
		<tr>
			<th>No</th>
			<th>작성자</th>
			<th>작성일자</th>
			<th>작성시각</th>
			<th>제목</th>
		</tr>
		</thead>
		<tbody>
		<c:choose>
			<c:when test="${empty BBS_LIST}">
				<tr><td colspan="5">데이터가 없습니다</td></tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="BBS" items="${BBS_LIST}" varStatus="index">
					<tr class="bbs_tr" data-bbs-id="${BBS.bbs_id}">
						<td>${index.count}</td>
						<td>${BBS.bbs_writer}</td>
						<td>${BBS.bbs_date}</td>
						<td>${BBS.bbs_time}</td>
						<td>${BBS.bbs_subject}</td>
					</tr>
					<c:if test="${not empty BBS.bbs_replay}">
						<c:set var="BBS_SUB" value="${BBS.bbs_replay}"/>
						<%@ include file="/WEB-INF/views/include/bbs_replay.jsp" %>
					</c:if>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		</tbody>
	</table>
	</div>
</article>


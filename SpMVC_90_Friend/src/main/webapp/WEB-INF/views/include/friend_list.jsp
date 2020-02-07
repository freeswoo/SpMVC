<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>
$(function() {
	
	$(".friend_tr").click(function() {
		
		let id = $(this).data('friend-id')
		document.location.href = "${rootPath}/friend/view?friend_id=" + id;
	})
})
</script>

<article class="container-fluid">
	<div class="table-responsive">
		<table class="table table-dark table-striped table-hover">
			<thead>
				<tr>
					<th>No</th>
					<th>이름</th>
					<th>전화번호</th>
					<th>휴대폰번호</th>
					<th>주소</th>
					<th>취미</th>
					<th>관계</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${empty FRIEND_LIST}">
						<tr><td colspan="5">데이터가 없습니다</td></tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="FRIEND" items="${FRIEND_LIST}" varStatus="index">
							<tr class="friend_tr" data-friend-id="${FRIEND.friend_id}">
								<td>${index.count}</td>
								<td>${FRIEND.friend_name}</td>
								<td>${FRIEND.friend_tel}</td>
								<td>${FRIEND.friend_hp}</td>
								<td>${FRIEND.friend_addr}</td>
								<td>${FRIEND.friend_hobby}</td>
								<td>${FRIEND.friend_relation}</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
</article>
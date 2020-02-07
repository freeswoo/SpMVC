<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<style>
	.card-header h3 {
		display: inline-block;
		width: auto;
		padding: 5px 15px;
	}
</style>

<article class="card">
	<div class="card-header bg-primary text-white">
		<h3>${friendVO.friend_name}</h3>
	</div>
	<div class="card-body">
		<th>전화번호</th><td>${friendVO.friend_tel}</td>
	</div>
	<div class="card-body">
		<th>휴대폰번호</th><td>${friendVO.friend_hp}</td>
	</div>
	<div class="card-body">
		<th>주소</th><td>${friendVO.friend_addr}</td>
	</div>
	<div class="card-body">
		<th>취미</th><td>${friendVO.friend_hobby}</td>
	</div>
	<div class="card-body">
		<th>관계</th><td>${friendVO.friend_relation}</td>
	</div>
</article>
<div class="btn-group">
	<button type="button" class="btn btn-primary">수정</button>
	<button type="button" class="btn btn-primary">삭제</button>
</div>
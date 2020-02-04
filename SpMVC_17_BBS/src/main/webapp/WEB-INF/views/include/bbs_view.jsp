<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<style>
	.card-header h3 {
		display: inline-block;
		width: auto;
		padding: 5px 15px;
	}
</style>
<article class="card">
	<div class="card-header bg-primary text-white">
			<h3>${bbsVO.bbs_subject}</h3>
			(${bbsVO.bbs_date} : ${bbsVO.bbs_time})
	</div>
	<div class="card-body">
			${bbsVO.bbs_content}
	</div>
	<div class="card-footer bg-success text-white">
			CopyRight &copy; ${bbsVO.bbs_writer}
	</div>
</article>
<div class="btn-group">
	<button type="button" class="btn btn-primary">리스트보기</button>
	<button type="button" class="btn btn-success">수정</button>
	<button type="button" class="btn btn-warning">삭제</button>
	<button type="button" class="btn btn-dark">댓글</button>
</div>

<form:form action="${rootPath}/bbs/replay" 
				modelAttribute="bbsVO">
	<form:textarea 
			path="bbs_content" 
			placeholder="답글을 입력하세요" 
			cols="" 
			rows="10"/> 
	<button class="btn btn-info">답글저장</button>
</form:form>




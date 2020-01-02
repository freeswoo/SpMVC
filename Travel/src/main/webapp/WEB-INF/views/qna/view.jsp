<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<c:set var="rootPath" value="${pageContext.request.contextPath}" /> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>□□□ 나의 JSP 페이지 □□□</title>
<script src="${rootPath}/js/jquery-3.4.1.js"></script>
</head>
<style>
	table{
		width:70%;
		margin:20px auto;
		border-top: 2px solid #252525;
		border-bottom: 1px solid #ccc;
	}
	
	table th {
		text-align : left;
		background-color : #f7f7f7;
		color : #3b3b3b;
	}
	
	table th, table td {
		padding:15px 0 16px 16px;
		border-bottom: 1px solid #ccc;
	}
	
	caption {
		font-size: 25px;
		padding:10px;
		font-weight: bold;
		color: blue;
	}
	
	div.btn-box {
		width:70%;
		margin:5px auto;
		
		display: flex;
		justify-content: center;
		align-items: center;
	}
	
	a.btn {
		border-radius: 3px;
		padding:5px 11px;
		color: #fff;
		display: inline-block;
		background-color: #6b9ab8;
		border : 1px solid #56819d;
		vertical-align: middle;
		text-decoration: none;
		margin:10px;
	}
	
	a.btn:hover {
		/* border:1px solid blue; */
		box-shadow: 5px 5px 8px rgba(80,80,80,0.8)
	}
</style>
<!-- <script>
$(function(){
	$("#btn-update").on("click",function(){
		/*
		새 페이지를 만들어 지금 페이지 위에 겹쳐서 보여라
		뒤로가기를 하면 이전페이지로 돌아가기가 되고
		*/
		document.location.href 
			= "${rootPath}/qna/update?id=${qnaDTO.qna_seq}" 
		
	})
	
	$("#btn-delete").click(function(){
		if(confirm("메모를 삭제합니다!!!")) {
			/*
			현재 페이지를 지우고, 새로운 페이지로 다시 그려라
			뒤로가기를 하면 엉뚱한 페이지(history에 저장된)로 이동
			*/
			let query = "${rootPath}/qna/delete?qna_seq=${qnaDTO.qna_seq}"
			document.location.replace(query)
		}
	})
})
</script> -->

<body>
<table>
	<caption>QnA 게시판</caption>

	<tr>
	<th>SEQ</th><td>${qnaDTO.qna_seq}</td>
	<th>작성자</th><td>${qnaDTO.qna_id}</td>
	</tr>

	<tr>
	<th>작성시각</th><td>${qnaDTO.qna_date}</td>
	</tr>

	<tr>
	<th>제목</th><td colspan="3">${qnaDTO.qna_subject}</td>
	</tr>
	
	<tr>
	<th>세부내용</th><td colspan="3">${qnaDTO.qna_content}</td>
	</tr>

</table>

<br/><br/>
<div class="btn-box">
	<a href="javascript:void(0)" 
			class="btn" id="btn-update">수정</a>
	<a href="javascript:void(0)" 
			class="btn" id="btn-delete">삭제</a>
</div>

</body>
</html>
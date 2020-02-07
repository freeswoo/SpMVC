<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<script>
$(function() {
	$("button.btn-save").click(function() {
		let friend_name = $("#friend_name").val()
		let friend_hp = $("#friend_hp").val()
		let friend_relation = $("#friend_relation").val()
		
		if(friend_name == "") {
			alert("이름은 반드시 입력해야 합니다")
			$("#friend_name").focus()
			return false
		}
		if(friend_hp == "") {
			alert("휴대폰 번호는 반드시 입력해야 합니다")
			$("#friend_hp").focus()
			return false
		}
		if(friend_relation == "") {
			alert("관계 반드시 입력해야 합니다")
			$("#friend_relation").focus()
			return false
		}
		$("form").submit()
	})
})
</script>

<form:form action="${rootPath}/friend/save" modelAttribute="friendVO">

	<div class="form-group">
		<form:input class="form-control"
			path="friend_name" placeholder="이름"/>
	</div>
	
	<div class="form-group">
		<form:input class="form-control"
			path="friend_tel" placeholder="전화번호"/>
	</div>
	
	<div class="form-group">
		<form:input class="form-control"
			path="friend_hp" placeholder="휴대폰번호"/>
	</div>
	
	<div class="form-group">
		<form:input class="form-control"
			path="friend_addr" placeholder="주소"/>
	</div>
	
	<div class="form-group">
		<form:input class="form-control"
			path="friend_hobby" placeholder="취미"/>
	</div>
	
	<div class="form-group">
		<form:input class="form-control"
			path="friend_relation" placeholder="관계"/>
	</div>
	
	<div class="form-group">
		<button class="btn btn-primary btn-save"
			type="button">저장</button>
	</div>
</form:form>
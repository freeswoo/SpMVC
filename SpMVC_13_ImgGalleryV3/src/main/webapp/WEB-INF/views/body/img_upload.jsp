<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  
			prefix="form"%>
<form:form modelAttribute="imageVO">
	<fieldset>

		<legend>이미지 갤러리 작성</legend>
		<div class="input_box">
			<form:input type="text" 
				path="img_title"
				placeholder="제목을 입력하세요" />
		</div>
		<div class="input_box">
			<form:textarea
				path="img_text"
				placeholder="제목을 입력하세요"/>
		</div>
		<div class="input_box">
			<form:hidden path="img_file"/>
			<div id="d_d_box">
				<h3>이미지를 올려놓으세요</h3>
				<img id="img_view" height="95%">
			</div>
		</div>
		
		<c:if test="${!empty imageVO.img_file}">
			<div class="input_box">
				<img src="${rootPath}/images/${imageVO.img_file}" width="100px">
			</div>	
		</c:if>
		
		<c:if test="${!empty imageVO.img_files}">
			<div class="input_box">
				<div class="img_list">
				<c:forEach items="${imageVO.img_files}" var="img">
					<div class="img_view" 
							data-id="${img.img_file_seq}"
							data-pcode="${imageVO.img_seq}">
						<img src="${rootPath}/images/${img.img_file_upload_name}">		
					</div>
				</c:forEach>
				</div>
			</div>
		</c:if>
		
		<div class="input_box">
			<button class="bz-button">저장</button>
			<button	class="bz-button" 
				type="button">
				<a href="${rootPath}/">리스트보기</a></button>
		</div>
	</fieldset>

</form:form>
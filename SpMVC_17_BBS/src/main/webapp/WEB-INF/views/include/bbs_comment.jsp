<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${not empty CMT_LIST}">
	<div class="row">
		<c:forEach var="CMT" items="${CMT_LIST}">
			<div class="col-md-3">
				<div class='card'>
					<div class="card-header">
						<span class="text-primary"><b>${CMT.cmt_writer}</b></span>
					</div>
					<div class="card-body">${CMT.cmt_text}</div>
					<div class="card-footer">${CMT.cmt_date}</div>	
				</div>
			</div>
		</c:forEach>
	</div>
</c:if>
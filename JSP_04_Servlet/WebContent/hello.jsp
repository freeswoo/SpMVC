<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

String st_name = request.getParameter("st_name");
String st_dept = request.getParameter("st_dept");
String st_grade = request.getParameter("st_grade");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/JSP_04_Servlet/hello">

	<lable>이름 : <input name="st_name">
	<lable>학과 : <input name="st_dept">
	<lable>학년 : <input name="st_grade">
	<button>서버로 전송</button>
	
</form>
</body>
</html>
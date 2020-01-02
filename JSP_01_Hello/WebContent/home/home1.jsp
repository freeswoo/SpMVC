<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// java script let(javaScript 가 아님) 코드
	String strName = request.getParameter("strName");
	String strNum1 = request.getParameter("num1");
	String strNum2 = request.getParameter("num2");
	
	int intNum1 = 0;
	int intNum2 = 0;
	try{
		intNum1 = Integer.valueOf(strNum1);
		intNum2 = Integer.valueOf(strNum2);
	} catch(Exception e) {
		
	}
	int intSum = intNum1 + intNum2;
	
%>
<!--
	주석코드
	주석코드를 사용할때 꺽쇠 테그 사용금지
	본문 코드와 겹처서 Web에 보여질때 의도하지 않는 모양으로 나타남
	
	느낌표 기호도 가급적 사용하지 말것 
-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form>
	<p><label>num1</label><input name="num1">
	<p><label>num2</label><input name="num2">
	<p><button>계산</button>
</form>
<h3><%= intSum %></h3>
</body>
</html>
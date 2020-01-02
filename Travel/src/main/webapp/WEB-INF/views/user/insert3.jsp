<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<title>회원가입-계절여행</title>
<script>
   function validate() {
       var re = /^[a-zA-Z0-9]{4,12}$/ // 아이디와 패스워드가 적합한지 검사할 정규식
       var re2 = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
       // 이메일이 적합한지 검사할 정규식

       var id = document.getElementById("user_id");
       var pw = document.getElementById("user_pass");
       var email = document.getElementById("user_email");


       // ------------ 이메일 까지 -----------

       if(!check(re,id,"아이디는 4~12자의 영문 대소문자와 숫자로만 입력")) {
           return false;
       }

       if(!check(re,pw,"패스워드는 4~12자의 영문 대소문자와 숫자로만 입력")) {
           return false;
       }

       if(join.pw.value != join.checkpw.value) {
           alert("비밀번호가 다릅니다. 다시 확인해 주세요.");
           join.checkpw.value = "";
           join.checkpw.focus();
           return false;
       }

       if(email.value=="") {
           alert("이메일을 입력해 주세요");
           email.focus();
           return false;
       }

       if(!check(re2, email, "적합하지 않은 이메일 형식입니다.")) {
           return false;
       }

       if(join.name.value=="") {
           alert("이름을 입력해 주세요");
           join.name.focus();
           return false;
       }
       
       alert("회원가입이 완료되었습니다.");
   }

   function check(re, what, message) {
       if(re.test(what.value)) {
           return true;
       }
       alert(message);
       what.value = "";
       what.focus();
       //return false;
   }
</script>
<style>
   @import url(http://fonts.googleapis.com/earlyaccess/nanumpenscript.css);
   body{font-family: 'Nanum Pen Script';}
</style>
</head>
<body>
<h1 align="center" style="font-size:50px;"><font color="navy"><b>SIGN UP</b></font></h1>
<form name="join" onsubmit="return validate();" action="join" method="post" enctype="text/plain">
   <table width="600" height="400" border="1" align="center" cellspacing="0">
       <tr height="10" align="center">
           <td colspan="2" style="background:navy;" ><font color=white><b>회원기본정보</b></font></td>
       </tr>
       <tr>
           <td><b>아이디:</b></td>
           <td><input type="text" style="width:170px"id="user_id" name="id" maxlength="12" /> ※4-12자의 영문 대소문자와 숫자로만 입력</td>
       </tr>
       <tr>
           <td><b>비번:</b></td>
           <td><input type="password"  style="width:170px"id="user_pass" maxlength="12"/> ※4-12자의 영문 대소문자와 숫자로만 입력</td>
       </tr>
       <tr>
           <td><b>비번확인:</b></td>
           <td><input type="password" style="width:170px" id="checkpw" maxlength="12"/></td>
       </tr>
       <tr>
           <td><b>메일주소:</b></td>
           <td><input type="text" style="width:170px" id="user_email" /> ex)hong513@naver.com</td>
       </tr>
       
       <tr>
           <td><b>이름:</b></td>
           <td><input type="text" style="width:170px" name="user_name" maxlength="12" /></td>
       </tr>
       <tr  height="10" align="center">
           <td colspan="2" style="background:navy;"><font color=white><b>개인정보</b></font></td>
       </tr>
       <tr>
           <td><b>전화번호:</b></td>
           <td><input type="text" style="width:170px" id="user_tel" /> ex)01012345678</td>
       </tr>
       <tr>
           <td><b>생일:</b></td>
           <td>
               <input type="date" style="width:200px" id="user_birth" />
           </td>
       </tr>
       <tr>
           <td><b>관심여행지:</b></td>
           <td><input type="radio" name="inter" value="1">가족여행지</input>
               <input type="radio" name="inter" value="2">커플여행지</input>
               <input type="radio" name="inter" value="3">솔로여행지</input>
               <input type="radio" name="inter" value="4">친구들과함께</input>
           </td>
       </tr>
   </table>
   <center>
       <br/>
       <input type="submit" value="회원가입" style="border-radius:5px; font-s"/>
       <input type="reset" value="다시입력" style="border-radius:5px;" />
   </center>
</form>
</body>
</html>
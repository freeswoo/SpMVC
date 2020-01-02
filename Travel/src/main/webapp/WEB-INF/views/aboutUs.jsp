<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>개발팀 소개</title>
<link href="${rootPath}/css/reset.css" rel="stylesheet" type="text/css" />
<link href="${rootPath}/css/style2.css?20191224ver011" rel="stylesheet" type="text/css" />

<script src="${rootPath}/js/jquery.1.12.4.js">
	
</script>

<script src="${rootPath}/plugins/bxslider/js/jquery.bxslider.js"
	type="text/javascript"></script>
<link href="${rootPath}/plugins/web-fonts-with-css/css/all.css"
	rel="stylesheet" type="text/css" />

<script>
	$(document).ready(function() {
		$('.slider').bxSlider({
			controls : false,
			pager : false,
			auto : true,

		});
	});

	$(function() {
		function slideMenu() {
			var activeState = $("#menu-container .menu-list")
					.hasClass("active");
			$("#menu-container .menu-list").animate({
				left : activeState ? "0%" : "-100%"
			}, 400);
		}
		$("#menu-wrapper").click(function(event) {
			event.stopPropagation();
			$("#hamburger-menu").toggleClass("open");
			$("#menu-container .menu-list").toggleClass("active");
			slideMenu();

			$("body").toggleClass("overflow-hidden");
		});

		$(".menu-list").find(".accordion-toggle").click(
				function() {
					$(this).next().toggleClass("open").slideToggle("fast");
					$(this).toggleClass("active-tab").find(".menu-link")
							.toggleClass("active");

					$(".menu-list .accordion-content").not($(this).next())
							.slideUp("fast").removeClass("open");
					$(".menu-list .accordion-toggle").not(jQuery(this))
							.removeClass("active-tab").find(".menu-link")
							.removeClass("active");
				});
	});
</script>


</head>
<body>

	<div id="menu-container">
		<div id="menu-wrapper">
			<div id="hamburger-menu">
				<span></span><span></span><span></span>
			</div>
			<!-- hamburger-menu -->
		</div>
		<!-- menu-wrapper -->
		<ul class="menu-list accordion">
			<li id="nav2" class="toggle accordion-toggle"><span
				class="icon-plus"></span> <a class="menu-link" href="#">Information</a>
			</li>
			<ul class="menu-submenu accordion-content">
				<li><a class="head" href="/travel/info">사이트 소개</a></li>
				<li><a class="head" href="/travel/aboutUs">About us</a></li>
			</ul>
			<li id="nav2" class="toggle accordion-toggle"><span
				class="icon-plus"></span> <a class="menu-link" href="#">여행지</a></li>
			<ul class="menu-submenu accordion-content">
				<li><a class="head" href="spring.html">봄</a></li>
				<li><a class="head" href="summer.html">여름</a></li>
				<li><a class="head" href="fall.html">가을</a></li>
				<li><a class="head" href="winter.html">겨울</a></li>
			</ul>
			<li id="nav3" class="toggle accordion-toggle"><span
				class="icon-plus"></span> <a class="menu-link" href="#">게시판</a></li>
			<ul class="menu-submenu accordion-content">
				<li><a class="head" href="qna.html">QnA</a></li>
			</ul>
			<li id="nav4" class="toggle accordion-toggle"><span
				class="icon-plus"></span> <a class="menu-link" href="#">회원</a></li>
			<ul class="menu-submenu accordion-content">
				<li><a class="head" href="/travel/user/join">회원가입</a></li>
				<li><a class="head" href="login.html">로그인</a></li>
			</ul>
		</ul>
		<!-- menu-list accordion-->
	</div>

	<div class="overlay"></div>
	<div class="slider">
		<div class="background__01"></div>
		<div class="background__02"></div>
		<div class="background__03"></div>
		<div class="background__04"></div>
	</div>
	<div class="contents">
		<p class="contents__job">TEAM PROJECT # 2019-12-20</p>
		<p class="contents__job">Leader & Support : LIM SUN-WOO</p>
		<p class="birth_tel">1980.01.08. Tel : 010-7167-2877</p>
		<a href="https://github.com/freeswoo"><p class="git">Move to Git hub</p></a>
		<p class="git">Contact E-mail : freeswoo@naver.com</p>
		<p class="contents__job">Design : SON MIN-HO</p>
		<p class="birth_tel">1993.02.22. Tel : 010-2867-9959</p>
		<a href="https://github.com/thsalsgh1234"><p class="git">Move to Git hub</p></a>
		<p class="git">Contact E-mail :  hhjkjm123@naver.com</p>
		<p class="contents__job">Board & All Data : LEE HEE-HYEON</p>
		<p class="birth_tel">1998.02.05. Tel : 010-5264-4329</p>
		<a href="https://github.com/desperateGirl"><p class="git">Move to Git hub</p></a>
		<p class="git">Contact E-mail : gjlhh0205@naver.com</p>
		<p class="contents__job">Merge & Map & Code crop : KIM MIN-WOO</p>
		<p class="birth_tel">1990.10.22. Tel : 010-3483-3421</p>
		<a href="https://github.com/arhrina"><p class="git">Move to Git hub</p></a>
		<p class="git">Contact E-mail : hyoukim@naver.com</p>
	</div>
</body>
</html>

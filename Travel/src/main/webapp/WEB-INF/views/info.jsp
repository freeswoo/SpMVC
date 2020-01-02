<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>계절여행 소개페이지??</title>
<link href="${rootPath}/css/reset.css" rel="stylesheet" type="text/css" />
<link href="${rootPath}/css/style3.css?20191224ver05" rel="stylesheet" type="text/css" />

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
		<p class="contents_name">계절별</p>
		<p class="contents_name">전국 여행지 소개 사이트</p>
		<p class="content">최초 구상</p>
		<p class="content">QnA 게시판에 로그인시 글쓰기와 글 내용 확인, 글 리스트, 게시판 번호매기기,</p>
		<p class="content">회원가입(id, password, 생일, 이름, email, 전화번호, 생일, 주로찾는 정보, 유효성검사), </p>
		<p class="content">, 로그인, 탈퇴, 정보수정,</p>
		<p class="content">분류된 자료를 통해 계절별로 지도 클릭시</p>
		<p class="content">회원정보에 주로 찾는 정보를 참조하여 해당하는 지역의 여행지 정보 제공</p>
		<p class="hidden">실제 구현내용</p>
		<p class="hidden">회원가입(id, password, 이름), 로그인, 로그아웃, QnA게시판에 로그인시 글 쓰기, 글 내용 확인, 계절별 지도 클릭시 해당 지역의 여행지정보를 DB에서 가져와 제공</p>
	</div>
</body>
</html>

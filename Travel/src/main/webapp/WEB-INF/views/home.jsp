<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
   <head>
        <meta charset="utf-8">
        <title>계절여행 소개페이지</title> 
       <link href="${rootPath}/css/reset.css" rel="stylesheet"
             type="text/css" />
       <link href="${rootPath}/css/style.css?20191224ver001" rel="stylesheet"
             type="text/css"/>
       
       <script src="${rootPath}/js/jquery.1.12.4.js">
       </script>
       
       <script src="${rootPath}/plugins/bxslider/js/jquery.bxslider.js"
               type="text/javascript"></script>
      <link href="${rootPath}/plugins/web-fonts-with-css/css/all.css" rel="stylesheet" type="text/css"/>
    
       <script>
        $(document).ready(function(){
            $('.slider').bxSlider({
                controls:false,
                pager:false,
                auto:true,
               
                
            });
        });
    
         $(function() {
        function slideMenu() {
            var activeState = $("#menu-container .menu-list").hasClass("active");
            $("#menu-container .menu-list").animate({left: activeState ? "0%" : "-100%"}, 400);
        }
        $("#menu-wrapper").click(function(event) {
            event.stopPropagation();
            $("#hamburger-menu").toggleClass("open");
            $("#menu-container .menu-list").toggleClass("active");
            slideMenu();

            $("body").toggleClass("overflow-hidden");
        });

        $(".menu-list").find(".accordion-toggle").click(function() {
            $(this).next().toggleClass("open").slideToggle("fast");
            $(this).toggleClass("active-tab").find(".menu-link").toggleClass("active");

            $(".menu-list .accordion-content").not($(this).next()).slideUp("fast").removeClass("open");
            $(".menu-list .accordion-toggle").not(jQuery(this)).removeClass("active-tab").find(".menu-link").removeClass("active");
        });
    });
       </script>
       
       
    </head>
    <body>
        
        <div id="menu-container">
            <div id="menu-wrapper">
                <div id="hamburger-menu"><span></span><span></span><span></span></div>
                <!-- hamburger-menu -->
            </div>
            <!-- menu-wrapper -->
            <ul class="menu-list accordion">
                <li id="nav2" class="toggle accordion"> 
                    <a class="menu-link" href="${rootPath}/">홈으로</a>
                </li>
                <li id="nav2" class="toggle accordion-toggle">
                    <a class="menu-link" href="#">Information</a>
                </li>
                <ul class="menu-submenu accordion-content">
                    <li><a class="head" href="/travel/info">사이트 소개</a></li>
                    <li><a class="head" href="/travel/aboutUs">About us</a></li>
                </ul> 
                <li id="nav2" class="toggle accordion-toggle"> 
                    <span class="icon-plus"></span>
                    <a class="menu-link" href="#">여행지</a>
                </li>
                <ul class="menu-submenu accordion-content">
                    <li><a class="head" href="${rootPath}/content/spring">봄</a></li>
                    <li><a class="head" href="summer.html">여름</a></li>
                    <li><a class="head" href="fall.html">가을</a></li>
                    <li><a class="head" href="${rootPath}/content/winter">겨울</a></li>
                </ul> 
                <li id="nav3" class="toggle accordion-toggle"> 
                    <span class="icon-plus"></span>
                    <a class="menu-link" href="#">게시판</a>
                </li>
                    <ul class="menu-submenu accordion-content">
                        <li><a class="head" href="${rootPath}/qna/list">QnA</a></li>
                    </ul>
                <li id="nav4" class="toggle accordion-toggle"> 
                    <span class="icon-plus"></span>
                    <a class="menu-link" href="#">회원</a>
                </li>
                    <ul class="menu-submenu accordion-content">
                    	<c:if test="${userDTO == null || userDTO.user_id == null}">
							<li><a class="head" href="${rootPath}/user/login">로그인</a>
							<li><a class="head" href="${rootPath}/user/join">회원가입</a>
						</c:if>
							
						<c:if test="${userDTO != null && userDTO.user_id != null}">
							<li><a class="head" href="${rootPath}/user/logout">로그아웃</a>
							<li><a class="head" href="${rootPath}/user/mypage">${userDTO.user_name}님의 페이지로</a>
						</c:if>
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
            <p class="contents__name">계절여행</p>
            <p class="contents__name">Seasonal trip</p>
            <p class="contents__job">TEAM PROJECT # 2019-12-20</p>
            
            <div class="contents__sns">
                <ul class="contents__list">
                    <li>
                        
                        <a href="https://www.facebook.com/" target="_blank">
                        <i class="fab fa-facebook-square"></i>
                        </a>
                    </li>
                    <li>
                        <a href="https://www.twitter.com" target="_blank">
                        <i class="fab fa-twitter-square"></i>
                        </a>
                    </li>  
                    <li>
                        <a href="https://www.instagram.com" target="_blank">
                        <i class="fab fa-instagram"></i>
                        </a>
                    </li>
                    <li>
                        <a href="">
                        <i class="fab fa-blogger-b"></i>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </body>
</html>

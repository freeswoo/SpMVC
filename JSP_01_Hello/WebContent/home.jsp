<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
// 여기는 JSP파일내에 Java 코드를 작성하는 영역
int num1 = 30;
int num2 = 40;
int sum = num1 + num2;
System.out.println(sum);
%>    
<!DOCTYPE html>
<html>
<!-- 
head tag는 페이지에 대한 정보등을 기록하는 부분 
웹페이지에 표시되지는 않지만 웹페이지에 어떤 것을 표시하기 위한
다양한 설정등을 기록하는 부분
-->
<head>
	<meta charset="UTF-8">
	<!-- 웹페이지를 표시할때 제목으로 사용되는 문자열 -->
	<title>나의 첫번째 홈페이지</title>
</head>
<!-- 웹페이지에 나타날 정보들을 표시하는 영역 -->
<!-- 디자인과 관련된 문서표시를 하는 부분 -->
<body>
	<!-- h tag는 h1 ~ h6 까지 사용되며 본문보다 큰 글자를 표시 -->
	<h2>나는 Home.jsp 입니다</h2>
	<h3>반갑습니다</h3>
	<h4>우리나라만세</h4>
	<h4><%= sum %></h4>
	<p>paragraph</p>
	<p>문단tag</p>
	<p>본문tag</p>
	<p>웹페이지에서는 Enter의 의미가 없다.</p>
	<p>한개의 문단내의 문자열이 매우 커서 한줄에 표시가 되지 않을때는
	자동으로 다음줄로 넘겨져서 표시가 된다.
	이러한 현상 Auto Word Wrap 이라고 한다.</p>
	<p>문서를 작성하면서 Enter키를 입력해도
	웹페이지에서는 단지 1개의 빈칸으로 인식한다.
	여러줄에 걸쳐 문서를 작성하기 위해 Enter를 입력하지만
	실제 웹페이지에서 볼때는 단지 1개의 빈칸으로만 인식한다.
	</p>
	<p>문자열을 표시하면서 br tag를 사용하면 해당 위치에서 강제 줄바꿈이 된다.<br/>
	br tag는 임의로 문단내에서 문자열을 여러줄에 표시하고자 할때 사용한다.<br/>
	break 의 약자</p>
	<p> br tag로 줄바꿈을 하면 문단내에서는<br/>
	위아래 여백이 없는 상태로 문자열들이<br/>
	표시된다
	
	<p>우리나라<br/>
	대한민국<br/>
	Republic of Korea</p>
	
	<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nisl tincidunt eget nullam non. Quis hendrerit dolor magna eget est lorem ipsum dolor sit. Volutpat odio facilisis mauris sit amet massa. Commodo odio aenean sed adipiscing diam donec adipiscing tristique. Mi eget mauris pharetra et. Non tellus orci ac auctor augue. Elit at imperdiet dui accumsan sit. Ornare arcu dui vivamus arcu felis. Egestas integer eget aliquet nibh praesent. In hac habitasse platea dictumst quisque sagittis purus. Pulvinar elementum integer enim neque volutpat ac.
Senectus et netus et malesuada. Nunc pulvinar sapien et ligula ullamcorper malesuada proin. Neque convallis a cras semper auctor. Libero id faucibus nisl tincidunt eget. Leo a diam sollicitudin tempor id. A lacus vestibulum sed arcu non odio euismod lacinia. In tellus integer feugiat scelerisque. Feugiat in fermentum posuere urna nec tincidunt praesent. Porttitor rhoncus dolor purus non enim praesent elementum facilisis. Nisi scelerisque eu ultrices vitae auctor eu augue ut lectus. Ipsum faucibus vitae aliquet nec ullamcorper sit amet risus. Et malesuada fames ac turpis egestas sed. Sit amet nisl suscipit adipiscing bibendum est ultricies. Arcu ac tortor dignissim convallis aenean et tortor at. Pretium viverra suspendisse potenti nullam ac tortor vitae purus. Eros donec ac odio tempor orci dapibus ultrices. Elementum nibh tellus molestie nunc. Et magnis dis parturient montes nascetur. Est placerat in egestas erat imperdiet. Consequat interdum varius sit amet mattis vulputate enim.
Sit amet nulla facilisi morbi tempus. Nulla facilisi cras fermentum odio eu. Etiam erat velit scelerisque in dictum non consectetur a erat. Enim nulla aliquet porttitor lacus luctus accumsan tortor posuere. Ut sem nulla pharetra diam. Fames ac turpis egestas maecenas. Bibendum neque egestas congue quisque egestas diam. Laoreet id donec ultrices tincidunt arcu non sodales neque. Eget felis eget nunc lobortis mattis aliquam faucibus purus. Faucibus interdum posuere lorem ipsum dolor sit.</p>
	<p>모든 국민은 법률이 정하는 바에 의하여 선거권을 가진다. 모든 국민은 근로의 의무를 진다. 국가는 근로의 의무의 내용과 조건을 민주주의원칙에 따라 법률로 정한다. 이 헌법시행 당시에 이 헌법에 의하여 새로 설치될 기관의 권한에 속하는 직무를 행하고 있는 기관은 이 헌법에 의하여 새로운 기관이 설치될 때까지 존속하며 그 직무를 행한다.

대통령은 헌법과 법률이 정하는 바에 의하여 공무원을 임면한다. 모든 국민은 법률이 정하는 바에 의하여 납세의 의무를 진다. 국회의원은 현행범인인 경우를 제외하고는 회기중 국회의 동의없이 체포 또는 구금되지 아니한다. 통신·방송의 시설기준과 신문의 기능을 보장하기 위하여 필요한 사항은 법률로 정한다.

국가는 농지에 관하여 경자유전의 원칙이 달성될 수 있도록 노력하여야 하며, 농지의 소작제도는 금지된다. 비상계엄이 선포된 때에는 법률이 정하는 바에 의하여 영장제도, 언론·출판·집회·결사의 자유, 정부나 법원의 권한에 관하여 특별한 조치를 할 수 있다. 대한민국의 국민이 되는 요건은 법률로 정한다.
	
</body>

</html>
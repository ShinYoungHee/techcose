<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Introduction Page</title>
<link rel="stylesheet" type="text/css"
   href="assets/css/accountStyle.css">
</head>
<body>
   <!-- Header 영역 -->
   <h1>Welcome to Smart Auction</h1>


   <a href="FarmPageMain">농부 페이지</a>&nbsp;&nbsp;
   <a href="BoardList">질문답변 게시판</a>&nbsp;&nbsp;
   <a href="gList">경매장</a>&nbsp;&nbsp;
   <a href="Login">로그인</a>&nbsp;&nbsp;
   
   
   <!-- 로그아웃을 위해 추가한부분-->
   <c:if test="${sessionID != null }">
   	${sessionID }님 로그인 중
      <a href="logout.do"><button>로그아웃</button></a>
   </c:if>

   <!-- 오른쪽 끝에 같은 선상에 로그인 버튼 만들기 -->


   <!-- Content 영역 -->
   <img src="assets/images/introPage.jpg" width="800" height="500"
      border="0">
   <!-- Footer 영역 -->
   <hr>
   <p align="center">
      Copyright(C) 2020. <b>Seokyeong University Bit Academy Team4</b> All
      rights reserved.
   </p>
</body>
</html>
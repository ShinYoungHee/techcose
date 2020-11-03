<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link rel="stylesheet" type="text/css"
   href="assets/css/accountstyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>아이디 찾기</title>
</head>

<body style="background-color: #f5f5dc;">

   <!--id_foundReseult1 시작 -->
   <c:if test="${id_foundResult1 == -1 || id_foundResult1 == 0 }">
      <script>
         alert("회원님의 정보가 존재하지 않습니다.");
      </script>
   </c:if>
   <c:if test="${ id_foundResult1 == 1 }">
      <script>
         alert("회원님의 id는 "+sessionID +"입니다!");  //이거 id는 뭐뭐라고 알려주는걸로 바꾸기
      </script>
   </c:if>
   <c:if test="${id_foundResult1!=-1 && id_foundResult1!=1 && id_foundResult1!=0 && id_foundResult1 != null }">
      <script>
         alert("이미 로그인 중입니다.");
      </script>
   </c:if>
   <!--id_foundReseult1 끝 -->

   <!--id_foundReseult2 시작 -->
   <c:if test="${id_foundResult2 == -1 || id_foundResult2 == 0 }">
      <script>
         alert("회원님의 정보가 존재하지 않습니다.");
      </script>
   </c:if>
   <c:if test="${ id_foundResult2 == 1 }">
      <script>
         alert("회원님의 id는 "+sessionID +"입니다!"); //이거 id는 뭐뭐라고 알려주는걸로 바꾸기
      </script>
   </c:if>
   <c:if
      test="${id_foundResult2!=-1 && id_foundResult2!=1 && id_foundResult2!=0 && id_foundResult2 != null }">
      <script>
         alert("이미 로그인 중입니다.");
      </script>
   </c:if>
   <!--id_foundReseult2 끝 -->



   <center>
      <h1>아이디 찾기</h1>
      <div id=f_div>
         <form name="withEmail" action="id_found.do" method="post">
            <p id="f_mail">본인 이메일로 아이디 찾기</p>
            <table id="f_table" align="center">
               <tr>
                  <td>이름 :</td>
                  <td><input type="text" name="name" size="23"
                     style="height: 25px;"></td>
               </tr>
               <tr>
                  <td>이메일 :</td>
                  <td><input type="text" name="email" size="23"
                     style="height: 25px;"></td>
               </tr>
            </table>
            <br /> <input type="submit" value="찾기"> <input type="reset"
               value="취소">
         </form>

         <form name="withPhone" action="id_found.do" method="post">
            <p id="f_mail">전화번호로 아이디 찾기</p>
            <table id="f_table" align="center">
               <tr>
                  <td>이름 :</td>
                  <td><input type="text" name="name" size="23"
                     style="height: 25px;"></td>
               </tr>
               <tr>
                  <td>전화번호 :</td>
                  <td><input type="text" name="phone" size="23"
                     style="height: 25px;"></td>
               </tr>
            </table>
            <br /> <input type="submit" value="찾기"> <input type="reset"
               value="취소">

         </form>
      </div>
   </center>
</body>
</html>
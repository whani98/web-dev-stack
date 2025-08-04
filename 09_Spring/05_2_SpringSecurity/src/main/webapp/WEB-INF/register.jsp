<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원가입</title>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
	<form action="/register" method="post">
	<h1>회원가입</h1>
	<section>
	  <input type="text" id="id" name="id" placeholder=" 아이디" />
	  <p id="resultId">영문자로 시작하고 영문자와 숫자 조합으로 4~12자 이내</p>

	  <input type="password" id="pwd" name="pwd" placeholder=" 비밀번호" />
	  <p id="resultPw">영문자, 숫자, 특수문자 조합으로 8~15자 이내</p>

	  <input type="text" id="name" name="name" placeholder=" 이름" />
	  <p id="resultName">한글 2자 이상</p>
	  
	  <div>
	    <button type="submit" id="join">회원가입</button>
	    <button id="reset">취소</button>
	  </div>
	  
	</section>
</form>
</body>
</html>
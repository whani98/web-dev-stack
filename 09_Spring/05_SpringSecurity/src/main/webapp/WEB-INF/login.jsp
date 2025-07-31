<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인</title>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
	<h1>로그인</h1>
	<div id="form">
	  <div>
	    <input type="text" id="userId" placeholder="아이디를 입력해주세요" />
	  </div>
	  <div>
	    <input type="text" id="password" placeholder="비밀번호를 입력해주세요" />
	  </div>
	  <button type="button" id="login">로그인</button>
	</div>
</body>
</html>
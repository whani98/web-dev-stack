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
	<form action="/login" method="post">
	<h1>로그인</h1>
	    <input type="text" id="id" name="username" placeholder="아이디" /><br/>
	    <input type="password" id="pwd" name="password" placeholder="비밀번호" /><br/>
	  <button type="submit" id="login">로그인</button>
	</form>
</body>
</html>
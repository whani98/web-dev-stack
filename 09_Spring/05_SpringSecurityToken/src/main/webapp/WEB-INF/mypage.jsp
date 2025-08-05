<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>마이 페이지</title>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
	<!-- get, /mypage : 인증된 사람만 즉, 로그인된 사람만-->
	<h1>마이 페이지</h1>
	<p>ID : <sec:authentication property="principal.id"/></p>
	<p><sec:authentication property="principal.name"/>님의 페이지입니다.</p>
	<sec:authorize access="hasRole('ADMIN')">
		<a href="/admin" id="admin">관리자페이지</a><br>
	</sec:authorize>
</body>
</html>
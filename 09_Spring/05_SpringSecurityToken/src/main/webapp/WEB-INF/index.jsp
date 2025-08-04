<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Index</title>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
	<h1>전체 페이지</h1>
	
	<div id="anonymous" style="display: none;">
		<!-- sec : session에 저장되어있기 때문에 사용 가능 -->
		<sec:authorize access="isAnonymous()" >
			<a href="/login">로그인</a><br>
			<a href="/register">회원가입</a><br>
		</sec:authorize>
	</div> 
	
	<div id="authenticated" style="display: none;">
		<!--sec:authorize access="isAuthenticated()" -->
			<a href="/logout">로그아웃</a><br></br>
			<a href="/mypage">마이페이지</a><br>
		<!--/sec:authorize-->
	
		<!--sec:authorize access="hasRole('ADMIN')"-->
			<a href="/admin">관리자페이지</a><br>
		<!--/sec:authorize-->
	</div>

	<script>
		const token = localStorage.getItem("token");
		//alert(token);
		if(token!==null){
			$('#authenticated').show();
		} else {
			$('#anonymous').show();
		}
		
	</script>
</body>
</html>
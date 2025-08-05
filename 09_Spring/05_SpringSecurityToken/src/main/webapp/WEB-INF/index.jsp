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
	<sec:authorize access="isAnonymous()" ></sec:authorize>
	<sec:authorize access="isAuthenticated()"></sec:authorize>
	<sec:authorize access="hasRole('ADMIN')"></sec:authorize>
	
	<div id="anonymous" style="display: none;">
		<a href="/login">로그인</a><br>
		<a href="/register">회원가입</a><br>
	</div> 
	
	<div id="authenticated" style="display: none;">
		<a href="/logout" id="logout">로그아웃</a><br></br>
		<a href="/mypage"id="mypage">마이페이지</a><br>
	</div>

	<a href="/admin" id="admin">관리자페이지</a><br>
	
	<script>
		
		const token = localStorage.getItem("token");
		//alert(token);
		if(token !== null){
			$('#authenticated').show();
			$('#anonymous').hide();
			$('#admin').hide();
			
			$.ajax({
				url: '/check',
				type: 'get',
				data: { token : token },
				success: function(data) {
					// console.log(data);
					// role이 admin일 경우 관리자페이지 보임
					if(data.role === 'ROLE_ADMIN') {
						$('#admin').show();
					}
				}
			})
		} else {
			$('#anonymous').show();
			$('#authenticated').hide();
			$('#admin').hide();
		}
		
		$('#logout').click((e) => {
			e.preventDefault(); // 기존 기능 막기
			localStorage.removeItem("token"); // 토큰 삭제
			location.reload(); // 새로고침
		})
		
		$('#mypage').click((e)=>{
			e.preventDefault(); // 기존 기능 막기
			$.ajax({
				url: '/mypage',
				type: 'get',
				beforeSend: function(xhr) {
					//JwtAuthenticationFilter의 parseBearerToken에서 가져오기
					xhr.setRequestHeader('Authorization', 'Bearer ' + token);
				},
				success: function(data) {
					// console.log(data);
					// SPA:SinglePageApplication->React, Vue
					$('body').html(data);
				}
			})
		})
		
		$('#admin').click((e)=>{
					e.preventDefault(); // 기존 기능 막기
					$.ajax({
						url: '/admin',
						type: 'get',
						beforeSend: function(xhr) {
							// JwtAuthenticationFilter의 parseBearerToken에서 가져오기
							xhr.setRequestHeader('Authorization', 'Bearer ' + token);
						},
						success: function(data) {
							$('body').html(data);
						}
					})
				})
		
	</script>
</body>
</html>
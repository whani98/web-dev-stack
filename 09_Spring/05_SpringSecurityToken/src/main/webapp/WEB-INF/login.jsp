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
	<form action="/login" method="post" id="frm">
	    <input type="text" name="id" id="id" placeholder="아이디" /><br/>
	    <input type="password" name="pwd" id="pwd" placeholder="비밀번호" /><br/>
	  <button type="submit" id="login">로그인</button>
	  </form>
	  <div id="result"></div>
	  
	<script>
		$("#login").click((e) => {
			e.preventDefault(); // 기존 submit 이벤트 제거
			$.ajax({
				url: '/login',
				type: 'post',
				data: $('#frm').serialize(),
				success: function(data) {
					// alert(data); // 토큰 출력
					// localStrage에 token 키 값으로 저장
					localStorage.setItem("token", data);
					// / <- index.jsp로 이동
					location.href = "/";
					
				}
			})
		});
		
	</script>
</body>
</html>
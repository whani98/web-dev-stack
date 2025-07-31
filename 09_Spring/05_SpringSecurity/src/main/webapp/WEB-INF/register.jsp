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
	<h1>회원가입</h1>
	<section>
	  <input type="text" id="id" placeholder=" 아이디를 입력해주세요" />
	  <p id="resultId">영문자로 시작하고 영문자와 숫자 조합으로 4~12자 이내</p>

	  <input type="password" id="pw" placeholder=" 비밀번호를 입력해주세요" />
	  <p id="resultPw">영문자, 숫자, 특수문자 조합으로 8~15자 이내</p>

	  <input
	    type="password"
	    id="pw2"
	    placeholder=" 비밀번호를 다시 한 번 입력해주세요"
	  />
	  <p id="resultPw2">위 비밀번호와 동일하게</p>

	  <input type="text" id="name" placeholder=" 이름을 입력해주세요" />
	  <p id="resultName">한글 2자 이상</p>

	  <input type="text" id="email" placeholder=" 이메일을 입력해주세요" />
	  <p id="resultEmail">이메일 형식</p>

	  <input type="text" id="tel" placeholder=" 전화번호를 입력해주세요" />
	  <p id="resultTel">전화번호 형식</p>
	  <div>
	    <button onclick="join()" id="join">회원가입</button>
	    <button id="reset">취소</button>
	  </div>
	</section>
</body>
</html>
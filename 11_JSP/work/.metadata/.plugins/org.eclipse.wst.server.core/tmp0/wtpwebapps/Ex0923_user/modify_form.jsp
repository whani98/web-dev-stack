<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function update(f) {
		f.action = 'member_modify_fin.do';
		f.submit();
	}
</script>
</head>

<body>
	<form>
		<table border="1">
			<caption>회원 정보 수정</caption>
			<tr>
				<th>회원번호</th>
				<!-- type="hidden"이어야 오류가 안남 -->
				<td>${vo.idx}<input type="hidden" name="idx" value="${vo.idx}" /></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input name="name" value="${vo.name}" /></td>
			</tr>
			<tr>
				<th>아이디</th>
				<td>${vo.id}<input type="hidden" name="id" value="${vo.id}" /></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input name="pwd" value="${vo.pwd}" /></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input name="email" value="${vo.email}" /></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input name="addr" value="${vo.addr}" /></td>
			</tr>
		</table>
		<input type="button" value="수정" onClick="update(this.form);">
		<input type="button" value="취소" onClick="location.href='list.do'">
	</form>
</body>
</html>
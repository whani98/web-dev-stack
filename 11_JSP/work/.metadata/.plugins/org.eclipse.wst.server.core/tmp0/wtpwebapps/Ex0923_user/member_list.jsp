<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>
// 함수 이용해서 삭제하는 방법
function del(idx) {
	// alert(idx);
	
	// 취소 누르면 값 변하지 않고 그대로
	if(!confirm("정말로 삭제하시겠습니까?")){
		return;
	}
	// 확인 누르면 값 삭제
	location.href='member_delete.do?idx='+ idx;
	
}

</script>
</head>
<body>
	<table border="1">
		<tr>
			<th>회원번호</th>
			<th>이름</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이메일</th>
			<th>주소</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="vo" items="${list}">
			<tr>
				<td>${vo.idx}</td>
				<td>${vo.name}</td>
				<td>${vo.id}</td>
				<td>${vo.pwd}</td>
				<td>${vo.email}</td>
				<td>${vo.addr}</td>
				<td><input type="button" value="수정"
					onClick="location.href='member_select_one.do?idx=${vo.idx}'"></td>
				<td><input type="button" value="삭제" onClick="del(${vo.idx})"></td>
			</tr>
		</c:forEach>
	</table>
	<input type="button" value="회원등록"
		onClick="location.href='register_form.jsp'">
</body>
</html>
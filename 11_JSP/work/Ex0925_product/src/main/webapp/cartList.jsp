<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="index.jsp" />
	<table border="1" align="center" width="600">
		<tr bgcolor="#dedede">
			<th>제품 코드</th>
			<th>이미지</th>
			<th width="20%">제품명</th>
			<th width="25%">단가</th>
			<th>수량</th>
			<th colspan="2">금액</th>
		</tr>
		<tr align="center">
			<td>abc123</td>
			<td><img src="images/cookie.gif" height="80px"></td>
			<td>스케이트</td>
			<td>
				단가 : 6000원
				<br>세일가격 : <b>5000원</b>
			</td>

			<td>
			    <form>
					<input type="hidden">
					<input size="3">
					<input type="submit" value="수정">
			     </form>
			</td>
			<td><fmt:formatNumber value="20000"/></td>
			<td><input type="button" value="삭제"></td>
		</tr>
		<tr>
		<td colspan="6" align="right">총 결제액&nbsp;</td>
		<td><fmt:formatNumber value="20000"/></td> 
		</tr>

	</table>

</body>
</html>
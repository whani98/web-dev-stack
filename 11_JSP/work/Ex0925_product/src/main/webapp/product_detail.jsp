<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>product_detail</title>
</head>
<body>
	<form>
		<jsp:include page="index.jsp" />
		<table border="1" align="center" width="600">
			<tr>
				<td colspan="2">
					<b>상세보기</b>
				</td>
			</tr>
			<tr>
				<th width="50%">카테고리</th>
				<td>${vo.category}</td>
			</tr>
			<tr>
				<th>제품코드</th>
				<td>${vo.p_num}</td>
			</tr>
			<tr>
				<th>제품명</th>
				<td>${vo.p_name}</td>
			</tr>
			<tr>
				<th>제조사</th>
				<td>${vo.p_company}</td>
			</tr>
			<tr>
				<th>가격</th>
				<td>
					<del><fmt:formatNumber value="${vo.p_price}"/>원</del>
					(할인가 : <fmt:formatNumber value="${vo.p_saleprice}"/>원)
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<img src="images/${vo.p_image_l}" height="300px" />
					<br><br>
					<!-- pre : enter 가능 -->
					<pre>${vo.p_content}</pre>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="장바구니에 담기" onClick="location.href='cart_list.do'">
					<input type="button" value="장바구니 보기" onClick="location.href='cartList.jsp'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
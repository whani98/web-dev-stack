<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KOREA SHOPPING CENTER</title>

<style>
a:link {
	text-decoration: none;
	color: green;
	
}

a:hover {
	text-decoration: underline;
	color: lime;
}
</style>

</head>
<body>
	<hr width="600" border="1" noshade color="navy">

	<center>
		<font size="4" color="maroon"> <b>KOREA SHOPPING CENTER</b>
		</font>
	</center>

	<hr width="600" border="1" noshade color="navy">

	<center>
		<a href="list.do?category=com001">컴퓨터</a> <a
			href="list.do?category=ele002">생활가전</a> <a
			href="list.do?category=sp003">스포츠</a>
			<input type="button" value="장바구니 보기" onClick="location.href='cart_list.do?m_idx=1'">
	</center>

	<hr width="600" border="1" noshade color="navy">
</body>
</html>
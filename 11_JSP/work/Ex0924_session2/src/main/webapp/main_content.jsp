<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <c:if test="${empty sessionScope.user }">
    <script>
    // 로그인하지 않고 접속할 경우
    alert("로그인 후 이용하세요");
    location.href="login_form.jsp";
    </script>
    </c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>main_content</title>
</head>
<body>
<jsp:include page="check_login.jsp"/>

${sessionScope.user.name}님 환영합니다.
<br/>
<input type="button" value="로그아웃" onClick="location.href='logout.do'">
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>ERP</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/layout.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/content.css"/>
  </head>
  <body>
    <jsp:include page="side.jsp"/>
    <div class="main">
      <jsp:include page="header.jsp"/>
      <jsp:include page="${component}"/>
    </div>
	<script src="${pageContext.request.contextPath}/resources/js/layout.js"></script>
  </body>
</html>
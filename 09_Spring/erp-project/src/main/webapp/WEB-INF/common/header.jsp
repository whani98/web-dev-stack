<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="top-header">
  <c:if test="${not empty pageTitle}">
    <div class="breadcrumb">${pageTitle}</div>
</c:if>
  <div class="right-area">
    <span>테스트 님 환영합니다</span>
    <a href="/user/mypage" class="btn-mypage">마이페이지</a>
    <a href="/logout" class="btn-logout">로그아웃</a>
  </div>
</header>
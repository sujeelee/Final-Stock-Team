<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	login test
</h1>
	<a href='<c:url value="/member/login"/>'>로그인</a>
	<a href='<c:url value="/member/join"/>'>회원가입</a>
</body>
</html>

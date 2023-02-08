<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!
</h1>

<form action="/spring/login" method="post">
	<input type="text" name="id" placeholder="아이디"> <br>
	<input type="password" name="pw" placeholder="비밀번호"> <br>
	<button>로그인</button>
</form>
</body>
</html>

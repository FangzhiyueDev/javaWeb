<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="con" class="com.fang.dao.DatabaseBean"></jsp:useBean>

	<c:choose>
		<c:when test="${con.connectedOK}">连接成功</c:when>
		<c:otherwise>连接失败</c:otherwise>
	</c:choose>
</body>
</html>
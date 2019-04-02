<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 上边的导航菜单 -->
	<div class="contentMenuHead">
		<img alt="" src="">	
		<div>
			<c:choose>
				<c:when test="${sessionScope.mode==null}">
					<li>文章管理</li>
					<li>文章发布</li>
				</c:when>
				<!-- 代表的是存在选中的模块，更新当前的显示 -->
				<c:when test="${sessionScope.mode!=null}">
					<c:forEach items="${sessionScope.mode.functions}" var="menuItem">
						<li>${menuItem}</li>
					</c:forEach>
				</c:when>
			
			</c:choose>
		</div>
	</div>
	<!-- 下边的显示数据 -->
	<div class="contentInclude">
		<c:choose>
			<c:when test="${sessionScope.mode==null}">
				<c:import url="contentInclude/articleManager.jsp"></c:import>
			</c:when>
			<c:when test="${sessionScope.mode!=null}">
				<c:import url="${sessionScope.mode.import[0]}"></c:import>
			</c:when>
		</c:choose>
	</div>
	
</body>
</html>
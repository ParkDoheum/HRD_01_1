<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String title = (String)request.getAttribute("title");
	String view = (String)request.getAttribute("view");
	
	if(title == null) {
		title = "홈";
		view = "home.jsp";
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=title %></title>
<script type="text/javascript" src="common.js"></script>
</head>
<body>
	<div>
		<a href="preg">물품 등록</a>
		<a href="regpim">입고</a>
		<a href="regpex">출고</a>
		<a href="readpd">물품 조회</a>
		<a href="readpim">입고 조회</a>
		<a href="readpex">출고 조회</a>
		<a href="psales">매출</a>
		<a href="index.jsp">홈으로</a>
	</div>
	<div>
		<jsp:include page="<%=view %>"></jsp:include>
	</div>
</body>
</html>
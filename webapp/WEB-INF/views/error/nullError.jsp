<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>NullPointerException page</h1>
	<%
		Exception exception = (Exception) request.getAttribute("exception");
	%>
	<%="Java Code을 이용한 예외 Message 보기 ::" + exception.getMessage()%><br />
	EL을 이용한 예외 Message 보기 ::
	<br>
	<h2>${ exception.message }</h2>
	<br />
	<img src="${pageContext.request.contextPath}/assets/images/dean.jpg" />
	<hr />
	<br />
	<%=request.getRequestURI()%>
	<br />
	<%=request.getRequestURL()%>
</body>
</html>
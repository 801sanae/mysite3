<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath}/assets/css/guestbook.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
	
		<!-- header -->
		<c:import url="/WEB-INF/views/include/header.jsp"/>
	
		<!-- content -->
		<div id="content">
			<div id="guestbook" class="delete-form">
				<form method="post" action="${pageContext.request.contextPath}/guestbook/delete">
					<input type='hidden' name="no" value="${param.no}">
					<label>비밀번호</label>
					<input type="password" name="password">
					<input type="submit" value="확인">
				</form>
				<a href="${pageContext.request.contextPath}/guestbook/list">방명록 리스트</a>
			</div>
		</div>
		
		<!-- navigation -->
		<c:import url="/WEB-INF/views/include/navi.jsp">
<%-- 			<c:param name="menu" value="main"></c:param> --%>
		</c:import>
		<!-- footer -->
		<c:import url="/WEB-INF/views/include/footer.jsp"/>
	</div>
</body>
</html>
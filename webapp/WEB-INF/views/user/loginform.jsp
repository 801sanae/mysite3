<%@ page contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath}/assets/css/user.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<div id="container">
		
		<!-- header -->
		<c:import url="/WEB-INF/views/include/header.jsp"/>
		
		<!-- content -->
		<div id="content">
			<div id="user">
				<form id="login-form" name="loginform" method="get" action="${pageContext.request.contextPath}/user/login">
					<label class="block-label" for="email">이메일</label> 
					
					<input id="email" name="email" type="text" value=""> 
					<label class="block-label">패스워드</label> <input name="password"	type="password" value=""> 
					
					<input type="submit" value="로그인">
					
					<c:if test="${param.result ne fail  }">
						<p>로그인이 실패 했습니다.</p>
					</c:if>
				</form>
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
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%
	pageContext.setAttribute("newLine", "\n");
%>
<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath}/assets/css/guestbook.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<div id="container">
	
		<!-- header -->
		<c:import url="/WEB-INF/views/include/header.jsp"/>

		<!-- 
		%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
		%%%%%%%%%%EL JSTL 적용%%%%%%%%%%
		%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
		 -->
		 
		<!-- content -->
		<div id="content">
			<div id="guestbook">
				<form action="${pageContext.request.contextPath}/guestbook/insert" method="post">
					<table>
						<tr>
							<td>이름</td>
							<td>
								<input type="text" name="name" value="${authUser.name }" >
							</td>
							<td>비밀번호</td>
							<td>
								<input type="password" name="password" value="${authUser.password }" >
							</td>
						</tr>
						<tr>
							<td colspan=4><textarea name="content" id="content"></textarea></td>
						</tr>
						<tr>
							<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
						</tr>
					</table>
				</form>
				<ul>
					<li>
						<c:set var="cnt" value="${fn:length(list)}" />
						<c:set var="newLine" value="\n"/>
						<c:forEach items="${list }" var="vo" varStatus="status">
						
						<table>
							<tr>
								<td>${cnt-status.index }</td>
								<td>${vo.name }</td>
								<td>${vo.reg_date }</td>
								<td><a href="${pageContext.request.contextPath}/guestbook/form?no=${vo.no }">삭제</a></td>
							</tr>
							<tr>
								<td colspan=4>
								${fn:replace(vo.message,'<br>', 'newLine')}
								<!-- ??????? -->
								</td>
							</tr>
						</table> 
						
						</c:forEach>
 						<br>
					</li>
				</ul>
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
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath}/assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
	
		<!-- header -->
		<c:import url="/WEB-INF/views/include/header.jsp"/>
		
		<div id="content">
			<div id="board">
				<form class="board-form" method="post" action="${pageContext.request.contextPath}/board/write" enctype="multipart/form-data">
					<input type="hidden" name="group_no" value="${board.group_no }">
					<input type="hidden" name="order_no" value="${board.order_no }">
					<input type="hidden" name="depth" value="${board.depth }">
					${board.group_no } ${board.order_no } ${board.depth }
					<table class="tbl-ex">
						<tr>
							<th colspan="2">글쓰기</th>
						</tr>
						<tr>
							<td class="label">제목</td>
							<td><input type="text" name="title" value=""></td>
						</tr>
						<tr>
							<td class="label">파일</td>
							<td>
							<label>업로드 파일:</label>
							<input type="file" name="uploadFile">
							</td>
						</tr>
						<tr>
							<td class="label">내용</td>
							<td>
								<textarea id="content" name="contents"></textarea>
							</td>
						</tr>
					</table>
					<div class="bottom">
						<a href="${pageContext.request.contextPath}/board/list">취소</a>
						<input type="submit" value="등록">
					</div>
				</form>				
			</div>
		</div>
		
		<!-- navigation -->
		<c:import url="/WEB-INF/views/include/navi.jsp"/>
		
		<!-- footer -->
		<c:import url="/WEB-INF/views/include/footer.jsp"/>
	</div>
</body>
</html>
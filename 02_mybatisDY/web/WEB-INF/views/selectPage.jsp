<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	
	<c:if test="${ not empty list }">
			<table>
				<tr>
					<th>사번</th>
					<th>사원명</th>
					<th>주민번호</th>
					<th>이메일</th>
					<th>전화번호</th>
					<th>부서코드</th>
					<th>직급코드</th>
					<th>급여레벨</th>
					<th>급여</th>
					<th>보너스율</th>
					<th>매니져사번</th>
					<th>입사일</th>
					<th>성별</th>
				</tr>
				<c:forEach items="${list }" var="e" varStatus="v">
					<tr>
						<td><c:out value='${e["EMP_ID"] }'/></td>
						<td><c:out value='${e["EMP_NAME"] }'/></td>
						<td><c:out value='${e["EMP_NO"] }'/></td>
						<td><c:out value='${e["EMAIL"] }'/></td>
						<td><c:out value='${e["PHONE"] }'/></td>
						<td><c:out value='${e["DEPT_CODE"] }'/></td>
						<td><c:out value='${e["JOB_CODE"] }'/></td>
						<td><c:out value='${e["SAL_LEVEL"] }'/></td>
						<td><fmt:formatNumber value='${e["SALARY"] }' type="currency"/></td>
						<td><fmt:formatNumber value='${e["BONUS"] }' type="percent"/></td>
						<td><c:out value='${e["MANAGER_ID"] }'/></td>
						<td><fmt:formatDate value='${e["HIRE_DATE"] }' dateStyle="default"/></td>
						<td><c:out value='${e["GENDER"]}'/></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		
		<c:if test="${ empty list }">
			<p>자료가 없습니다.</p>
		</c:if>
		
		<c:if test="${ not empty pageBar }">
			${pageBar}
		</c:if>
	
</body>
</html>
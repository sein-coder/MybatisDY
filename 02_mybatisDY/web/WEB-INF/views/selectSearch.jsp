<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>항목별 검색</title>
</head>

<!-- WEB-INF는 보안폴더이기때문에 직접 외부에서 접근이 불가능
그래서 무조건 서블릿을 통해서만 들어가야한다. -->

<body>
	<div id="search-container">
		<form action="${path }/selectSearchEnd" method="post">
			<table id="tbl-search">
				<tr>
					<td colspan="2">
						<select name="searchType">
							<option value="" disabled selected>검색타입</option>
							<option value="emp_id">사번</option>
							<option value="emp_name">사원명</option>
							<option value="email">이메일</option>
							<option value="phone">전화번호</option>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="search" name="keyword"/>
					</td>
				</tr>
				<tr>
					<th>성별</th>
					<td>
						<input type="radio" name="gender" value="남" id="gender0">
						<label for="gender0">남</label>
						<input type="radio" name="gender" value="여" id="gender1">
						<label for="gender1">여</label>
					</td>
				</tr>
				<tr>
					<th>월급</th>
					<td>
						<input type="number" name="salary" min="0" step="100000"/>
						<label>
							<input type="radio" name="salary_le_ge" id="salary_ge" value="ge">이상
						</label>
						<label>
							<input type="radio" name="salary_le_ge" id="salary_le" value="le">이하
						</label>
					</td>
				</tr>
				<tr>
					<th>입사일</th>
					<td>
						<input type="date" name="hire_date">
						<label>
							<input type="radio" name="hire_date_le_ge" id="date_ge" value="ge">이후
						</label>
						<label>
							<input type="radio" name="hire_date_le_ge" id="date_le" value="le">이전
						</label>
					</td>
				</tr>
				<tr>
					<th>직책</th>
					<td>
						<input type="checkbox" name="job_code" id="J1" value="J1">
						<label for="J1">대표</label>
						
						<input type="checkbox" name="job_code" id="J2" value="J2">
						<label for="J2">부사장</label>
						
						<input type="checkbox" name="job_code" id="J3" value="J3">
						<label for="J3">부장</label>
						
						<input type="checkbox" name="job_code" id="J4" value="J4">
						<label for="J4">차장</label>
						
						<input type="checkbox" name="job_code" id="J5" value="J5">
						<label for="J5">과장</label>
						
						<input type="checkbox" name="job_code" id="J6" value="J6">
						<label for="J6">대리</label>
						
						<input type="checkbox" name="job_code" id="J7" value="J7">
						<label for="J7">사원</label>
						
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="검색"/>
					</td>
				</tr>
			</table>
		</form>
		
		<c:if test="${ not empty emp }">
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
				<c:forEach items="${emp }" var="e" varStatus="v">
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
		
		<c:if test="${ empty emp }">
			<p>자료가 없습니다.</p>
		</c:if>
		
	</div>
</body>
</html>
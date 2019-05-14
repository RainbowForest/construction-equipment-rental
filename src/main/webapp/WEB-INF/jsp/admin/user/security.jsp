<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE = edge,chrome=1" />
	<link rel="stylesheet" href="/css/style.css" type="text/css">
	<link rel="stylesheet" href="/css/searchuserstable.css" type="text/css">
</head>
<body>
	<div id="container">
		<%@include file="/WEB-INF/incl/header.app"%>
		<div id="bar4">
			<a href="/">Home </a><label>></label><a href="/admin"> Admin Dashboard</a><label>></label><a href="#"> Search Users</a>
		</div>
		<%@include file="/WEB-INF/incl/navigation.app"%>
		<div id="bar3"></div>
		<div id="main-content">
			<div id="table-container">
				<div id="table-header">Security</div>
				<div id="searchbox">
				<sf:form action="/admin/security/user" method="post">
					<label>Search: </label>
					<input type="search" name="userName"> <input type="image" src="/img/searchicon.png" title="Search" id="search-icon" >
				</sf:form>
				</div>
				<table>
					<tr>
						<th>Username</th>
						<th>Password</th>
						<th>Role</th>
						<th>Active</th>
						<th>Options</th>
					</tr>
					<c:forEach var="user" items="${users}">
						<tr>
							<td><c:out value="${user.userName}" /></td>
							<td><c:out value="${user.userPassword}" /></td>
							<td><c:out value="${user.role.userRole}" /></td>
							<td><c:choose>
									<c:when test="${user.userEnabled == 0}">
										<font color="red"><c:out value="NO" /></font>
									</c:when>
									<c:otherwise>
										<font color="green"><c:out value="YES" /></font>
									</c:otherwise>
								</c:choose></td>
							<td>
								<sf:form action="/admin/security/edit">
									<input type="image" src="/img/edit.png" width="20" height="20" title="edit">
									<input type="hidden" value="${user.id}" name = "usid">
								</sf:form>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
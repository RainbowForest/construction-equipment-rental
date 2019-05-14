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
	<link rel="stylesheet" href="/css/viewuserdetails.css" type="text/css">
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
				<div id="table-header">User</div>
				<div id="userName-label">
					<label><c:out value="${user.userAccount.userName}" /></label>
				</div>
				<table>
					<tr>
						<th>First name</th>
						<th>Last name</th>
						<th>Email</th>
						<th>Phone number</th>
						<th>Position</th>
						<th>Workplace</th>
					</tr>
					<tr>
						<td><c:out value="${user.firstName}" /></td>
						<td><c:out value="${user.lastName}" /></td>
						<td><c:out value="${user.email}" /></td>
						<td><c:out value="${user.phoneNumber}" /></td>
						<td><c:out value="${user.position}" /></td>
						<td><c:out value="${user.constructionSites.buildingName}" /></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
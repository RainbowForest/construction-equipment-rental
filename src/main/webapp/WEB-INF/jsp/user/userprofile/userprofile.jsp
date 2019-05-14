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
	<link rel="stylesheet" href="/css/userprofile.css" type="text/css">
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
				<div id="messagebar">
					<label>!User name cannot be changed!</label>
				</div>
				<sf:form action="/my-profile/update" modelAttribute="userAccountDetails" method="post">
					<div id="table-header">
						<label>My Profile</label>
					</div>
					<div id="info-form">
						<table>
							<div class="label">
								<label>Profile Information</label>
								<div class="separator"></div>
							</div>
							<tr>
								<td>User name</td>
								<td><c:out value="${userAccountDetails.userAccount.userName}"></c:out></td>
							</tr>
							<tr>
								<td>First name</td>
								<td><c:out value="${userAccountDetails.firstName}"></c:out></td>
							</tr>
							<tr>
								<td>Last name</td>
								<td><c:out value="${userAccountDetails.lastName}"></c:out></td>
							</tr>
							<tr>
								<td>Position</td>
								<td><c:out value="${userAccountDetails.position}"></c:out></td>
							</tr>
							<tr>
								<td>Email</td>
								<td><c:out value="${userAccountDetails.email}"></c:out></td>
							</tr>
							<tr>
								<td>Phone number</td>
								<td><c:out value="${userAccountDetails.phoneNumber}"></c:out></td>
							</tr>
							<tr>
								<td>Workplace</td>
								<td><c:out value="${userAccountDetails.constructionSites.buildingName}"></c:out></td>
							</tr>
							<tr>
								<td>Old password</td>
								<td><input type="text" name="oldPassword"/></td>
							</tr>
							<tr>
								<td>New password</td>
								<td><input type="text" name="newPassword"/></td>
							</tr>
							<tr>
								<td>Repeat password</td>
								<td><input type="text" name="repeatPassword"/></td>
							</tr>
						</table>
					</div>
					<div id="buttonbar">
						<div class="button">
							<input type="submit" value="save">
							<input type="hidden" value="${userAccountDetails.id}" name = "usId">
						</div>
						<div class="button">
							<input type="button" value="cancel">
						</div>
					</div>
				</sf:form>
			</div>
		</div>
	</div>
</body>
</html>
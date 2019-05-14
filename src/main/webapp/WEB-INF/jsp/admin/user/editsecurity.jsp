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
	<link rel="stylesheet" href="/css/edituser.css" type="text/css">
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
				<sf:form action="/admin/security/update" modelAttribute="user" method="post">
					<div id="table-header">
						<label>Security</label>
					</div>
					<div id="info-form">
						<table>
							<div class="label">
								<label>Security Information</label>
								<div class="separator"></div>
							</div>
							<tr>
								<td>User name</td>
								<td><sf:input path="userName" type="text" disabled="true"/></td>
							</tr>
							<tr>
								<td>Password</td>
								<td><sf:input path="userPassword" type="text"/></td>
							</tr>
							<tr>
							</tr>
							<tr>
								<td>Enabled User:</td>
								<td>
									<div class="sec-inputs">
										<sf:select path="userEnabled">
											<sf:option value="0">NO</sf:option>
											<sf:option value="1">YES</sf:option>
										</sf:select>
									</div>
								</td>
							</tr>
							<tr>
								<td>Select user role:</td>
								<td>
									<div class="sec-inputs">
										<sf:radiobutton path="role" value="1" name="role" />
										<label>Administrator</label>
									</div>
								</td>
							</tr>
							<tr>
								<td></td>
								<td>
									<div class="sec-inputs">
										<sf:radiobutton path="role" value="2"/>	
										<label>User</label>
									</div>
								</td>
							</tr>
						</table>
					</div>
					<div id="buttonbar">
						<div class="button">
							<input type="submit" value="save">
							<input type="hidden" value="${user.id}" name = "usid">
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
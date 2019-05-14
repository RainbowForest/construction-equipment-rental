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
	<link rel="stylesheet" href="/css/style.css" type="text/css" />
	<link rel="stylesheet" href="/css/userform.css" type="text/css">
	<link rel="stylesheet" href="/css/errorsbar.css" type="text/css">
	<link rel="stylesheet" href="/css/messagesbar.css" type="text/css">
</head>
<body>
	<div id="container">
		<%@include file="/WEB-INF/incl/header.app"%>
		<div id="bar4">
			<a href="/">Home </a><label>></label><a href="/admin"> Admin Dashboard </a><label>></label><a href="/user-form"> Add New Users</a>
		</div>
		<%@include file="/WEB-INF/incl/navigation.app"%>
		<div id="bar3"></div>
		<div id="main-content">
			<div class="messagebar">
				<c:out value="${message}"/>
			</div>
			<c:if test="${result != null }">
				<sf:form modelAttribute="user" id="error-form">
					<sf:errors path="*" />
				</sf:form>
			</c:if>
			<div id="table-container">
				<sf:form id="form" action="/admin/save-user" modelAttribute="user"
					method="post">
					<div id="table-header">
						<label>Add New User</label>
					</div>
					<div id="info-form">
						<table>
							<div class="label">
								<label>User Information</label>
								<div class="separator"></div>
							</div>
							<tr>
								<td>User name *</td>
								<td><sf:input path="userAccount.userName" type="text"/></td>
								
							</tr>
							<tr>
								<td>Password *</td>
								<td><sf:input path="userAccount.userPassword" type="password" /></td>
							</tr>
							<tr>
								<td>First name *</td>
								<td><sf:input path="firstName" type="text" /></td>
								
								
							</tr>
							<tr>
								<td>Last name *</td>
								<td><sf:input path="lastName" type="text" /></td>
								
							</tr>
							<tr>
								<td>Email</td>
								<td><sf:input path="email" type="text" /></td>
							</tr>
							<tr>
								<td>Phone number</td>
								<td><sf:input path="phoneNumber" type="text" /></td>
							</tr>
							<tr>
								<td>Position</td>
								<td><sf:input path="position" type="text" /></td>
							</tr>
							<tr>
								<td>Workplace</td>
								<td>
									<sf:select path="constructionSites" id="workplace" >
										<sf:option value="0" label="None" selected="selected"/>
										<sf:options items="${constructionSiteList}" itemValue="id" itemLabel="buildingName" name="csid"/>
									</sf:select>
								</td>
							</tr>
						</table>
					</div>
					<div id="sec-form">
						<table>
							<div class="label">
								<label> Security Information</label>
								<div class="separator"></div>
							</div>
							<tr>
								<td>Enabled User:</td>
								<div class="sec-inputs">
									<td><sf:select path="userAccount.userEnabled">
											<sf:option value="0">NO</sf:option>
											<sf:option value="1" selected="selected">YES</sf:option>
										</sf:select></td>
								</div>
							</tr>
							<tr>
								<td>Select user role:</td>
								<td>
									<div class="sec-inputs">
										<sf:radiobutton path="userAccount.role" value="1" />
										<label>Administrator</label>
									</div>
								</td>
							</tr>
							<tr>
								<td></td>
								<td>
									<div class="sec-inputs">
										<sf:radiobutton path="userAccount.role" value="2"
											checked="checked" />
										<label>User</label>
									</div>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<div id="submit">
										<input type="submit" value="Add User">
									</div>
								</td>
							</tr>
						</table>
					</div>
				</sf:form>
			</div>
		</div>
	</div>
</body>
</html>
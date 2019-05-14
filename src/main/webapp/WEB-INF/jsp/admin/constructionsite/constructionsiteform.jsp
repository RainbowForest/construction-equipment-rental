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
	<link rel="stylesheet" href="/css/edituser.css" type="text/css">
	<link rel="stylesheet" href="/css/errorsbar.css" type="text/css">
	<link rel="stylesheet" href="/css/messagesbar.css" type="text/css">
</head>
<body>
	<div id="container">
		<%@include file="/WEB-INF/incl/header.app"%>
		<div id="bar4">
			<a href="/">Home </a><label>></label><a href="/admin"> Admin Dashboard </a><label>></label><a href="#"> Add Construction Site</a>
		</div>
		<%@include file="/WEB-INF/incl/navigation.app"%>
		<div id="bar3"></div>
		<div id="main-content">
			<div class="messagebar">
				<c:out value="${message}"/>
			</div>
			<c:if test="${result != null }">
				<sf:form modelAttribute="cs" id="error-form">
					<sf:errors path="*" />
				</sf:form>
			</c:if>
			<div id="table-container">
				<sf:form action="/admin/save-cs" modelAttribute="cs" method="post">
					<div id="table-header">
						<label>Add New Construction Site</label>
					</div>
					<div id="info-form">
						<table>
							<div class="label">
								<label>Construction Site Information</label>
								<div class="separator"></div>
							</div>
							<tr>
								<td>Building name</td>
								<td><sf:input path="buildingName" type="text" /></td>
							</tr>
							<tr>
								<td>Building code</td>
								<td><sf:input path="buildingCode" type="text" /></td>
							</tr>
							<tr>
								<td>Street</td>
								<td><sf:input path="constructionSiteAdress.street" type="text" /></td>
							</tr>
							<tr>
								<td>Street number</td>
								<td><sf:input path="constructionSiteAdress.streetNumber" type="text" /></td>
							</tr>
							<tr>
								<td>Locality</td>
								<td><sf:input path="constructionSiteAdress.locality" type="text" /></td>
							</tr>
							<tr>
								<td>Zip Code</td>
								<td><sf:input path="constructionSiteAdress.zipCode" type="text" /></td>
							</tr>
							<tr>
								<td>Country</td>
								<td><sf:input path="constructionSiteAdress.country" type="text" /></td>
							</tr>
						</table>
					</div>
					<div id="buttonbar">
						<div class="button">
							<input type="submit" value="save">
							<input type="hidden" value="0" name="status" >
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
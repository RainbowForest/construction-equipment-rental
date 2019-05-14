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
			<a href="/">Home </a><label>></label><a href="/admin"> Admin Dashboard </a><label>></label><a href="/admin/catalog/add-item"> Add New Item</a>
		</div>
		<%@include file="/WEB-INF/incl/navigation.app"%>
		<div id="bar3"></div>
		<div id="main-content">
			<div id="messagebar">
				<c:out value="${message}"/>
			</div>
			<c:if test="${result != null }">
				<sf:form modelAttribute="product" id="error-form">
					<sf:errors path="*" />
				</sf:form>
			</c:if>
			<div id="table-container">
				<sf:form action="/admin/catalog/save-item" modelAttribute="product" method="post">
					<div id="table-header">
						<label>Add New Item</label>
					</div>
					<div id="info-form">
						<table>
							<div class="label">
								<label>Item information</label>
								<div class="separator"></div>
							</div>
							<tr>
								<td>Product Code</td>
								<td><sf:input path="productCode" type="text" /></td>
							</tr>
							<tr>
								<td>Product Name</td>
								<td><sf:input path="productName" type="text" /></td>
							</tr>
							<tr>
								<td>Category</td>
								<td><sf:input path="productCategory" type="text" /></td>
							</tr>
							<tr>
								<td>Availability</td>
								<td><sf:input path="availability" type="text" /></td>
							</tr>
							<tr>
								<td>Price</td>
								<td><sf:input path="productPrice" type="text"/></td>
							</tr>
						</table>
					</div>
					<div id="buttonbar">
						<div class="button">
							<input type="submit" value="save">
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
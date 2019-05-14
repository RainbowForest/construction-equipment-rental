<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE = edge,chrome=1" />
	<link rel="stylesheet" href="/css/style.css" type="text/css" />
	<link rel="stylesheet" href="/css/orderformStyle.css" type="text/css">
</head>
<body>
	<div id="container">
		<%@include file="/WEB-INF/incl/header.app"%>
		<div id="bar4">
			<a href="/">Home </a><label>></label><a href="/catalog"> Catalog </a><label>></label><a href="/cart"> Cart </a>
		</div>
		<%@include file="/WEB-INF/incl/navigation.app"%>
		<div id="bar3"></div>
		<div id="main-content">
			<div id="table-container">
				<div id="table-header">Cart</div>
				<table id="product-list-table">
					<tr>
						<th colspan="8">Product List</th>
					</tr>
					<tr>
						<th>No.</th>
						<th>Code</th>
						<th>Name</th>
						<th>Category</th>
						<th>Quantity</th>
						<th>Price</th>
						<th>Sub Total</th>
						<th>Options</th>
					</tr>
					<tr>
						<c:forEach items="${cart}" var="item">
						<tr>
							<td><c:out value="${1}"></c:out></td>
							<td><c:out value="${item.product.productCode}"></c:out></td>
							<td><c:out value="${item.product.productName}"></c:out></td>
							<td><c:out value="${item.product.productCategory}"></c:out></td>
							<td>
								<sf:form action="/cart/update">
									<input type="number" value="<c:out value="${item.quantity}"/>" name="quantity">
									<input type="hidden" value="${item.product.id}" name = "itemId">
									<input type="submit" value="upd">
								</sf:form>
							</td>
							<td><c:out value="${item.product.productPrice}"></c:out></td>
							<td><c:out value="${item.quantity * item.product.productPrice}"></c:out></td>
							<td>
								<sf:form action="/cart/delete-item">
									<input type="image" src="/img/delete.png" width="20" height="20" title="delete">
									<input type="hidden" value="${item.product.id}" name = "itemId">
								</sf:form>
							</td>
								
						</tr>
						</c:forEach>
					</tr>
					<c:if test="${cart != null}">
					<tr>
						<td class="void-cell"></td>
						<td class="void-cell"></td>
						<td class="void-cell"></td>
						<td class="void-cell"></td>
						<td class="void-cell"></td>
						<td>Total Price</td>
						<td><c:out value="${totalPrice}" /></td>
					</tr>
					</c:if>
				</table>
				<form action="/cart/order">
					<input type="button" onclick="window.location.href = '/catalog';" value="<- BACK"> 
					<input type="submit" value="NEXT ->">
				</form>
			</div>
		</div>
	</div>
</body>
</html>
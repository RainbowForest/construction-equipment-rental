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
	<link rel="stylesheet" href="/css/orderform.css" type="text/css">
</head>
<body>
	<div id="container">
		<%@include file="/WEB-INF/incl/header.app"%>
		<div id="bar4">
			<a href="/">Home </a><label>></label><a href="/catalog"> Catalog </a><label>></label><a href="/cart"> Cart</a><label>></label><a href="/cart/order"> Order</a>
		</div>
		<%@include file="/WEB-INF/incl/navigation.app"%>
		<div id="bar3"></div>
		<div id="main-content">
			<div id="form-container">
				<div id="table-header">Order</div>
					<div id="inputs-area">
						<label>First name : 
							<c:out value="${orderDetails.firstName}"/>
						</label>
						<label>Last name :
							<c:out value="${orderDetails.lastName}"/>
						</label>
						<label>Email :
							<c:out value="${orderDetails.email}"/>
						</label>
						<label> Construction Site :
							<c:out value="${orderDetails.order.constructionSite.buildingName}"/>
						</label>
					</div>
					<table>
						<tr>
							<td colspan="6">Product List</td>
						</tr>
						<tr>
							<th>No.</th>
							<th>Code</th>
							<th>Name</th>
							<th>Category</th>
							<th>Quantity</th>
							<th>Sub Price</th>
						</tr>
							<c:forEach items="${orderDetails.items}" var="item">
								<tr>
									<td><c:out value="${1}"></c:out></td>
									<td><c:out value="${item.product.productCode}"></c:out></td>
									<td><c:out value="${item.product.productName}"></c:out></td>
									<td><c:out value="${item.product.productCategory}"></c:out></td>
									<td><c:out value="${item.quantity}"></c:out></td>
									<td><c:out value="${item.product.productPrice * item.quantity}"></c:out></td>				
								</tr>
							</c:forEach>
						<tr>
							<td class="blank-cell"></td>
							<td class="blank-cell"></td>
							<td class="blank-cell"></td>
							<td class="blank-cell"></td>
							<td>Total Price</td>
							<td><c:out value="${orderDetails.order.totalPrice}"/></td>
						</tr>
					</table>
					<input type="button" onclick="window.location.href = '/cart';" value="<- BACK">
					<input type="submit" value="SEND">
			</div>
		</div>
	</div>
</body>
</html>
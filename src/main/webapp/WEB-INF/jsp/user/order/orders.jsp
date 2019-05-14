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
			<a href="/">Home </a><label>></label><a href="/catalog"> Catalog </a><label>></label><a href="/cart"> Cart </a>
		</div>
		<%@include file="/WEB-INF/incl/navigation.app"%>
		<div id="bar3"></div>
		<div id="main-content">
			<div id="table-container">
                <div id="table-header"> Catalog </div>
                <div id="searchbox"> 
                	<sf:form action="/admin/catalog/product" method="post">
						<label>Search: </label>
						<input type="search" name="productName"> <input type="image" src="/img/searchicon.png" title="Search" id="search-icon" >
					</sf:form>
                </div>
                <table>
                    <tr>
                      	<th>Construction Site</th>
						<th>Ordering Party</th>
						<th>Total Price</th>
						<th>Date</th>
						<th>Order Details</th>
						<th>Status</th>
                    </tr>
						<c:forEach var="order" items="${orders}">
							<tr>
								<td><c:out value="${order.constructionSite.buildingName}"></c:out></td>
								<td><c:out value="${order.orderingParty}"></c:out></td>
								<td><c:out value="${order.totalPrice}"></c:out></td>
								<td><c:out value="${order.date}"></c:out></td>
								<sf:form action="/orders/details">
								<td><input type="submit"> 
								<input type="hidden" value="${order.orderDetails.id}" name="orderDetailsId"></td>
								</sf:form>
								<td>
								<c:choose>
									<c:when test="${order.status == 0}">
										<font color="blue">Progress</font>
									</c:when>
									<c:when test="${order.status == 1}">
										<font color="red">Canceled</font>
									</c:when>
									<c:otherwise>
										<font color="green">Finished</font>
									</c:otherwise>
								</c:choose>
								</td>
							</tr>
						</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
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
                    <sf:form action="/catalog/search" method="post">
						<label>Search: </label>
						<input type="search" name="productName"> <input type="image" src="/img/searchicon.png" title="Search" id="search-icon" >
					</sf:form>
                </div>
                <table>
                    <tr>
                      	<th>code</th>
						<th>name</th>
						<th>category</th>
						<th>availability</th>
						<th>price per day</th>
						<th>quantity</th>
						<th>order</th>
                    </tr>
					<tr>
						<td><c:out value="${product.productCode}"></c:out></td>
						<td><c:out value="${product.productName}"></c:out></td>
						<td><c:out value="${product.productCategory}"></c:out></td>
						<td><c:out value="${product.availability}"></c:out></td>
						<td><c:out value="${product.productPrice}"></c:out></td>		
						<sf:form action="cart/add">
							<td><input type="number" name="quantity" value="1"></td>
							<td>
								<input type="submit"> 
								<input type="hidden" value="${product.productName}" name="productName">
							</td>
						</sf:form>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
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
		<div id="bar4"><a href="/">Home </a><label>></label><a href="/admin"> Admin Dashboard</a><label>></label><a href="#"> Search Users</a></div>
		<%@include file="/WEB-INF/incl/navigation.app"%>
		<div id="bar3"></div>
		<div id="main-content">
			<div id="table-container">
                <div id="table-header"> Construction Sites </div>
                <div id="searchbox"> <td><label>Search: </label><input type="search"></td>
                    <a href="#" title="Find"><img id="search-icon" src="/img/searchicon.png"></a>
                </div>
                <table>
                    <tr>
                        <th> Building name </th>
                        <th> Building code </th>          
                        <th> Street </th>
                        <th> Street number </th>
                        <th> Locality </th>
                        <th> Zip Code </th>
                        <th> Country </th>
                        <th> Status </th>
                    </tr>
                    <c:forEach var="cs" items="${cs}">
                    <tr>
                        <td><c:out value="${cs.buildingName}"/></td>
                        <td><c:out value="${cs.buildingCode}"/></td>
                        <td><c:out value="${cs.constructionSiteAdress.street}"/></td>
                        <td><c:out value="${cs.constructionSiteAdress.streetNumber}"/></td>
                        <td><c:out value="${cs.constructionSiteAdress.locality}"/></td>
                        <td><c:out value="${cs.constructionSiteAdress.zipCode}"/></td>
                        <td><c:out value="${cs.constructionSiteAdress.country}"/></td>
                        <td>
                        	<c:choose>
                        		<c:when test="${cs.status == 0}">
                        			<font color="green"><c:out value="IN PROGRESS"/></font>
                        		</c:when>
                        		<c:otherwise>
                        			<font color="blue"><c:out value="FINISHED"/></font>
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
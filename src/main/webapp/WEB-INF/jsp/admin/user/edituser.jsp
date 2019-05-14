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
                <div id="messagebar"><label>!User name cannot be changed!</label></div>
 				<sf:form action="/admin/users/update-user" modelAttribute="user" method="post">
       					<div id="table-header">
           					<label>Edit User</label>
        				</div>
        		<div id="info-form">
        			<table>
          	  			<div class="label">
               				<label>User Information</label>
               				<div class="separator"></div>
           				</div>
			            <tr>
			                <td> Username </td>
			                <td><sf:input path="userAccount.userName" type="text" disabled="true"/></td>
			            </tr>
			            <tr>
			                <td> First name </td>
			                <td><sf:input path="firstName" type="text"/></td>
			            </tr>
			            <tr>
			                <td> Last name </td>
			                <td><sf:input path="lastName" type="text"/></td>
			            </tr>
			            <tr>
			                <td> Email </td>
			                <td><sf:input path="email" type="text"/></td>
			            </tr>
			            <tr>
			                <td> Phone number </td>
			                <td><sf:input path="phoneNumber" type="text"/></td>
			            </tr>
			            <tr>
			                <td> Position </td>
			                <td><sf:input path="position" type="text"/></td>
			            </tr>
			            <tr>
			                <td> Workplace </td>
			                <td>
								<sf:select path="constructionSites" id="workplace" name="constructionSites">
									<sf:option value="" label="None"/>
									<sf:options items="${constructionSiteList}" itemValue="id" itemLabel="buildingName"/>
								</sf:select>  
			            </tr>
				        </table>
					</div>
	            	<div id="buttonbar">
	                	<div class="button">
	                   		<input type="submit" value="save" >
	                    	<input type="hidden" value="${user.id}" name="usid">  
						</div> 
	                	<div class="button">
	                    	<input type="button" value="cancel" >
	                	</div>
	            	</div>
	    		</sf:form>
        	</div>
		</div>
	</div>
</body>
</html>
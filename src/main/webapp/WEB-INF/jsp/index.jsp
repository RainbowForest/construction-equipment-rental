<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf-8"%>
<%@ taglib prefix="sec"  uri="http://www.springframework.org/security/tags"%>



<!DOCTYPE html>
<html>
<head>
	<meta charset = "utf-8"/>
	<meta http-equiv = "X-UA-Compatible" content = "IE = edge,chrome=1"/>
	<link rel="stylesheet" href= "css/style.css" type="text/css"/>
</head>
<body>
	<div id="container">
		<%@include file="/WEB-INF/incl/header.app"%>
		<div id="bar4"><a href="/">Home </a></div>
		<%@include file="/WEB-INF/incl/navigation.app" %>
		<div id="bar3"></div>
        <div id="main-content"></div>
	</div>
</body>
</html>
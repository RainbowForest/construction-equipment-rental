<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s"    uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"  uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="sf"   uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv = "X-UA-Compatible" content = "IE = edge,chrome=1"/>
	<link href="/css/loginstyle.css" rel="stylesheet">
	<link href="/css/loginerror.css" rel="stylesheet">
</head>
<body>
	<div id="login-form">
    	<div id= "bar"></div>
        <div id="loginbox">
        	<div id="login-error">
            	<c:if test="${not empty param.error}">
            		<s:message code="error.login"/>
            	</c:if>
            </div>
            <sf:form action = "/login" method = "post">
            	<input type="text" name = "userName" placeholder="Username" autofocus>
                <input type="password" name = "userPassword" placeholder="Password" autofocus>
                <input type="submit" value="LOGIN">    
            </sf:form>
    	</div>
	</div>
</body>
</html>










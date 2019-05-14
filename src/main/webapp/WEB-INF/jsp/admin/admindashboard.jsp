<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s"    uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"  uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="sf"   uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv = "X-UA-Compatible" content = "IE = edge,chrome=1"/>
	<link rel="stylesheet" href= "css/style.css" type="text/css"/>
	<link rel="stylesheet" href="css/admindashboard.css" type="text/css">
</head>
<body>
	<div id="container">
		<%@include file="/WEB-INF/incl/header.app"%>
		<div id="bar4"><a href="/">Home </a><label>></label><a href="/admin"> Admin Dashboard </a></div>
		<%@include file="/WEB-INF/incl/navigation.app" %>
		<div id="bar3"></div>
   		<div id="main-content">
   		
            <!-- User Panel -->
            
            <div class="dbpanel">
                <div class="panel-header">
                    <label>Users</label>
                </div>
                <div class="panel-content">
                    <div class="panel-tiles">
                        <a href="admin/user-form">Add New</a>
                    </div><br>
                    <div class="panel-tiles">
                        <a href="admin/users">Search Account</a>
                    </div><br>
                    <div class="panel-tiles">
                        <a href="admin/security">Security</a>
                    </div>  
                </div> 
            </div>
    
            <!-- Construction Site Panel -->
    
            <div class="dbpanel">
                <div class="panel-header">
                    <label>Construction Sites</label>
                </div>
                <div class="panel-content">
                    <div class="panel-tiles">
                        <a href="admin/cs-form">Add New</a>
                    </div><br>
                    <div class="panel-tiles">
                        <a href="admin/construction-sites">Search</a>
                    </div><br>
                    <div class="panel-tiles">
                        <a href="admin/construction-site/stock-list">Stock List</a>
                    </div><br>
                </div>
            </div>
            <!-- Catalog Panel -->
    
            <div class="dbpanel">
                <div class="panel-header">
                    <label>Catalog</label>
                </div>
                <div class="panel-content">
                    <div class="panel-tiles">
                        <a href="admin/catalog/add-item">Add New Item</a>
                    </div><br>
                    <div class="panel-tiles">
                        <a href="admin/catalog/products">Edit Item</a>
                    </div>  
                </div>
                
            </div>
    
            <!-- Order Panel -->
    
            <div class="dbpanel">
                <div class="panel-header">
                    <label>Orders</label>
                </div>
               <div class="panel-content">
                    <div class="panel-tiles">
                        <a href="admin/orders">Check Orders</a>
                    </div><br>
                    <div class="panel-tiles">
                        <a href="admin/orders/history">Order History</a>
                    </div><br>
                </div>
            </div>
    
            <!-- Liabilities Panel -->
    
            <div class="dbpanel">
                <div class="panel-header">
                    <label>Liabilities</label>
                </div>
               <div class="panel-content">
                    <div class="panel-tiles">
                        <a href="admin/liabilities">Check Liabilities</a>
                    </div><br>
                </div>
            </div> 
   		</div>
	</div>
</body>
</html>
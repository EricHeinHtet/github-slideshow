<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Customer Site: Mini Bank System[${param.frmHeading }] : 
		${sessionScope.loginUser.getCustName()}</h3>
	<hr>
	<a href="viewAccPath">View Account</a> ||
	<a href="transferOwnPath?type=own">Transfer Own</a> ||
	<a href="transferOtherPath?type=other">Transfer Other</a> ||
	<a href="viewTranPath">View Transaction</a> ||
	<a href="changePassPath">Change Password</a> ||
	<a href="logoutPath">Logout</a>
	<hr>
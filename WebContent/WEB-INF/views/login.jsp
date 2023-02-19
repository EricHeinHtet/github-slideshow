<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="sform" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	.error{
	color:#ff0000;
	font-style:italic;
	font-weight:bold;	
	}
</style>
</head>
<body>
	<h3>Customer Site: Mini Bank System</h3>
	<sform:form action="loginPath" method="post" modelAttribute="frmCust">
		Enter Customer name:
			<sform:input path="frmCustName"/>
			<sform:errors path="frmCustName" cssClass="error"/>
			<br>
		Enter Customer password:
			<sform:password path="frmCustPass"/>
			<sform:errors path="frmCustPass" cssClass="error"/>
			<br>
		<input type="submit" value="Login">
		<p class="error">${errLogin}</p>	
		
	</sform:form>
</body>
</html>
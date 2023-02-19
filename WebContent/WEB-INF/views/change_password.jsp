 <%@taglib uri="http://www.springframework.org/tags/form" prefix="sform" %>  
<jsp:include page="header.jsp">
	<jsp:param value="CHANGE PASSWORD " name="frmHeading"/>
</jsp:include>
<sform:form modelAttribute="frmCust" method="post" action="changePassPath">
	Enter your new password:<sform:input path="frmCustPass"/>
	<input type="submit" value="CHANGE"/>
</sform:form>
<%@ include file="footer.jsp" %>

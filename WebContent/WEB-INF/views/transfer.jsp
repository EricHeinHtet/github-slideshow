 <%@taglib uri="http://www.springframework.org/tags/form" prefix="sform" %>  
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp">
	<jsp:param value="TRANSFER OWN " name="frmHeading"/>
</jsp:include>
<h3>COMBINE PAGE for OWN and OTHER</h3>
<sform:form modelAttribute="frmTransfer" method="post" action="transferPath">
		Select From account:
					<sform:select path="frmFromAccNo">
						<sform:options items="${frmTransfer.frmAccounts }" 
						itemLabel="accNo" itemValue="accNo"/>
					</sform:select><br>
		
					<c:if test="${frmType=='own' }">
					Select To account:
						<sform:select path="frmToAccNo">
							<sform:options items="${frmTransfer.frmAccounts }"
							itemLabel="accNo" itemValue="accNo"/>
						</sform:select>
					</c:if>
					<c:if test="${frmType=='other' }">
					Enter To account:<sform:input path="frmToAccNo"/>
					</c:if>
					<br>	
		Enter Transfer Amount:<sform:input path="frmAmount"/>		<br>
		<input type="submit" value="Transfer"/>			
		<input type="hidden" name="type" value="${frmType}"/>
</sform:form>
		<font style="color:red;">${frmTransfer.frmError}</font>

<%@ include file="footer.jsp" %>

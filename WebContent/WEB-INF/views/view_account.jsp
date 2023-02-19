 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="header.jsp">
	<jsp:param value="VIEW ACCOUNT" name="frmHeading"/>
</jsp:include>
<table border="1" width="75%">
	<thead>
			<tr>
				<th>No</th>
				<th>Account No</th>
				<th>Open Date</th>
				<th>Account Type</th>
				<th>Balance</th>
				<th>Status</th>
			</tr>
	</thead>
	<tbody>
			<c:forEach var="acc" items="${accList}" varStatus="vs">
				<tr>
					<td>${vs.index+1}</td>
					<td>${acc.accNo}</td>
					<td>
						<fmt:formatDate value="${acc.accOpenDate }" pattern="dd-MMM-yyyy"/>
					</td>
					<td>${acc.accountType.typeName}</td>
					<td>${acc.accBalance }</td>
					<td>
						<c:if test="${acc.accStatus==true}">
								<font color="blue">ACTIVE</font>
						</c:if>
						<c:if test="${acc.accStatus==false}">
								<font color="red">BLACKLIST</font>
						</c:if>
					</td>
				</tr>
			</c:forEach>	
	</tbody>
</table>



<%@ include file="footer.jsp" %>

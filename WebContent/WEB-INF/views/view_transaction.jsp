 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="header.jsp">
	<jsp:param value="VIEW TRANSACTION " name="frmHeading"/>
</jsp:include>
<table border="1" width="75%">
	<thead>
			<tr>
				<th>No</th>
				<th>Account No</th>
				<th>Amount</th>
				<th>Transaction Type</th>
				<th>Date</th>
			</tr>
	</thead>
	<tbody>
			<c:set var="no" value="1"/>
			<c:forEach var="acc" items="${frmCustTran.accounts}" varStatus="vs1">
				<c:forEach var="tran" items="${acc.transactions}" varStatus="vs2">
				<tr>
					<td>${no}</td>
					<td>${acc.accNo}</td>
					<td>${tran.tranAmount }</td>
					<td>${tran. tranType}</td>
					<td>
						<fmt:formatDate value="${tran.tranDate }" pattern="dd-MMM-yyy hh:mm:ss a"/>
					</td>
					<c:set var="no" value="${no+1}"/>
				</tr>
				</c:forEach>
			</c:forEach>
<%@ include file="footer.jsp" %>

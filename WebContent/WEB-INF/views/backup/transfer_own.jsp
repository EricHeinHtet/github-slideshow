
<sform:form modelAttribute="frmTransfer" method="post" action="transferPath">
		Select From account:
					<sform:select path="frmFromAccNo">
						<sform:options items="${frmTransfer.frmAccounts }" 
						itemLabel="accNo" itemValue="accNo"/>
					</sform:select><br>
		Select To account:
					<sform:select path="frmToAccNo">
						<sform:options items="${frmTransfer.frmAccounts }"
						itemLabel="accNo" itemValue="accNo"/>
					</sform:select><br>	
		Enter Transfer Amount:<sform:input path="frmAmount"/>		<br>
		<input type="submit" value="Transfer"/>					
</sform:form>



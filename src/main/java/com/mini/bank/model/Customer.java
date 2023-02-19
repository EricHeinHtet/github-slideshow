package com.mini.bank.model;


import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Customer {
	@NotEmpty(message = "User Name is required")
	private String frmCustName;
	@Size(min=4,max=10)
	private String frmCustPass;
	
	public String getFrmCustName() {
		System.out.println("\t\t[MODEL] getter");
		return frmCustName;
	}
	public void setFrmCustName(String frmCustName) {
		System.out.println("\t\t[MODEL] setter");
		this.frmCustName = frmCustName;
	}
	public String getFrmCustPass() {
		return frmCustPass;
	}
	public void setFrmCustPass(String frmCustPass) {
		this.frmCustPass = frmCustPass;
	}
}
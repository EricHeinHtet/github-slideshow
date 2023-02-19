package com.mini.bank.model;

import java.util.List;

import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.NotEmpty;

import com.mini.bank.entity.TblAccount;

public class Transfer {
	private List<TblAccount> frmAccounts;
	private String frmFromAccNo;
	private String frmToAccNo;
	private long frmAmount;
	private String frmError;
	
	
	
	
	public String getFrmError() {
		return frmError;
	}
	public void setFrmError(String frmError) {
		this.frmError = frmError;
	}
	public List<TblAccount> getFrmAccounts() {
		return frmAccounts;
	}
	public void setFrmAccounts(List<TblAccount> frmAccounts) {
		this.frmAccounts = frmAccounts;
	}
	public String getFrmFromAccNo() {
		return frmFromAccNo;
	}
	public void setFrmFromAccNo(String frmFromAccNo) {
		this.frmFromAccNo = frmFromAccNo;
	}
	public String getFrmToAccNo() {
		return frmToAccNo;
	}
	public void setFrmToAccNo(String frmToAccNo) {
		this.frmToAccNo = frmToAccNo;
	}
	public long getFrmAmount() {
		return frmAmount;
	}
	public void setFrmAmount(long frmAmount) {
		this.frmAmount = frmAmount;
	}
	
	
	
}

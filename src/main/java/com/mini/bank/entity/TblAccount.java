package com.mini.bank.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_account")
public class TblAccount {
	@Id
	@Column(name="acc_no")
	private String accNo;
	
	@Column(name="acc_open_date")
	private Date accOpenDate;
	
	@Column(name="acc_status")
	private boolean accStatus;
	
	@Column(name="acc_balance")
	private Long accBalance;
	
	@ManyToOne
	@JoinColumn(name="cust_id",nullable = false)
	private TblCustomer customer;
	
	@ManyToOne
	@JoinColumn(name="type_id",nullable = false)
	private TblAccountType accountType;
	
	@OneToMany(mappedBy ="account",fetch = FetchType.EAGER)
	private Set<TblTransaction> transactions;

	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public Date getAccOpenDate() {
		return accOpenDate;
	}

	public void setAccOpenDate(Date accOpenDate) {
		this.accOpenDate = accOpenDate;
	}

	public boolean isAccStatus() {
		return accStatus;
	}

	public void setAccStatus(boolean accStatus) {
		this.accStatus = accStatus;
	}

	public Long getAccBalance() {
		return accBalance;
	}

	public void setAccBalance(Long accBalance) {
		this.accBalance = accBalance;
	}

	public TblCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(TblCustomer customer) {
		this.customer = customer;
	}

	public TblAccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(TblAccountType accountType) {
		this.accountType = accountType;
	}

	public Set<TblTransaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<TblTransaction> transactions) {
		this.transactions = transactions;
	}
	
	

}

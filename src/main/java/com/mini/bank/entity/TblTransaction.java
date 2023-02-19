package com.mini.bank.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_transaction")
public class TblTransaction {
	@Id
	@Column(name="tran_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tranId;
	@Column(name="tran_amount")
	private Long tranAmount;
	@Column(name="tran_type")
	private String tranType;
	@Column(name="tran_date")
	private Date tranDate;
	@ManyToOne
	@JoinColumn(name="tran_acc_no")
	private TblAccount account;
	public int getTranId() {
		return tranId;
	}
	public void setTranId(int tranId) {
		this.tranId = tranId;
	}
	public Long getTranAmount() {
		return tranAmount;
	}
	public void setTranAmount(Long tranAmount) {
		this.tranAmount = tranAmount;
	}
	public String getTranType() {
		return tranType;
	}
	public void setTranType(String tranType) {
		this.tranType = tranType;
	}
	public Date getTranDate() {
		return tranDate;
	}
	public void setTranDate(Date tranDate) {
		this.tranDate = tranDate;
	}
	public TblAccount getAccount() {
		return account;
	}
	public void setAccount(TblAccount account) {
		this.account = account;
	}
	
	
}



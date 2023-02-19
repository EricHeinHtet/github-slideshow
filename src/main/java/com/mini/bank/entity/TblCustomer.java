package com.mini.bank.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnTransformer;

@Entity // to map the table under Database
@Table(name="tbl_customer") //declare the mapping table under Database
public class TblCustomer{	
	public TblCustomer() {System.out.println("TblCustomer ENtity");}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cust_id")
	private int custId;
	@Column(name="cust_name")
	private String custName;
	@Column(name="cust_nrc")
	private String custNrc;
	@Column(name="cust_dob")
	private Date custDob;
	@Column(name="cust_father_name")
	private String custFatherName;
	@Column(name="cust_phone")
	private String custPhone;
	@Column(name="cust_uname")
	private String custUname;
	@Column(name="cust_pass")
	private String custPass;
	@OneToMany(mappedBy ="customer",fetch = FetchType.EAGER)
	private Set<TblAccount> accounts;
	
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustNrc() {
		return custNrc;
	}
	public void setCustNrc(String custNrc) {
		this.custNrc = custNrc;
	}
	public Date getCustDob() {
		return custDob;
	}
	public void setCustDob(Date custDob) {
		this.custDob = custDob;
	}
	public String getCustFatherName() {
		return custFatherName;
	}
	public void setCustFatherName(String custFatherName) {
		this.custFatherName = custFatherName;
	}
	public String getCustPhone() {
		return custPhone;
	}
	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}
	public String getCustUname() {
		return custUname;
	}
	public void setCustUname(String custUname) {
		this.custUname = custUname;
	}
	public String getCustPass() {
		return custPass;
	}
	public void setCustPass(String custPass) {
		this.custPass = custPass;
	}
	public Set<TblAccount> getAccounts() {
		return accounts;
	}
	public void setAccounts(Set<TblAccount> accounts) {
		this.accounts = accounts;
	}
	
	
	
	
}

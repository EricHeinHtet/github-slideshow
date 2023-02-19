package com.mini.bank.service;

import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mini.bank.dao.TblAccountDao;
import com.mini.bank.dao.TblCustomerDao;
import com.mini.bank.entity.TblAccount;
import com.mini.bank.entity.TblCustomer;
import com.mini.bank.model.Customer;

@Service
public class CustomerService {
	public CustomerService() { System.out.println("SERVICE ");}	
	@Autowired
	private TblCustomerDao tblCustomerDao;
	@Autowired
	private TblAccountDao tblAccountDao;
	
	@Transactional(readOnly = true)
	public void processLogin(Customer cust,TblCustomer tblCust) {
		try {
		BeanUtils.copyProperties(
				tblCust,
				tblCustomerDao.getCustomerByUname(
					cust.getFrmCustName(), cust.getFrmCustPass()));
		}catch(Exception e) {}
	}
	
	@Transactional(readOnly = true)
	public void processViewLoad(List<TblAccount> accList,int custId) {
		try {
			//get the accounts of login user from Database
			for(TblAccount a:tblAccountDao.getAccountsByCust(custId)) {
				//copy one account by one account
				TblAccount tmp=new TblAccount();
				BeanUtils.copyProperties(tmp,a);
				//add the reference list of the controller 
				accList.add(tmp);
			}			
		}catch(Exception e) {}
	}
	
	public void processTransactionLoad(TblCustomer cust) {
		try {
			BeanUtils.copyProperties(cust,this.tblCustomerDao.getCustomerByCustId(cust.getCustId()));
		}catch(Exception e) {}
	}
	
	public void processChangePassword(TblCustomer cust) {
		this.tblCustomerDao.updatePassword(cust);
	}
}

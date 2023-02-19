package com.mini.bank.service;

import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mini.bank.dao.TblAccountDao;
import com.mini.bank.entity.TblAccount;
import com.mini.bank.entity.TblTransaction;
import com.mini.bank.model.Transfer;

@Service
public class TransferService {
	@Autowired
	private TblAccountDao tblAccountDao;

	public void processTransferLoad(Transfer transfer, int custId) {
		transfer.setFrmAccounts(new ArrayList<TblAccount>());
		try {
			// get the accounts of login user from Database
			for (TblAccount a : tblAccountDao.getAccountsByCust(custId)) {
				// copy one account by one account
				TblAccount tmp = new TblAccount();
				BeanUtils.copyProperties(tmp, a);
				// add the reference list of the controller
				transfer.getFrmAccounts().add(tmp);
			}
		} catch (Exception e) {
		}
	}

	public void processTransfer(Transfer transfer) {
		String strFrom = transfer.getFrmFromAccNo();
		String strTo = transfer.getFrmToAccNo();
		Long amount = transfer.getFrmAmount();
		if (this.tblAccountDao.getAccountByAccNo(strTo) == null) {
			transfer.setFrmError(transfer.getFrmToAccNo() + " is not exist in this Bank");
		} else {
			TblAccount fromAcc = this.tblAccountDao.getAccountByAccNo(strFrom);
			if (fromAcc.getAccBalance() < amount) {
				transfer.setFrmError(transfer.getFrmFromAccNo() + " is not sufficient amount");
			} else {
				transfer.setFrmError("");
				TblTransaction fromTran = new TblTransaction();
				fromTran.setTranAmount(amount);
				fromTran.setTranType("withdraw");
				fromTran.setTranDate(new Date());

				TblTransaction toTran = new TblTransaction();
				toTran.setTranAmount(amount);
				toTran.setTranType("deposit");
				toTran.setTranDate(new Date());

				tblAccountDao.transfer(strFrom, strTo, amount, fromTran, toTran);
			}
		}

	}

}

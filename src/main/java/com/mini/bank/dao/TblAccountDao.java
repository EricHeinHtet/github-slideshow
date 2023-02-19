package com.mini.bank.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mini.bank.entity.TblAccount;
import com.mini.bank.entity.TblCustomer;
import com.mini.bank.entity.TblTransaction;

@Repository
@Transactional
public class TblAccountDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(rollbackFor = Exception.class)
	public void transfer(String fromAccNo, String toAccNo, Long amount, TblTransaction fromTran,
			TblTransaction toTran){
		Session s = this.sessionFactory.getCurrentSession();

		TblAccount fromAcc = s.find(TblAccount.class, fromAccNo);// select * from tbl_account where acc_no=?
		fromAcc.setAccBalance(fromAcc.getAccBalance() - amount);
		s.update(fromAcc);// updae tbl_account

		TblAccount toAcc = s.find(TblAccount.class, toAccNo);// select * from tbl_account where acc_no=?
		toAcc.setAccBalance(toAcc.getAccBalance() + amount);
		s.update(toAcc);// updae tbl_account

		fromTran.setAccount(fromAcc);
		s.save(fromTran);

		toTran.setAccount(toAcc);
		s.save(toTran);

	}

	public List<TblAccount> getAccountsByCust(int custId) {
		List<TblAccount> l = new ArrayList<TblAccount>();
		Session s = this.sessionFactory.getCurrentSession();

		String hql = "from TblAccount  where customer.custId=:cid";
		Query q = s.createQuery(hql);
		q.setParameter("cid", custId);
		l = q.getResultList();

		return l == null || l.isEmpty() ? null : l;
	}

	public TblAccount getAccountByAccNo(String accNo) {
		Session s = this.sessionFactory.getCurrentSession();
		// select * from table where primaryKey=value
		// HQL
		TblAccount account = s.find(TblAccount.class, accNo);
		return account;
	}

}

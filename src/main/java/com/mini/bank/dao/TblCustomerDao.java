package com.mini.bank.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mini.bank.entity.TblCustomer;

@Repository
@Transactional
public class TblCustomerDao {
	public TblCustomerDao() {System.out.println("Dao");}
	@Autowired
	private SessionFactory sessionFactory;
	public TblCustomer getCustomerByUname(String uname,String password) {
		TblCustomer tblCust=null;
		Session s=this.sessionFactory.getCurrentSession();
		//sql =====> select * from tbl_customer where cust_unmae=? and cust_pass=?
		//hql =====> operate the query on ClassName that has already mapped with table
		String hql="from TblCustomer where custUname=:cname and custPass=:cpass";
		Query q=s.createQuery(hql);
		q.setParameter("cname",uname);
		q.setParameter("cpass",password);
		List resultList=q.getResultList();
		if(resultList!=null && !resultList.isEmpty()) 
		    tblCust=(TblCustomer)resultList.get(0);

		return tblCust;
	}
	public TblCustomer getCustomerByCustId(int custId) {
		Session s=this.sessionFactory.getCurrentSession();
		TblCustomer tblCust=s.find(TblCustomer.class,custId);
		return tblCust;
	}
	public void updatePassword(TblCustomer cust) {
		Session s=this.sessionFactory.getCurrentSession();
		s.update(cust);
	}
}

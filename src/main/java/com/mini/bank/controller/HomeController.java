package com.mini.bank.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mini.bank.dao.TblAccountDao;
import com.mini.bank.entity.TblAccount;
import com.mini.bank.entity.TblCustomer;
import com.mini.bank.model.Customer;
import com.mini.bank.model.Transfer;
import com.mini.bank.service.CustomerService;
import com.mini.bank.service.TransferService;
import com.mini.bank.util.SessionUtil;

@Controller
public class HomeController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private SessionUtil sessionUtil;

	@GetMapping(value = { "/viewAccPath" })
	public String renderViewAccount(HttpSession s, Model model) {
		// check login session time out or not
		String viewName = sessionUtil.renderSessionTimeOut(s, model);
		if (viewName == null) {
			// no session Timeout
			// get login customer
			TblCustomer cust = (TblCustomer) s.getAttribute("loginUser");
			// prepare the account list
			List<TblAccount> accList = new ArrayList<TblAccount>();
			// call the service to get the account list of the login customer
			// by passing prepared list and login id
			customerService.processViewLoad(accList, cust.getCustId());
			// set the result list into model to show on MODEL
			model.addAttribute("accList", accList);
		}
		return viewName != null ? viewName : "view_account";
	}

	@GetMapping(value = { "/viewTranPath" })
	public String renderViewTransaction(HttpSession s, Model model) {
		String viewName = sessionUtil.renderSessionTimeOut(s, model);
		if (viewName == null) {
			TblCustomer cust=new TblCustomer();
			cust.setCustId(((TblCustomer)s.getAttribute("loginUser")).getCustId());
			this.customerService.processTransactionLoad(cust);
			model.addAttribute("frmCustTran",cust);
		}
		return viewName != null ? viewName : "view_transaction";
	}

	@GetMapping(value = { "/changePassPath" })
	public String renderChangePass(HttpSession s, Model model) {
		String viewName = sessionUtil.renderSessionTimeOut(s, model);
		if (viewName == null) {
			model.addAttribute("frmCust",new Customer());
		}
		return viewName != null ? viewName : "change_password";
	}
	@PostMapping(value = { "/changePassPath" })
	public String renderChangePassProcess(HttpSession s, Model model,
			@ModelAttribute("frmCust")Customer cust) {
		String viewName = sessionUtil.renderSessionTimeOut(s, model);
		if (viewName == null) {
			TblCustomer curr=(TblCustomer)s.getAttribute("loginUser");
			curr.setCustPass(cust.getFrmCustPass());
			this.customerService.processChangePassword(curr);
		}
		return viewName != null ? viewName : "home";
	}

	@GetMapping(value = { "/logoutPath" })
	public String renderLogout(HttpSession s, Model model) {
		s.removeAttribute("loginUser");
		s.invalidate();
		model.addAttribute("frmCust", new Customer());
		return "login";
	}

}

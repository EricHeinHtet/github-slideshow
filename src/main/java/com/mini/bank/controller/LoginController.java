package com.mini.bank.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mini.bank.entity.TblCustomer;
import com.mini.bank.model.Customer;
import com.mini.bank.service.CustomerService;

//Spring MVC : Controller Part
@Controller
public class LoginController {
	
	public LoginController() {
		System.out.println("Controller ");
	}

	@Autowired
	private CustomerService customerService;

	// return view name {prefix}viewname{suffix}
	@GetMapping(value = { "/" }) // doGet
	public String renderLoginLoad(Model model) {
		model.addAttribute("frmCust", new Customer());
		return "login";
	}

	@PostMapping(value = { "/loginPath" })
	public String renderLogin(@Validated @ModelAttribute("frmCust") Customer cust, // carry the data from view
			BindingResult bindingResult, // respond the error exist or not from SPRING
			Model model, // send data to view
			HttpSession session) {// control for the session

		if (bindingResult.hasErrors()) {
			model.addAttribute("frmCust", cust);
			return "login";
		}

		TblCustomer tblCust = new TblCustomer();
		customerService.processLogin(cust, tblCust);
		if (tblCust == null || tblCust.getCustName() == null) {
			model.addAttribute("frmCust", cust);
			model.addAttribute("errLogin", "User Name and Password is mismatch");
			return "login";
		} else {
			session.setAttribute("loginUser", tblCust);
			return "home";
		}
	}
}

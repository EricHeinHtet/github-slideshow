package com.mini.bank.util;

import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import com.mini.bank.model.Customer;
public class SessionUtil {
	public String renderSessionTimeOut(HttpSession s, Model model) {
		if (s == null || s.getAttribute("loginUser") == null) {
			model.addAttribute("errLogin", "Your login is time out");
			model.addAttribute("frmCust", new Customer());
			return "login";
		} else
			return null;
	}
}
package com.mini.bank.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mini.bank.entity.TblCustomer;
import com.mini.bank.model.Transfer;
import com.mini.bank.service.TransferService;
import com.mini.bank.util.SessionUtil;

@Controller
public class TransferController {
	@Autowired
	private TransferService transferService;
	@Autowired
	private SessionUtil sessionUtil;

	@GetMapping(value = { "/transferOwnPath", "/transferOtherPath" })
	public String renderTransferOwn(@RequestParam("type") String type, HttpSession s, Model model) {
		String viewName = sessionUtil.renderSessionTimeOut(s, model);
		if (viewName == null) {
			Transfer transfer = new Transfer();
			this.transferService.processTransferLoad(transfer, ((TblCustomer) s.getAttribute("loginUser")).getCustId());
			model.addAttribute("frmTransfer", transfer);
			model.addAttribute("frmType", type);
		}
		return viewName != null ? viewName : "transfer";
	}

	/*
	 * @GetMapping(value = { "/transferOwnPath" }) public String
	 * renderTransferOwn(HttpSession s, Model model) { String viewName =
	 * sessionUtil.renderSessionTimeOut(s, model); Transfer transfer = new
	 * Transfer(); this.transferService.processTransferLoad(transfer, ((TblCustomer)
	 * s.getAttribute("loginUser")).getCustId()); model.addAttribute("frmTransfer",
	 * transfer); return viewName != null ? viewName : "transfer_own"; }
	 * 
	 * @GetMapping(value = { "/transferOtherPath" }) public String
	 * renderTransferOther(HttpSession s, Model model) { String viewName =
	 * sessionUtil.renderSessionTimeOut(s, model); Transfer transfer = new
	 * Transfer(); this.transferService.processTransferLoad(transfer, ((TblCustomer)
	 * s.getAttribute("loginUser")).getCustId()); model.addAttribute("frmTransfer",
	 * transfer); return viewName != null ? viewName : "transfer_other"; }
	 */

	@PostMapping(value = { "/transferPath" })
	public String renderTransfer(HttpSession s, Model model, 
			@ModelAttribute("frmTransfer") Transfer transfer,
			@RequestParam("type")String type) {
		String viewName = sessionUtil.renderSessionTimeOut(s, model);
		if (viewName == null) {
			this.transferService.processTransfer(transfer);
			if(!transfer.getFrmError().isEmpty()) {
				this.transferService.processTransferLoad(transfer, ((TblCustomer) s.getAttribute("loginUser")).getCustId());
			   model.addAttribute("frmType",type);
				viewName="transfer";
			}else {
				viewName="home";
			}
		}
		return viewName; //sessionTimeout[login]  noToAccount[transfer]  sucess[home]
	}
}

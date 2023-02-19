package com.mini.bank.ws.controller;

import java.util.Date;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mini.bank.dao.TblAccountDao;
import com.mini.bank.entity.TblAccount;
import com.mini.bank.entity.TblTransaction;

@RestController
public class AccountService {
	@Autowired
	public TblAccountDao tblAccountDao;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(
			value="/checkValid/{accNo}",
			method=RequestMethod.GET,
			headers="Accept=application/json")
	public String checkValidOrNot(@PathVariable String accNo) {
		TblAccount acc=this.tblAccountDao.getAccountByAccNo(accNo);
		JSONObject  jsObj=new JSONObject();
		jsObj.put("status",true);//account exist
		if(acc==null) jsObj.put("status",false);
		return jsObj.toJSONString();
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(
			value="/checkAmt",
			method=RequestMethod.GET,
			headers="Accept=application/json")	
	public String checkEnoughOrNot(@RequestParam("accNo") String accNo,@RequestParam("amt")String amtStr) {
		TblAccount acc=this.tblAccountDao.getAccountByAccNo(accNo);
		Long amt=Long.valueOf(amtStr);
		JSONObject  jsObj=new JSONObject();
		jsObj.put("status",true);//amount enough
		if(amt>acc.getAccBalance())  jsObj.put("status",false);
		return jsObj.toJSONString();
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(
			value="/transfer",
			method=RequestMethod.PUT,
			headers="Accept=application/json")	
	public void transfer(@RequestBody String jsStr) {
		try {
			JSONParser jsParser=new JSONParser();
			JSONObject jsObj=(JSONObject)jsParser.parse(jsStr);
			String fromAccNo=(String)jsObj.get("from");
			String toAccNo=(String)jsObj.get("to");
			Long amt=(Long)jsObj.get("amt");
			
			TblTransaction fromTran = new TblTransaction();
			fromTran.setTranAmount(amt);
			fromTran.setTranType("withdraw");
			fromTran.setTranDate(new Date());

			TblTransaction toTran = new TblTransaction();
			toTran.setTranAmount(amt);
			toTran.setTranType("deposit");
			toTran.setTranDate(new Date());
			
			this.tblAccountDao.transfer(fromAccNo, toAccNo, amt, fromTran, toTran);
			
		}catch(Exception e) {}
	}
}




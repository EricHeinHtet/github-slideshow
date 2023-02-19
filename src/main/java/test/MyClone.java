package test;

import com.mini.bank.entity.TblCustomer;

public class MyClone {

	public static void main(String[] args) throws CloneNotSupportedException {
		TblCustomer c1=new TblCustomer();
		TblCustomer c2=new TblCustomer();
		
		System.out.println("C1 :"+c1);
		System.out.println("C2 :"+c2);
		
		c1.setCustName("XXXXXXX");
		
		//c2=(TblCustomer)c1.clone();
		System.out.println("C1 :"+c1);
		System.out.println("C2 :"+c2);
		System.out.println("C1 Data "+c1.getCustName());
		System.out.println("C2 Data "+c2.getCustName());
		
	}

}


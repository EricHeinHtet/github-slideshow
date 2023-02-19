package test;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.mini.bank.entity.TblCustomer;

public class MyCopyUtils {

	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
		TblCustomer c1=new TblCustomer();
		TblCustomer c2=new TblCustomer();
		c1.setCustName("U BA");

		System.out.println("Check c1 ="+c1+":"+c1.getCustName());
		System.out.println("Check c2 ="+c2+":"+c2.getCustName());
		
		BeanUtils.copyProperties(c2, c1);
		
		System.out.println("Check c1 ="+c1+":"+c1.getCustName());
		System.out.println("Check c2 ="+c2+":"+c2.getCustName());
	}

}

package com.mini.bank.init;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//similar with web.xml
public class WebInitializer  extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("Root COnfig Method in Web Initializer");
		return new Class[] {HibernateInitializer.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("Servlet COnfig Method in Web Initializer");
		return new Class[] {SpringInitializer.class};
	}

	@Override
	protected String[] getServletMappings() {//<servlet-mapping>
		System.out.println("Servlet Mapping Method in Web Initializer");
		return new String[] {"/"};
	}

}

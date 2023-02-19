package com.mini.bank.init;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.mini.bank.util.SessionUtil;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.mini.bank"})
@PropertySource( value ={"classpath:message.properties"})
public class SpringInitializer implements  WebMvcConfigurer{
	//View configuration
	@Bean
	public InternalResourceViewResolver viewResolver() {
		System.out.println("\tINternal Resource View Resolver");
		InternalResourceViewResolver resolver=new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	@Bean
	public SessionUtil sessionUtil() {
		return new SessionUtil();
	}
}
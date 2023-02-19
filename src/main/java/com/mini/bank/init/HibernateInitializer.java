package com.mini.bank.init;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource( value ={"classpath:database.properties","classpath:hibernate.properties"})
@EnableTransactionManagement
public class HibernateInitializer {
	@Autowired
	private Environment environment;
	public HibernateInitializer() {
		System.out.println("Hiberante Initializer starting....");		
	}	
	@Bean
	public DataSource dataSource() {
		System.out.println("Data Source connnection.....");
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName(environment.getProperty("jdbc.driver"));
		ds.setUrl(environment.getProperty("jdbc.url"));
		ds.setUsername(environment.getProperty("jdbc.user"));
		ds.setPassword(environment.getProperty("jdbc.password"));		
		return ds;		
	}
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		System.out.println("SessionFactory Creation for Hibernate Framework.....");
		LocalSessionFactoryBean lsfb=new LocalSessionFactoryBean();
		lsfb.setDataSource(dataSource()); //database connection that created by SPRING for Hibernate
		lsfb.setHibernateProperties(hibernateProperties());
		lsfb.setPackagesToScan("com.mini.bank.entity");//point to the location of @Entity
		return lsfb;		
	}
	private Properties hibernateProperties() {
		Properties prop=new Properties();
		prop.put("hibernate.dialect",environment.getProperty("hb.dialect"));
		prop.put("hibernate.show_sql",environment.getProperty("hb.sql.show"));
		prop.put("hibernate.format_sql",environment.getProperty("hb.sql.format"));
		return prop;
	}
	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager htm=new HibernateTransactionManager();
		htm.setSessionFactory(sessionFactory().getObject());
		return htm;
	}
}




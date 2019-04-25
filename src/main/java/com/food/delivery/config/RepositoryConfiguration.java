package com.food.delivery.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.food.delivery.repository")
//@PropertySource("classpath:application.propertiesss")
@EnableTransactionManagement 
public class RepositoryConfiguration {
	
	@Autowired
	private DataSource dataSource;
	@Autowired
	private Environment env;
	
	@Bean
	public DataSource productDataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		/*
		 * dataSource.setDriverClassName(env.getProperty(
		 * "spring.datasource.driver-class-name"));
		 * dataSource.setUrl(env.getProperty("spring.datasource.url"));
		 * dataSource.setUsername(env.getProperty("spring.datasource.username"));
		 * dataSource.setPassword(env.getProperty("spring.datasource.password"));
		 */
		
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost/food_delivery");
		dataSource.setUsername("root");
		dataSource.setPassword("mysql");
		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(productDataSource());
		emf.setPackagesToScan(new String[] { "com.food.delivery.model" });
		
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setShowSql(true);
		vendorAdapter.setGenerateDdl(true);
		emf.setJpaVendorAdapter(vendorAdapter);
		
		Map<String, Object> jpaProperties = new HashMap<String, Object>();
		jpaProperties.put("hibernate.hbm2ddl.auto", "update");//env.getProperty("hibernate.hbm2ddl.auto"));
		jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");//env.getProperty("hibernate.dialect"));
		jpaProperties.put("hibernate.show-sql", "true");//env.getProperty("hibernate.show-sql"));

		emf.setJpaPropertyMap(jpaProperties);
        
		return emf;
	}

	@Primary
	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager txnMgr = new JpaTransactionManager();
		txnMgr.setEntityManagerFactory(entityManagerFactory().getObject());
		return txnMgr;
	}

	/*
	 * @Bean public ReloadableResourceBundleMessageSource messageSource() {
	 * ReloadableResourceBundleMessageSource messageSource = new
	 * ReloadableResourceBundleMessageSource();
	 * messageSource.setBasenames("classpath:error/Food_Delivey_Spring_MVC");
	 * messageSource.setDefaultEncoding("UTF-8"); return messageSource; }
	 */

}

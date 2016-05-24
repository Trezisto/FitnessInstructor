package com.prijilevschi.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Main configuration class for testing
 * 
 * @author Evgheni Prijilevschi
 *
 */
@EnableWebMvc
@ComponentScan(basePackages = { "com.prijilevschi.*" }, excludeFilters = { @Filter(type = FilterType.ANNOTATION, value = Configuration.class) })
@EnableTransactionManagement
public class TestConfig {
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource());
		emf.setJpaVendorAdapter(jpaVendorAdapter());
		emf.setJpaDialect(jpaDialect());
		emf.setJpaProperties(getJpaProperties());
		emf.setPersistenceUnitName("myPersistenceUnit");
		emf.setPackagesToScan("com.prijilevschi.model");
		return emf;
	}

	private Properties getJpaProperties() {
		Properties prop = new Properties();
		prop.put("hibernate.hbm2ddl.auto", "create-drop");
		prop.put("hibernate.format_sql", "false");
		prop.put("hibernate.show_sql", "true");
		prop.put("hibernate.dialect",
				"org.hibernate.dialect.HSQLDialect");
		return prop;
	}

	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("org.hsqldb.jdbcDriver");
		ds.setUrl("jdbc:hsqldb:mem:fitness_instructor");
		ds.setUsername("test");
		ds.setPassword("test");
		return ds;
	}

	@Bean
	public HibernateJpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter jpaVendor = new HibernateJpaVendorAdapter();
		jpaVendor.setShowSql(true);
		return jpaVendor;
	}

	// Create a transaction manager
	@Bean
	public JpaTransactionManager txManager(EntityManagerFactory emf) {
		JpaTransactionManager jpaTM = new JpaTransactionManager();
		jpaTM.setEntityManagerFactory(emf);
		jpaTM.setDataSource(dataSource());
		jpaTM.setJpaDialect(jpaDialect());
		return jpaTM;
	}

	@Bean
	public HibernateJpaDialect jpaDialect() {
		return new HibernateJpaDialect();
	}
	
}

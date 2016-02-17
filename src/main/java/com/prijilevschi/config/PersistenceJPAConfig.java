package com.prijilevschi.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * JPA configuration for application.
 * 
 * @author Evgheni Prijilevschi
 *
 */
@Configuration
@EnableTransactionManagement
public class PersistenceJPAConfig {
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
		prop.put("hibernate.hbm2ddl.auto", "update");
		prop.put("hibernate.format_sql", "false");
		prop.put("hibernate.show_sql", "true");
		prop.put("hibernate.dialect",
				"org.hibernate.dialect.MySQL5InnoDBDialect");
		return prop;
	}

	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/fitness_instructor?autoReconnect=true");
		ds.setUsername("root");
		ds.setPassword("oracle2013Query");
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

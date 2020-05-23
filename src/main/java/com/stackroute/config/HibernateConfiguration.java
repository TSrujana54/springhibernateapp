package com.stackroute.config;
import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.stackroute.model.Team;

@Configuration
@EnableTransactionManagement
public class HibernateConfiguration {		
		@Bean
		@Autowired
		public DataSource getConnection() {
			BasicDataSource ds = new BasicDataSource();
			ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
			ds.setUrl("jdbc:mysql://localhost:3306/test");
			ds.setUsername("root");
			ds.setPassword("root");
			return ds;
		}
		
		
		@Bean
		 public LocalSessionFactoryBean getSessionFactory(DataSource dataSource) throws IOException {
			 LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
			 sessionFactoryBean.setDataSource(dataSource);
			 Properties properties = new Properties();
			 properties.put("hibernate.show.sql","true");
			 properties.put("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
			 properties.put("hibernate.hbm2ddl.auto","update");
			 
			 sessionFactoryBean.setAnnotatedClasses(Team.class);
			 sessionFactoryBean.setHibernateProperties(properties);
			 sessionFactoryBean.afterPropertiesSet();
			 return sessionFactoryBean;
			 
		 }

		
		 @Bean
		 public HibernateTransactionManager  getTransactionManager(SessionFactory sessionFactory) {
			 HibernateTransactionManager  transactionManager = new HibernateTransactionManager();
			 transactionManager.setSessionFactory(sessionFactory);
			 return transactionManager;
		 }


	


}

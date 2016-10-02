package com.spring.uniteAll.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.spring.uniteAll.Dao.BlogDAOImpl;
import com.spring.uniteAll.Dao.ForumDAOImpl;
import com.spring.uniteAll.Dao.UserDAOImpl;
import com.spring.uniteAll.model.Blog;
import com.spring.uniteAll.model.Forum;
import com.spring.uniteAll.model.Job;
import com.spring.uniteAll.model.User;


@Configuration
/*@EnableWebMvc*/
@ComponentScan("com.spring.uniteAll")
@EnableTransactionManagement

public class ApplicationContextConfig {
	
		

	    
		 @Bean(name = "dataSource")
		    public DataSource getDataSource() {
		    	BasicDataSource dataSource = new BasicDataSource();
		    	dataSource.setDriverClassName("org.h2.Driver");
		    	dataSource.setUrl("jdbc:h2:tcp://localhost/~/newunite");
		    	dataSource.setUsername("sa");
		    	dataSource.setPassword(""); 
		    	
		    	return dataSource;
		    }
		    
		    
		    private Properties getHibernateProperties() {
		    	Properties properties = new Properties();
		    	properties.put("hibernate.show_sql", "true");
		    	properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		    	properties. put("hibernate.hbm2ddl.auto","update");
		    	return properties;
		    } 
	     
	    @Autowired
	    @Bean(name = "sessionFactory")
	    public SessionFactory getSessionFactory(DataSource dataSource) {
	    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	    	sessionBuilder.addProperties(getHibernateProperties());
	    	sessionBuilder.addAnnotatedClasses(Blog.class);
	    	sessionBuilder.addAnnotatedClasses(User.class);
	    	sessionBuilder.addAnnotatedClasses(Forum.class);
	    	sessionBuilder.addAnnotatedClasses(Job.class);
	    	
	    	return sessionBuilder.buildSessionFactory();
	    }
	    
		@Autowired
		@Bean(name = "transactionManager")
		public HibernateTransactionManager getTransactionManager(
				SessionFactory sessionFactory) {
			HibernateTransactionManager transactionManager = new HibernateTransactionManager(
					sessionFactory);

			return transactionManager;
		}
	    
	    
	    
	    @Autowired
	    @Bean(name = "userDAO")
	    public UserDAOImpl geUserOrderDao(SessionFactory sessionFactory) {
	    	return new UserDAOImpl(sessionFactory);
	    }
	    
	    
	    @Autowired
	    @Bean(name = "blogDAO")
	    public BlogDAOImpl geBlogDAO(SessionFactory sessionFactory) {
	    	return new BlogDAOImpl(sessionFactory);
	    }
	    
	    @Autowired
	    @Bean(name = "forumDAO")
	    public ForumDAOImpl geForumDAO(SessionFactory sessionFactory) {
	    	return new ForumDAOImpl(sessionFactory);
	    }
	}

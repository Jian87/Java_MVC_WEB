package com.jian.lcapp.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan("com.jian.lcapp")
@PropertySource("classpath:mail.properties")
public class LoveCalculatorAppConfig implements WebMvcConfigurer {

	@Autowired
	private Environment env;
	
	@Bean
	public ViewResolver vierResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	@Bean
	public JavaMailSender javaMailSender() {
		
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
		
		System.out.println(env.getProperty("mail.host"));
		javaMailSender.setHost(env.getProperty("mail.host"));
		javaMailSender.setUsername(env.getProperty("mail.username"));
		javaMailSender.setPassword(env.getProperty("mail.password"));
		javaMailSender.setPort(Integer.parseInt(env.getProperty("mail.port")));
		
		Properties properties = new Properties();
		properties.put("mail.smtp.starttls.enable", true);
		properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		javaMailSender.setJavaMailProperties(properties);
		
		return javaMailSender;
	}
	
	@Bean
	public DataSource dataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		// initial the database information here
		dataSource.setUsername("your_database_name");
		dataSource.setPassword("your_database_password");
		dataSource.setUrl("your_database_url");
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate JdbcTemplate() {
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
		
		return jdbcTemplate;
	}
	
	@Bean
	public MessageSource messageSource() {
		
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		
		return messageSource;
	}
	
	@Override
	public Validator getValidator() {
		
		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
		bean.setValidationMessageSource(messageSource());
		
		return bean;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry
		.addResourceHandler("/UrlToJSFile/**")
		.addResourceLocations("/layout/js/");
	}
	
}

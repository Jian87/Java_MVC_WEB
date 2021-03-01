package com.jian.lcapp.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class LoveCalculatorAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(LoveCalculatorAppConfig.class);
		
		DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
		
		ServletRegistration.Dynamic servletDynamic = servletContext.addServlet("My Dispatcher Servlet", dispatcherServlet);
		
		servletDynamic.addMapping("/");
		servletDynamic.setLoadOnStartup(1);

	}

}

package com.company.filters;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Configurator implements ServletContextListener
{
    @Override
    public void contextInitialized(ServletContextEvent event)
    {
        ServletContext context = event.getServletContext();
        FilterRegistration.Dynamic registration = context.addFilter("filterA", new FilterA());
        registration.setAsyncSupported(true);
        registration.addMappingForUrlPatterns(null, false, "/login", "/chat");
    }
    @Override
    public void contextDestroyed(ServletContextEvent event) { }
}

package com.company.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "FilterA")
public class FilterA implements Filter
{
    public void destroy() { }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException
    {
        System.out.println("Entering FilterA.doFilter().");
        chain.doFilter(req, resp);
        System.out.println("Leaving FilterA.doFilter().");
    }

    public void init(FilterConfig config) throws ServletException
    {

    }
}

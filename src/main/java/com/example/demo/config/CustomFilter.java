package com.example.demo.config;

import java.io.IOException;

import org.springframework.boot.actuate.web.exchanges.HttpExchange.Principal;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class CustomFilter implements Filter {
	 @Override
	    public void init(FilterConfig filterConfig) throws ServletException {
	        System.out.println("Init::called");
	    }

	    @Override
	    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
	        System.out.println("doFilter::called");

	        HttpServletRequest request = (HttpServletRequest) servletRequest;

	        java.security.Principal userPrincipal = request.getUserPrincipal();
	        System.out.println("userPrinciple::"+userPrincipal);
	        filterChain.doFilter(servletRequest, servletResponse);
	    }

	    @Override
	    public void destroy() {
	        System.out.println("Destroy::called");

	    }
	}

	
	
	

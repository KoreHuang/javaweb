package com.video.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hr = (HttpServletRequest) request;
		
		String url = hr.getRequestURI();
		String path = url.substring
				(url.lastIndexOf("/")+1,url.lastIndexOf("."));
		
		
		if(!path.equals("LoginAction!login")){
			HttpSession session = hr.getSession();
			
			Object obj = session.getAttribute("user");
			if(obj == null){
				HttpServletResponse hro = (HttpServletResponse) response;
				hro.sendRedirect("login.jsp");
				return;
			}
		}
			
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}

package com.video.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.video.service.LoginService;
import com.video.vo.AdminVO;

public class LoginAction{
	
	
	
	
	protected void login(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			String user = req.getParameter("user");
			String pass = req.getParameter("pass");
			
			LoginService ls = new LoginService();
			
			AdminVO admin= ls.login(user, pass);
			
			if(admin != null){
				
				HttpSession session = req.getSession();
				session.setAttribute("user", admin.getUserName());
				resp.sendRedirect("success.html");
			}else{
				req.setAttribute("error", "用户名或密码错误");
				req.getRequestDispatcher("login.jsp")
						.forward(req, resp);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}

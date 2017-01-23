package com.video.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.video.vo.DirectionVO;

public class JSTLAction extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setAttribute("a","wx");
		HttpSession session = req.getSession();
		req.setAttribute("s1","wwwwwx");
		session.setAttribute("s1", "sssssss1");
		
		DirectionVO dvo = new DirectionVO();
		
		dvo.setDirection("哈怂");
		
		req.setAttribute("dvo", dvo);
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 5; i++) {
			list.add("a"+i);
		}
		req.setAttribute("list",list);
		
		req.getRequestDispatcher("jstl.jsp").forward(req, resp);
	}
	
	
}

package com.video.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.video.service.DireInfoService;
import com.video.vo.DTypeVO;
import com.video.vo.DirectionVO;


public class DireInfoAction extends HttpServlet {
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String id = request.getParameter("id");
			//将其他数据保存至数据库
			DireInfoService ds = new DireInfoService();
			
			DirectionVO dVO = ds.findDireInfoById(id);
			List<DTypeVO> listType = ds.findTypeListByDireId(id);
			
			request.setAttribute("dvo", dVO);
			request.setAttribute("listType",listType);
			
			
			request.getRequestDispatcher("dire_info.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}

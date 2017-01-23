package com.video.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.video.service.DireInfoService;
import com.video.service.DireService;
import com.video.vo.DTypeVO;
import com.video.vo.DirectionVO;

public class DireAction {
	
	public void addDire(){
		System.out.println("添加一个课程方向.......");
	}
	
	public void findDireList(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		
		
			
			String s_page = req.getParameter("page");
			String s_pageSize = req.getParameter("pageSize");
			DireService ds = new DireService();
			List<DirectionVO> listDire =ds.findDireList(s_page,s_pageSize);
			int totalPage = ds.getFindDirePage(s_pageSize);
			req.setAttribute("totalPage",totalPage);
			req.setAttribute("listDire",listDire);
			req.getRequestDispatcher("dire_list.jsp").
			forward(req, resp);
			
			
		
	}
	
	public void findDireInfo
		(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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

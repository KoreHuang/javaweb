package com.video.action;

import java.io.IOException;
import java.lang.reflect.Method;
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

import org.apache.tomcat.jni.Local;

import com.video.service.DireInfoService;
import com.video.vo.DTypeVO;
import com.video.vo.DirectionVO;


public class ControlAction extends HttpServlet {
	public static final ThreadLocal<Connection> 
	LOCAL = new ThreadLocal<Connection>();
	
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		try {
			String ss = (String) request.getAttribute("myFilter");
			
			System.out.println(ss);
			
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.
					getConnection
		("jdbc:mysql://localhost:3306/video", "root","123456");
			conn.setAutoCommit(false);
			LOCAL.set(conn);
			String url = request.getRequestURI();
			String path = url.substring
					(url.lastIndexOf("/")+1,url.lastIndexOf("."));
			String[] s = path.split("!");
			Class clazz = Class.forName("com.video.action."+s[0]);
			Method me = clazz.getDeclaredMethod(s[1],HttpServletRequest.class,HttpServletResponse.class);
			Object obj = clazz.newInstance();
			me.invoke(obj,request,response);
			
			conn.commit();
			
		} catch (Exception e) {
			try {
				conn.rollback();
				response.sendRedirect("error.html");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally{
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}

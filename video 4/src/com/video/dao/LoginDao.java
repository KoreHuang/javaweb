package com.video.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.video.vo.AdminVO;

public class LoginDao {
	
	
	public AdminVO login(String user,String pass){
		AdminVO admin = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/video", "root","123456");
			
			PreparedStatement pre = conn.prepareStatement("SELECT * FROM v_admin WHERE login_name=? AND password=?");
			
			pre.setString(1, user);
			pre.setString(2, pass);
			
			ResultSet rs = pre.executeQuery();
			if(rs.next()){
				admin = new AdminVO();
				admin.setUserName(rs.getString("user_name"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return admin;
	}
	
	
}

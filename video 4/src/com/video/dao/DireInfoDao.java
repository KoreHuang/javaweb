package com.video.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.video.vo.AdminVO;
import com.video.vo.DTypeVO;
import com.video.vo.DirectionVO;

public class DireInfoDao {
	
	public DirectionVO findDireInfoById(String id){
		DirectionVO dVO = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection
			("jdbc:mysql://localhost:3306/video","root","123456");
			
			PreparedStatement pre =conn.prepareStatement("SELECT * FROM v_direction WHERE id=?");
			pre.setString(1, id);
			
			ResultSet rs = pre.executeQuery();
			
			if(rs.next()){
				dVO= new DirectionVO(); 
				dVO.setDirection(rs.getString("direction"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dVO;
	}
	
	
	public List<DTypeVO> findTypeListByDireId(String id){
		
		List<DTypeVO> listType = new ArrayList<DTypeVO>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection
			("jdbc:mysql://localhost:3306/video","root","123456");
			PreparedStatement pre2 = conn.prepareStatement("SELECT * FROM v_type WHERE did=?");
			
			pre2.setString(1, id);
			
			ResultSet rs2 = pre2.executeQuery();
			
			listType = new ArrayList<DTypeVO>();
			
			while(rs2.next()){
				DTypeVO type = new DTypeVO();
				type.setTname(rs2.getString("tname"));
				listType.add(type);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listType;
	}
	
	
	
}

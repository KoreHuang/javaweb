package com.video.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.video.action.ControlAction;
import com.video.vo.DirectionVO;

public class DireDao {

	public List<DirectionVO> findDireList
				(String s_page, String s_pageSize) {
		List<DirectionVO> listDire = null;
		try {
			int page = Integer.parseInt(s_page);
			int pageSize = Integer.parseInt(s_pageSize);
			
			Connection conn = ControlAction.LOCAL.get();
			
			
			System.out.println(conn);
			
			PreparedStatement pre = conn.prepareStatement
					("SELECT * FROM v_direction limit ?,?");
			
			pre.setInt(1, (page-1)*pageSize);
			pre.setInt(2, pageSize);
			
			ResultSet rs = pre.executeQuery();
			listDire = new ArrayList<DirectionVO>();
			 
			while(rs.next()){
				DirectionVO dv = new DirectionVO();
				dv.setDirection(rs.getString("direction"));
				dv.setId(rs.getInt("id"));
				listDire.add(dv);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listDire;
	}
	
	
	
	public int findDireCount() throws Exception{
		int total = 0;
		
			Connection conn = ControlAction.LOCAL.get();
			
			//统计所有记录条数
			Statement sta = conn.createStatement();
			ResultSet rs2 = sta.executeQuery("SELECT count(*) total FROM v_direction");
			if(rs2.next()){
				total = rs2.getInt("total");
			}
			return total;
	}
	
	
	
}

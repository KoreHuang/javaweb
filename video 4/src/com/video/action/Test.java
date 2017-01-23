package com.video.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test {
	
	public static void main(String[] args) {
		try {
			
			System.out.println(Thread.currentThread());
			
			
			new Thread(
					
				new Runnable() {
					@Override
					public void run() {
						System.out.println(Thread.currentThread());
					}
				}	
					
			).start();
			
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.
					getConnection("jdbc:mysql://localhost:3306/video", "root","123456");
			
			Connection conn2 = DriverManager.
					getConnection("jdbc:mysql://localhost:3306/video", "root","123456");
			
			conn.setAutoCommit(false);
			conn2.setAutoCommit(false);
			
			try {
				PreparedStatement pre = conn.prepareStatement("INSERT INTO v_direction(direction) values('哈哈哈')");
				
				pre.executeUpdate();
				
				
				PreparedStatement pre2 = conn2.prepareStatement("INSER22T INTO v_direction(direction) values('哈哈哈222')");
				
				pre2.executeUpdate();
			} catch (Exception e) {
				System.out.println("出错了.....");
				conn2.rollback();
			}
			
			conn.commit();
			conn2.commit();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}
	
}

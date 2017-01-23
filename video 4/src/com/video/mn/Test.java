package com.video.mn;


public class Test {
	
	public static ThreadLocal<User> LOCAL = new ThreadLocal<User>();
	
	
	public static void main(String[] args) {
		
		
		try {
			for (int i = 0; i < 10; i++) {
				Thread.sleep(1000);
				User u = new User("大笨蛋"+i);
				new MyThread("T"+i,u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
}

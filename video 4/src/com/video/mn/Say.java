package com.video.mn;

public class Say {
	
	
	public void say(){
		User u = Test.LOCAL.get();
		System.out.println(u.getName()
				+"是笨蛋!!!!"+Thread.currentThread().getName());
	}
	
	
}

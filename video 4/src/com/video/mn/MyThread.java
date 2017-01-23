package com.video.mn;

public class MyThread extends Thread{
	private User u;

	
	public MyThread(String name,User u) {
		
		this.setName(name);
		this.u = u;
		this.start();
	}
	
	
	@Override
	public void run() {
		Test.LOCAL.set(u);
		new Say().say();
	}
	
	
	
}

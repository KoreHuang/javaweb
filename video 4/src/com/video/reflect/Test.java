package com.video.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
	
	public static void main(String[] args) throws Exception{
		Class  clazz = User.class;
		/*
		Field[] filed = clazz.getDeclaredFields();
		for (Field f : filed) {
			System.out.println(f.getName());
		}
		Method[] mes = clazz.getDeclaredMethods();
		for (Method me : mes) {
			System.out.println(me.getName());
		}
		clazz.getDeclaredMethod("eat",null);*/
		/*
		User user = new User();
		user.eat();*/
		
		Method me = clazz.getDeclaredMethod
				("add", int.class,int.class);
		Object obj = clazz.newInstance();
		me.invoke(obj, 1,2);
		
		
	}
	
	
	
}

package com.video.service;

import com.video.dao.LoginDao;
import com.video.vo.AdminVO;

public class LoginService {
	
	
	public AdminVO login(String user,String pass){
		return new LoginDao().login(user, pass);
	}
	
	
	
}

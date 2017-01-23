package com.video.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.video.dao.DireInfoDao;
import com.video.vo.DTypeVO;
import com.video.vo.DirectionVO;


public class DireInfoService {
	
	public DirectionVO findDireInfoById(String id){
		
		return new DireInfoDao().findDireInfoById(id);
	}
	
	
	public List<DTypeVO> findTypeListByDireId(String id){
		
		
		return new DireInfoDao().findTypeListByDireId(id);
	}
	
	
}

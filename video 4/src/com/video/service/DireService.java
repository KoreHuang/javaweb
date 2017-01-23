package com.video.service;

import java.util.List;

import com.video.dao.DireDao;
import com.video.vo.DirectionVO;

public class DireService {

	public List<DirectionVO> findDireList
	(String s_page, String s_pageSize) {
		
		return new DireDao().findDireList(s_page,s_pageSize);
	}
	
	public int getFindDirePage(String s_pageSize) throws Exception{
		int total = new DireDao().findDireCount();
		
		int pageSize = Integer.parseInt(s_pageSize);
		
		int totalPage = 0;
		if(total%pageSize == 0){
			totalPage  = total/pageSize;
		}else{
			totalPage  = total/pageSize+1;
		}
		
		return totalPage;
	}

	
	
}

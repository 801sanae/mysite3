package com.hanains.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanains.mysite.dao.GuestBookDao;
import com.hanains.mysite.vo.GuestBookVo;
import com.hanains.mysite.vo.UserVo;

@Service
public class GuestBookService {

	@Autowired
	GuestBookDao dao;
	
	public List<GuestBookVo> getlist() {
		List<GuestBookVo> list = dao.getlist();
		return list;
	}

	public void insert(GuestBookVo vo) {
		dao.insert(vo);
	}

	public void delete(GuestBookVo vo) {
		dao.delete(vo);
	}

}

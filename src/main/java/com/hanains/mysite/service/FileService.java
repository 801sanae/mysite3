package com.hanains.mysite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanains.mysite.dao.FileDao;
import com.hanains.mysite.vo.FileVo;

@Service
public class FileService {
	
	@Autowired
	private FileDao dao;
	
	public void insert(FileVo vo) {
		dao.insert(vo);
	}
}

package com.hanains.mysite.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hanains.mysite.vo.FileVo;

@Repository
public class FileDao {

	@Autowired
	private SqlSession sqlSession;
	
	public void insert( FileVo vo ) {
		sqlSession.insert("file.insert", vo);
	}
	
}

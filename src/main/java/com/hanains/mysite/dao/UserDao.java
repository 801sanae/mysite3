package com.hanains.mysite.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hanains.mysite.exception.RepositoryException;
import com.hanains.mysite.vo.UserVo;

@Repository//scanning을 위한 annotation, component도 상관없음?~
public class UserDao {

	@Autowired
	private SqlSession sqlSession;
	
	
	public UserVo get( String email, String password ) throws RepositoryException{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("email", email);
		map.put("password", password);
		
		UserVo userVo = sqlSession.selectOne("user.getbyEmailAndPassword", map);
		return userVo;
	}

	public void insert( UserVo vo ) {
		sqlSession.insert("user.insert", vo);
	}
	
	public UserVo get(int no){
		UserVo vo = sqlSession.selectOne("user.getByNo", no);
		return vo;
	}

	public UserVo get(String email) {
		UserVo vo = sqlSession.selectOne("user.selectByEmail", email);
		return null;
	}
	
	public void delete(UserVo vo){
		sqlSession.delete("user.deleteNoPassword", vo);
	}
}
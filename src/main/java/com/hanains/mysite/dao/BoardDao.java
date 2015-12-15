package com.hanains.mysite.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hanains.mysite.vo.BoardVo;

@Repository
public class BoardDao {
	
	@Autowired
	private SqlSession sqlSession;

	//TODO
	public void insert(BoardVo vo){
		sqlSession.insert("board.insert", vo);
	}
	
	//TODO
	public void delete(){}
	
	//TODO
	public void update(BoardVo vo){
		sqlSession.update("guestbook.update", vo);
	}
	
	//TODO
	public BoardVo getView(BoardVo vo){
		BoardVo boardVo =sqlSession.selectOne("board.getView", vo); 
		return boardVo;
	}
	
	//TODO
	public List<BoardVo> getList(){
		System.out.println("::board getList Start");
		List<BoardVo> list = sqlSession.selectList("board.getList");
		return list;
	}
}

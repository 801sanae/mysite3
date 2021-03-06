package com.hanains.mysite.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hanains.mysite.vo.BoardVo;

@Repository
public class BoardDao {
	
	@Autowired
	private SqlSession sqlSession;

	//TODO 트렌젝션 @처리
	@Transactional
	public void insert(BoardVo board){
		sqlSession.update("board.updateOrder",board);
		sqlSession.insert("board.insert", board);
	}
	
	//TODO
	public void delete(BoardVo board){
		sqlSession.delete("board.delete", board);
	}
	
	//TODO
	public void update(BoardVo board){
		sqlSession.update("board.update", board);
	}
	
	//TODO
	public BoardVo getView(BoardVo board){
		
		BoardVo boardVo =sqlSession.selectOne("board.getView", board); 
		System.out.println("DAO = getView:"+boardVo);
		return boardVo;
	}
	
	//TODO
	public List<BoardVo> getList(){
		System.out.println("::board getList Start");
		List<BoardVo> list = sqlSession.selectList("board.getList");
		return list;
	}

	public void updateViewCnt(BoardVo board) {
		sqlSession.update("board.updateViewCnt", board);
		
	}
}

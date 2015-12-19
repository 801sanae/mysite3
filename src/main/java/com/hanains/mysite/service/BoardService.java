package com.hanains.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanains.mysite.dao.BoardDao;
import com.hanains.mysite.vo.BoardVo;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao dao;

	public void insert(BoardVo board) {
		dao.insert(board);
	}
	
	public void update(BoardVo board) {
		dao.update(board);
	}

	public void delete(BoardVo board) {
		dao.delete(board);
	}
	
	public BoardVo getView(BoardVo board) {
		BoardVo vo = dao.getView(board);
		return vo;
	}
	
	public List<BoardVo> getList() {
		List<BoardVo> list = dao.getList();
		return list;
	}

	public void updateViewCnt(BoardVo board) {
		dao.updateViewCnt(board);
	}



}

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

	public void insert(BoardVo vo) {
		dao.insert(vo);
	}
	
	public List<BoardVo> getList() {
		List<BoardVo> list = dao.getList();
		return list;
	}

	public BoardVo getView(BoardVo vo) {
		BoardVo board = dao.getView(vo);
		return board;
	}

	public void update(BoardVo board) {
		dao.update(board);
	}

}

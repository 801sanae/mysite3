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

	public List<BoardVo> getList() {
		List<BoardVo> list = dao.getList();
		return list;
	}

	public void insert(BoardVo vo) {
		System.out.println("boardservice:"+vo);
		dao.insert(vo);
	}

	public BoardVo getView(int no) {
		System.out.println("boardservice:"+no);
		BoardVo board = dao.getView(no);
		return board;
	}

	public void update(BoardVo board) {
		System.out.println("boardserviceL"+board);
		dao.update(board);
	}

}

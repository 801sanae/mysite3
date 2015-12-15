package com.hanains.mysite.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hanains.mysite.service.BoardService;
import com.hanains.mysite.vo.BoardVo;
import com.hanains.mysite.vo.UserVo;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request){
		List<BoardVo> list  = boardService.getList();
		request.setAttribute("list", list);
		return "/board/list";
	}
	
	@RequestMapping("/writeform")
	public String writeform(){
		return "/board/write";
	}
	
	@RequestMapping("/write")
	public String write(@ModelAttribute BoardVo vo,HttpServletRequest request){
		String content = request.getParameter("content");
		UserVo memberVo = (UserVo) request.getSession(true).getAttribute("authUser");
		
		vo.setUserVo(memberVo);
		vo.setContents(content);
		
		System.out.println("::controller:"+vo);
		
		boardService.insert(vo);
		return "redirect:/board/list";
	}
	
	@RequestMapping("view")
	public String view(@ModelAttribute BoardVo vo, HttpServletRequest request){
		System.out.println("::contorller:"+vo.getNo());
		
		BoardVo board = boardService.getView(vo);
		
		request.setAttribute("board", board);
		
		return "/board/view";
	}
	
	@RequestMapping("updateform")
	public String updateform(@ModelAttribute BoardVo vo, HttpServletRequest request){
		BoardVo board = boardService.getView(vo);
		request.setAttribute("board", board);
		return "/board/modify";
	}
	
	@RequestMapping("update")
	public String update(HttpServletRequest request,
						@ModelAttribute BoardVo vo,
						@RequestParam("no") int no,
						@RequestParam("title") String title,
						@RequestParam("content") String content){
		
		BoardVo board = boardService.getView(vo);
		board.setTitle(title);
		board.setContents(content);
		
		request.setAttribute("board", board);
		
		boardService.update(board);
		return "/board/view";
	}
}

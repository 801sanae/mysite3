package com.hanains.mysite.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hanains.mysite.service.GuestBookService;
import com.hanains.mysite.vo.GuestBookVo;

@Controller
@RequestMapping("/guestbook")
public class GuestBookController {
	
	@Autowired
	private GuestBookService guestBookService;
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request){
		List<GuestBookVo> list =guestBookService.getlist();
		
		request.setAttribute("list", list);
		
		return "/guestbook/list";
	}
	
	@RequestMapping("/insert")
	public String insert(@ModelAttribute GuestBookVo vo, HttpServletRequest request){
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String content=request.getParameter("content");
		
		vo.setName(name); vo.setPassword(password); vo.setMessage(content);
		System.out.println("insert = "+vo);
		guestBookService.insert(vo);
		
		return "redirect:/guestbook/list";
	}
	
	@RequestMapping("form")
	public String form(){
		return "/guestbook/deleteform";
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, @ModelAttribute GuestBookVo vo){
		
		System.out.println("deleteC:"+vo);
		
		guestBookService.delete(vo);
		
		return "redirect:/guestbook/list";
	}
	
}

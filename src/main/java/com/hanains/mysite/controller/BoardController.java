package com.hanains.mysite.controller;

import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hanains.mysite.annotation.Auth;
import com.hanains.mysite.annotation.AuthUser;
import com.hanains.mysite.service.BoardService;
import com.hanains.mysite.service.FileService;
import com.hanains.mysite.vo.BoardVo;
import com.hanains.mysite.vo.FileVo;
import com.hanains.mysite.vo.UserVo;

@Controller
@RequestMapping("/board")
public class BoardController {

	private static final String SAVE_PATH = "/temp/"; //저장위치 

	@Autowired
	private BoardService boardService;

	@Autowired
	private FileService fileService;

	@RequestMapping("/list")
	public String list(HttpServletRequest request){
		List<BoardVo> list  = boardService.getList();
		request.setAttribute("list", list);
		return "/board/list";
	}

	@Auth
	@RequestMapping("/writeform")
	public String writeform(@ModelAttribute BoardVo vo, @AuthUser UserVo authUser,
			@RequestParam(value="group_no", required=false, defaultValue="0") int group_no,
			@RequestParam(value="order_no", required=false, defaultValue="0") int order_no,
			@RequestParam(value="depth", required=false, defaultValue="0") int depth,
			HttpServletRequest request){
		System.out.println("C:writeform"+authUser);

		vo.setMember_no(authUser.getNo());
		vo.setDepth(depth);
		vo.setGroup_no(group_no);
		vo.setOrder_no(order_no);

		request.setAttribute("board", vo);


		return "/board/write";
	}

	@Auth
	@RequestMapping("/write")
	public String write(
			@ModelAttribute BoardVo vo,
			@RequestParam( "uploadFile" ) MultipartFile multipartFile, 
			Model model,
			@ModelAttribute FileVo file,
			@AuthUser UserVo authUser){
		vo.setMember_no(authUser.getNo());

		// 파일 처리
		if( multipartFile.isEmpty() == false ) {

			String fileOriginalName = multipartFile.getOriginalFilename();
			String extName = fileOriginalName.substring( fileOriginalName.lastIndexOf(".") + 1, fileOriginalName.length() );
			String fileName = multipartFile.getName();
			Long size = multipartFile.getSize();

			String saveFileName = genSaveFileName( extName );

			writeFile( multipartFile, SAVE_PATH, saveFileName );

			String url = "/profile-images/" + saveFileName;

			file.setPath(url);
			file.setBoardNo(vo.getNo());


			model.addAttribute( "profileUrl", url );
		}


		fileService.insert(file);

		boardService.insert(vo);

		return "redirect:/board/list";
	}

	@Auth
	@RequestMapping("/view")
	public String view(@ModelAttribute BoardVo vo, HttpServletRequest request){
		System.out.println(vo);
		BoardVo board = boardService.getView(vo);

		request.setAttribute("board", board);

		return "/board/view";
	}

	@Auth
	@RequestMapping("/updateform")
	public String updateform(@ModelAttribute BoardVo vo, HttpServletRequest request){
		BoardVo board = boardService.getView(vo);
		
		request.setAttribute("board", board);
		return "/board/modify";
	}

	@Auth
	@RequestMapping("/update")
	public String update(@AuthUser UserVo authUser,
			@ModelAttribute BoardVo vo,
			HttpServletRequest request){
		boardService.update(vo);
		BoardVo board = boardService.getView(vo);
		
		request.setAttribute("board", board);
		return "/board/view";
	}
	
	@Auth
	@RequestMapping("/delete")
	public String delete(@AuthUser UserVo authUser,@ModelAttribute BoardVo vo){
		BoardVo board = boardService.getView(vo);
		boardService.delete(board);
		
		return "redirect:/board/list";
	}


	private void writeFile( MultipartFile file, String path, String fileName ) {
		FileOutputStream fos = null;
		try {
			byte fileData[] = file.getBytes();
			fos = new FileOutputStream( path + fileName );
			fos.write(fileData);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (Exception e) {
				}
			}
		}
	}

	private String genSaveFileName( String extName ) {

		Calendar calendar = Calendar.getInstance();
		String fileName = "";

		fileName += calendar.get( Calendar.YEAR );
		fileName += calendar.get( Calendar.MONTH );
		fileName += calendar.get( Calendar.DATE );
		fileName += calendar.get( Calendar.HOUR );
		fileName += calendar.get( Calendar.MINUTE );
		fileName += calendar.get( Calendar.SECOND );
		fileName += calendar.get( Calendar.MILLISECOND );
		fileName += ( "." + extName );

		return fileName;
	}
}

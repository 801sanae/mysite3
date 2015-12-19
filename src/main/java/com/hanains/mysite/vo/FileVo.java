package com.hanains.mysite.vo;

public class FileVo {
	private int no;
	private String path;
	private int boardNo;
	
	public FileVo() {}
	
	public int getNo() {
		return no;
	}
	public String getPath() {
		return path;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	@Override
	public String toString() {
		return "FileVo [no=" + no + ", path=" + path + ", boardNo=" + boardNo + "]";
	}
	
	
}

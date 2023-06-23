package com.gyojincompany.mybatis.board.dao;

import java.util.ArrayList;

import com.gyojincompany.mybatis.board.dto.BoardDto;

public interface BoardDao {
	
	public ArrayList<BoardDto> listDao();//게시판 모든 글 목록 가져오기
	public void writeDao(String bid, String btitle, String bcontent);//게시판 글 쓰기;
	
}

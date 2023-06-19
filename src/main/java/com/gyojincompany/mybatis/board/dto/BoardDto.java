package com.gyojincompany.mybatis.board.dto;

import java.sql.Timestamp;

public class BoardDto {
	
	private int bnum;//게시판 번호
	private String bid;//글쓴이 아이디
	private String btitle;//게시판 글제목
	private String bcontent;//게시판 내용
	private int bhit;//조회수
	private Timestamp bdate;//게시글 등록일
	
	public BoardDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardDto(int bnum, String bid, String btitle, String bcontent, int bhit, Timestamp bdate) {
		super();
		this.bnum = bnum;
		this.bid = bid;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bhit = bhit;
		this.bdate = bdate;
	}
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public int getBhit() {
		return bhit;
	}
	public void setBhit(int bhit) {
		this.bhit = bhit;
	}
	public Timestamp getBdate() {
		return bdate;
	}
	public void setBdate(Timestamp bdate) {
		this.bdate = bdate;
	}
	
	

}

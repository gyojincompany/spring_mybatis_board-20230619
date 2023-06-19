package com.gyojincompany.mybatis.member.dao;

public interface MemberDao {
	
	public void joinMemberDao(String mid, String mpw, String mname, String memail);//회원 가입
	public int loginDao(String mid, String mpw);//회원 로그인 체크

}

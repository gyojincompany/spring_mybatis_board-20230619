package com.gyojincompany.mybatis.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gyojincompany.mybatis.member.dao.MemberDao;

@Controller
public class MemberController {
	
	@Autowired//의존 자동 주입
	private SqlSession sqlSession;
	
	@RequestMapping(value = "/join")
	public String join() {
		return "joinMember";
	}
	
	@RequestMapping(value = "/joinOk", method = RequestMethod.POST)
	public String joinOk(HttpServletRequest request, Model model) {		
		
//		request.setCharacterEncoding("utf-8");
		
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		
		dao.joinMemberDao(request.getParameter("mid"), request.getParameter("mpw"), request.getParameter("mname"), request.getParameter("memail"));
		
		model.addAttribute("memberID", request.getParameter("mid"));
		
		return "joinOk";
	}
	
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/loginOk", method = RequestMethod.POST)
	public String loginOk(HttpServletRequest request, Model model, HttpSession session) {
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		
		int loginFlag = dao.loginDao(mid, mpw);//1이 반환되면 로그인 성공, 0이 반환되면 로그인 실패
		
		if(loginFlag == 1) {//참이면 로그인 성공
			session.setAttribute("sessionId", mid);	
			model.addAttribute("memberID", mid);
		}		
		
		model.addAttribute("loginCheck", loginFlag);
		
		return "loginOk";
	}

}

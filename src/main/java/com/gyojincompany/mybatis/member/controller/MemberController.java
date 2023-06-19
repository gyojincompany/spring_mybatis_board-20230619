package com.gyojincompany.mybatis.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gyojincompany.mybatis.member.dao.MemberDao;

@Controller
public class MemberController {
	
	@Autowired//의존 자동 주입
	private SqlSession sqlSession;
	
	@RequestMapping(value = "/join")
	public String join() {
		return "joinMember";
	}
	
	@RequestMapping(value = "/joinOk")
	public String joinOk(HttpServletRequest request, Model model) {		
		
//		request.setCharacterEncoding("utf-8");
		
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		
		dao.joinMemberDao(request.getParameter("mid"), request.getParameter("mpw"), request.getParameter("mname"), request.getParameter("memail"));
		
		model.addAttribute("memberID", request.getParameter("mid"));
		
		return "joinOk";
	}

}

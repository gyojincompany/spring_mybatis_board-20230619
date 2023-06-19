package com.gyojincompany.mybatis.board.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gyojincompany.mybatis.board.dao.BoardDao;
import com.gyojincompany.mybatis.member.dao.MemberDao;

@Controller
public class BoardController {
	
	@Autowired//의존 자동 주입
	private SqlSession sqlSession;
	
	@RequestMapping(value = "/list")
	public String list(Model model) {
		
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		
		System.out.println(dao.listDao().get(0).toString());
		
		model.addAttribute("list", dao.listDao());
		
		return "list";
	}

}

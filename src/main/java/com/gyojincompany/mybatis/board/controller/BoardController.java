package com.gyojincompany.mybatis.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gyojincompany.mybatis.board.dao.BoardDao;
import com.gyojincompany.mybatis.board.dto.BoardDto;
import com.gyojincompany.mybatis.member.dao.MemberDao;

@Controller
public class BoardController {
	
	@Autowired//의존 자동 주입
	private SqlSession sqlSession;
	
	@RequestMapping(value = "/list")
	public String list(Model model) {
		
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		
		//System.out.println(dao.listDao().get(0).toString());
		
		model.addAttribute("list", dao.listDao());
		
		return "list";
	}
	
	@RequestMapping(value = "/write_form")
	public String write_form(HttpSession session, Model model) {
		
		String sessionId = (String) session.getAttribute("sessionId");
		
		if(sessionId == null) {
			model.addAttribute("sessionId", "GUEST");
		} else {
			model.addAttribute("sessionId", sessionId);
		}
		
		
		return "writeForm";
	}
	
	@RequestMapping(value = "/write")
	public String write(HttpServletRequest request) {
		
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		
		dao.writeDao(request.getParameter("bid"), request.getParameter("btitle"), request.getParameter("bcontent"));
		
		return "redirect:list";
	}
	
	@RequestMapping(value = "/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		
//		request.getParameter("bnum");//클라이언트가 클릭한 글의 번호
		
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		
		BoardDto boardDto = dao.contentViewDao(request.getParameter("bnum"));
		
		//System.out.println("글제목테스트:"+boardDto.getBtitle());
		
		model.addAttribute("boardDto", boardDto);
		
		return "contentView";
	}
	
	@RequestMapping(value = "/content_modify")
	public String content_modify(HttpServletRequest request, Model model) {
		
//		request.getParameter("bnum");//클라이언트가 클릭한 글의 번호
		
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		
		BoardDto boardDto = dao.contentViewDao(request.getParameter("bnum"));
		
		//System.out.println("글제목테스트:"+boardDto.getBtitle());
		
		model.addAttribute("boardDto", boardDto);
		
		return "contentModify";
	}
	
	@RequestMapping(value = "/modify")
	public String modify(HttpServletRequest request) {
		
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		
		dao.contentModifyDao(request.getParameter("bnum"), request.getParameter("btitle"), request.getParameter("bcontent"));
		
		return "redirect:list";
	}

}

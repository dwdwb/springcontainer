package com.mycompany.springcontainer.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.springcontainer.dao.Ch13BoardDaoOld;
import com.mycompany.springcontainer.dto.Ch13Board;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch13")
public class Ch13Controller {
	@Resource
	private Ch13BoardDaoOld boardDaoOld;
	
	@RequestMapping("/content")
	public String content() {
		return "ch13/content";
	}

	@GetMapping("/insertBoard")
	public String insertBoard() {
		log.info("실행");
		
		Ch13Board board = new Ch13Board();
		board.setBtitle("덥다");
		board.setBcontent("개졸려요");
		board.setMid("user");
		
		boardDaoOld.insert(board);
		return "redirect:/ch13/content";
	}

	@GetMapping("/getBoardList")
	public String getBoardList() {
		boardDaoOld.selectAll();
		return "redirect:/ch13/content";
	}

	@GetMapping("/updateBoard")
	public String updateBoard() {
		boardDaoOld.updateByBno();
		return "redirect:/ch13/content";
	}

	@GetMapping("/deleteBoard")
	public String deleteBoard() {
		boardDaoOld.deleteByBno();
		return "redirect:/ch13/content";
	}
}
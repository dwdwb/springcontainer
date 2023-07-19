package com.mycompany.springcontainer.controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	public HomeController() {
		log.info("객체 생성");
	}
	
	@PostConstruct
	public void method1() {
		log.info("@PostConstruct: 객체 생성 후 실행");
	}
	
	@PreDestroy
	public void method2() {
		log.info("@PreDestroy: 객체 소멸 전 실행");
	}
	
	@RequestMapping("/")
	public String index() {
		log.info("실행");
		return "home";
	}
}

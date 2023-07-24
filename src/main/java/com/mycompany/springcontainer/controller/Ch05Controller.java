package com.mycompany.springcontainer.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch05")
public class Ch05Controller {
	@RequestMapping("/content")
	public String content() {
		return "ch05/content";
	}
	
	@GetMapping("/getHeaderValue")
	public String getHeaderValue(
			@RequestHeader("User-Agent") String userAgent,
			HttpServletRequest request) {
		log.info("User-Agent: " + userAgent);
		log.info("Client IP: " + request.getRemoteAddr());
		return "redirect:/ch05/content";
	}
	
	@GetMapping("/createCookie")
	public String createCookie(HttpServletResponse response) {
		
		Cookie cookie = new Cookie("useremail", "summer@mycompany.com");
		cookie.setDomain("localhost");
		cookie.setPath("/");
		cookie.setMaxAge(30*60);
		cookie.setHttpOnly(false);
		cookie.setSecure(false);
		response.addCookie(cookie);
		
		return "redirect:/ch05/content";
	}
	
	@GetMapping("/getCookie")
	public String getCookie(@CookieValue("useremail") String userEmail) {
		log.info("useremail: " + userEmail);
		return "redirect:/ch05/content";
	}
}

package com.mycompany.springcontainer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.springcontainer.service.Ch12ServiceDiByAnnotation;
import com.mycompany.springcontainer.service.Ch12ServiceDiByXml;
import com.mycompany.springcontainer.service.Ch12ServicePropertyDi;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch12")
public class Ch12Controller {
	@Autowired
	private Ch12ServiceDiByXml serviceDiByXml;

	@Autowired
	private Ch12ServiceDiByAnnotation serviceDiByAnnotation;
	
	@Autowired
	private Ch12ServicePropertyDi servicePropertyDi;
	
	@RequestMapping("/content")
	public String content() {
		serviceDiByXml.method();
		serviceDiByAnnotation.method();
		servicePropertyDi.method();
		return "ch12/content";
	}
}

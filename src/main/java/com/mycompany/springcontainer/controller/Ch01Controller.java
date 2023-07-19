package com.mycompany.springcontainer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.springcontainer.controller.Ch01Controller;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch01")
public class Ch01Controller {
   //private static final Logger log = LoggerFactory.getLogger(Ch01Controller.class);
   
   @RequestMapping("/content")
   public String content() {
      log.info("실행");
      return "ch01/content";
   }
   @RequestMapping("/button1")
   public String button1() {
      log.info("실행");
      return "ch01/content";
   }
   @RequestMapping("/button2")
   public String button2() {
      log.info("실행");
      return "redirect:/ch01/content"; //이걸로 requestmapping 하라
   }
}
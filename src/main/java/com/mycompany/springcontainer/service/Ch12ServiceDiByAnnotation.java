package com.mycompany.springcontainer.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mycompany.springcontainer.dao.Ch12DaoByAnnotation1;
import com.mycompany.springcontainer.dao.Ch12DaoByAnnotation2;
import com.mycompany.springcontainer.dao.Ch12DaoByAnnotation3;
import com.mycompany.springcontainer.dao.Ch12DaoI;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Ch12ServiceDiByAnnotation {
	//필드
	@Autowired  //@Resource
	private Ch12DaoByAnnotation1 daoAnnotation1;
	
	private Ch12DaoByAnnotation2 daoAnnotation2;
	private Ch12DaoByAnnotation3 daoAnnotation3;
	
	//필드(같은 인터페이스의 구현객체가 2개 이상일 때 충돌이 일어남 -> 해결 방법 2가지)
	@Resource(name="ch12DaoImpl1")
	private Ch12DaoI ch12Dao1;
	@Autowired @Qualifier("ch12DaoImpl2")
	private Ch12DaoI ch12Dao2;
	
	//기본생성자
	public Ch12ServiceDiByAnnotation() {
		log.info("실행");
	}
	//생성자
	//@Autowired  //생성자 주입(기본 생성자가 없을 때)
	public Ch12ServiceDiByAnnotation(Ch12DaoByAnnotation1 daoAnnotation1) {
		log.info("실행");
		this.daoAnnotation1 = daoAnnotation1;
	}
	
	//Setter
	public void setDaoAnnotation1(Ch12DaoByAnnotation1 daoAnnotation1) {
		log.info("실행");
		this.daoAnnotation1 = daoAnnotation1;
	}
	
	@Autowired  //@Resource
	public void setDaoAnnotation2(Ch12DaoByAnnotation2 daoAnnotation2) {
		log.info("실행");
		this.daoAnnotation2 = daoAnnotation2;
	}
	@Autowired  //@Resource
	public void setDaoAnnotation3(Ch12DaoByAnnotation3 daoAnnotation3) {
		log.info("실행");
		this.daoAnnotation3 = daoAnnotation3;
	}
	
	//인스턴스 메소드
	public void method() {
		daoAnnotation1.method();
		daoAnnotation2.method();
		daoAnnotation3.method();
		ch12Dao1.method();
		ch12Dao2.method();
	}
	
}

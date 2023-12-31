package com.mycompany.springcontainer.service;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.mycompany.springcontainer.dao.Ch12DaoByXml1;
import com.mycompany.springcontainer.dao.Ch12DaoByXml2;
import com.mycompany.springcontainer.dao.Ch12DaoByXml3;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ch12ServiceDiByXml {
	//필드
	private Ch12DaoByXml1 daoByXml1;
	private Ch12DaoByXml2 daoByXml2;
	private Ch12DaoByXml3 daoByXml3;

	//기본생성자
	public Ch12ServiceDiByXml() {
		log.info("실행");
	}
	//생성자
	public Ch12ServiceDiByXml(Ch12DaoByXml1 daoByXml1) {
		log.info("실행");
		this.daoByXml1 = daoByXml1;
	}
	
	//Setter
	public void setCh12DaoXml1(Ch12DaoByXml1 daoByXml1) {
		log.info("실행");
		this.daoByXml1 = daoByXml1;
	}
	public void setCh12DaoXml2(Ch12DaoByXml2 daoByXml2) {
		log.info("실행");
		this.daoByXml2 = daoByXml2;
	}
	public void setCh12DaoXml3(Ch12DaoByXml3 daoByXml3) {
		log.info("실행");
		this.daoByXml3 = daoByXml3;
	}
	
	//Setter(컬렉션)
	public void setCollection1(List<String> list) {
		log.info("실행");
		for(String item : list) {
			log.info(item);
		}
	}
	public void setCollection2(Set set) {
		log.info("실행");
		log.info("아이템 수: " + set.size());
	}
	public void setCollection3(Map<String, Object> map) {
		log.info("실행");
		log.info("아이템 수: " + map.size());
	}
	public void setCollection4(Properties prop) {
		log.info("실행");
		log.info("아이템 수: " + prop.size());
	}
	
	//인스턴스 메소드
	public void method() {
		daoByXml1.method();
		daoByXml2.method();
		daoByXml3.method();
	}
}

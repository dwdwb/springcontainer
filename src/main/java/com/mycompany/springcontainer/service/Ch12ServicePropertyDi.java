package com.mycompany.springcontainer.service;

import org.springframework.beans.factory.annotation.Value;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ch12ServicePropertyDi {
	//필드
	@Value("${file.upload.dir}")
	private String fileUploadDir;
	@Value("${test.prop1}")
	private int prop1;
	private double prop2;
	private boolean prop3;
	private String prop4;

	//Setter
	@Value("${test.prop2}")
	public void setProp2(double prop2) {
		this.prop2 = prop2;
	}
	@Value("${test.prop3}")
	public void setProp3(boolean prop3) {
		this.prop3 = prop3;
	}
	public void setProp4(String prop4) {
		this.prop4 = prop4;
	}
	
	//인스턴스 메소드
	public void method() {
		log.info("fileUploadDir: " + fileUploadDir);
		log.info("prop1: " + prop1);
		log.info("prop2: " + prop2);
		log.info("prop3: " + prop3);
		log.info("prop4: " + prop4);
	}

}

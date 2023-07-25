package com.mycompany.springcontainer.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Ch09FileUpload {
	private String title;
	private String desc;
	private MultipartFile attach;
}

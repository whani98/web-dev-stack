package com.kh.upload.model.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class BoardDTO {
	
    private String title;
    private String content;
    private MultipartFile file;
}

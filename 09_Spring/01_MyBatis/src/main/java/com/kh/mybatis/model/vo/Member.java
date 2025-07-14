package com.kh.mybatis.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Member {
	private String id;
	private String pwd;
	private String name;
	private int age;
}

package com.kh.upload.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {

	void boardAdd();
	void boardAll();
	void boardDelete();
	void boardSearch();
	void boardUpdate();
}

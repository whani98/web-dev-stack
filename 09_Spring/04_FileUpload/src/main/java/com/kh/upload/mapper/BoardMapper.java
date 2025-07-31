package com.kh.upload.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.upload.model.dto.BoardDTO;
import com.kh.upload.model.dto.PagingDTO;
import com.kh.upload.model.vo.Board;

@Mapper
public interface BoardMapper {

	void boardAdd(Board vo);
	List<Board> boardAll(PagingDTO paging);
	Board boardSearch(int no);
	void boardUpdate(BoardDTO dto);
	void boardDelete(int no);
	int total(String keyword);
}

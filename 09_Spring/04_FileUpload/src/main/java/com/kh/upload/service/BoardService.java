package com.kh.upload.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.upload.mapper.BoardMapper;
import com.kh.upload.model.dto.BoardDTO;
import com.kh.upload.model.vo.Board;

@Service
public class BoardService implements BoardMapper{

	@Autowired
	private BoardMapper mapper;
	@Override
	public void boardAdd(Board vo) {
		mapper.boardAdd(vo);
	}
	
	@Override
	public List<Board> boardAll() {
		return mapper.boardAll();
	}

	@Override
	public void boardDelete(int no) {
		mapper.boardDelete(no);
	}
	
	@Override
	public Board boardSearch(int no) {
		return mapper.boardSearch(no);
	}
	
	@Override
	public void boardUpdate(Board vo) {
		mapper.boardUpdate(vo);
	}
	
	@Override
	public void write(BoardDTO dto) {
		mapper.write(dto);
	}
	
}

package com.kh.upload.service;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.upload.mapper.BoardMapper;
import com.kh.upload.model.dto.BoardDTO;
import com.kh.upload.model.dto.PagingDTO;
import com.kh.upload.model.vo.Board;

@Service
public class BoardService {

	@Autowired
	private BoardMapper mapper;
	
	public void boardAdd(Board vo) {
		mapper.boardAdd(vo);
	}
	
	public List<BoardDTO> boardAll(PagingDTO paging) {
//		System.out.println(paging.getStartPage());
		List<Board> list = mapper.boardAll(paging);
		paging.setOffset(paging.getLimit() * (paging.getPage() - 1));
		List<BoardDTO> dtoList = new ArrayList<BoardDTO>();
		for(Board b : list) {
			BoardDTO dto = new BoardDTO();
			dto.setNo(b.getNo());
			dto.setTitle(b.getTitle());
			Date formatDate = Date.from(b.getCreatedAt().atZone(ZoneId.systemDefault()).toInstant());
			dto.setFormatDate(formatDate);
			dtoList.add(dto);
		}
		return dtoList;
	}
	
	public void boardUpdate(BoardDTO dto) {
		mapper.boardUpdate(dto);
	}
	
	public void boardDelete(int no) {	
		mapper.boardDelete(no);
	}
	
	public Board boardSearch(int no) {
		return mapper.boardSearch(no);
	}
	
	public int total(String keyword) {
		return mapper.total(keyword);
	}
	
}

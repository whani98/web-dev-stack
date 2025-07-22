package com.kh.paging.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.paging.dto.PagingDTO;
import com.kh.paging.vo.Film;

@Mapper
public interface FilmMapper {
	List<Film> showFilm(PagingDTO paging); // service에서 만든 기능, service와 파라미터 동일하게!
}

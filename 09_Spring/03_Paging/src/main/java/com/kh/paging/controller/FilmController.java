package com.kh.paging.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.paging.dto.PagingDTO;
import com.kh.paging.mapper.FilmMapper;
import com.kh.paging.service.FilmService;
import com.kh.paging.vo.Film;
//1
@Controller
public class FilmController{

	// localhost:8080/list -> GET
	// 4 service 만든 후에 부르기
	@Autowired
	private FilmService service; 
	
	// 2
	@GetMapping("/list")// list.jsp를 뜻한다!
	public String list(Model model, PagingDTO paging) {//4 모델에 담음
		System.out.println(paging);
        // 3 System.out.println("호출!"); 호출 되는지 확인
		// 5 service와 파라미터 동일하게!
		List<Film> list = service.showFilm(paging);
		model.addAttribute("list", list);
		model.addAttribute("paging", new PagingDTO(paging.getPage(), service.total()));
        // System.out.println(list);
		// list.jsp에서 list가 필요
		return "list";//2 
	}

}

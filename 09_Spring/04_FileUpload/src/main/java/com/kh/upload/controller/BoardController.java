package com.kh.upload.controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.kh.upload.model.dto.PagingDTO;
import com.kh.upload.model.dto.BoardDTO;
import com.kh.upload.model.vo.Board;
import com.kh.upload.service.BoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class BoardController {
	
	private String path = "\\\\192.168.0.35\\upload\\";

	@Autowired
    private final BoardService service;

    private final CustomErrorController customErrorController;

    BoardController(CustomErrorController customErrorController, BoardService service) {
        this.customErrorController = customErrorController;
        this.service = service;
    }

	@GetMapping("/")
	public String index() {
		return "index";
	}
	public String fileUpload(MultipartFile file) {
//		System.out.println("파일 이름 : " + file.getOriginalFilename());
//		System.out.println("파일 사이즈 : " + file.getSize());
//		System.out.println("파일 파라미터명 : " + file.getName());
		
		// 중복 방지를 위한 UUID 적용
		UUID uuid = UUID.randomUUID();
//		System.out.println(uuid.toString());
		
		String fileName = uuid.toString() + "_" + file.getOriginalFilename();
//		System.out.println(fileName);
		File copyFile = new File(path + fileName);
		try {
			file.transferTo(copyFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return fileName;
	}
	
	@PostMapping("/upload")
	public String upload(MultipartFile file) {
		System.out.println("파일 이름 : " + file.getOriginalFilename());
		System.out.println("파일 사이즈 : " + file.getSize());
		System.out.println("파일 파라미터명 : " + file.getName());
		
		String fileName = fileUpload(file);
		// http://localhost:8001/ +fileName <- url
		return "redirect:/";
	}
	
	// List<MultipartFile>
	@PostMapping("/multiUpload")
	public String multiUpload(List<MultipartFile> files) {
		for(MultipartFile file : files) {
			String fileName = fileUpload(file);
		}
		return "redirect:/";
	}
	
	@GetMapping("/list")
	public String list(Model model, PagingDTO paging) {
		System.out.println(paging.getEndPage());
//		System.out.println("keyword : " + paging.getKeyword());
		List<BoardDTO> list = service.boardAll(paging);
		model.addAttribute("list", list);
		model.addAttribute("paging", new PagingDTO(paging.getPage(), service.total(paging.getKeyword())));
		return "list";
	}
	
	@PostMapping("/write")
	public String write(BoardDTO dto) {
//		*데이터 잘 들어가는지 확인할 때
//		-파라미터가 String title, String content, MultipartFile file
//		System.out.println(title);
//		System.out.println(content);
//		System.out.println(file);
//		-파라미터가 BoardDTO dto
//		System.out.println(dto);
//		또는
//		System.out.println(dto.getTitle());
//		System.out.println(dto.getContent());
//		System.out.println(dto.getFile());
		
		// 이미지 업로드 추가
		String fileName = fileUpload(dto.getFile());
		
		// board 테이블에 데이터 추가 
		Board vo = new Board();
		vo.setTitle(dto.getTitle());
		vo.setContent(dto.getContent());
		vo.setUrl(fileName);
		service.boardAdd(vo);
		
		System.out.println(vo);
		
		return "redirect:/view?no=" + vo.getNo();
	}
	// /view?no=${board.no} -> view.jsp 데이터 보여주기
	@GetMapping("/view")
	public String view(int no, Model model) {
//		System.out.println(no);
		Board board = service.boardSearch(no);
		model.addAttribute("board", board);
		return "view";
	}
	
	@PostMapping("/update")
	public String update(BoardDTO dto) {
//		System.out.println(dto); dto 잘 받는지 확인
		// board 테이블에 데이터 수정 -> 기존 파일은 삭제하고 해당 파일을 업로드하고 DB url을 수정
		
		System.out.println(dto.getFile().isEmpty());
		if(!dto.getFile().isEmpty()) {
		// 1. 파일이 비어있지 않다면 기존 파일 삭제
		File file = new File(path + dto.getUrl());
		file.delete();
		
		// 2. 해당 파일 업로드 -> 새로운 파일의 url의 파일명
		String url = fileUpload(dto.getFile());
		dto.setUrl(url); // 새로운 파일의 url 넣기
		}

		// 3. 해당 no에 따른 데이터들 수정
//		System.out.println(dto.getUrl()+","+ dto.getFile());
		service.boardUpdate(dto);
		return "redirect:/view?no=" + dto.getNo();
	}
	
	@GetMapping("/delete")
	public String delete(int no, BoardDTO dto) {
		// 이미지가 있는 경우 삭제
		// 기존 url 컬럼에 값이 필요하지 않을까?
		// no로 하나 정보 가지고 오는 기능
		Board board = service.boardSearch(no);

		File file = new File(path + dto.getUrl());
		file.delete();
		
		service.boardDelete(no);
		
		return "redirect:/list";
	}
	
	@GetMapping("/search")
	public String search(Model model) {
		//검색창에 입력한 값 받기
//		List<BoardDTO> dtoList = service.boardSearch();
//			model.addAttribute("search", dtoList);
		
		
		return "list";
	}
	

}

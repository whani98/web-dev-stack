package com.kh.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.security.model.vo.User;
import com.kh.security.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	public UserService userService;
	
	@PostMapping("/register")
	public String register(User vo) {
		// jsp에서 각 태그들을 id로 걸어두면 null이 뜨므로 name으로 설정할 것!
//		System.out.println(vo); 
		userService.register(vo);
		return "redirect:/login";
	}
	

}

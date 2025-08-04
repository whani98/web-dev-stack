package com.kh.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.kh.security.controller.PageController;
import com.kh.security.mapper.UserMapper;
import com.kh.security.model.vo.User;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private PasswordEncoder bcpe;

	public void register(User vo) {
//		System.out.println("암호화 전 : "  + vo.getPwd()); 
		// 1234
//		System.out.println("암호화 후 : "  + bcpe.encode(vo.getPwd())); 
		//$2a$10$65JRnAhNfPSBHbvpILnJLOZSE01D.R7Kadi2PM/iiJGbyT5ctmTSS
		if(vo.getId().equals("admin")) {
			vo.setRole("ROLE_ADMIN");
		} else {
			vo.setRole("ROLE_USER");
		}
		// pwd에 암호화된 비밀번호 넣기
		vo.setPwd(bcpe.encode(vo.getPwd()));
		// DB로 보내기
		userMapper.register(vo);
	}

	public User login(User vo) {
		User user =  userMapper.login(vo.getId());
		// null이 아니고, 저장된 비밀번호와 입력한 비밀번호가 일치하는 경우
		if(user != null && bcpe.matches(vo.getPwd(), user.getPwd())) {
			System.out.println("로그인 성공!");
			return user;
		}
		
		return null;
	}

	

}

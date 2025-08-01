package com.kh.security.model.vo;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class User implements UserDetails{

	private String id;
	private String pwd;
	private String name;
	private String role;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() { // 권한 세팅
		return List.of(new SimpleGrantedAuthority(role));
	}
	
	@Override
	public String getPassword() { // 비밀번호
		return pwd; // 내가 사용하는 것으로 맞춰주기
	}
	
	@Override
	public String getUsername() { // 아이디
		return id; // 내가 사용하는 것으로 맞춰주기
	}
}

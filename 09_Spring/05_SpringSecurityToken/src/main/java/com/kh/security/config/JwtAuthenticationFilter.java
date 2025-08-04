package com.kh.security.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.kh.security.model.vo.User;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component // $$ 반드시 등록, Component : 요소
//extends OncePerRequestFilter - security config와 맞추기 위함
// header에서 key가 Authorization 후 Bearer 토큰~~이 온다.
public class JwtAuthenticationFilter extends OncePerRequestFilter{

	@Autowired
	private TokenProvider tokenProvider;
	
	protected void doFilterInternal(HttpServletRequest request, 
			HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		// 클라이언트에서 보낸 토큰을 받아서 사용자 확인 후 인증 처리
		String token = parseBearerToken(request);
		System.out.println(token);
		
		if(token!=null && !token.equalsIgnoreCase("null")) {
			User user = tokenProvider.validate(token);
			System.out.println(user);
		}
		
		filterChain.doFilter(request, response);
	}
	
	private String parseBearerToken(HttpServletRequest request) {
		// 토큰 따왔음
		String bearerToken = request.getHeader("Authorization");
		
		if(StringUtils.hasText(bearerToken)  && bearerToken.startsWith("Bearer")) {
			// substring(7) - Bearer 자르고 리턴
			return bearerToken.substring(7);
		}
		return null;
	}
}

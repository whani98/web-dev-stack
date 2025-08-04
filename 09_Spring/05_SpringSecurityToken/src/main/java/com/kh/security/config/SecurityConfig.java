package com.kh.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration // Configuration : 구성
public class SecurityConfig {
// $$ : 기존 security에 추가된 token 방식 
	
	// $$ JwtAuthenticationFilter 끌고오기
	@Autowired
	private JwtAuthenticationFilter jwtFilter;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		return http // 제어 시작
				// 웹 보안 토큰 설정 (비활성화)
				.csrf(csrf -> csrf.disable())
				// $$Http Basic 인증 방식 비활성화 -> JWT 토큰 방식 사용
				.httpBasic(basic -> basic.disable())
				// $$세션 설정 -> STATELESS 무상태 방식으로 설정 
				// *무상태: 서버에서 기억하지 않도록하는 것
				.sessionManagement(session -> 
				        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				// 내가 만든 페이지에 접속가능, authorize : 승인하다, permit : 허용하다
				// authorizeHttpRequests - url을 어디서, 어디까지 설정할건지 결정 
				// anyRequest - 요청한 것을
				// permitAll - 전부 다 허용
				.authorizeHttpRequests(authorize -> 
				      authorize
						// register만 비허용 - 403 접속불가상태
						// authenticated - 로그인된 사용자만 /mypage에 접근 가능
						.requestMatchers("/mypage").authenticated()
						// 여러개 추가 가능!, ROLE_ADMIN(X) ADMIN(O)
						.requestMatchers("/admin").hasRole("ADMIN")
						.anyRequest().permitAll()
				)
				
//				$$ security 방식의 로그인, 로그아웃 방식 삭제, 토큰방식 추가
				.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)          
				.build(); 
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

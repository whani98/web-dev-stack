package com.kh.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // Configuration : 구성
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		return http // 제어 시작
				// 웹 보안 토큰 설정 (비활성화)
				.csrf(csrf -> csrf.disable())
				// 내가 만든 페이지에 접속가능, authorize : 승인하다, permit : 허용하다
				// authorizeHttpRequests - url을 어디서, 어디까지 설정할건지 결정 
				// anyRequest - 요청한 것을
				// permitAll - 전부 다 허용
				.authorizeHttpRequests(authorize -> authorize
						// register만 비허용 - 403 접속불가상태
						// authenticated - 로그인된 사용자만 /mypage에 접근 가능
						.requestMatchers("/mypage").authenticated()
						// 여러개 추가 가능!
						.requestMatchers("/admin").hasRole("ADMIN")
						.anyRequest().permitAll()
				)
				.formLogin(form -> 
				    // 내가 만든 로그인 페이지를 사용하겠다는 의미
				    form.loginPage("/login")
				    // 로그인 성공시 /mypage로 이동
				        .defaultSuccessUrl("/mypage")
				)
				.logout(logout -> 
				     logout.logoutUrl("/logout")
				           .logoutSuccessUrl("/")
				 )          
				.build(); 
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

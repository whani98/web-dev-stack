package com.kh.security.config;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import com.kh.security.model.vo.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service // 비즈니스 로직에서 받는 이노테이션
public class TokenProvider {

	private final SecretKey secretkey = Keys.secretKeyFor(SignatureAlgorithm.HS512); 
	
	public String create(User user) {
		return Jwts.builder()
			// PAYLOAD
				// 사인한다
				.signWith(secretkey, SignatureAlgorithm.HS512)
				// 세팅
				.setClaims(Map.of(
					"id", user.getId(),
					"name",  user.getName(),
					"role", user.getRole()
				))
				// 토큰 발행 시점
				.setIssuedAt(new Date())
				// 토큰 만료 시점 
				// Instant.now().plus(1, ChronoUnit.DAYS)) - 발행 시점으로부터 하루 지나면 만료
				.setExpiration(Date.from(Instant.now().plus(1, ChronoUnit.DAYS)))
				.compact();
	}
	// validate : 검증하다
	public User validate(String token) {
		Claims claims = Jwts
				.parserBuilder()
				.setSigningKey(secretkey)
				.build()
				.parseClaimsJws(token)
				.getBody();
		// User(vo)에서 @Builder 추가 후
		return User.builder()
				.id((String) claims.get("id"))
				.name((String) claims.get("name"))
				.role((String) claims.get("role"))
				.build();
	}
	
}

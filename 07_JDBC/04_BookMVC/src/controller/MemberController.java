package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;

import dao.MemberDAO;
import vo.Member;

public class MemberController {

	private MemberDAO dao = MemberDAO.getInstance();
	// 4. 회원가입
	public void register(Member member){

	}
	
	// 5. 로그인
	public Member login(String id, String pwd) {
		return null;
	}
	
	// 6. 회원탈퇴
	public void delete(String id) {
		// 회원 탈퇴시 대여 중인 책을 모두 기록 삭제
	}
}

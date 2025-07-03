package dao;

import config.ServerInfo;
import vo.Member;

public class MemberDAO {
	
private static MemberDAO instance = new MemberDAO();
	
	private MemberDAO() {
		try {
			Class.forName(ServerInfo.DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	public static MemberDAO getInstance() {
		return null;
	}

	// 4. 회원가입
	public void register(Member client) {
		
	}
	
	// 5. 로그인
	public Member login(String id, String pwd) {
		return null;
	}
	
	// 6. 회원탈퇴
	public void delete(String id) {
		
	}


}

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Member;

public class MemberDAO {

	public MemberDAO() {
		try {// 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public Connection connect() throws SQLException {
		// DB 연결
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/work", "root", "qwer1234");

	}
	// 회원가입
		public void register(Member member) throws SQLException {
			Connection connect = connect();

			String query = "INSERT INTO member VALUES(?, ?, ?, ?)";
			PreparedStatement ps = connect.prepareStatement(query);

			ps.setString(1, member.getId());
			ps.setString(2, member.getPwd());
			ps.setString(3, member.getName());
			ps.setInt(4, member.getAge());

			ps.executeUpdate();
		}
		
		public void login(String id, String pwd) throws SQLException {
			Connection connect = connect();
			String query = "SELECT * FROM member WHERE id=? and pwd=?";
			PreparedStatement ps = connect.prepareStatement(query);
			ps.setString(1, id);
			ps.setString(2, pwd);
			ResultSet rs = ps.executeQuery();
			
			Member member = new Member();
			member = null;
			if (rs.next()) {
				member = new Member(rs.getString("id"), rs.getString("name"), rs.getString("pwd"), rs.getInt("age"));
			}
		}
		
		public Member search(String id) throws SQLException {
			Connection connect = connect();

			String query = "SELECT * FROM member WHERE id=?";
			PreparedStatement ps = connect.prepareStatement(query);
			
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			
			Member member = new Member();
			member = null;
			if (rs.next()) {
				member = new Member(rs.getString("id"), rs.getString("name"), rs.getString("pwd"), rs.getInt("age"));
			}
			return member;
		}
		
		// 전체 회원보기
		public List<Member> allMember() throws SQLException {
			Connection connect = connect();

			String query = "SELECT * FROM member";
			PreparedStatement ps = connect.prepareStatement(query);

			ResultSet rs = ps.executeQuery();
			List<Member> list = new ArrayList<>();
			while (rs.next()) {
				Member member = new Member();
				member.setId(rs.getString("id"));
				member.setName(rs.getString("name"));
				member.setPwd(rs.getString("pwd"));
				member.setAge(rs.getInt("age"));
				list.add(member);
			}
			return list;
		}
		
		public void logout() {
			
		}
		
}

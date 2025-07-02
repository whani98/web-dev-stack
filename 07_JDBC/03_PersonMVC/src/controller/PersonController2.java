package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;

public class PersonController2 {

	// 리턴 타입이나 파라미터 자유롭게 변경 가능!
	// 메서드 추가 가능!

	public PersonController2() {
		try {// 1. 드라이브 로딩
			Class.forName(ServerInfo.DRIVER);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 고정적으로 반복 -- 디비 연결, 자원 반납
	// 2. 디비 연결
	public Connection getConnect() throws SQLException {
		return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
	}

	// 오버로딩! - 메서드 이름은 같지만 파라미터 개수는 다른 것
	public void close(PreparedStatement ps, Connection connect) throws SQLException {
		ps.close();
		connect.close();
	}

	public void close(ResultSet rs, PreparedStatement ps, Connection connect) throws SQLException {
		rs.close();
		close(ps, connect);
	}

	// ----- 변동적인 반복 : DAO(Database Access Object)

	// person 테이블에 데이터 추가 - INSERT
	public void addPerson(String name, int age, String addr) throws SQLException {
		Connection connect = getConnect();

		// 3. PreparedStatement 객체 생성 - 쿼리
		String query1 = "INSERT INTO person VALUES(?, ?, ?, ?)";
		PreparedStatement ps = connect.prepareStatement(query1);
		ps.setInt(1, 1);
		ps.setString(2, name);
		ps.setInt(3, age);
		ps.setString(4, addr);
		

		// --> 로직 추가 예정

		// 4. 쿼리 실행
		ps.executeUpdate();
		System.out.println(ps.executeUpdate() + "명 추가!");

		// 5. 자원 반납
		close(ps, connect);

	}

	// person 테이블에 있는 데이터 전체 보여주기 - SELECT
	public void searchAllPerson() throws SQLException {
		Connection connect = getConnect();

		String query2 = "SELECT * FROM person";
		PreparedStatement ps = connect.prepareStatement(query2);

		// --> 로직 추가 예정

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int age = rs.getInt("age");
			String addr = rs.getString("addr");
			System.out.println(id + " / " + name + " / " + age + " / " + addr);
		}
		// --> 추가 예정

		close(rs, ps, connect);

	}

	// person 테이블에서 데이터 한개만 가져오기 - SELECT -> id로!
	public void searchPerson() throws SQLException {
		Connection connect = getConnect();
		String query3 = "SELECT * FROM person WHERE id = 1";
		PreparedStatement ps = connect.prepareStatement(query3);

		// --> 로직 추가 예정

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int age = rs.getInt("age");
			String addr = rs.getString("addr");
			System.out.println(id + " / " + name + " / " + age + " / " + addr);
		}

		// --> 추가 예정

		close(rs, ps, connect);
	}

	// person 테이블에 데이터 수정 - UPDATE
	public void updatePerson() throws SQLException {
		Connection connect = getConnect();
		String query4 = "UPDATE person SET age=11 WHERE id=1";
		PreparedStatement ps = connect.prepareStatement(query4);

		// --> 로직 추가 예정

		ps.executeUpdate();
		System.out.println(ps.executeUpdate() + "명 수정!");

		close(ps, connect);

	}

	// person 테이블에 데이터 삭제 - DELETE
	public void removePerson(int id) throws SQLException {
		Connection connect = getConnect();
		String query5 = "DELETE FROM person WHERE id = ?";
		PreparedStatement ps = connect.prepareStatement(query5);
		ps.setInt(1, id);

		// --> 로직 추가 예정

		ps.executeUpdate();
		System.out.println(ps.executeUpdate() + "명 삭제!");

		close(ps, connect);
	}

}

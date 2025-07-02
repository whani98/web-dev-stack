package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;

public class PersonController {
	
	// 리턴 타입이나 파라미터 자유롭게 변경 가능!
	// 메서드 추가 가능!
	
	public PersonController() {
		try {// 1. 드라이브 로딩
			Class.forName(ServerInfo.DRIVER);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// person 테이블에 데이터 추가 - INSERT
	public void addPerson() {
		Connection connect;
		try {
			connect = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
			String query1 = "INSERT INTO person VALUES(?, ?, ?, ?)";
			PreparedStatement ps1 = connect.prepareStatement(query1);
			ps1.setInt(1, 1);
			ps1.setString(2, "김일번");
			ps1.setInt(3, 21);
			ps1.setString(4, "서울");
			ps1.executeUpdate();
			
			System.out.println(ps1.executeUpdate() + "명 추가!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// person 테이블에 있는 데이터 전체 보여주기 - SELECT
	public void searchAllPerson() {
		Connection connect;
		try {
			connect = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
			
			String query2 = "SELECT * FROM person";
			PreparedStatement ps2 = connect.prepareStatement(query2);
			
			ResultSet rs = ps2.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String addr = rs.getString("addr");
				System.out.println(id + " / " + name + " / " + age + " / " + addr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	// person 테이블에서 데이터 한개만 가져오기 - SELECT -> id로!
	public void searchPerson() {
		Connection connect;
		try {
			connect = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
			
			String query3 = "SELECT * FROM person WHERE id = 1";
			PreparedStatement ps3 = connect.prepareStatement(query3);
			ResultSet rs = ps3.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String addr = rs.getString("addr");
				System.out.println(id + " / " + name + " / " + age + " / " + addr);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// person 테이블에 데이터 수정 - UPDATE
	public void updatePerson() {
		Connection connect;
		try {
			connect = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
			
			String query4 = "UPDATE person SET age=11 WHERE id=1";
			PreparedStatement ps4 = connect.prepareStatement(query4);
			
			System.out.println(ps4.executeUpdate() + "명 수정!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	// person 테이블에 데이터 삭제 - DELETE
	public void removePerson() {
		Connection connect;
		try {
			connect = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
			
			String query5 = "DELETE FROM person WHERE id = 1";
			PreparedStatement ps5 = connect.prepareStatement(query5);
			
			System.out.println(ps5.executeUpdate() + "명 삭제!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}

package transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;

public class TransactionTest2 {
	
	/*
	 * 지은 -> 지연 : 3만원씩 이체
	 * 지은님의 잔액이 마이너스가 될 경우 이체 취소!
	 * UPDATE 2개, SELECT 1개
	 * */

	public static void main(String[] args) {
		
		try {
			Class.forName(ServerInfo.DRIVER);
			
			Connection connect = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
			
			// update
			int balance = 30000;
			String send = "지은";
			String to = "지연";
			
			connect.setAutoCommit(false);
			
			String query1 = "UPDATE bank SET balance = balance - ? WHERE name = ?"; 
			PreparedStatement ps1 = connect.prepareStatement(query1);
			ps1.setInt(1, balance);
			ps1.setString(2, send);
			ps1.executeUpdate();
			
			String query2 = "UPDATE bank SET balance = balance + ? WHERE name = ?"; 
			PreparedStatement ps2 = connect.prepareStatement(query2);
			ps2.setInt(1, balance);
			ps2.setString(2, to);
			ps2.executeUpdate();

			// select
			String query3 = "SELECT balance FROM bank WHERE name = ?";
			PreparedStatement ps3 = connect.prepareStatement(query3);
			ps3.setString(1, send);
			
			ResultSet rs = ps3.executeQuery();
			
			if(rs.next()) {
				if(rs.getInt("balance") <0) {
					// 잔액이 없음 -> 이체 취소
					System.out.println("잔액이 없으므로 이체 취소!");
					connect.rollback();
					
				} else { // 이체 성공
					System.out.println("잔액이 있으므로 이체 성공!");
					connect.commit();
				}
			} 
			connect.setAutoCommit(true);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		

	}

}

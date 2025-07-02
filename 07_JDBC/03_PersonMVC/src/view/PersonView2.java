package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import config.ServerInfo;
import controller.PersonController2;

public class PersonView2 {

	public static void main(String[] args) {
		
		PersonController2 pc2 = new PersonController2();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 > " );
		String name = sc.nextLine();
		
		System.out.print("나이 > " );
		int age = Integer.parseInt(sc.nextLine());
		
		System.out.print("주소 > " );
		String addr = sc.nextLine();
		
		System.out.println("삭제할 ID 번호 > ");
		int id = Integer.parseInt(sc.nextLine());

		try {
			pc2.addPerson(name, age, addr);
			pc2.searchAllPerson();
			pc2.searchPerson();
			pc2.updatePerson();
			pc2.removePerson(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void addPerson() {
		
	}
}

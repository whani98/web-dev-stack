package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import config.ServerInfo;
import controller.PersonController2;
import vo.Person;

public class PersonView2 {
	PersonController2 pc2 = new PersonController2();
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		PersonView2 view = new PersonView2();
		view.menu();
	}

	public void menu() {
		while (true) {
			System.out.println("1. 추가");
			System.out.println("2. 전체 조회");
			System.out.println("3. 아이디 조회");
			System.out.println("4. 정보 수정");
			System.out.println("5. 정보 삭제");
			System.out.print("선택 > ");
			int select = Integer.parseInt(sc.nextLine());
			switch (select) {
			case 1:
				System.out.println(addPerson());
				break;
			case 2:
				searchAllPerson();
				break;
			case 3:
				searchPerson();
				break;
			case 4:
				System.out.println(updatePerson());
				break;
			case 5:
				System.out.println(removePerson());
				break;
			}
		}
	}

	public String addPerson() {
		try {
			System.out.print("이름 > ");
			String name = sc.nextLine();
			System.out.print("나이 > ");
			int age = Integer.parseInt(sc.nextLine());
			System.out.print("주소 > ");
			String addr = sc.nextLine();
			return pc2.addPerson(name, age, addr);
		} catch (NumberFormatException e) {
			return "숫자를 입력해주세요~~";
		}
	}

	public void searchAllPerson() {
		List<Person> list = pc2.searchAllPerson();
		if (list != null) {
			for (Person p : list) {
				System.out.println(p);
			}
		}

	}

	public void searchPerson() {
			searchAllPerson();
			System.out.print("아이디 선택 > ");
			int id = Integer.parseInt(sc.nextLine());
			Person person = pc2.searchPerson(id);
			if (person != null) System.out.println(person + "이 조회되었습니다!");
			else System.out.println("아이디가 없습니다..");
	}

	public String updatePerson() {
			searchAllPerson();
			System.out.print("수정할 아이디 선택 > ");
			int id = Integer.parseInt(sc.nextLine());

			// 아이디가 있는 경우만 수정할 수 있도록!
			Person person = pc2.searchPerson(id);
			// 아이디가 없는 경우는 내보내기
			if (person == null)
				return "조회된 아이디가 없습니다.";

			System.out.print("새로운 이름 > ");
			String name = sc.nextLine();
			System.out.print("새로운 나이 > ");
			int age = Integer.parseInt(sc.nextLine());
			System.out.print("새로운 주소 > ");
			String addr = sc.nextLine();

			return pc2.updatePerson(name, age, addr, id);
	}

	public String removePerson() {
			searchAllPerson();
			System.out.print("아이디 선택 > ");
			int id = Integer.parseInt(sc.nextLine());

			Person person;
			person = pc2.searchPerson(id);
			
			if (person == null) return "조회된 아이디가 없습니다.";
			return pc2.removePerson(id);
	}
}

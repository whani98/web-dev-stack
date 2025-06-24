package com.kh.array.practice2;

import java.util.Arrays;
import java.util.Scanner;

import com.kh.array.practice2.controller.MemberController;
import com.kh.array.practice2.model.Member;

public class Application {
	Scanner sc = new Scanner(System.in);
	MemberController mc = new MemberController();
	private int count = 0;

	public static void main(String[] args) {

		Application app = new Application();
		app.mainMenu();

	}

	// 전체 메뉴
	public void mainMenu() {
		boolean check = true;
		while (check) {
			System.out.println("최대 등록 가능한 회원 수는 3명입니다.");
			System.out.println("현재 등록된 회원 수는 " + mc.count + "명입니다.");

			if (mc.count >= 3) {
				System.out.println("회원 수가 모두 꽉 찼기 때문에 일부 메뉴만 오픈합니다.");
			} else {
				System.out.println("1. 새 회원 등록");
			}
			System.out.println("2. 회원 정보 수정");
			System.out.println("3. 전체 회원 정보 출력");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			int num = Integer.parseInt(sc.nextLine());

			switch (num) {
			case 1:
				insertMember();
				break;
			case 2:
				updateMember();
				break;
			case 3:
				printAll();
				break;
			case 9:
				System.out.println("프로그램 종료");
				check = false;
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
				break;
			}
		}
	}

	// 메뉴 1 : insertMember
	public void insertMember() {
		Member m = new Member();
		System.out.print("아이디 : ");
		m.setId(sc.nextLine());

		// 아이디 체크해야하는 부분!
		boolean idCheck = mc.idCheck(m.getId()) == -1; // 아이디가 없는 경우!
		// 아이디 이외의 내용이 아이디가 하나라도 있는 경우 안나오게 처리
		if (idCheck) {
			System.out.print("이름 : ");
			m.setName(sc.nextLine());
			System.out.print("비밀번호 : ");
			m.setPwd(sc.nextLine());
			System.out.print("이메일 : ");
			m.setEmail(sc.nextLine());
			System.out.print("성별(M/F) : ");
			m.setGender(sc.nextLine().charAt(0));
			System.out.print("나이 : ");
			m.setAge(Integer.parseInt(sc.nextLine()));

			// 추가 로직 와야되는 부분!
			mc.addInfo(m);
		}
	}

	// 메뉴 2 : updateMember
	public void updateMember() {
		System.out.print("수정할 회원의 아이디 :");
		String id = sc.nextLine();
		// 회원 정보가 없는 경우
		boolean idUpdate = mc.idCheck(id) == -1;
		if (idUpdate) {
			System.out.println("회원 정보가 없습니다.");
		} else {
			System.out.print("수정할 이름 :");
			String name = sc.nextLine();
			System.out.print("수정할 이메일 :");
			String email = sc.nextLine();
			System.out.print("수정할 비밀번호 :");
			String pwd = sc.nextLine();

			// 수정하는 로직!
			mc.updateInfo(id, name, email, pwd);
		}
	}

	// 메뉴 3 전체 회원 정보 출력
	public void printAll() {
		System.out.println("전체 회원 정보");
		for (Member member : mc.getMembers())
			if (member != null) {
				System.out.println(member);
			}
	}

}

package com.kh.practice;

import java.time.LocalDate;
import java.util.Scanner;

import com.kh.practice.model.Department;
import com.kh.practice.model.UserInfo;

public class Application {

	Scanner sc = new Scanner(System.in);
	UserInfo user = new UserInfo();
	Department dept = new Department();
	UserInfoController con = new UserInfoController();

	public static void main(String[] args) {
		Application app = new Application();
		boolean check = true;
		while (check) {
			int select = app.employeeMenu();
			switch (select) {
			case 1:
				app.insertEmp();
				break;
			case 2:
				app.updateEmp();
				break;
			case 3:
				app.printEmp();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				check = false;
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요~");
			}
		}

	}

	// 메인 메뉴를 출력하는 메서드
	public int employeeMenu() {
		System.out.println("1. 직원 정보 추가");
		System.out.println("2. 직원 정보 수정");
		System.out.println("3. 직원 정보 출력");
		System.out.println("9. 프로그램 종료");
		System.out.print("메뉴 번호를 누르세요 : ");
		return Integer.parseInt(sc.nextLine());
	}

	// 저장할 데이터를 사용자에게 받는 메서드
	public void insertEmp() {
		System.out.print("직원 번호 : ");
		user.setUserNo(Integer.parseInt(sc.nextLine()));
		System.out.print("직원 아이디 : ");
		user.setId(sc.nextLine());
		System.out.print("직원 비밀번호 : ");
		user.setPassword(sc.nextLine());
		System.out.print("직원 이메일 : ");
		user.setEmail(sc.nextLine());
		System.out.print("직원 이름 : ");
		user.setName(sc.nextLine());
		System.out.print("추가 정보를 더 입력하시겠습니까?(y/n) : ");
		// y일 경우만
		String addInfo = sc.nextLine();
		if (addInfo.equals("y")) {
			System.out.print("직원 전화번호 : ");
			user.setPhone(sc.nextLine());
			System.out.print("직원 주소 : ");
			user.setAddr(sc.nextLine());
			System.out.print("직원 성별 : ");
			user.setGender(sc.nextLine());
			System.out.print("직원 생일 (예 : 2025-06-23) : "); // LocalDate.parse(문자열) <- 문자열을 날짜로
			user.setBirthdate(LocalDate.parse(sc.nextLine()));
			System.out.print("부서 번호 : "); // 너무 어렵다면 생략!
			dept.setDeptNo(Integer.parseInt(sc.nextLine()));
		}
	}

	// 수정할 데이터를 사용자에게 받는 메서드
	public void updateEmp() {
		System.out.println("수정하려면 로그인이 필요합니다.");
		System.out.print("아이디 입력 : ");
		String loginId = sc.nextLine();
		System.out.print("비밀번호 입력 : ");
		String loginPwd = sc.nextLine();

		// 아이디랑 비밀번호가 틀리다면!
		if (!loginId.equals(user.getId()) || !loginPwd.equals(user.getId())) {
			System.out.println("로그인 실패! 정보 수정할 수 없습니다");
		} else {// 아이디와 비밀번호 성공했을시에만!
			System.out.println("직원의 어떤 정보를 수정하시겠습니까?");
			System.out.println("1. 전화 번호");
			System.out.println("2. 생일");
			System.out.println("3. 부서 번호");
			System.out.println("9. 돌아가기");
			System.out.print("메뉴 번호를 누르세요 : ");
			int select = Integer.parseInt(sc.nextLine());

			switch (select) {
			case 1:
				System.out.print("전화 번호 입력 : ");
				user.setPhone(sc.nextLine());
				break;
			case 2:
				System.out.print("생일 입력 (예 : 2025-06-23) : ");
				user.setBirthdate(LocalDate.parse(sc.nextLine()));
				break;
			case 3:
				System.out.print("부서 입력 : ");
				dept.setDeptNo(Integer.parseInt(sc.nextLine()));
				break;
			case 9:
				break;
			}
		}
	}

	// 데이터를 출력하는 메서드
	public void printEmp() {
		System.out.println("전체 회원 정보");
		for(UserInfo userInfo : con.getUserInfo())
			if(userInfo != null) {
				System.out.println(userInfo);
			}

	}
}
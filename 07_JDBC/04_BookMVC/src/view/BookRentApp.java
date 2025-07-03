package view;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.BookController;
import controller.MemberController;
import controller.RentController;
import vo.Member;

public class BookRentApp {

	private Scanner sc = new Scanner(System.in);

	// 로그인 했을 시 사용자 정보 담을 객체
	private Member member = new Member();

	private BookController bc = new BookController();
	private MemberController mc = new MemberController();
	private RentController rc = new RentController();

	public static void main(String[] args) {
		BookRentApp app = new BookRentApp();
		app.menu();
	}

	public void menu() {
		// 0
		// 1. 전체 책 조회 - 로그인 X
		// 2. 회원가입 - 로그인 X
		// 3. 로그인 - 로그인 X
		// 1
		// 관리자로 로그인 했을 때
		// 1. 책 등록 - 로그인 O (관리자 : admin, 1234)
		// 2. 책 삭제 - 로그인 O (관리자 : admin, 1234)
		// 3. 로그아웃 - 로그인 O
		// 2
		// 일반회원으로 로그인 했을 때
		// 1. 회원탈퇴 - 로그인 O (관리자 X)
		// 2. 로그아웃 - 로그인 O
		// 3. 책 대여 - 로그인 O
		// 4. 내가 대여한 책 조회 - 로그인 O
		// 5. 대여 취소 - 로그인 O
		while (true) {
			System.out.println("1. 전체 책 조회");
			System.out.println("2. 회원가입");
			System.out.println("3. 로그인");
			int select = Integer.parseInt(sc.nextLine());
			switch (select) {
			case 1:
				printBookAll();
				break;
			case 2:
				register();
				break;
			case 3:
				login();
				break;
			}
		}
	}

	public void adminMenu() {
		while (true) {
			System.out.println("1. 책등록");
			System.out.println("2. 책삭제");
			System.out.println("3. 로그아웃");

			System.out.print("선택 > ");
			int select = Integer.parseInt(sc.nextLine());
			switch (select) {
			case 1:
				registerBook();
				break;
			case 2:
				sellBook();
				break;
			case 3:
				logout();
				break;
			}
		}
	}

	public void memberMenu() {
		while (true) {
			System.out.println("1. 회원탈퇴");
			System.out.println("2. 로그아웃");
			System.out.println("3. 책 대여");
			System.out.println("4. 로그아웃");
			System.out.println("5. 책 대여");
			System.out.print("선택 > ");
			int select = Integer.parseInt(sc.nextLine());
			switch (select) {
			case 1:
				printBookAll();
				break;
			case 2:
				registerBook();
				break;
			case 3:
				sellBook();
				break;
			}
		}
	}

	// 0-1 전체 책 조회
	public void printBookAll() {
		ArrayList<vo.Book> bookList = bc.printBookAll();
		if (bookList != null) {
			for (vo.Book b : bookList) {
				System.out.println(b);
			}
		}
	}

	// 0-2 회원가입 - 로그인 X
	public void register() {

		Member member = new  Member();
		System.out.println("아이디 > ");
		member.setId(sc.nextLine());
		System.out.println("이름 > ");
		member.setName(sc.nextLine());
		System.out.println("비밀번호 > ");
		member.setPwd(sc.nextLine());
		System.out.println("나이 > ");
		member.setAge(Integer.parseInt(sc.nextLine()));
		
		mc.register(member);
		
	}

	// 0-3 로그인 - 로그인 X
	public void login() {

	}

	// 1-1 책 등록 - 로그인(관리자 : admin, 1234)
	public boolean registerBook() {
		System.out.println("도서명 > ");
		String title = sc.nextLine();
		System.out.println("저자명 > ");
		String author = sc.nextLine();
		System.out.println("제한 나이 > ");
		int accessAge = Integer.parseInt(sc.nextLine());
		return true;
	}

	//1-1 책 삭제 - 로그인(관리자 : admin, 1234)
	public void sellBook() {

	}

	//2-1 회원탈퇴 - 로그인 O(관리자 X)
	public void delete() {

	}

	//2-3 책 대여 - 로그인 O
	public void rentBook() {

	}

	//2-4 내가 대여한 책 조회 - 로그인 O
	public void printRentBook() {

	}

	//2-5 대여취소 - 로그인 O
	public void deleteRent() {

	}

	//1-3, 2-2 로그아웃
	public void logout() {

	}

}

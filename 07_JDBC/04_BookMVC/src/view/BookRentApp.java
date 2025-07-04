package view;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.BookController;
import controller.MemberController;
import controller.RentController;
import vo.Book;
import vo.Member;
import vo.Rent;

public class BookRentApp {

	private Scanner sc = new Scanner(System.in);

	// 로그인 했을 시 사용자 정보 담을 객체
	private Member member = null;

	private BookController bc = new BookController();
	private MemberController mc = new MemberController();
	private RentController rc = new RentController();

	public static void main(String[] args) {
		BookRentApp app = new BookRentApp();
		app.menu();
		app.adminMenu();
		app.memberMenu();
	}
	public void menu() {
		while(true) {
			if(member==null) {
				menu1();
			} else if(member.getId().equals("admin") && member.getPwd().equals("1234")) {
				// 관리자 들어온 경우
				adminMenu();
			} else {
				// 일반 회원인 경우
				memberMenu();
			}
		}
	}

	public void menu1() {
		System.out.println("1. 전체 책 조회");
		System.out.println("2. 회원가입");
		System.out.println("3. 로그인");
		System.out.print("선택 > ");
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

	public void adminMenu() {
		System.out.println("1. 책 등록");
		System.out.println("2. 책 삭제");
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
			this.member = null;
			break;
		}
	}

	public void memberMenu() {
		System.out.println("1. 회원탈퇴");
		System.out.println("2. 로그아웃");
		System.out.println("3. 책 대여");
		System.out.println("4. 내가 대여한 책 조회");
		System.out.println("5. 대여취소");
		System.out.print("선택 > ");
		int select = Integer.parseInt(sc.nextLine());
		switch (select) {
		case 1:
			delete();
			break;
		case 2:
			this.member = null;
			break;
		case 3:
			rentBook();
			break;
		case 4:
			printRentBook();
			break;
		case 5:
			deleteRent();
			break;
		}
	}

	// 0-1 전체 책 조회
	public void printBookAll() {
		ArrayList<Book> list = bc.printBookAll();
		if (list != null && list.size() > 0) {
			for (Book b : list) {
				System.out.println(b);
			}
		} else {
			System.out.println("등록된 책이 없습니다. 새로 등록해주세요.");
		}
	}

	// 0-2 회원가입 - 로그인 X
	public void register() {
		Member member = new  Member();
		System.out.print("아이디 > ");
		member.setId(sc.nextLine());
		System.out.print("이름 > ");
		member.setName(sc.nextLine());
		System.out.print("비밀번호 > ");
		member.setPwd(sc.nextLine());
		System.out.print("나이 > ");
		member.setAge(Integer.parseInt(sc.nextLine()));
		
		System.out.println(mc.register(member));
		
	}

	// 0-3 로그인 - 로그인 X
	public void login() {
		System.out.print("아이디 > ");
		String id = sc.nextLine();
		System.out.print("비밀번호 > ");
		String pwd = sc.nextLine();
		Member member = mc.login(id, pwd);
		if(member!=null) {
			this.member = member;
			System.out.println(member.getName() + "님이 로그인 하셨습니다.");
		} else {
			System.out.println("로그인 실패! 아이디와 비밀번호를 다시 입력해주세요.");
		}
	}

	// 1-1 책 등록 - 로그인(관리자 : admin, 1234)
	public void registerBook() {
		System.out.print("도서명 > ");
		String title = sc.nextLine();
		System.out.print("저자명 > ");
		String author = sc.nextLine();
		System.out.print("제한 나이 > ");
		int accessAge = Integer.parseInt(sc.nextLine());
		if( bc.registerBook(title, author, accessAge)) {
			System.out.println("[" + title + "]" + " 책 등록 완료.");
		} else {
			System.out.println("책 등록 실패. 다시 등록해주세요.");
		}
	}

	//1-2 책 삭제 - 로그인(관리자 : admin, 1234)
	public void sellBook() {
		printBookAll();
		System.out.println("삭제할 도서명을 입력하세요.");
		System.out.print("도서명 > ");
		String title = sc.nextLine();
		
		if(bc.sellBook(title)) {
			System.out.println("[" + title + "]" + "이(가) 삭제되었습니다.");
		} else {
			System.out.println("책 삭제 실패");
		}
		
	}

	//2-1 *회원탈퇴
	public void delete() {
		mc.delete(this.member.getId());
		this.member = null;
		
		
	}
	

	//2-3 책 대여 - 로그인 O
	public void rentBook() {
		printBookAll();
		System.out.println("대여할 도서명을 입력하세요.");
		System.out.print("도서명 > ");
		String title = sc.nextLine();
		if(rc.rentBook(this.member.getId(), title)) {
			System.out.println(this.member.getName() + "님, " + "[" + title + "]" + " 대여 완료");
		} else {
			System.out.println("대여 실패");
		};


	}

	//2-4 내가 대여한 책 조회 - 로그인 O
	public void printRentBook() {
		ArrayList<Rent> list = rc.printRentBook(this.member.getId());
		for(Rent r : list) {
			System.out.println(r.getBook());
		}
		
	}

	//2-5 대여취소 - 로그인 O
	public void deleteRent() {
		ArrayList<Rent> list = rc.printRentBook(this.member.getId());
		for(Rent r : list) {
			System.out.println(r);
		}
		System.out.print("취소할 대여 번호 > ");
		int rentNo = Integer.parseInt(sc.nextLine());
		rc.deleteRent(rentNo);
	}

}

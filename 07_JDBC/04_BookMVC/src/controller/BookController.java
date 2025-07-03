package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.BookDAO;
import vo.Book;

public class BookController {

	private BookDAO dao = BookDAO.getInstance();
	
	// 1. 전체 책 조회
	public ArrayList<Book> printBookAll() {
		try {
			return dao.printBookAll();
		} catch (SQLException e) {
			return null;
		}
		
		
	}
	
	// 2. 책 등록
	public boolean registerBook(String title, String author, int accessAge) {
		// 기존 제목, 저자, 제한 나이까지 동일한 책이 있으면 등록 안되도록
		try {
			boolean check = dao.checkBook(title, author, accessAge);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// 3. 책 삭제
	public boolean sellBook(int bookNo) {
		// 대출된 책은 삭제 못하도록
		try {
			if(dao.sellBook(bookNo)) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
}

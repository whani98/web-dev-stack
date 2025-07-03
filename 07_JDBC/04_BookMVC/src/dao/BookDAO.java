package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.ServerInfo;
import vo.Book;

public class BookDAO {
	
	private static BookDAO instance = new BookDAO();
	
	private BookDAO() {
		try {
			Class.forName(ServerInfo.DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static BookDAO getInstance() {
		return instance;
	}
	
	public Connection getConnect() throws SQLException {
		return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
	}
	public void close(PreparedStatement ps, Connection connect) throws SQLException {
		ps.close();
		connect.close();
	}
	public void close(ResultSet rs, PreparedStatement ps, Connection connect) throws SQLException {
		rs.close();
		connect.close();
	}

	// 1. 전체 책 조회
	public ArrayList<Book> printBookAll() throws SQLException {
		Connection connect = getConnect();
		
		String query = "SELECT * FROM book";
		PreparedStatement ps = connect.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		ArrayList<Book> bookList = new ArrayList<>();
		while(rs.next()) {
			Book book = new Book(rs.getInt("book_no"), rs.getString("title"), rs.getString("author"), rs.getInt("access_age"));
			bookList.add(book);
		}
		
		close(rs, ps, connect);
		
		return bookList;
	}
	
	// 2. 책 등록
	// - 중복책 확인
	public boolean checkBook(String title, String author, int accessAge) throws SQLException {
		Connection connect = getConnect();
		
		String query = "SELECT title, author, access_age FROM book WHERE title = ? author = ? access_age = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, title);
		ps.setString(2, author);
		ps.setInt(3, accessAge);
		ResultSet rs = ps.executeQuery();
		
		return rs.next();

	}
	// - 책 등록
	public String registerBook(String title, String author, int accessAge) throws SQLException {
		Connection connect = getConnect();
		String query = "INSERT INTO book(title, author, access_age) VALUES(?, ?, ?)";
		PreparedStatement ps = connect.prepareStatement(query);
		
		ps.setString(1, title);
		ps.setString(2, author);
		ps.setInt(3, accessAge);
		
		int result = ps.executeUpdate();
		
		close(ps, connect);
		
		return title + "(" + author + ")" + " 등록 완료";
	}
	
	// 3. 책 삭제
	public boolean sellBook(int  bookNo) throws SQLException {
		Connection connect = getConnect();
		String query = "DELETE FROM book WHERE book_no = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setInt(1, bookNo);
		ps.executeUpdate();
		
		close(ps, connect);
		
		return true;
	}
	
	
}

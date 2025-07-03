package dao;

import java.util.ArrayList;

import config.ServerInfo;
import vo.Rent;

public class RentDAO {
	
private static RentDAO instance = new RentDAO();
	
	private RentDAO() {
		try {
			Class.forName(ServerInfo.DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static RentDAO getInstance() {
		return null;
	}

	// 7. 책 대여
	public void rentBook(String id, int bookNo) {

	}

	// 8. 내가 대여한 책 조회
	public ArrayList<Rent> printRentBook(String id) {
		return null;
	}
	
	//9. 대여 취소
	public void deleteRent(int rentNo) {
		
	}

	
}

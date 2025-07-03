package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.ServerInfo;
import dao.PersonDAO;
import vo.Person;

// DAO - Controller(중간관리 역할) - view 
public class PersonController2 {

	private PersonDAO dao = PersonDAO.getInstance();

	public String addPerson(String name, int age, String addr) {

		try {
			boolean check = dao.checkName(name, age, addr);
			if (check) {
				return "이미 정보가 있습니다.";
			}

			return dao.addPerson(name, age, addr);

		} catch (SQLException e) {
			return "회원가입 실패";
		}
	}

	public List<Person> searchAllPerson() {
		try {
			return dao.searchAllPerson();
		} catch (SQLException e) {
			return null;
		}
	}

	public Person searchPerson(int id) {
		try {
			return dao.searchPerson(id);
		} catch (SQLException e) {
			return null;
		}
	}

	public String updatePerson(String name, int age, String addr, int id) {
		try {
			return dao.updatePerson(name, age, addr, id);
		} catch (SQLException e) {
			return "수정 실패했습니다.";
		}
	}

	public String removePerson(int id) {
		try {
			if (dao.removePerson(id)) {
				return "아이디가" + id + "인 회원이 삭제되었습니다. 또 만나욧~";
			}
			return "삭제 실패";
		} catch (SQLException e) {
			return "관리자에게 물어보세요";
		}
	}
}

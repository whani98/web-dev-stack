package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.Member;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dao.MemberDAO;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 한글 처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		try {

			// 1. form값 받아오기
			String id = request.getParameter("id");
			
			// 2. DB 정보조회 -> DAO 필요
			MemberDAO dao = new MemberDAO();
			Member member = dao.search(id);
			
			// 3. 바인딩 -> 이 정보가 필요한지
			request.setAttribute("member", member);
			
			// 4. 네비게이션 -> view.jsp
			request.getRequestDispatcher("search.jsp").forward(request, response);
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}

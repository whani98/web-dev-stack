package Servlet;

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

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 처리
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");
		try {
			MemberDAO dao = new MemberDAO();
			Member member= dao.search(id);
			
			request.getRequestDispatcher("/views/result.jsp").forward(request, response);// 한번 더 보낼 때 사용!!
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

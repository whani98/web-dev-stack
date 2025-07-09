package Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vo.Member;

import java.io.IOException;
import java.sql.SQLException;

import dao.MemberDAO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 한글 처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		boolean check = true;

		MemberDAO dao = new MemberDAO();
		try {
			Member member = dao.login(id, pwd);
			
			// Session - 바인딩
			HttpSession session = request.getSession();
			session.setAttribute("member", member);
			
			response.sendRedirect("/");
			
		} catch (SQLException e) {
			check = false;
		}
		
			
		
	}

}

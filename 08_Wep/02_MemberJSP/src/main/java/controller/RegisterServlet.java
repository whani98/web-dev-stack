package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.Member;

import java.io.IOException;
import java.sql.SQLException;

import dao.MemberDAO;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 한글 처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 1. form값 받아오기
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));

		boolean check = true;
	
		// 콘솔확인
//		System.out.println(id);
//		System.out.println(pwd);
//		System.out.println(name);
//		System.out.println(age);

		// 2. DAO 호출 - DB 접근 필요시
		MemberDAO dao = new MemberDAO();
		try {
			dao.register(new Member(id, name, pwd, age));
		} catch (SQLException e) {
			check = false;
		}
		// 3. 바인딩 : 결과 페이지에 서버에서 받은 값 보내야할 때
		request.setAttribute("name", name);
		request.setAttribute("check", check);

		// 4. 결과 페이지
		// -> 회원가입 성공할 때랑 실패할 때 페이지를 구분하는 것
		// check가 true인 경우는 회원가입 성공 페이지로 이동
		// response.sendRedirect("result.jsp");는 강제 이동
		// 만약 결과 페이지로 서버에서 받은 값 보여주려면
		// -> RequestDispatcher forward 방식으로 보내야함
		
		// 결과 페이지는 하나로! 가는경우
//		if (check) {
			request.getRequestDispatcher("result.jsp").forward(request, response);
//		} else {// false인 경우는 실패 페이지로 이동
//			response.sendRedirect("fail.jsp");
//		}
		
			
			

	}

}

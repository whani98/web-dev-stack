package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutAct
 */
@WebServlet("/logout.do")
public class LogoutAct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션 객체
		HttpSession session = request.getSession();
		
		// login에서 user라고 저장된 것을 지움
		session.removeAttribute("user");
		
		// 삭제된 후 로그인 페이지로 돌아가도록 설정
		response.sendRedirect("login_form.jsp");
	}

}

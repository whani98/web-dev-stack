package action;

import java.io.IOException;
import java.text.Format;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import vo.MemberVO;

/**
 * Servlet implementation class LoginAct
 */
@WebServlet("/login.do")
public class LoginAct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// login.do?id=one&pwd=1111

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		MemberVO vo = MemberDAO.getInstance().selectOne(id);

		String param = "";
		String resultStr = "";

		// id가 일치하지 않을 경우
		if (vo == null) {
          param = "no_id";
          resultStr = String.format("[{'param': '%s'}]", param);
          response.getWriter().println(resultStr);
          return;
		}
		
		// 비밀번호 불일치
	if(!vo.getPwd().equals(pwd)){
		param = "no_pwd";
		resultStr = String.format("[{'param': '%s'}]", param);
		response.getWriter().println(resultStr);
		return;
			
		}
	// 로그인이 가능한 경우
	HttpSession session = request.getSession();
	session.setAttribute("user", vo);
	
	param = "clear";
	resultStr = String.format("[{'param': '%s'}]", param);
	response.getWriter().println(resultStr);
	
	}


}

package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;

/**
 * Servlet implementation class MemberDelAct
 */
@WebServlet("/member_delete.do")
public class MemberDelAct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 파라미터값 받기
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		// DAO에 파라미터값 보내기 res는 1 또는 0
		int res = MemberDAO.getInstance().delete(idx);
		
		String param = "no";
		if(res > 0) {
			param = "yes";
		}
		
		String resultStr = String.format("[{'res':'%s'}]", param);
		response.getWriter().println(resultStr);
		
		// 모든 요청이 완료되면 list.do 갱신
		// response.sendRedirect("list.do");
	}

}

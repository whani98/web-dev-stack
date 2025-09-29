package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import vo.MemberVO;

/**
 * Servlet implementation class MemberIdCheckAct
 */
@WebServlet("/check_id.do")
public class MemberIdCheckAct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//check_id.do?id=one
		String id = request.getParameter("id");
		
		MemberVO vo = MemberDAO.getInstance().selectOne(id);
		
		String res = "no";
		
		if(vo == null) { 
			// 가입이 가능한 id인 경우
			res = "yes";			
		}
		
		// 결과를 callback메서드로 전달
		response.setContentType("text/plane;charset=UTF-8");
		String resultStr = String.format("[{'result': '%s', 'id': '%s'}]", res, id);
		
		// DB 사용을 마친 최종 결과를 콜백 메서드로 전달
		response.getWriter().println(resultStr);
	}
}

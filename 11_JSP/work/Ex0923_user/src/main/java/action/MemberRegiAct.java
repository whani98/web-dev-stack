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
 * Servlet implementation class MemberRegiAct
 */
@WebServlet("/member_register.do")
public class MemberRegiAct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post로 전송되는 파라미터에 한글이 포함되어 있다면 글자가 깨지지 않도록 utf-8로 인코딩
		request.setCharacterEncoding("utf-8");
		
		// 파라미터 받기
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String addr = request.getParameter("addr");
		
		// 파라미터로 받은 값 vo에 담기
		MemberVO vo = new MemberVO();
		vo.setName(name);
		vo.setId(id);
		vo.setPwd(pwd);
		vo.setEmail(email);
		vo.setAddr(addr);
		
		// dao에 vo 보내기
		MemberDAO.getInstance().register(vo);
		
		// 모든 요청이 완료되면 list.do 갱신
		response.sendRedirect("list.do");
		
	}

}

package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DeptDAO;
import vo.DeptVO;

/**
 * Servlet implementation class DeptUdtAct
 */
@WebServlet("/dept_update.do")
public class DeptUdtAct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// dept_update.do?deptno=10
		int deptNo = Integer.parseInt(request.getParameter("deptNo"));
		
		// DeptVO로 받을거고, 부서번호를 보내 DeptDAO에 요청
		DeptVO vo = DeptDAO.getInstance().updateSelect(deptNo);

		// vo로 바인딩
		request.setAttribute("vo", vo);
		
		// vo를 써먹을 포워딩을 위한 경로 지정
		RequestDispatcher disp = request.getRequestDispatcher("update_form.jsp");
		disp.forward(request, response); // 어디로, 무엇을 가지고 갈건지 지정

	}

}

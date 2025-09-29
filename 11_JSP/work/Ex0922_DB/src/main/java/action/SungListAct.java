package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SjDAO;
import vo.SjVO;

/**
 * Servlet implementation class SungListAct Servlet : 자바 어플리케이션에서 클라이언트의 요청을
 * 처리하고 응답을 반환하는 역할을 하는 하나의 클래스
 */
@WebServlet("/list.do")
public class SungListAct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 학생 목록 가져온다.
		// DAO를 싱글톤으로 가져옴 ->
		// 바인딩과 포워딩
		List<SjVO> list = SjDAO.getInstance().select();

		// list를 바인딩
		request.setAttribute("list", list);

		System.out.println("size : " + list.size());

		// 포워딩을 위한 경로 지정(괄호 안에 지정하고 싶은 jsp)
		RequestDispatcher disp = request.getRequestDispatcher("sj_list.jsp");
		disp.forward(request, response);
	
	}

}

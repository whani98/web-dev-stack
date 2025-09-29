package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DeptDAO;
import vo.DeptVO;

/**
 * Servlet implementation class DeptRegiAct
 */
@WebServlet("/dept_register.do")
public class DeptRegiAct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int deptNo = Integer.parseInt(request.getParameter("deptNo"));
		String dName = request.getParameter("dName");
		String loc = request.getParameter("loc");
		
		DeptVO vo = new DeptVO();
		vo.setDeptNo(deptNo);
		vo.setdName(dName);
		vo.setLoc(loc);
		
		DeptDAO.getInstance().register(vo);
		
		response.sendRedirect("list.do");
	}

}

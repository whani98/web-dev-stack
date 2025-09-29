package action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DeptDAO;
import vo.DeptVO;

/**
 * Servlet implementation class DeptUpdateFinAct
 */
@WebServlet("/dept_update_fin.do")
public class DeptUpdateFinAct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 원래 deptNo
		int ori_deptNo = Integer.parseInt(request.getParameter("ori_deptNo"));
		// 새로 받은 deptNo
		int deptNo = Integer.parseInt(request.getParameter("deptNo"));
		String dName = request.getParameter("dName");
		String loc = request.getParameter("loc");
		// map은 직접 객체화를 못해서 hashmap을 붙임
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ori_deptNo", ori_deptNo);
		map.put("deptNo", deptNo);
		map.put("dName", dName);
		map.put("loc", loc);
		
		DeptDAO.getInstance().update(map);
		
		response.sendRedirect("list.do");
	}

}

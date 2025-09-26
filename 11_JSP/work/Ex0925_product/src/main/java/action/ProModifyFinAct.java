package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProModifyFinAct
 */
@WebServlet("/pro_modify_fin.do")
public class ProModifyFinAct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		String category = request.getParameter("category");
		String p_num = request.getParameter("p_num");
		String p_name = request.getParameter("p_name");
		String p_company = request.getParameter("p_company");
		int p_price = Integer.parseInt(request.getParameter("p_price"));
		int p_saleprice = Integer.parseInt(request.getParameter("p_saleprice"));
		String p_content = request.getParameter("p_content");
		
	}

}

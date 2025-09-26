package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import vo.ProductVO;

/**
 * Servlet implementation class ProductListAct
 */
@WebServlet("/list.do")
public class ProductListAct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 받으려는 파라미터 값 (list.do?category=com001)
		String category = request.getParameter("category");

		// null  --> list.do
		// empty --> list.do?
		if (category == null || category.isEmpty()) { // null 값이거나 비어있으면
			category = "com001"; // 강제로 com001로 잡기
		}
		
	   // 카테고리별 목록 조회
		
		// DAO에 카테고리 정보를 보냄
		List<ProductVO> list = ProductDAO.getInstance().selectList(category);
		
		// list 바인딩
		request.setAttribute("list", list);
		// System.out.println(list);
		
		// 포워딩
		RequestDispatcher disp = request.getRequestDispatcher("product_list.jsp");
		disp.forward(request, response);
	}

}

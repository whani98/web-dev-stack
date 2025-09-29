package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDAO;
import vo.CartVO;

/**
 * Servlet implementation class CartListAct
 */
@WebServlet("/cart_list.do")
public class CartListAct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 파라미터 수신
		int m_idx = Integer.parseInt(request.getParameter("m_idx"));
		
		
		// 리스트 받기
		List<CartVO> list = CartDAO.getInstance().select(m_idx);
		// 총액 받기
		int total = CartDAO.getInstance().selectTotalAmount(m_idx);
		
		// 바인딩
		request.setAttribute("list", list);
		request.setAttribute("total", total);
		
		
		// 포워딩
		RequestDispatcher disp = request.getRequestDispatcher("cartList.jsp");
		disp.forward(request, response);
	}

}

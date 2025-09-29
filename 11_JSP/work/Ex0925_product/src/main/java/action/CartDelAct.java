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
 * Servlet implementation class CartDelAct
 */
@WebServlet("/cart_delete.do")
public class CartDelAct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int c_idx = Integer.parseInt(request.getParameter("c_idx"));
		
		CartDAO.getInstance().delete(c_idx);
		
		List<CartVO> list = CartDAO.getInstance().select(1);
		int total_amount = CartDAO.getInstance().selectTotalAmount(1);
		
		// 바인딩
		request.setAttribute("list", list);
		request.setAttribute("total", total_amount);
		
		// 포워딩
		RequestDispatcher disp = request.getRequestDispatcher("cartList.jsp");
		disp.forward(request, response);
	}

}

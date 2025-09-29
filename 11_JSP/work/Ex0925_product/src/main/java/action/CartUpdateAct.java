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
 * Servlet implementation class CartUpdateAct
 */
@WebServlet(name = "CartUpdAct", urlPatterns = { "/cart_update.do" })
public class CartUpdateAct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터 수신
		int c_idx = Integer.parseInt(request.getParameter("c_idx"));
		int c_cnt = Integer.parseInt(request.getParameter("c_cnt"));
		
		// 파라미터로 받은 값 vo 형태로 저장
		CartVO vo = new CartVO();
		vo.setC_idx(c_idx);
		vo.setC_cnt(c_cnt);
 		
		CartDAO.getInstance().update_cnt(vo);
		
		// 현재 접속한 회원의 장바구니 목록 조회 (1 : 회원번호(m_idx))
		List<CartVO> list  = CartDAO.getInstance().select(1);
		
		// 장바구니 총 계 (1 : 회원번호(m_idx))
		int total_amount = CartDAO.getInstance().selectTotalAmount(1);
		
		// 바인딩
		request.setAttribute("list", list);
		request.setAttribute("total", total_amount);
		
		// 포워딩
		RequestDispatcher disp = request.getRequestDispatcher("cartList.jsp");
		disp.forward(request, response);
	}

}

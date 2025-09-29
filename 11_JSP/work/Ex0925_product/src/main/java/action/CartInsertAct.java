package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDAO;
import vo.CartVO;

/**
 * Servlet implementation class CartInsertAct
 */
@WebServlet("/cart_insert.do")
public class CartInsertAct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터 수신
		// 상품 번호
		int idx = Integer.parseInt(request.getParameter("idx"));
		// 회원 번호
		int m_idx = Integer.parseInt(request.getParameter("m_idx"));
		
		// 중복 상품인지 조회
		CartVO vo = new CartVO();
		vo.setIdx(idx);
		vo.setM_idx(m_idx);
		
		CartVO resVo = CartDAO.getInstance().selectOne(vo);
		
		String result = "no";
		if(resVo == null) {
			result = "yes";
			// 상품을 장바구니에 등록
			CartDAO.getInstance().insert(vo);
		}
		
		String resStr = String.format("[{'result': '%s'}]", result);
		response.getWriter().println(resStr);
		
		
	}

}

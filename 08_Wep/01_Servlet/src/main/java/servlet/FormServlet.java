package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;


@WebServlet("/form")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FormServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 브라우저에 입력한 값 가져오기
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String gender = request.getParameter("gender");
		gender = gender.equals("M") ? "남자": "여자";
		String[] menu = request.getParameterValues("menu");
		// 콘솔 출력
		System.out.println(userId);
		System.out.println(userPwd);
		System.out.println(gender);
		System.out.println(Arrays.toString(menu));
	    // 브라우저에 출력
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>아이디 : " + userId +"</h1>");
		out.println("<h1>비밀번호 : " + userPwd +"</h1>");
		out.println("<h1>성별 : " + gender +"</h1>");
//		out.println("<h1>좋아하는 메뉴 : " + String.join(", ", menu) +"</h1>");
		out.println("<h1>좋아하는 메뉴</h1>");
		out.println("<ul>");
		if(menu!=null) {
		for(String m : menu) {
			out.println("<li>" + m +"</li>");
		}}
		out.println("</ul>");
		out.println("</body></html>");

		out.close();
	}

}

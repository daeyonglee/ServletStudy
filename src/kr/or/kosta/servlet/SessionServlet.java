package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionServlet
 */
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		String product1 = "TV";
		String product2 = "노트북";
		
		HttpSession session = request.getSession();
		System.out.println(session.isNew());
		
		session.setAttribute("product1", product1);
		session.setAttribute("product2", product2);
		
		
		PrintWriter out = response.getWriter();
		
		StringBuffer s = new StringBuffer();
		s.append("<html>");
		s.append("<head>");
		s.append("<title>처음으로 작성한 서블릿</title>");
		s.append("</head>");
		s.append("<body>");
		s.append("<h2>" + product1 + "," + product2 + "를 장바구니에 담았습니다..</h2>");
		s.append("<a href='session2'> 장바구니 보기</a>");
		s.append("</body>");
		s.append("</html>");
		
		out.println(s.toString());
	}


}

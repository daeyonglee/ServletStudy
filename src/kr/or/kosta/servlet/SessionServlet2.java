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
public class SessionServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		String product1 = "";
		String product2 = "";
		
		HttpSession session = request.getSession();

		if (!session.isNew()) {
			product1 = (String) session.getAttribute("product1");
			product2 = (String) session.getAttribute("product2");
		}
		
		
		
		PrintWriter out = response.getWriter();
		StringBuffer s = new StringBuffer();
		
		s.append("<html>");
		s.append("<head>");
		s.append("<title>처음으로 작성한 서블릿</title>");
		s.append("</head>");
		s.append("<body>");
		s.append(product1 + ", " + product2);
		s.append("</body>");
		s.append("</html>");
		
		out.println(s.toString());
	}


}

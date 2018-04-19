package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConfigServlet
 */
public class ContextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
		//response.sendError(HttpServletResponse.SC_NOT_FOUND);
		// 문자스트링 생성
		PrintWriter out = response.getWriter();
		Calendar c = Calendar.getInstance();
		
		ServletContext context = getServletContext();
		String applicationName = context.getContextPath();
		
		// HelloServlet에 데이터 전달
		context.setAttribute("message", "종찬이바보");
		
		response.sendRedirect("hello.do");
		
		StringBuffer s = new StringBuffer();
		s.append("<html>");
		s.append("<head>");
		s.append("<title>ContextServlet</title>");
		s.append("</head>");
		s.append("<body>");
		s.append("<h2>서버이름</h2>");
		s.append(context + "<br>");
		s.append(applicationName + "<br>");
		s.append("</body>");
		s.append("</html>");
		
		out.println(s.toString());
	}

}

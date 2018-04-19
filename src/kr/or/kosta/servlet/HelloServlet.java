package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet Container에 의해 생성, 관리, 실행되는 Web Component
 * @author ldy
 *
 */
public class HelloServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
		//response.sendError(HttpServletResponse.SC_NOT_FOUND);
		// 문자스트링 생성
		PrintWriter out = response.getWriter();
		Calendar c = Calendar.getInstance();
		
		
		StringBuffer s = new StringBuffer();
		s.append("<html>");
		s.append("<head>");
		s.append("<title>처음으로 작성한 서블릿</title>");
		s.append("</head>");
		s.append("<body>");
		s.append("   <h1>안녕하세유~~~~서블릿이에유~~~</h1>");
		s.append("   <h2>안녕하세유~~~~서블릿이에유~~~</h2>");
		s.append("   <h3>안녕하세유~~~~서블릿이에유~~~</h3>");
		s.append("   <h4>안녕하세유~~~~서블릿이에유~~~</h4>");
		s.append("   <h5>안녕하세유~~~~서블릿이에유~~~</h5>");
		s.append("   <h5>안녕하세유~~~~서블릿이에유~~~</h5>");
		s.append("   <hr>");
		s.append("   <h1>" + String.format("%1$tF %1$tT", c) + "</h1>");
		String message = (String)getServletContext().getAttribute("message");
		s.append(message + "<br>");
		s.append(getServletContext().getInitParameter("abc") + "<br>");
		s.append("</body>");
		s.append("</html>");
		
		out.println(s.toString());
	}
}

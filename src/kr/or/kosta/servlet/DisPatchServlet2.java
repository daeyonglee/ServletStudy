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
public class DisPatchServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String message = (String)getServletContext().getAttribute("message");
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
		s.append(message);
		getServletContext().getRequestDispatcher("/gugudan").include(request, response);
		s.append("</body>");
		s.append("</html>");
		
		out.println(s.toString());
		
		
		
	
	}

}

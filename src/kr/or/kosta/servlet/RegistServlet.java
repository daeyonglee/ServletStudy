package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 브라우저 요청 메시지 처리
 * @author ldy
 *
 */
public class RegistServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		process(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		process(request, response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String passwd = request.getParameter("passwd");
		String teams  = request.getParameter("teams");
		String[] fruits = request.getParameterValues("fruit");
		
		String method   = request.getMethod();
		String uri      = request.getRequestURI();
		String protocol = request.getProtocol();
		// 문자스트링 생성
		PrintWriter out = response.getWriter();
		
		StringBuffer s = new StringBuffer();
		s.append("<html>");
		s.append("<head>");
		s.append("<title>처음으로 작성한 서블릿</title>");
		s.append("</head>");
		s.append("<body>");
		s.append("   <h5>요청방식: " + method + "</h5><br>");
		s.append("   <h5>요청URI: " + uri + "</h5><br>");
		s.append("   <h5>요청Protocol: " + protocol + "</h5>");
		s.append("   니이름: " + name + "<br>");
		s.append("   니비번: " + passwd + "<br>");
		s.append("   니팀: " + teams + "<br>");
		s.append("   니과일: ");
		if (fruits != null ) {
			for (String fruit : fruits) {
				s.append(fruit +"," + "<br>");
			}
		}
		
		Enumeration<String> e2 = request.getParameterNames();
		String value = "";
		while(e2.hasMoreElements()) {
			String n = e2.nextElement();
			value += n + ",";
		}
		s.append("파라미터네임: " + value + "<br>");
		
		s.append("<br>");
		s.append("</body>");
		s.append("</html>");
		
		out.println(s.toString());
	}
}

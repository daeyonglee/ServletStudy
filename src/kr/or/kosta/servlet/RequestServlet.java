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
public class RequestServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String method   = request.getMethod();
		String uri      = request.getRequestURI();
		String protocol = request.getProtocol();
		Enumeration<String> e = request.getHeaderNames();
		response.setContentType("text/html; charset=utf-8");
		// 문자스트링 생성
		PrintWriter out = response.getWriter();
		Calendar c = Calendar.getInstance();
		
		
		StringBuffer s = new StringBuffer();
		s.append("<html>");
		s.append("<head>");
		s.append("<title>처음으로 작성한 서블릿</title>");
		s.append("</head>");
		s.append("<body>");
		s.append("   <h5>요청방식: " + method + "</h5><br>");
		s.append("   <h5>요청URI: " + uri + "</h5><br>");
		s.append("   <h5>요청Protocol: " + protocol + "</h5>");
		while(e.hasMoreElements()) {
			String header = e.nextElement();
			s.append(header + ": " + request.getHeader(header) + "<br>");
		}
		s.append("웹 애플리케이션 이름: " + request.getContextPath() + "<br>");
		s.append("웹 클라이언트 IP: " + request.getRemoteAddr() + "<br>");
		s.append("</body>");
		s.append("</html>");
		
		out.println(s.toString());
	}
}

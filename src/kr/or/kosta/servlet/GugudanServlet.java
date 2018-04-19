package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GugudanServlet
 */
public class GugudanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 마임타입(MIME) 설정
		response.setContentType("text/html; charset=utf-8");
		// 문자스트링 생성
		PrintWriter out = response.getWriter();
		
		StringBuffer s = new StringBuffer();
		s.append("<html>");
		s.append("<head>");
		s.append("<title>처음으로 작성한 서블릿</title>");
		s.append("<link rel='stylesheet' type='text/css' href='css/041.css'");
		s.append("</head>");
		s.append("<body>");
		s.append("	<table border='1'>");
		s.append("    <caption>구구단</caption>");
		for (int ii=1; ii<=9; ii++) {
			s.append("    <tr>");
			for (int i=2; i<=9; i++) {
				s.append("<td>"+i + " * " + ii + " = " + ii*i +"</td>");
			}
			s.append("    </tr>");
		}
		s.append("	</table>");
		s.append("</body>");
		s.append("</html>");
		
		out.println(s.toString());
	}
}

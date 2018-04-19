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
public class ResponseServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Database 입력처리
		
		// 다른 서블릿을 요청하게  응답코드와 헤더 설정
		/*response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
		response.setHeader("Location", "gugudan");*/
		
		response.sendRedirect("gugudan");
	}
}

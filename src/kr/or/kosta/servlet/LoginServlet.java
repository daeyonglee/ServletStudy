package kr.or.kosta.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.servlet.common.dao.DaoFactory;
import kr.or.kosta.servlet.user.dao.ConnectionFactory;
import kr.or.kosta.servlet.user.dao.JdbcUserDao;
import kr.or.kosta.servlet.user.dao.UserDao;
import kr.or.kosta.servlet.user.domain.User;

/**
 * 쿠키를 이용한 로그인 처리 서블릿
 * @author ldy
 *
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 로그아웃 처리
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie[] cookie = request.getCookies();
		if (cookie != null) {
			for (Cookie c : cookie) {
				if ("id".equals(c.getName()) || "name".equals(c.getName())) {
					c.setMaxAge(0);
					response.addCookie(c);
				}
			}
		}
		
		response.sendRedirect("index.do");
	}
	
	// 로그인 처리
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id     = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		String url = null;
		
		// JdbcUserDao를 이용한 DB 연동 생략
		UserDao dao = (UserDao) DaoFactory.getInstance().getDao(JdbcUserDao.class);
		User user = dao.isMember(id, passwd);
		
		if (user != null) {
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(3600);
			response.addCookie(cookie);
			response.addCookie(new Cookie("name", URLEncoder.encode(user.getName(), "utf-8")));
			url = "index.do";
		} else {
			url = "loginForm.html";
		}
		response.sendRedirect(url);
	}
}

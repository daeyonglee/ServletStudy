package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 메인서블릿
 * @author ldy
 *
 */
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		String id   = null;
		String name = null;
		
		Cookie[] cookie = request.getCookies();
	    if (cookie != null) {
	 	  for (Cookie c : cookie) {
	        if (c.getName().equals("id")) {
	        	id = c.getValue();
	        }
	        if (c.getName().equals("name")) {
	        	name = c.getValue();
	        }
	      }
	    }
		
		String html  = "<!DOCTYPE html>";
		       html += "<html>";
		       html += "<head>";
		       html += "<meta charset='utf-8'>";
		       html += "<title>index.html</title>";
		       html += "<link rel='stylesheet' type='text/css' href='css/index.css'>";
		       html += "</head>";
		       html += "<body>";
		       html += "  <section>";
		       html += "    <header id='top'>TomMenu 영역";
		       
		       if (id == null) {
	    	     html += "<form action='login.do' method='post' style='float: right;'>";
				 html += "  <input type='text' name='id' placeholder='ID'>";  
				 html += "  <input type='password' name='passwd' placeholder='PASSWORD'>";  
			     html += "  <input type='submit' value='로그인'>";   
			     html += "</form>";  
		       } else {
		    	 html += "<div style='float: right;'>";
			     html += "<span>"+ URLDecoder.decode(name, "utf-8") +"님 환영합니다.</span>";
			     html += "<a href='login.do'>로그아웃</a>";
			     html += "</div>"; 
		       }
		       
		       
		       html += "    </header>";
		       html += "    <aside id='aside'>SideMenu 영역</aside>";
		       html += "    <section id='contents'>Page Contents 영역</section>";
		       html += "    <footer id='footer'>Footer 영역</footer>";
		       html += "  </section>";
		       html += "</body>";
		       html += "</html>";
		       
		       
	   out.println(html);
	}
}

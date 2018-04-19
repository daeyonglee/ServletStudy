package kr.or.kosta.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.servlet.util.ModifiedDate;

/**
 * Servlet implementation class FileListServlet
 */
public class FileListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static String fileRepository;
    
    @Override
    public void init() throws ServletException {
    	fileRepository = getServletContext().getInitParameter("fileRepository");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		File file = new File(fileRepository);
		int count = 0;
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);
		Date date = new Date();

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String html     = "<html>";
			   html    += "<head>";
			   html    += "<meta charset='utf-8'>";
			   html    += "<title>파일 리스트</title>";
			   html    += "<script type='text/javascript' src='js/file.js'></script>";
			   html    += "</head>";
			   html    += "<body>";
			   html    += "<h1>자료실</h1>";
			   html    += "<hr>";
			   html    += "<table border='1'>";
			   html    += "<tr>";
			   html    += "<th>번호</th>";
			   html    += "<th>파일명</th>";
			   html    += "<th>파일용량</th>";
			   html    += "<th>변경된날짜</th>";
			   html    += "<th>구분</th>";
			   html    += "</tr>";
			   if (file.isDirectory()) {
				 File[] fileList = file.listFiles();
				 Arrays.sort(fileList, new ModifiedDate());
				 count = fileList.length;
				 for (File f : fileList) {
					 date.setTime(f.lastModified());
				     html += "<tr>";
				     html += "<td>" + count-- + "</td>";
				     html += "<td>" + f.getName() + "</td>";
				     html += "<td>" + (f.getTotalSpace()/100000000.0) + "Mb</td>";
				     html += "<td>" + formatter.format(date) + "</td>";
				     html += "<td><button onclick='download(\""+ f.getName() +"\")'>다운로드</button></td>";
				     html += "</tr>";
			     }
			   }
			   html    += "</table>";
			   html    += "<form action='download.do' method='post'>";
			   html    += "  <input type='hidden' name='file' />";
			   html    += "</form>";
			   html    += "</body>";
			   html    += "</html>";
			   
			   
			   
	    out.println(html);
		
	}
}

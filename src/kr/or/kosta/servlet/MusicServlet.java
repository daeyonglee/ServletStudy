package kr.or.kosta.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * mp3파일 응답
 * @author ldy
 *
 */
public class MusicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String fileDownload = "";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MusicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		fileDownload = getInitParameter("fileDownload");
		
		//String requestFile = "a.mp4";
	     String requestFile = "b.pptx";
	     
	     // 응답헤더에 Content-Type 설정
	     //response.setContentType("video/mp4");     
	     response.setContentType("application/vnd.ms-powerpoint");     
	     
	     // 바이트입력스트림 생성
	     InputStream in = new FileInputStream(fileDownload + requestFile);
	     // response가 제공하는 바이트입력스트림 취득
	     OutputStream out = response.getOutputStream();
	     byte[] buffer = new byte[1024];
	     int count = 0;
	     try{
	          while( (count = in.read(buffer)) != -1){
	               out.write(buffer, 0, count);
	          }
	     }finally{
	          if(out != null) out.close();
	          if(in != null) in.close();
	     }
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

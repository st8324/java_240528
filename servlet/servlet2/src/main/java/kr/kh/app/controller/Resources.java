package kr.kh.app.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/resources/*")
public class Resources extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	private String uploadPath = "/resources";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//URL에서 컨택스트 패스와 /resources를 제거하는 작업
		//  /servlet_project1/resources/css/test.css
		//  => /css/test.css
		String path = request.getRequestURI().replaceFirst("/resources", "");
		path = path.replaceFirst(request.getContextPath(), "");
		
        String fileName = path;
        String filePath = getServletContext().getRealPath(uploadPath) + fileName;

        File file = new File(filePath);
        try(FileInputStream fis = new FileInputStream(file);
            OutputStream os = response.getOutputStream()){
            String mimeType = getServletContext().getMimeType(filePath);
            
            response.setContentType(mimeType != null ? mimeType : "application/octet-stream");
            response.setContentLength((int)(file.length()));
            response.setHeader("Content-Disposition", "attachment : filename=\"" + fileName + "\"");
            
            byte[] buffer = new byte[1024 * 4];
            int readCount;
            while((readCount = fis.read(buffer)) != -1) {
                os.write(buffer, 0, readCount);
            }
        }
	}
}

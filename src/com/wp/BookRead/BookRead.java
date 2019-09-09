package com.wp.BookRead;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookRead
 */
@WebServlet("/BookRead")
public class BookRead extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String folderName = "F:/s/";
		String name=request.getParameter("name");
		int dot=name.lastIndexOf('.');
		String ext=name.substring(dot+1);
		
		FileInputStream fis=new FileInputStream(folderName+name);
		byte b[]=new byte[fis.available()];
		fis.read(b);
		
		if(ext.equals("pdf"))
		{
			response.setContentType("application/pdf");
			ServletOutputStream out1=response.getOutputStream();
			out1.write(b);
			out1.close();
		}
		
		else
		{
			response.setContentType("application/msword");
			ServletOutputStream out1=response.getOutputStream();
			out1.write(b);
			out1.close();
		}

		fis.close();
		 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

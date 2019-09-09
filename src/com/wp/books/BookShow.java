package com.wp.books;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookShow
 */
@WebServlet("/BookShow")
public class BookShow extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		String folderName = "F:/s/";

		File f = new File(folderName);

		if (f.isDirectory()) {
			File files[] = f.listFiles();
			Arrays.sort(files);
			out.println("<html>");
			out.println("<body>");
			out.println("<br>");
			out.println("<h3>List of Books</h3><hr>");
			for (File file : files) {
				
				String name=file.getName();
				
				

				out.println("<a href='BookRead?name="+name+"'>"+name+"</a>");
				out.println("<br>");

			}
			out.println("</body>");
			out.println("</html>");
			
			out.println("<br><br>");
			out.println("<a href='BookEntryForm.jsp'>Add Book</a>");
			out.println("<br>");
			out.println("<a href='BookSearch.jsp'>Search Book</a>");
		}
		

		 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

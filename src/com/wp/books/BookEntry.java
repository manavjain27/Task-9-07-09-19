package com.wp.books;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookEntry
 */
@WebServlet("/BookEntry")
public class BookEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		String title=request.getParameter("title");
		String subject=request.getParameter("subject");
	    String price=request.getParameter("price");
	    
	    
	    
	   
	    	try {
	    		
	    		Class.forName("com.mysql.jdbc.Driver");
	    		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/abc","root","root");
	    		String sql="insert into books(btitle,bsubject,bprice) values(?,?,?)";
	    	
	    		PreparedStatement ps=con.prepareStatement(sql);
	    	
	    		ps.setString(1,title);
	    		ps.setString(2,subject);
	    		ps.setString(3,price);
	    	
	    		if(ps.executeUpdate()>0)
	    		out.println("<br><center><h3>Book Added Successfully</h3></center>");
	    		else
	    		out.println("<br><center><h3>Book Not Added</h3></center>\"");
	    		}
	    
	    		catch(Exception e)
	    		{
	    				out.println(e.getMessage());
	    		}
	       }
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

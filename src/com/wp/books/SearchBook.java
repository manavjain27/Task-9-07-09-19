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
 * Servlet implementation class SearchBook
 */
@WebServlet("/SearchBook")
public class SearchBook extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out=response.getWriter();
		String subject=request.getParameter("subject");
		
		try {
    		
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/abc","root","root");
    		String sql="select btitle,bprice,bsubject from books where bsubject=?";
    		PreparedStatement ps=con.prepareStatement(sql);
    		ps.setString(1,subject);
    		
    		ResultSet rs= ps.executeQuery();
    		while(rs.next())
    		{
    			out.println("<html>");
    			out.println("<body>");
    			out.println("<h3>\nBook Title :"+rs.getString(1)+"</h3>");
    			out.println("<h3>\nBook Price :"+rs.getString(2)+"</h3>");
    			out.println("<h3>\nBook Subject :"+rs.getString(3)+"<h3>");
    			out.println("<hr>");
    			out.println("</body>");
    			out.println("</html>");
    			
    		}
    			
	    	
    		
		}
		catch(Exception e)
		{
				out.println(e.getMessage());
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

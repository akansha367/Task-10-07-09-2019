package com.ssi.task10;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BookEntry")
public class BookEntry extends HttpServlet {
	private Connection con;
	private PreparedStatement ps;

    
    public BookEntry() {
        // TODO Auto-generated constructor stub
    }


	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			Connection con = DriverManager.getConnection(url, "system", "abcd1234"); 
			String sql = "insert into books values(?,?,?,?)";
			ps = con.prepareStatement(sql);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	

	
	public void destroy() {
		// TODO Auto-generated method stub
	try{
		con.close();
	}catch(Exception e){
		e.printStackTrace();
	}
	}

		
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {

			PrintWriter out=response.getWriter();
			//reads-request
			String bookid=request.getParameter("bookid");
			String bookname=request.getParameter("bookname");
			String authorname=request.getParameter("authorname");
	        String subject=request.getParameter("subject");
			//process
			try{
				ps.setString(1, bookid);
				ps.setString(2, bookname);
				ps.setString(3, authorname);
				ps.setString(5, subject);
				int n=ps.executeUpdate();
				out.println("Book Added successfully");
				
			}catch(Exception e){
				out.println(e);
			}
		
		} catch (Exception ex) {
			ex.printStackTrace();

		}
	}

}

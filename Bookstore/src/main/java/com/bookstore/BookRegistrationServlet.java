//Dagmawi Elias Lewi

package com.bookstore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/registerBook")
public class BookRegistrationServlet extends HttpServlet {
    private final DBConnectionManager dbConnectionManager;

    public BookRegistrationServlet(DBConnectionManager dbConnectionManager) {
        this.dbConnectionManager = dbConnectionManager;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        double price = Double.parseDouble(request.getParameter("price"));

        try {
            dbConnectionManager.openConnection();
            Connection connection = dbConnectionManager.getConnection();
            String sql = "INSERT INTO Books (title, author, price) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, title);
            statement.setString(2, author);
            statement.setDouble(3, price);
            statement.executeUpdate();

            PrintWriter out = response.getWriter();
            out.println("Book registered successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                dbConnectionManager.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}







//package com.bookstore;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.mysql.cj.xdevapi.Statement;
//
//
//@WebServlet("/register")
//public class BookRegistrationServlet extends HttpServlet {
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
//
//	//get PrintWriter
//	PrintWriter pw = resp.getWriter();
//	//set content type
//	resp.setContentType("text/html");
//	
//	//get the book info
//	String bookName = req.getParameter("bookName");
//	String bookEdition = req.getParameter("bookEdition");
//	float bookPrice = Float.parseFloat(req.getParameter("bookPrice"));
//	
//	//load the jdbc driver
//	try {
//		Class.forName("com.mysql.jdbc.Driver:");
//	} catch (ClassNotFoundException cnf) {
//		cnf.printStackTrace();
//	}
//	//generate the connection
//	try {
//		Class.forName("com.mysql.jdbc.Driver");
//		
//		Connection conn = DriverManager.getConnection(
//		"jdbc:mysql://localhost:3306/bookstoredb",
//		"root",
//		"123321");
//		
//	
//		PreparedStatement ps = conn.prepareStatement(query);
//
//
//		
//		ps.setString(1, bookName);
//		ps.setString(2, bookEdition);
//		ps.setFloat(3, bookPrice);
//		int count = ps.executeUpdate();
//		if(count == 1) {
//		pw.println("<h2> Book registered successfully.</h2");
//		}
//		else {
//		pw.println("<h2> Book Not registered successfully.</h2");
//		}
//		
//	} catch (SQLException se) {
//		se.printStackTrace();
//		pw.println("<h1>" + se.getMessage() + "</h1>");
//	} catch (Exception e) {
//		e.printStackTrace();
//		pw.println("<h1>" + e.getMessage() + "</h1>");
//	}
//	pw.println("<a href='Home.html'>Home</a>");
//	pw.print("<br>");
//	pw.println("<a href='booklist'>Book List</a>");
//	}
//	@Override
//
//	protected void doPost( HttpServletRequest req, HttpServletResponse resp) throws IOException {
//
//	doGet(req, resp);
//	}
//	
//	private static final String query = "insert into books(bookname, bookedition, bookprice)values(?, ?, ?)";
//}
//

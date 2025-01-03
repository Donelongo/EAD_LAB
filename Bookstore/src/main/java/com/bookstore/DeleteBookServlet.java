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

@WebServlet("/deleteBook")
public class DeleteBookServlet extends HttpServlet {
    private DBConnectionManager dbConnectionManager = new DBConnectionManager();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            dbConnectionManager.openConnection();
            Connection connection = dbConnectionManager.getConnection();
            String sql = "DELETE FROM Books WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();

            PrintWriter out = response.getWriter();
            if (rowsDeleted > 0) {
                out.println("Book deleted successfully!");
            } else {
                out.println("No book found with the given id.");
            }
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


//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet("/deleteurl")
//public class DeleteBookServlet extends HttpServlet{
//	private static final String query = "Delete from books where id = ?";
//	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
//	//get PrintWriter
//	PrintWriter pw = resp.getWriter();
//	//set content type
//	resp.setContentType("text/html");
//	// get the id of record
//	int id = Integer.parseInt(req.getParameter("id"));
//	//load the jdbc driver
//	try {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//	} catch (ClassNotFoundException cnf) {
//		cnf.printStackTrace();
//	}
//	
//	//generate the connection
//	try {
//	Connection conn = DriverManager.getConnection(
//	"jdbc:mysql:///bookregister", "root", "123321");
//
//	PreparedStatement ps =
//
//	conn.prepareStatement(query);
//
//	ps.setInt(1, id);
//	int count = ps.executeUpdate();
//	if(count == 1) {
//		pw.println("<h2>Record is deleted successfully.</h2>");
//	}else {
//		pw.println("<h2>Record not deleted.</h2>");
//	}
//	} catch (SQLException se) {
//		se.printStackTrace();
//		pw.println("<h1>" + se.getMessage() + "</h1>");
//	} catch (Exception e) {
//		e.printStackTrace();
//		pw.println("<h1>" + e.getMessage() + "</h1>");
//
//	}
//	pw.println("<a href='Home.html'>Home</a>");
//	pw.print("<br>");
//	pw.println("<a href='booklist'>Book List</a>");
//	}
//	
//	@Override
//	protected void doPost(HttpServletRequest req,
//	HttpServletResponse resp) throws ServletException, IOException {
//
//		doGet(req, resp);
//	}
//}
	
	



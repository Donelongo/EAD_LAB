//package com.bookstore;
//
//import java.awt.print.Book;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import lombok.Setter;
//
//@WebServlet("/searchBooks")
//public class SearchBooksServlet extends HttpServlet {
//    private static final String query = "select * from Books where title like ?";
//
//    @Setter
//    private DBConnectionManager dbConnectionManager = new DBConnectionManager();
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String title = request.getParameter("title");
//        StringBuilder htmlResponse = new StringBuilder();
//        dbConnectionManager.openConnection();
//        Connection connection = dbConnectionManager.getConnection();
//        try {
//            PreparedStatement ps = connection.prepareStatement(query);
//            ps.setString(1, "%" + title + "%");
//            ResultSet rs = ps.executeQuery();
//            ArrayList<Book> books = new ArrayList<Book>();
//            while (rs.next()) {
//                books.add(new Book());//rs.getInt("id"), rs.getString("title"), rs.getString("author"), rs.getDouble("price")
//            }
//
//            htmlResponse.append("<html><head> </head><body>");
//            htmlResponse.append("<h2>Showing search results for: '" + title + "'</h2>");
//            htmlResponse.append("<table style='border: 2px solid black; border-spacing: 10px;'>");
//            htmlResponse.append("<tr>");
//            htmlResponse.append("<th>Book ID</th>");
//            htmlResponse.append("<th>Title</th>");
//            htmlResponse.append("<th>Author</th>");
//            htmlResponse.append("<th>Price</th>");
//            htmlResponse.append("</tr>");
//            for (Book book : books) {
//                htmlResponse.append("<tr>");
//                htmlResponse.append("<td>").append(book.getId()).append("</td>");
//                htmlResponse.append("<td>").append(book.getTitle()).append("</td>");
//                htmlResponse.append("<td>").append(book.getAuthor()).append("</td>");
//                htmlResponse.append("<td>").append(book.getPrice()).append("</td>");
//                htmlResponse.append("</tr>");
//            }
//            htmlResponse.append("</table>");
//            htmlResponse.append("</body></html>");
//        } catch (SQLException se) {
//            se.printStackTrace();
//            htmlResponse.append("<h1>").append(se.getMessage()).append("</h1>");
//        } catch (Exception e) {
//            e.printStackTrace();
//            htmlResponse.append("<h1>").append(e.getMessage()).append("</h1>");
//        }
//
//        htmlResponse.append("</body></html>");
//        dbConnectionManager.closeConnection();
//
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.print(htmlResponse.toString());
//    }
//}

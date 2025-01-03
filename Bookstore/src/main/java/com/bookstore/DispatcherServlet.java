package com.bookstore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/*")
public class DispatcherServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        if (path.equals("/registerBook")) {
            request.getRequestDispatcher("/registerBook").forward(request, response);
        } else if (path.equals("/displayBooks")) {
            request.getRequestDispatcher("/displayBooks").forward(request, response);
        } else if (path.equals("/deleteBook")) {
            request.getRequestDispatcher("/deleteBook").forward(request, response);
        } else if (path.equals("/searchBooks")) {
            request.getRequestDispatcher("/searchBooks").forward(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

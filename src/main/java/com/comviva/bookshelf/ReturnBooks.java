package com.comviva.bookshelf;

import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/return")
public class ReturnBooks extends HttpServlet{


		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws IOException, ServletException {
					BookRowMapper1 user1=new BookRowMapper1();
				
				   //PrintWriter out = response.getWriter();
				   String bookNo = request.getParameter("BookNo");
				   String empId = request.getParameter("EmpId");
			
				   user1.returnBook(empId,bookNo);
				   request.setAttribute("EmpId", empId);
				   request.getRequestDispatcher("/successfulreturn.jsp").forward(request, response);
		}

	}



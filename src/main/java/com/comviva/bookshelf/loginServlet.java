package com.comviva.bookshelf;

import java.util.List;
import java.io.IOException;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	@WebServlet(urlPatterns = "/login")
	public class loginServlet extends HttpServlet {
       

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;


		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws IOException, ServletException {
			BookRowMapper1 user1=new BookRowMapper1();
				
				 //PrintWriter out = response.getWriter();
				 String name = request.getParameter("name");
			
				   List<Books> query=user1.BookAvailable(name);
				   System.out.println("query size is"+query.size());
			
				      if(query.size()==0)
						request.getRequestDispatcher("/index.jsp").forward(request, response);
					else
				      {
				    	   request.setAttribute("query", query);
							  request.getRequestDispatcher("/success.jsp").forward(request, response);
				      }
		}

	}




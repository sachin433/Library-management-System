package com.comviva.bookshelf;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

public class BookRowMapper1 {

	public List<Books> BookAvailable(String name) {
		ArrayList<Books> books = null;
		 Books book=null;
		  try{
			//loading drivers for Postgres
			Class.forName("org.postgresql.Driver");

			//creating connection with the database 
			Connection con=DriverManager.getConnection
	                   ("jdbc:postgresql://localhost:5432/postgres","postgres","root");

			Statement stmt = con.createStatement();
			String sql;
			
			System.out.println("passed name is: " + name);
			
			sql="select e.BookName,e.Author,e.Edition,e.BookNo from Books e where e.BookName='"+name+"'";
			System.out.print("passed name was: " + name);
	   
			ResultSet rs = stmt.executeQuery(sql);
			books=new ArrayList<Books>();
			while(rs.next()){
	    	 
	    	book=new Books();
	    	
	 		book.setBookNo(rs.getString("BookNo"));
	 		book.setBookName(rs.getString("BookName"));
	 		book.setAuthor(rs.getString("Author"));
	 		book.setEdition(rs.getString("Edition"));
	 		books.add(book);
	 		 
	 		String id  = rs.getString("BookNo");
	        String naam = rs.getString("BookName");
	        String author = rs.getString("Author");
	        String edition = rs.getString("Edition");

	        //Display values
	        System.out.print("ID: " + id);
	        System.out.print(", Age: " +naam);
	        System.out.print(", First: " + author);
	        System.out.println(", Last: " + edition);
	 		
	       }
	    }
		catch(Exception e)
		  {
			e.printStackTrace();
		  }
		 return books;
	}
	
	
	public List<Books> BookAvailableUsingId(String name) {
		ArrayList<Books> books = null;
		 Books book=null;
		  try{
			//loading drivers for Postgres
			Class.forName("org.postgresql.Driver");

			//creating connection with the database 
			Connection con=DriverManager.getConnection
	                   ("jdbc:postgresql://localhost:5432/postgres","postgres","root");

			Statement stmt = con.createStatement();
			String sql;
			System.out.println("passed name is: " + name);
			
			sql="select e.BookName,e.Author,e.Edition,e.BookNo from Books e where e.BookNo='"+name+"'";
			System.out.print("passed name was: " + name);
	   
			ResultSet rs = stmt.executeQuery(sql);
			books=new ArrayList<Books>();
			while(rs.next()){
	    	 
	    	book=new Books();
	    	
	 		book.setBookNo(rs.getString("BookNo"));
	 		book.setBookName(rs.getString("BookName"));
	 		book.setAuthor(rs.getString("Author"));
	 		book.setEdition(rs.getString("Edition"));
	 		books.add(book);
	 		 
	 		
	 		
	       }
	    }
		catch(Exception e)
		  {
			e.printStackTrace();
		  }
		 return books;
	}

		
	public BookIssue BookAvailable2(String name) {
		BookIssue bookIssue=new BookIssue();
		Books book=new Books();
		 List<Books> books=null;
		  try{
			//loading drivers for Postgres
			Class.forName("org.postgresql.Driver");

			//creating connection with the database 
			Connection con=DriverManager.getConnection
	                   ("jdbc:postgresql://localhost:5432/postgres","postgres","root");

			Statement stmt = con.createStatement();
			String sql;
		
			
			sql="select e.BookName,e.Author,e.Edition,e.BookNo from Books e where e.BookNo='"+name+"'";

	   
			ResultSet rs = stmt.executeQuery(sql);
			books=new ArrayList<Books>();
			while(rs.next()) {
	    	
	 		book.setBookNo(rs.getString("BookNo"));
	 		book.setBookName(rs.getString("BookName"));
	 		book.setAuthor(rs.getString("Author"));
	 		book.setEdition(rs.getString("Edition"));
	 		 

	 		books.add(book);
			}

			sql="select Issued from BookIssueInfo where BookNo='"+books.get(0).getBookNo()+"'";


			List<Boolean> bools=new ArrayList<Boolean>();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
			System.out.println("statusssss: "+rs.getString("issued"));
			bools.add(rs.getString("issued").equals("t")?new Boolean(true):new Boolean(false));
			}
			bookIssue.setBook(books.get(0));
			bookIssue.setIssued(bools.get(0));
	    }
		catch(Exception e)
		  {
			e.printStackTrace();
		  }
		 return bookIssue;
	}


	
	
	public int Transaction(String empId, String bookNo) {
		System.out.println("issuing book");
		int res=-1;
		  try{
			//loading drivers for Postgres
			Class.forName("org.postgresql.Driver");

			//creating connection with the database 
			Connection con=DriverManager.getConnection
	                   ("jdbc:postgresql://localhost:5432/postgres","postgres","root");

			Statement stmt = con.createStatement();
			String sql;
			System.out.println("passed name is: " +empId);
			

			System.out.println("issuing book");
			
			sql="select count(*) from transaction where doreturn is null and empId='"+empId+"'";
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			int noOfIssuedBooks=rs.getInt(1);
			System.out.println("noOfIssuedBooks"+noOfIssuedBooks);
			
			sql="select * from issuelimit";
			rs = stmt.executeQuery(sql);
			rs.next();
			int maxLimit=rs.getInt(1);
			System.out.println("maxLimit"+maxLimit);
			
			if(noOfIssuedBooks>=maxLimit) {
				return -1;
			}
			
			sql="Insert into Transaction values('"+empId+"','"+bookNo+"',CURRENT_DATE); Update BookIssueInfo set issued=true where bookNo='"+bookNo+"'";

			System.out.println("issuing book");
			stmt.execute(sql);
			res=1;
	    }
		catch(Exception e)
		  {
			e.printStackTrace();
		  }
		  return res;
	}

	public List<Transaction> getTransactions(String empId) {
		List<Transaction> transactions = null;
		 Transaction transaction=null;
		 System.out.println(empId);
		  try{
			//loading drivers for Postgres
			Class.forName("org.postgresql.Driver");

			//creating connection with the database 
			Connection con=DriverManager.getConnection
	                   ("jdbc:postgresql://localhost:5432/postgres","postgres","root");

			Statement stmt = con.createStatement();
			String sql;
			
			sql="select * from Transaction where empId='"+empId+"'";
	   
			ResultSet rs = stmt.executeQuery(sql);
			transactions=new ArrayList<>();
			while(rs.next()){
	    	 
	    	transaction=new Transaction();
	    	
	    	transaction.setEmpId(rs.getString("empId"));
	    	transaction.setBookNo(rs.getString("bookno"));
	    	transaction.setDOIssue(rs.getString("doissue"));
	    	transaction.setDOReturn(rs.getString("doreturn"));
	    	System.out.println(transaction);
	 		transactions.add(transaction);
	       }
	    }
		catch(Exception e)
		  {
			e.printStackTrace();
		  }
		 return transactions;
	}
	

	public void returnBook(String empId, String bookNo) {
		Boolean res=false;
		  try{
			//loading drivers for Postgres
			Class.forName("org.postgresql.Driver");

			//creating connection with the database 
			Connection con=DriverManager.getConnection
	                   ("jdbc:postgresql://localhost:5432/postgres","postgres","root");

			Statement stmt = con.createStatement();
			String sql;
			System.out.println("passed name is: " +empId);
			

			System.out.println("issuing book");
			
			//System.out.println(java.time.LocalDate.now());
			sql="Update Transaction set DOReturn='"+java.time.LocalDate.now()+"' where bookNo="+bookNo+" and EmpId="+empId+"; Update BookIssueInfo set issued=false where bookNo="+bookNo;

			System.out.println("returning book");
			stmt.execute(sql);
			
	    }
		catch(Exception e)
		  {
			e.printStackTrace();
		  }
	}
		
		
	} 


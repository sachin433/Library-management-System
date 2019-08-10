<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.comviva.bookshelf.Books"%>
<%@page import="com.comviva.bookshelf.BookRowMapper1"%>
<%@page import="com.comviva.bookshelf.Transaction"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book Store</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="theme-color" content="#03a6f3">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:200,300,400,500,600,700,800,900" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/styles.css">
</head>

<body>
    <header>
        <div class="header-top">
            <div class="container">
                <div class="row">
                    <div class="col-md-3"><a href="#" class="web-url">www.comviva.com</a></div>
                    <div class="col-md-6">
                        <h5>Enhance your learning daily</h5></div>
                    <div class="col-md-3">
                        <span class="ph-number">Call : 800 1234 5678</span>
                    </div>
                </div>
            </div>
        </div>
        <div class="main-menu">
            <div class="container">
                <nav class="navbar navbar-expand-lg navbar-light">
                    <a class="navbar-brand" href="https://www.comviva.com/"><img src="images/comvivalogo.jpeg" alt="logo"></a>
                    <img src="images/bookshelflogo.png" alt="logo">
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        &nbsp;
						&nbsp;
						
                        
                        <form class="form-inline my-2 my-lg-0">
                            <input class="form-control mr-sm-2" type="search" placeholder="Search here..." aria-label="Search">
                            <span class="fa fa-search"></span>
                        </form>
                    </div>
                </nav>
            </div>
        </div>
    </header>
    <div class="breadcrumb">
        <div class="container">
            <a class="breadcrumb-item" href="index.html">Home</a>
            <span class="breadcrumb-item active">Account</span>
			<span class="breadcrumb-item active">Previous Issues</span>
        </div>
    </div>
    <section class="static about-sec">
        <div class="container">
            <h2>My Previous Issues</h2>
            <div class="recomended-sec">
                <div class="row">
                
                <% 
				Connection con=null;
                try{
                	Class.forName("org.postgresql.Driver");
                	con=DriverManager.getConnection
    	                   ("jdbc:postgresql://localhost:5432/postgres","postgres","root");
                }
                catch(Exception e){
                	e.printStackTrace();
                }
                /*String empId=request.getAttribute("EmpId").toString();
                if(empId==null)*/
                String empId=request.getParameter("EmpId");
				//empId=empId.substring(empId.indexOf("EmpId=")+6);
                //System.out.println("request.getAttribute(EmpId).toString()"+request.getAttribute("EmpId").toString());
                BookRowMapper1 rowMapper=new BookRowMapper1();
                List<Transaction> transactions=rowMapper.getTransactions(empId);
                for(Transaction t : transactions)
    			{
            		String bookNo=t.getBookNo();
            		System.out.println("t.getBookNo()"+bookNo);
            		try{
        				Statement stmt = con.createStatement();
        				String sql;
        				sql="select BookName from Books where bookNo='"+bookNo+"'";
        				ResultSet rs = stmt.executeQuery(sql);
        				rs.next();
        				t.setBookName(rs.getString("bookname"));
        	    	}
            		catch(Exception e){
            			e.printStackTrace();
            		}
            		String bookname=t.getBookName();
                	
                	String address="images/"+bookname+".jpg";
                	out.print("<div class='col-lg-3 col-md-6'><div class='item'><img src='"+address+"' alt='img'/><h3>");
                	out.print(t.getBookName());  
        			String DOReturn=t.getDOReturn();
        			String style;
        			String linkOpened="";
        			String linkClosed="";
        			if(DOReturn==null)
        				{
        				DOReturn="Yet to be returned";
        				style="";
        				linkOpened="<a href='/returnconfirm?BookNo="+bookNo+"&EmpId="+empId+"'>";
        				linkClosed="";
        				}
        			else{
        				DOReturn="DOR: "+DOReturn;
        				style="style='color:black'";
        			}
        			out.print("</h3><h6><span class='price' "+style+">");
        			out.print(DOReturn+"</span></h6><div class='hover'>"+linkOpened+"<span><i class='fa fa-long-arrow-right' aria-hidden='true'></i></span>"+linkClosed+"</div><h6><span class='price' style='color:black'>DOI: ");
        			out.print(t.getDOIssue());
        			out.print("</span></h6></div></div>");
        		}
    		%>
				
               </div>
            </div>
           
              
        </div>
    </section> <%-- --%>
   <footer>
   <div class="container">
            <div class="row">
                
                
                <div class="col-md-5">
                    <div class="form">
                        <h3>Feedback</h3>
                        
                        <form>
                            <div class="row">
                                <div class="col-md-6">
                                    <input placeholder="Name" required>
                                </div>
                                <div class="col-md-6">
                                    <input type="email" placeholder="Email" required>
                                </div>
                                <div class="col-md-12">
                                    <textarea placeholder="Message"></textarea>
                                </div>
                                <div class="col-md-12">
                                    <button class="btn black">Alright, Submit</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
   
   
   
   
   
   
   
        <div class="copy-right">
            <div class="container">
                <div class="row">
                    <div class="col-md-6">
                        <h5>(C) 2019. All Rights Reserved. Comviva Technologies.</h5>
                    </div>
                    
                </div>
            </div>
        </div>
    </footer>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/owl.carousel.min.js"></script>
    <script src="js/custom.js"></script>
</body>

</html>
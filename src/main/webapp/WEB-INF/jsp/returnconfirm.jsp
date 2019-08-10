<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.comviva.bookshelf.Books"%>
<%@page import="com.comviva.bookshelf.BookRowMapper1"%>
<%@page import="com.comviva.bookshelf.BookIssue"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book Store</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="theme-color" content="#03a6f3">
    <link rel="stylesheet" href="bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:200,300,400,500,600,700,800,900" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="owl.carousel.min.css">
    <link rel="stylesheet" href="styles.css">
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
						
                        
                        <form class="form-inline my-2 my-lg-0" action="/ComvivaBookShelf/search">
                            <input class="form-control mr-sm-2" type="search" placeholder="Search here..." aria-label="Search" name="name"/>
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
            <span class="breadcrumb-item active">Book Return</span>
			<span class="breadcrumb-item active">Confirm</span>
        </div>
    </div>
	
	
	
	
	
	
	
	
	 <section class="product-sec">
        <div class="container">
         
            <div class="row">
                <div class="col-md-6 slider-sec">
                    <!-- main slider carousel -->
                    <div id="myCarousel" class="carousel slide">
                        <!-- main slider carousel nav controls -->
                        <ul class="carousel-indicators list-inline">
                            <li class="list-inline-item active">
                            <%

              		String bookId = request.getParameter("BookNo");
					BookRowMapper1 user1=new BookRowMapper1();
				   	BookIssue b=user1.BookAvailable2(bookId);
				   	String bookName=b.getBook().getBookName();
				   	String authorName=b.getBook().getAuthor();
				   	bookId=b.getBook().getBookNo();
				   	%>
                                <a id="carousel-selector-0" class="selected" data-slide-to="0" data-target="#myCarousel">
                                <img src="images/<%=bookName %>.jpg" class="img-fluid">
                            </a>
                            </li>
                        </ul>
                    </div>
                    <!--/main slider carousel-->
                </div>
                <div class="col-md-6 slider-content">
                
                 
                   
					<h4> You are Returning </h4>
                    
                      
                       
                            <span class="name"><%=bookName %><br/><%=authorName %></span>
                       
                        
                   
					
					<br/>
					<br/>
					<br/>
					<br/>
					
                    <div class="btn-sec">
                    <form action="/ComvivaBookShelf/return">
                    	<input type="hidden" value=<%=bookId%> name="BookNo"/>
                    	<input type="hidden" value=101 name="EmpId"/>
                    	<button class='btn '>Confirm</button>
                    </form>
                        <button class="btn black">Cancel</button>
                    </div>
                </div>
            </div>
        </div>
    </section>
	
	
	
	
	
	
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
    <script src="jquery.min.js"></script>
    <script src="bootstrap.min.js"></script>
    <script type="text/javascript" src="owl.carousel.min.js"></script>
    <script src="custom.js"></script>
</body>

</html>
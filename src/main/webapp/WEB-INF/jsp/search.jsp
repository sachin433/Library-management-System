<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.comviva.bookshelf.Books"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="ISO-8859-1">
    <title>Book Store</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="theme-color" content="#03a6f3">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:200,300,400,500,600,700,800,900" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
						
                        
                        <form class="form-inline my-2 my-lg-0" action="/search">
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
            <span class="breadcrumb-item active">Search</span>
        </div>
    </div>
    <section class="static about-sec">
        <div class="container">
            <h2>Search Results</h2>
            <div class="recomended-sec">
                <div class="row">
               <% ArrayList<Books> BookList = (ArrayList<Books>)request.getAttribute("query");
            //   HttpSession session = request.getSession();
    for(Books e : BookList)
    {
    	String bookNo=e.getBookNo();
    	String bookname=e.getBookName();
    	
    	String address="images/"+bookname+".jpg";
    	
                  out.print("<div class='col-lg-3 col-md-6'><div class='item'><img src='" +address+ "' alt='img'></img><h3>");
        out.print(e.getBookName());  
        out.print("</h3><!--<h6><span class='price'>Issue</span> <a href=''#''></a></h6>--><div class='hover'><a href='/Bookstatus?BookNo="+bookNo+"'><span><i class='fa fa-long-arrow-right' aria-hidden='true'></i></span></a></div></div></div> ");
    }
    %> 
               
					
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
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/owl.carousel.min.js"></script>
    <script src="js/custom.js"></script>
</body>

</html>
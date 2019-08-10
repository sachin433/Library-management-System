<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.comviva.bookshelf.Books"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Result</title>
</head>
<body>
Result:<% List<Books> students = (ArrayList<Books>)request.getAttribute("query");
 
    for(Books e : students)
    {
        out.print("Name: " + e.getBookName());
        out.print("<br/>");
        out.print("Id: " + e.getBookNo());
        out.print("<br/>");
        out.print("Author: " + e.getAuthor());
        out.print("<br/>");
        out.print("Edition: " + e.getEdition());
        out.print("<br/>");
        out.print("<br/>");
    }
 
%>
</body>
</html>
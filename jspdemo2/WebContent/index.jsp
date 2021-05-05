<%@page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1> Hello from HTML</h1>
	<%= "<h1> Hello from JSP </h1>" %>
	
	<% 
	    int x=10; 
	%>
	
	<input type="text" value="<%= x %>">
	<br/>
	
	<%
		for(int i=0; i<10; i++){
			out.print("i = " + i + "<br/>");
		}
	
		%>
	The current date is <%= new Date() %> <br,/>
	<%--JSP Implicit Objects 
		out - JspWriter
		application - ServletConfig
		config - ServletConfig
		page - Object
		pageContext - PageContext
		Exception - throwable
		request - HttpServletRequest
		response - HttpServletResponse
		--%>	
		
		<form action="">
			Enter Name: <input type="text" name="fname">
			<input type="submit" name="click" value="click me">
		</form>
		
		<%
			if(request.getParameter("click") != null){
				out.print("Hello " + request.getParameter("fname"));
			}
		%>
	
	<%@include file="footer.html" %>
	
	
	
</body>
</html>
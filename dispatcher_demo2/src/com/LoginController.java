package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html; charset=utf-8");
    	String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	
    	RequestDispatcher rd = null;
    	if(username.equalsIgnoreCase("tom") && password.equals("jerry")) {
    		rd = request.getRequestDispatcher("SuccessServlet");
    		rd.forward(request, response);
    	}else {
    		rd = request.getRequestDispatcher("login.html");
    		PrintWriter out = response.getWriter();
    		rd.include(request, response);
    		out.print("<center><span style='color:red'> Invalid username or password </span></center>");
    		
    	}
    	
	}

}

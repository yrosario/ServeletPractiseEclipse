package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.User;

/**
 * Servlet implementation class SummaryServlet
 */
public class SummaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SummaryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		User user = new User();
		
		//pass in false to continue last session that was started at FirstServlet returns a reference
		//to session started in first Servlet
		HttpSession session= request.getSession(false);
		
		//Check if a session has been started
		if(session != null) {
			//Retrieve existing user object from session
			user =(User) session.getAttribute("user");
			user.setCity(request.getParameter("city"));
			user.setContact(Long.parseLong(request.getParameter("contact")));
			
			PrintWriter out = response.getWriter();
			out.println("<h2> Hello " + user.getEmail() + " </h2>");
			out.println("<h3> Details .. " + user + " </h3>");
			out.println("<h4> Session Id is " + session.getId() + " </h4>");
			out.println("<h4> Session created at " + session.getCreationTime() + " </h4>");
			
			//Terminate session
			session.invalidate();

		}
	}

}

package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.User;

/**
 * Servlet implementation class SecondServlet
 */
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecondServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		
		//pass in false to continue last session that was started at FirstServlet returns a reference
		//to session started in first Servlet
		HttpSession session= request.getSession(false);
		
		//Check if a session has been started
		if(session != null) {
			//Retrieve existing user object from session
			user =(User) session.getAttribute("user");
			user.setEmail(request.getParameter("email"));
			user.setAge(Integer.parseInt(request.getParameter("age")));
			session.setAttribute("user", user);
			
			//redirect to other webpage. This is how session is maintained
			response.sendRedirect("three.html");
		}
	}
	

}

package com.us.g2g.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.us.g2g.hbm.User;
import com.us.g2g.hbm.UserHome;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String name= request.getParameter("name");
		String sname= request.getParameter("short_name");
		String email= request.getParameter("reg_email");
		String password= request.getParameter("password");
			
		User user = new User();
		user.setName(name);
		user.setShortName(sname);
		user.setEmail(email);
		user.setPassword(password);
		user.setRole("normal_user");
		
		UserHome home = new UserHome();
		int id = home.persist(user);
		if(id > 0){
			user.setId(id);
			request.getSession().setAttribute("user", user);
		}else if(id == -2){
			response.sendError(response.SC_UNAUTHORIZED,"Email already exists..");
		}else{
			response.sendError(response.SC_BAD_REQUEST,"No Connectivity");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

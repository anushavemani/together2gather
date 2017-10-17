package com.us.g2g.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.us.g2g.hbm.Event;
import com.us.g2g.hbm.Participant;
import com.us.g2g.hbm.User;
import com.us.g2g.hbm.UserHome;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		UserHome userHome = new UserHome();
		User user = userHome.findById(request.getParameter("login_email"));
		
		if(user != null){
			if(user.getPassword().equals(request.getParameter("login_pwd"))){
				request.getSession().setAttribute("user", user);
				Gson gson = (new GsonBuilder()).excludeFieldsWithoutExposeAnnotation().create();
				JsonObject jobj = gson.toJsonTree(user).getAsJsonObject();
				List<Integer> eventids = new ArrayList<Integer>();
				for (Event	event: user.getEventsForCreatedBy()) {
					eventids.add(event.getId());
				}
				jobj.add("ownEvents", gson.toJsonTree(eventids));

				
				List<Integer> volunteerList = new ArrayList<Integer>();
				for (Participant participant: user.getParticipants()) {
					if("true".equals(participant.getStatus()))
							volunteerList.add(participant.getEvent().getId());
				}
				jobj.add("volunteered", gson.toJsonTree(volunteerList));
				
				response.getWriter().println(jobj.toString());
			}else{
				response.sendError(response.SC_UNAUTHORIZED,"Invalid Password");
			}
		}else{
			response.sendError(response.SC_UNAUTHORIZED,"No user found..");
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

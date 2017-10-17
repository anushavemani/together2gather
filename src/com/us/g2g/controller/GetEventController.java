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
import com.us.g2g.hbm.Comment;
import com.us.g2g.hbm.Event;
import com.us.g2g.hbm.EventHome;
import com.us.g2g.hbm.Payment;
import com.us.g2g.hbm.Photo;
import com.us.g2g.hbm.User;

/**
 * Servlet implementation class GetEventController
 */
@WebServlet("/GetEventController")
public class GetEventController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetEventController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		
		User user = (User) request.getSession().getAttribute("user");
		Integer userid = -1;
		try {
			userid = user.getId();
		} catch (Exception e) {
		}
		
		EventHome home = new EventHome();
		List<Event> events = home.findAll();
		List<Event> removeEventList = new ArrayList<Event>();
		List<Comment> removeCommentList = new ArrayList<Comment>();
		List<Photo> removePhotoList = new ArrayList<Photo>();
		List<Payment> removePaymentList = new ArrayList<Payment>();
		
		start: for (int i = 0;i<events.size();i++) {
			Event event = events.get(i);
			if(!event.getUserByCreatedBy().getId().equals(userid)){
				if(event.getApprovedOn() == null){
					removeEventList.add(event);
					continue start;
				}
			}
			for (Comment comment : event.getComments()) {
				if(!comment.getUserByPostedBy().getId().equals(userid)){
					if(comment.getApprovedOn() == null){
						removeCommentList.add(comment);
					}
				}				
			}
			event.getComments().removeAll(removeCommentList);
			for (Photo photo : event.getPhotos()) {
				if(!photo.getUserByUserId().getId().equals(userid)){
					if(photo.getApprovedOn() == null){
						removePhotoList.add(photo);
					}
				}
			}
			event.getPhotos().removeAll(removePhotoList);
			
			for (Payment payment : event.getPayments()) {
				if(!payment.getStatus().equals("SUCCESS")){
					removePaymentList.add(payment);
				}else{
					payment.setPaidBy(payment.getUser().getName());
				}
			}
			event.getPayments().removeAll(removePaymentList);
			
		}
		events.removeAll(removeEventList);
		Gson gson  = (new GsonBuilder()).excludeFieldsWithoutExposeAnnotation().create();
		JsonObject jobj = new JsonObject();
		jobj.add("events", gson.toJsonTree(events));
		response.getWriter().println(jobj);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

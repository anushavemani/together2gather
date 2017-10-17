package com.us.g2g.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sun.javafx.collections.MappingChange.Map;
import com.us.g2g.hbm.Comment;
import com.us.g2g.hbm.Event;
import com.us.g2g.hbm.Participant;
import com.us.g2g.hbm.Payment;
import com.us.g2g.hbm.Photo;
import com.us.g2g.hbm.User;
import com.us.g2g.hbm.UserHome;
import com.us.g2g.model.TimelineData;

/**
 * Servlet implementation class TimelineController
 */
@WebServlet("/TimelineController")
public class TimelineController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimelineController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("application/json");
		
		User user = (User) request.getSession().getAttribute("user");

		UserHome home = new UserHome();
		User fullUser =  home.findCompleteUser(user.getId());
		TreeMap<Date, TimelineData> timeline = new TreeMap<Date,TimelineData>();
		
//		Hibernate.initialize(instance.getEventsForCreatedBy());
		for(Event event: fullUser.getEventsForCreatedBy()){
			TimelineData data = new TimelineData();
			data.setAction("Event Creation : " + event.getTitle());
			data.setDescription(event.getDescription());
			data.setActionDateTime(event.getDateTime());
			timeline.put(event.getDateTime(), data);
		}
		
//		Hibernate.initialize(instance.getParticipants());
		for(Participant event: fullUser.getParticipants()){
			TimelineData data = new TimelineData();
			if(event.getStatus().equals("true"))
				data.setAction("Volunteered Event : " + event.getEvent().getTitle());
			else
				data.setAction("De-Volunteered Event : " + event.getEvent().getTitle());
			
			data.setDescription(event.getNote());
			data.setActionDateTime(event.getDateTime());
			timeline.put(event.getDateTime(), data);
		}
		
//		Hibernate.initialize(instance.getCommentsForApprovedBy());
		for(Comment comment: fullUser.getCommentsForApprovedBy()){
			TimelineData data = new TimelineData();
			data.setAction("Approved Comment on event : " + comment.getEvent().getTitle());
			data.setDescription(comment.getText());
			data.setActionDateTime(comment.getApprovedOn());
			timeline.put(comment.getApprovedOn(), data);
		}
		
//		Hibernate.initialize(instance.getCommentsForPostedBy());
		for(Comment comment: fullUser.getCommentsForPostedBy()){
			TimelineData data = new TimelineData();
			data.setAction("Commented Event : " + comment.getEvent().getTitle());
			data.setDescription(comment.getText());
			data.setActionDateTime(comment.getDateTime());
			timeline.put(comment.getDateTime(), data);
		}
		
//		Hibernate.initialize(instance.getEventsForApprovedBy());
		for(Event event: fullUser.getEventsForApprovedBy()){
			TimelineData data = new TimelineData();
			data.setAction("Approved Event : " + event.getTitle());
			data.setDescription(event.getDescription());
			data.setActionDateTime(event.getApprovedOn());
			timeline.put(event.getApprovedOn(), data);
		}
		
//		Hibernate.initialize(instance.getPayments());
		for(Payment payment: fullUser.getPayments()){
			TimelineData data = new TimelineData();
			if("SUCCESS".equals(payment.getStatus()))
				data.setAction("Donated $"+payment.getAmount()+" on Event : " + payment.getEvent().getTitle());
			else if("FAILED".equals(payment.getStatus()))
				data.setAction("Failed Donation $"+payment.getAmount()+" on Event : " + payment.getEvent().getTitle());
			else
				data.setAction("PENDING Donation $"+payment.getAmount()+" on Event : " + payment.getEvent().getTitle());
			data.setDescription(payment.getNote());
			data.setActionDateTime(payment.getPaidOn());
			timeline.put(payment.getPaidOn(), data);
		}
		
//		Hibernate.initialize(instance.getPhotosForApprovedBy());
		for(Photo photo: fullUser.getPhotosForApprovedBy()){
			TimelineData data = new TimelineData();
			data.setAction("Approved photo ");
			data.setDescription(photo.getSource());
			data.setActionDateTime(photo.getApprovedOn());
			timeline.put(photo.getApprovedOn(), data);
		}
		
//		Hibernate.initialize(instance.getPhotosForUserId());
		for(Photo photo: fullUser.getPhotosForUserId()){
			TimelineData data = new TimelineData();
			data.setAction("Added a photo: ");
			data.setDescription(photo.getSource());
			data.setActionDateTime(photo.getDateTime());
			timeline.put(photo.getDateTime(), data);
		}
		

		Gson gson = new Gson();
		
		response.getWriter().println(gson.toJsonTree(timeline.values()).toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

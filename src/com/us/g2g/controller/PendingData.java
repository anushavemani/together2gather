package com.us.g2g.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.us.g2g.hbm.Comment;
import com.us.g2g.hbm.CommentHome;
import com.us.g2g.hbm.Event;
import com.us.g2g.hbm.EventHome;
import com.us.g2g.hbm.Photo;
import com.us.g2g.hbm.PhotoHome;
import com.us.g2g.hbm.User;

/**
 * Servlet implementation class PendingData
 */
@WebServlet("/PendingData")
public class PendingData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PendingData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		// TODO Auto-generated method stub
		JsonObject returnObject = new JsonObject();

		EventHome  home = new EventHome();
		List<Event> events = home.findAll();
		JsonArray eventsJson = new JsonArray();
		for (Event event : events) {
			if(event.getApprovedOn() == null){
				JsonObject eventjson = new JsonObject();
				eventjson.addProperty("id", event.getId());
				eventjson.addProperty("title", event.getTitle());
				eventjson.addProperty("description", event.getDescription());
				eventjson.addProperty("estimatedBudget", event.getEstimatedBudget());
				eventjson.addProperty("receivedFund", event.getReceivedFund());
				eventjson.addProperty("exepectedFund", event.getExepectedFund());
				eventjson.addProperty("pocName", event.getPocName());
				eventjson.addProperty("pocContact", event.getPocContact());
				eventjson.addProperty("occuranceDate", event.getOccuranceDate());
				eventjson.addProperty("occuranceTime", event.getOccuranceTime());
				eventjson.addProperty("dateTime", event.getDateTime().getTime());
				eventjson.addProperty("status", event.getStatus());
				eventjson.addProperty("postedBy", event.getUserByCreatedBy().getName());
				eventsJson.add(eventjson);
			}
		}
		
		returnObject.add("events",eventsJson);

		CommentHome chome = new CommentHome();
		List<Comment> comments = chome.findAll();
		JsonArray commentsJson = new JsonArray();
		for (Comment comment : comments) {
			if(comment.getApprovedOn() == null){
				JsonObject commentjson = new JsonObject();
				commentjson.addProperty("id", comment.getId());
				commentjson.addProperty("event", comment.getEvent().getTitle());
				commentjson.addProperty("postedBy", comment.getUserByPostedBy().getName());
				commentjson.addProperty("text", comment.getText());
				commentjson.addProperty("visible", comment.getVisible());
				commentjson.addProperty("dateTime", comment.getDateTime().getTime());
				commentsJson.add( commentjson);
			}
		}
		returnObject.add("comments", commentsJson);
		
		
		PhotoHome pHome = new PhotoHome();
		List<Photo> photos = pHome.findAll();
		JsonArray photosJson = new JsonArray();
		for (Photo photo : photos) {
			if(photo.getApprovedOn() == null){
				JsonObject photojson = new JsonObject();
				photojson.addProperty("id", photo.getId());
				photojson.addProperty("source", photo.getSource());
				photojson.addProperty("dateTime", photo.getDateTime().getTime());
				photojson.addProperty("event", photo.getEvent().getTitle());
				photojson.addProperty("postedBy", photo.getUserByUserId().getName());
				photosJson.add(photojson);
			}
		}
		returnObject.add("photos", photosJson);
		
		response.getWriter().println(returnObject.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

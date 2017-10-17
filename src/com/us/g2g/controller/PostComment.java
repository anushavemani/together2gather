package com.us.g2g.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.us.g2g.hbm.Comment;
import com.us.g2g.hbm.CommentHome;
import com.us.g2g.hbm.Event;
import com.us.g2g.hbm.User;

/**
 * Servlet implementation class PostComment
 */
@WebServlet("/PostComment")
public class PostComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostComment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	userid="+user.id+"&eventid="+$scope.event.id+"&text="+$scope.comment
		
		Integer userid = Integer.parseInt(request.getParameter("userid"));
		Integer eventid = Integer.parseInt(request.getParameter("eventid"));
		
		User user = (User) request.getSession().getAttribute("user");
		Event event = new Event();
		event.setId(eventid);
		
		Comment comment = new Comment();
		comment.setText(request.getParameter("text"));
		comment.setUserByPostedBy(user);
		comment.setEvent(event);
		
		CommentHome home = new CommentHome();
		home.persist(comment);
		request.getRequestDispatcher("/GetEventController").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

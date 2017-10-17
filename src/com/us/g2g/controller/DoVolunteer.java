package com.us.g2g.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.us.g2g.hbm.Event;
import com.us.g2g.hbm.Participant;
import com.us.g2g.hbm.ParticipantHome;
import com.us.g2g.hbm.User;

/**
 * Servlet implementation class DoVolunteer
 */
@WebServlet("/DoVolunteer")
public class DoVolunteer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoVolunteer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer userid = Integer.parseInt(request.getParameter("userid"));
		Integer eventid = Integer.parseInt(request.getParameter("eventid"));
		
		User user = new User();
		user.setId(userid);
		
		Event event = new Event();
		event.setId(eventid);
		
		
		Participant participant = new Participant();
		participant.setEvent(event);
		participant.setUser(user);
		ParticipantHome pHome = new ParticipantHome();
		
		if("false".equals(request.getParameter("status"))){
			participant.setDateTime(null);
			List<Participant> participantList =  pHome.findByExample(participant);
			for (Participant tempPart : participantList) {
				if(tempPart.getEvent().getId().equals(eventid) &&
						tempPart.getUser().getId().equals(userid)){
					tempPart.setNote(request.getParameter("note"));
					tempPart.setStatus(request.getParameter("status"));
					pHome.merge(tempPart);
					break;
				}
			}
			
		}else{
			participant.setNote(request.getParameter("note"));
			participant.setStatus(request.getParameter("status"));
			pHome.persist(participant);
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

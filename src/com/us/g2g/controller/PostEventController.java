package com.us.g2g.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.us.g2g.hbm.Event;
import com.us.g2g.hbm.EventHome;
import com.us.g2g.hbm.Photo;
import com.us.g2g.hbm.PhotoHome;
import com.us.g2g.hbm.User;
import com.us.g2g.hbm.UserHome;
import com.us.g2g.util.ConverterUtil;

/**
 * Servlet implementation class PostEventController
 */
@WebServlet("/postEventController")
@MultipartConfig
public class PostEventController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostEventController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		User user = (User) request.getSession().getAttribute("user");
		
		Event event  = new Event();
		event.setUserByCreatedBy(user);
		event.setTitle(request.getParameter("event_title"));
		event.setDescription(request.getParameter("event_description"));
		event.setPocName(request.getParameter("poc_name"));
		event.setPocContact(request.getParameter("poc_contact"));
		event.setLat(Double.parseDouble(request.getParameter("lat")));
		event.setLng(Double.parseDouble(request.getParameter("lng")));
		event.setEstimatedBudget(Integer.parseInt(request.getParameter("estimated_budget")));
		event.setExepectedFund(request.getParameter("expected_fund"));
		if(request.getParameter("status") != null)
			event.setStatus("ACTIVE");
		else
			event.setStatus("INACTIVE");
		
		
		event.setOccuranceDate(request.getParameter("event_date"));
		event.setOccuranceTime(request.getParameter("event_time"));
		String inputId = request.getParameter("id");
		EventHome home = new EventHome();
		if(inputId == null){
			int id =home.persist(event); // insert
			event.setId(id);
		}else{
			event.setId(Integer.parseInt(inputId));
			home.merge(event);// update
		}
		PhotoHome photoHome = new PhotoHome();

		Collection<Part> parts = request.getParts();
		for (Part part : parts) {
			String fname = getFileName(part);
			if(fname != null && !fname.isEmpty()){
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				InputStream is = part.getInputStream();
				int read = 0;
		        final byte[] bytes = new byte[1024];

		        while ((read = is.read(bytes)) != -1) {
		            bos.write(bytes, 0, read);
		        }
		        String b64 = ConverterUtil.imageToString(bos);
		        Photo photo = new Photo();
		        photo.setSource(b64);
		        photo.setEvent(event);
		        photo.setUserByUserId(user);
		        photoHome.persist(photo);
			}
		}
		
		request.getSession().setAttribute("user", (new UserHome()).findById(user.getId()));
		
		response.sendRedirect("index.jsp#near_by");
	}

	private String getFileName(final Part part) {
	    final String partHeader = part.getHeader("content-disposition");
	    for (String content : part.getHeader("content-disposition").split(";")) {
	        if (content.trim().startsWith("filename")) {
	            return content.substring(
	                    content.indexOf('=') + 1).trim().replace("\"", "");
	        }
	    }
	    return null;
	}
}

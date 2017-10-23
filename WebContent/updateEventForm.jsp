<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.Set"%>
<%@page import="com.us.g2g.hbm.Event"%>
<%@page import="com.us.g2g.hbm.Photo"%>
<%@page import="com.us.g2g.hbm.EventHome"%>
<%

Integer eventid = Integer.parseInt(request.getParameter("eventid"));
EventHome ehome = new EventHome();
Event event = ehome.findById(eventid);
Set<Photo> photos = event.getPhotos();

%>

<div class="col-lg-8 col-lg-offset-2">
                 <div class="modal-body">
                     <h2>Post Event</h2>
                     <hr class="star-primary">
                     <form action="postEventController" method="post" enctype="multipart/form-data">
                     	<input type="hidden" name="lat" id="lat" value="<%=event.getLat()%>"/>
                     	<input type="hidden" name="lng" id="lng" value="<%=event.getLng()%>"/>
                     	<input type="hidden" name="id" id="id" value="<%=event.getId()%>"/>
	<div id="contact-form" class="form-container" data-form-container style="color: rgb(46, 125, 50); background: rgb(200, 230, 201);">
	<div class="row">
		<div class="form-title">
			<span> Update Event </span>
		</div>
	</div>
	<div class="input-container">
		<div class="row">
			<span class="req-input invalid" >
				<span class="input-status" data-toggle="tooltip" data-placement="top" title="Event Title"></span>
				<input type="text" 
				data-toggle="tooltip"
				data-placement="right" title="Alphanumerics with minimum 8 characters"
				data-min-length="8" placeholder="Event Title" required value="<%=event.getTitle()%>" name="event_title"/>
			</span>
		</div>
	
		<div class="row">
			<span class="req-input message-box invalid">
				<span class="input-status" data-toggle="tooltip" data-placement="top" title="Event Description"> </span>
				<textarea type="textarea" 
				data-toggle="tooltip"
				data-placement="right" title="Alphanumerics with minimum 10 characters"
				data-min-length="10" name="event_description" required placeholder="Event Description"><%=event.getDescription()%></textarea>
			</span>
		</div>
		<div class="row">
			<span class="req-input invalid" >
				<span class="input-status" data-toggle="tooltip" data-placement="top" title="Point of Contact."> </span>
				<input type="text" 
				data-toggle="tooltip"
				data-placement="right" title="Alphanumerics with minimum 8 characters"
				data-min-length="8" placeholder="POC Name" name="poc_name" required  value="<%=event.getPocName()%>">
			</span>
		</div>
		<div class="row">
			<span class="req-input invalid">
				<span class="input-status" data-toggle="tooltip" data-placement="top" title="POC Phone Number."> </span>
				<input type="tel" 
				data-toggle="tooltip"
				data-placement="right" title="Numerics with minimum 10 characters"
				placeholder="Phone Number" name="poc_contact" required  value="<%=event.getPocContact()%>">
			</span>
		</div>
		
		<div class="row">
			<span class="req-input invalid">
				<span class="input-status" data-toggle="tooltip" data-placement="top" title="Estimated Budget"> </span>
				<input 
				data-toggle="tooltip"
				data-placement="right" title="Numerics with minimum 2 characters"
				type="number" placeholder="Estimated Budget" required name="estimated_budget"  value="<%=event.getEstimatedBudget()%>">
			</span>
		</div>
		
		<div class="row">
			<span class="req-input invalid">
				<span class="input-status" data-toggle="tooltip" data-placement="top" title="Expected Funding."> </span>
				<input type="number"
				data-toggle="tooltip"
				data-placement="right" title="Numerics with minimum 2 characters"
				placeholder="Expected Fund" required name="expected_fund"  value="<%=event.getExepectedFund()%>">
			</span>
		</div>
		<div class="row">
			<input type="checkbox" name="status" <%=(event.getStatus().equals("ACTIVE")?"checked":"") %> /> Active 
		</div>
		
		<div class="input-group registration-date-time">
          		<span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-calendar" aria-hidden="true"></span></span>
          		<input class="form-control" name="event_date" id="event_date" type="date" required value="<%=event.getOccuranceDate()%>">
          		<span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-time" aria-hidden="true"></span></span>
          		<input class="form-control" name="event_time" id="event_time" type="time" required value="<%=event.getOccuranceTime()%>">
          		<span class="input-group-btn">
          	    	<button class="btn btn-default" type="button" onclick="addNow()"><span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span> Now</button>
                  </span>
          	</div>
          	<div class="row">    
	            <input type="file" class="form-control" id="images" name="images[]" onchange="preview_images();" multiple/>
	    </div>
	    <div class="row"  id="existing_images">
	    	<% for(Photo photo : photos){
	    	%>
	    	<div class="col-md-4">
		    	<div class="thumbnail">
			      <a class="close" href="#" onclick="deletePic(<%=event.getId()%>,<%=photo.getId()%>)">?</a>
			      <img src="data:image/jpeg;base64,<%=photo.getSource()%>">
			    </div>
		    </div>
            <%
	    	} %>
	    </div>
	    <div class="row"  id="image_preview">
	    </div>
		<div class="row submit-row">
				<button type="submit" class="btn btn-block submit-form valid">Submit</button>
		</div>
	</div>
	</div>
</form>
                 </div>
             </div>
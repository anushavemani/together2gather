

<%@page import="com.us.g2g.hbm.User"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.Set"%>
<%@page import="com.us.g2g.hbm.Event"%>
<%@page import="com.us.g2g.hbm.Photo"%>
<%@page import="com.us.g2g.hbm.EventHome"%>
<%
User user = (User) session.getAttribute("user");
Integer eventid = Integer.parseInt(request.getParameter("eventid"));
EventHome ehome = new EventHome();
Event event = ehome.findById(eventid);

%>

<div class="col-lg-8 col-lg-offset-2">
                 <div class="modal-body">
                     <h2>Post Event</h2>
                     <hr class="star-primary">
                     <form action="donationController" method="post">
                     	<input type="hidden" name="id" id="id" value="<%=event.getId()%>"/>
	<div id="contact-form" class="form-container" data-form-container style="color: rgb(46, 125, 50); background: rgb(200, 230, 201);">
	<div class="row">
		<div class="form-title">
			<span> Donation for the Event <%=event.getTitle()%></span>
		</div>
	</div>
	<div class="input-container">
		<div class="row">
			<span class="req-input invalid" >
				<span class="input-status" data-toggle="tooltip" data-placement="top" title="Name"> </span>
				<input type="text" data-min-length="8" placeholder="Name" name="donator_name" required  value="<%=user.getName()%>">
			</span>
		</div>
		<div class="row">
			<span class="req-input invalid" >
				<span class="input-status" data-toggle="tooltip" data-placement="top" title="Email"></span>
				<input type="email" data-min-length="8" placeholder="Email" required value="<%=user.getEmail()%>" name="donator_email"/>
			</span>
		</div>
	
		<div class="row">
			<span class="req-input message-box invalid">
				<span class="input-status" data-toggle="tooltip" data-placement="top" title="Note/Suggestions"> </span>
				<textarea type="textarea" data-min-length="10" name="note" required placeholder="Please say something"></textarea>
			</span>
		</div>
		<div class="row">
			<span class="req-input invalid">
				<span class="input-status" data-toggle="tooltip" data-placement="top" title="Mobile Number."> </span>
				<input type="tel" placeholder="Mobile Number" name="mobile_number" required  value="">
			</span>
		</div>
		
		<div class="row">
			<span class="req-input invalid">
				<span class="input-status" data-toggle="tooltip" data-placement="top" title="Donation Amount"> </span>
				<input type="number" placeholder="Donation Amount" required name="donation_amount"  value="" min="9">
			</span>
		</div>
		
		
		<div class="row submit-row">
				<button type="submit" class="btn btn-block submit-form valid">Submit</button>
		</div>
	</div>
	</div>
</form>
                 </div>
             </div>
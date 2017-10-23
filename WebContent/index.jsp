<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" ng-app="myApp">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<meta http-equiv="cache-control" content="max-age=0" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
<meta http-equiv="pragma" content="no-cache" />

<title>Together to Gather -- Joining Hands</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-glyphicons.css" rel="stylesheet">


<!-- Custom CSS -->
<link href="css/full-slider.css" rel="stylesheet">

<!-- Theme CSS -->
<link href="css/freelancer.min.css" rel="stylesheet">
<link href="css/angular-block-ui.css" rel="stylesheet">
<link href="css/post_event.css" rel="stylesheet">
<link href="css/timeline.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
	rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css"
	media="screen">
<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker.css" />
<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker.css.map" />

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<style type="text/css">
.hide-bullets {
	list-style: none;
	margin-left: -40px;
	margin-top: 20px;
}

#map {
	height: 500px;
	margin-top: 40px;
	margin-bottom: 40px;
}

.info-window {
	font-family: 'Montserrat', sans-serif;
}

.info-content {
	color: #999;
}
</style>

</head>

<body id="page-top" class="index" cg-busy="myPromise">
	<div id="skipnav">
		<a href="#maincontent">Skip to main content</a>
	</div>

	<!-- Navigation -->
	<nav id="mainNav"
		class="navbar navbar-default navbar-fixed-top navbar-custom">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header page-scroll">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> Menu <i
						class="fa fa-bars"></i>
				</button>
				<a class="navbar-brand" href="#page-top">Together to Gather</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li class="hidden"><a href="#page-top"></a></li>
					<li class="page-scroll"><a href="#portfolio">Events</a></li>
					<li class="page-scroll"><a href="#near_by">Near By</a></li>
					<li class="page-scroll"><c:if test="${user eq null}">
							<a href="#register_login">Register</a>
						</c:if> <c:if test="${user ne null}">
							<a href="#register_login">${user.name}</a>
						</c:if></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>

	<!-- Header -->
	<header id="myCarousel" class="carousel slide">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
			<li data-target="#myCarousel" data-slide-to="3"></li>
			<li data-target="#myCarousel" data-slide-to="4"></li>
			<li data-target="#myCarousel" data-slide-to="5"></li>
			<li data-target="#myCarousel" data-slide-to="6"></li>
		</ol>

		<!-- Wrapper for Slides -->
		<div class="carousel-inner">
			<div class="item active">
				<!-- Set the first background image using inline CSS below. -->
				<div class="fill" style="background-image: url('img/1.jpg');"></div>
				<div class="carousel-caption">
					<h2>Street Cleaning at Aberdeen,Ohio</h2>
				</div>
			</div>
			<div class="item">
				<!-- Set the second background image using inline CSS below. -->
				<div class="fill" style="background-image: url('img/4.jpg');"></div>
				<div class="carousel-caption">
					<h2>Darke Team will workhard for their environment</h2>
				</div>
			</div>
			<div class="item">
				<!-- Set the second background image using inline CSS below. -->
				<div class="fill" style="background-image: url('img/10.jpg');"></div>
				<div class="carousel-caption">
					<h2>End of Poverty with Education</h2>
				</div>
			</div>
			<div class="item">
				<!-- Set the second background image using inline CSS below. -->
				<div class="fill" style="background-image: url('img/16.jpg');"></div>
				<div class="carousel-caption">
					<h2>Helping hands for Camden people</h2>
				</div>
			</div>
			<div class="item">
				<!-- Set the second background image using inline CSS below. -->
				<div class="fill" style="background-image: url('img/19.jpg');"></div>
				<div class="carousel-caption">
					<h2>Dedicated to Cleaning up the Merrimack River</h2>
				</div>
			</div>
			<div class="item">
				<!-- Set the second background image using inline CSS below. -->
				<div class="fill" style="background-image: url('img/30.jpg');"></div>
				<div class="carousel-caption">
					<h2>We cannot allow America's forests to decline.</h2>
				</div>
			</div>
			<div class="item">
				<!-- Set the second background image using inline CSS below. -->
				<div class="fill" style="background-image: url('img/31.jpg');"></div>
				<div class="carousel-caption">
					<h2>Help us plant roots for tomorrow and donate today.</h2>
				</div>
			</div>

		</div>

		<!-- Controls -->
		<a class="left carousel-control" href="#myCarousel" data-slide="prev">
			<span class="icon-prev"></span>
		</a> <a class="right carousel-control" href="#myCarousel"
			data-slide="next"> <span class="icon-next"></span>
		</a>

	</header>

	<section id="portfolio">
		<div class="container" ng-controller="event1Controller">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2>Events</h2>
					<hr class="star-primary">
				</div>
			</div>
			<div class="row">
				<div class="col-sm-3 portfolio-item" ng-repeat="event in eventsList">
					<a href="" class="portfolio-link" data-toggle="modal"
						ng-click="showSelectedEvent($index)">
						<div class="caption">
							<div class="caption-content">{{event.title}}</div>
						</div> {{event.title}}
						<div ng-if="event.photos.length > 0">
							<img src="data:image/jpeg;base64,{{photo.source}}"
								class="img-responsive" alt="Cabin"
								ng-repeat="photo in event.photos | limitTo: 1">
						</div>
						<div ng-if="event.photos.length == 0">
							<img src="img/portfolio/circus.png" class="img-responsive"
								alt="Cabin">
						</div>
					</a>
				</div>
			</div>
		</div>
	</section>

	<section class="success" id="near_by">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2>Near by</h2>
					<hr class="star-light">
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12" ng-controller="MapCtrl">
					<div id="map"></div>
				</div>
			</div>
		</div>
	</section>

	<!-- About Section 
    <section class="success" id="about">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2>About</h2>
                    <hr class="star-light">
                </div>
            </div>
            <div class="row">
                <div class="col-lg-4 col-lg-offset-2">
                    <p>Freelancer is a free bootstrap theme created by Start Bootstrap. The download includes the complete source files including HTML, CSS, and JavaScript as well as optional LESS stylesheets for easy customization.</p>
                </div>
                <div class="col-lg-4">
                    <p>Whether you're a student looking to showcase your work, a professional looking to attract clients, or a graphic artist looking to share your projects, this template is the perfect starting point!</p>
                </div>
                <div class="col-lg-8 col-lg-offset-2 text-center">
                    <a href="#" class="btn btn-lg btn-outline">
                        <i class="fa fa-download"></i> Download Theme
                    </a>
                </div>
            </div>
        </div>
    </section> -->

	<!-- Contact Section -->
	<section id="register_login">
		<div class="container" id="userData">
			<c:if test="${user eq null}">
				<div class="row">
					<div class="col-lg-12 text-center">
						<h2>Register Here</h2>
						<hr class="star-primary">
					</div>
				</div>
				<div class="row">
					<div class="col-lg-4 col-lg-offset-2" ng-controller="regCtrl">
						<!-- To configure the contact form email address, go to mail/contact_me.php and update the email address in the PHP file on line 19. -->
						<!-- The form should work on most web servers, but if the form is not working you may need to configure your web server differently. -->
						<form name="regForm" id="registerationForm" novalidate
							ng-submit="register()">
							<div class="row control-group">
								<div
									class="form-group col-xs-12 floating-label-form-group controls">
									<label for="name">Name</label> <input type="text"
										class="form-control" placeholder="Name" id="name" name="name"
										required
										data-validation-required-message="Please enter your name.">
									<p class="help-block text-danger"></p>
								</div>
							</div>
							<div class="row control-group">
								<div
									class="form-group col-xs-12 floating-label-form-group controls">
									<label for="short_name">Screen Name</label> <input type="text"
										class="form-control" placeholder="Short Name" id="short_name"
										name="short_name" required
										data-validation-required-message="Please enter your short name.">
									<p class="help-block text-danger"></p>
								</div>
							</div>
							<div class="row control-group">
								<div
									class="form-group col-xs-12 floating-label-form-group controls">
									<label for="email">Email Address</label> <input type="email"
										class="form-control" placeholder="Email Address" id="email"
										name="reg_email" required
										data-validation-required-message="Please enter your email address.">
									<p class="help-block text-danger"></p>
								</div>
							</div>
							<div class="row control-group">
								<div
									class="form-group col-xs-12 floating-label-form-group controls">
									<label for="regpwd">Password</label> <input type="password"
										class="form-control" placeholder="Password" id="regpwd"
										name="password" required
										data-validation-required-message="Please enter your password.">
									<p class="help-block text-danger"></p>
								</div>
							</div>
							<div class="row control-group">
								<div
									class="form-group col-xs-12 floating-label-form-group controls">
									<label for="regpwd1">Confirm Password</label> <input
										type="password" class="form-control" placeholder="Password"
										id="regpwd1" name="passwordagain" required
										data-validation-matches-match="password"
										data-validation-matches-message="Must match email address entered above"
										data-validation-required-message="Please enter your password.">
									<p class="help-block text-danger"></p>
								</div>
							</div>
							<br>
							<div id="reg_msg"></div>
							<div class="row">
								<div class="form-group col-xs-12">
									<button type="submit" class="btn btn-success btn-lg">Register</button>
								</div>
							</div>
						</form>
					</div>
					<div class="col-lg-4 col-lg-offset-2">
						<br>
						<br>
						<div class="col-lg-4 text-center">
							<h3>Login</h3>
						</div>

						<form name="loginForm" id="loginForm" novalidate
							ng-controller="loginCtrl">
							<div class="row control-group">
								<div
									class="form-group col-xs-12 floating-label-form-group controls">
									<label for="email">Email Address</label> <input type="email"
										class="form-control" placeholder="Email Address"
										ng-model="login_email" name="login_email" id="email" required
										data-validation-required-message="Please enter your email address.">
									<p class="help-block text-danger"></p>
								</div>
							</div>
							<div class="row control-group">
								<div
									class="form-group col-xs-12 floating-label-form-group controls">
									<label for="pword">Password</label> <input type="password"
										class="form-control" placeholder="Password"
										ng-model="login_pwd" name="login_pwd" id="pword" required
										data-validation-required-message="Please enter your password.">
									<p class="help-block text-danger"></p>
								</div>
							</div>
							<br>
							<div id="login_msg"></div>
							<div class="row">
								<div class="form-group col-xs-12">
									<button type="submit" ng-click="checkLogin()"
										class="btn btn-success btn-lg">Login</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</c:if>
			<c:if test="${user ne null}">
				<jsp:include page="userData.jsp" />
			</c:if>
		</div>
	</section>

	<!-- Footer -->
	<footer class="text-center">
		<div class="footer-above">
			<div class="container">
				<div class="row">
					<div class="footer-col col-md-4">
						<h3>Location</h3>
						<p>
							University of Central Missouri,<br>
							1101 NW Innovation Parkway, Lee's Summit, <br>
							MO 64086, USA
						</p>
					</div>
					<div class="footer-col col-md-4">
						<h3>Around the Web</h3>
						<ul class="list-inline">
							<li><a href="#" class="btn-social btn-outline"><span
									class="sr-only">Facebook</span><i class="fa fa-fw fa-facebook"></i></a>
							</li>
							<li><a href="#" class="btn-social btn-outline"><span
									class="sr-only">Google Plus</span><i
									class="fa fa-fw fa-google-plus"></i></a></li>
							<li><a href="#" class="btn-social btn-outline"><span
									class="sr-only">Twitter</span><i class="fa fa-fw fa-twitter"></i></a>
							</li>
							<li><a href="#" class="btn-social btn-outline"><span
									class="sr-only">Linked In</span><i class="fa fa-fw fa-linkedin"></i></a>
							</li>
							<li><a href="#" class="btn-social btn-outline"><span
									class="sr-only">Dribble</span><i class="fa fa-fw fa-dribbble"></i></a>
							</li>
						</ul>
					</div>
					<div class="footer-col col-md-4">
						<h3>About Moto</h3>
						<p>
							This is platform will give a chance to such person to raise his voice to call for help by posting activity with all the details, intentions, location of the activity. So, that any person who was willing to help in Social activity can volunteer such activities posted in this application.
						</p>
					</div>
				</div>
			</div>
		</div>
		<div class="footer-below">
			<div class="container">
				<div class="row">
					<div class="col-lg-12">Version: 1 Build:15</div>
				</div>
			</div>
		</div>
	</footer>

	<!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
	<div
		class="scroll-top page-scroll hidden-sm hidden-xs hidden-lg hidden-md">
		<a class="btn btn-primary" href="#page-top"> <i
			class="fa fa-chevron-up"></i>
		</a>
	</div>

	<!-- Portfolio Modals -->
	<div class="portfolio-modal modal fade" id="viewEventModalWindow1"
		tabindex="-1" role="dialog" aria-hidden="true"
		ng-controller="event1Controller">
		<div class="modal-content" id="viewEventModal1">
			<div class="close-modal" data-dismiss="modal">
				<div class="lr">
					<div class="rl"></div>
				</div>
			</div>
			<div class="container">
				<div class="row">
					<div class="col-lg-8 col-lg-offset-2">
						<div class="modal-body">
							<h2>{{event.title}}</h2>
							<hr class="star-primary">

							<!-- <img src="img/portfolio/cabin.png" class="img-responsive img-centered" alt=""> -->
							<p>{{event.description}}</p>
							<ul class="list-inline item-details">
								<li>Estimated Budget: <strong>{{event.estimatedBudget}}</strong>
								</li>
								<li>Expected Budget: <strong>{{event.exepectedFund}}</strong>
								</li>
								<li>Received Budget: <strong>{{event.receivedFund}}</strong>
								</li>
								<li>Date and Time: <strong>{{event.occuranceDate}} {{event.occuranceTime}}</strong>
								</li>
								<li>Contact Person: <strong>{{event.pocName}}</strong>
								</li>
								<li>Contact No: <strong>{{event.pocContact}}</strong>
								</li>
								<li>Status: <span ng-switch on="event.status"> <span
										class="label label-success" ng-switch-when="ACTIVE">{{event.status}}</span>
										<span class="label label-danger" ng-switch-when="INACTIVE">{{event.status}}</span>
								</span>
								<span class="label label-success" ng-show="event.approvedOn != undefined" >APPROVED</span>
								<span class="label label-warning" ng-show="event.approvedOn == undefined" >Pending for Approval</span>
								</li>
							</ul>
							<div ng-repeat="photo in event.photos">
								<img class="thumbnail fancybox"
									src="data:image/jpeg;base64,{{photo.source}}" width="400">
							</div>
							<div ng-if="isOwn()">
								<button type="button" class="btn btn-default"
									ng-click="editEvent()" data-dismiss="modal">
									<i class="fa fa-pencil"></i> Edit
								</button>
							</div>
							<div ng-if="!isOwn()">
								<button type="button" class="btn btn-default"
									ng-click="donateEvent()" data-dismiss="modal">
									<i class="fa fa-times"></i> Donate
								</button>
								<button type="button" class="btn btn-default"
									data-dismiss="modal" ng-click="volunteer(false)" ng-show="isVolunteered()">
									<i class="fa fa-times"></i> De-Volunteer
								</button>
								<button type="button" class="btn btn-default"
									data-dismiss="modal" ng-click="volunteer(true)" ng-show="!isVolunteered()">
									<i class="fa fa-times"></i> Volunteer
								</button>

							</div>
							<div class="chat-panel panel panel-default">
								<div class="panel-heading">
									<i class="fa fa-comments fa-fw"></i> Comments
								</div>
								<!-- /.panel-heading -->
								<div class="panel-body">
									<ul class="chat" type="none">
										<li class="left clearfix" ng-repeat="comment in event.comments | orderBy: '-dateTime'"
											style="border-bottom: dotted 1px black;">
											<div class="chat-body clearfix">
												<div class="primary-font" style="text-align:left">
													<strong>{{comment.commentedBy}}:</strong>{{comment.text}}
												</div>
												<div class="footer">
													<strong class="primary-font"></strong> <small
														class="pull-right text-muted"> <i
														class="fa fa-clock-o fa-fw"></i> {{comment.dateTime | date:'MM/dd/yyyy @ h:mma' }}
													</small>
												</div>
											</div>
										</li>
									</ul>
								</div>
								<!-- /.panel-body -->
								<div class="panel-footer">
									<div class="input-group">
										<input id="btn-input" type="text" ng-model="comment"
											class="form-control input-sm"
											placeholder="Type your message here..." /> <span
											class="input-group-btn">
											<button class="btn btn-warning btn-sm" id="btn-chat"
												ng-click="postComment()">Send</button>
										</span>
									</div>
								</div>
								<!-- /.panel-footer -->
							</div>
							<div class="panel panel-info" ng-show="isOwn()">
								<div class="panel-heading">
									Donations Received
								</div>
								<div class="panel-body">
									<table class="table table-hover table-striped table-bordered table-sm">
										<thead>
											<tr>
												<th>S.No</th>
												<th>Donator Name</th>
												<th>Amount</th>
												<th>Note</th>
												<th>Paid On</th>
												<th>Ref. No</th>
											</tr>
										</thead>
										<tbody>
											<tr ng-repeat="payment in event.payments">
												<td>{{$index + 1}}</td>
												<td>{{payment.paidBy}}</td>
												<td>$ {{payment.amount}}</td>
												<td>{{payment.note}}</td>
												<td>{{payment.paidOn | date:'MM/dd/yyyy @ h:mma'}}</td>
												<td>{{payment.gatewayId}}</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
							<div class="panel panel-info" ng-show="isOwn()">
								<div class="panel-heading">
									Volunteers List
								</div>
								<div class="panel-body">
									<table class="table table-hover table-striped table-bordered table-sm">
										<thead>
											<tr>
												<th>S.No</th>
												<th>Volunteer Name</th>
												<th>Status</th>
												<th>Note</th>
												<th>Date and Time</th>
											</tr>
										</thead>
										<tbody>
											<tr ng-repeat="participant in event.participants">
												<td>{{$index + 1}}</td>
												<td>{{participant.name}}</td>
												<td>{{(participant.status=='true')?"Volunteered":"De-Volunteered"}}</td>
												<td>{{participant.note}}</td>
												<td>{{participant.dateTime  | date:'MM/dd/yyyy @ h:mma'}}</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="portfolio-modal modal fade" id="updateEventModal"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-content">
			<div class="close-modal" data-dismiss="modal">
				<div class="lr">
					<div class="rl"></div>
				</div>
			</div>
			<div class="container">
				<div class="row" id="eventDataRow">
					<div class="col-lg-8 col-lg-offset-2">
						<div class="modal-body">
							<h2>Project Title</h2>
							<hr class="star-primary">
							<img src="img/portfolio/cake.png"
								class="img-responsive img-centered" alt="">
							<p>
								Use this area of the page to describe your project. The icon
								above is part of a free icon set by <a
									href="https://sellfy.com/p/8Q9P/jV3VZ/">Flat Icons</a>. On
								their website, you can download their free set with 16 icons, or
								you can purchase the entire set with 146 icons for only $12!
							</p>
							<ul class="list-inline item-details">
								<li>Client: <strong><a
										href="http://startbootstrap.com">Start Bootstrap</a> </strong>
								</li>
								<li>Date: <strong><a
										href="http://startbootstrap.com">April 2014</a> </strong>
								</li>
								<li>Service: <strong><a
										href="http://startbootstrap.com">Web Development</a> </strong>
								</li>
							</ul>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">
								<i class="fa fa-times"></i> Close
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="portfolio-modal modal fade" id="timelineModal"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-content">
			<div class="close-modal" data-dismiss="modal">
				<div class="lr">
					<div class="rl"></div>
				</div>
			</div>
			<div class="container">
				<div class="row">
					<div class="col-lg-8 col-lg-offset-2">
						<div class="modal-body">
							<h2>Timeline</h2>
							<hr class="star-primary">
							<ul class="timeline">
					        <li ng-repeat="action in userActions" ng-class-even="'timeline-inverted'">
					          <div class="timeline-badge"><i class="glyphicon glyphicon-check"></i></div>
					          <div class="timeline-panel">
					            <div class="timeline-heading">
					              <h4 class="timeline-title">{{action.action}}</h4>
					              <p><small class="text-muted"><i class="glyphicon glyphicon-time"></i> {{action.actionDateTime}}</small></p>
					            </div>
					            <div class="timeline-body">
					              <p ng-if="action.action == 'Added a photo: '">
					              <img src= "data:image/jpeg;base64,{{action.description}}" width="100">
					              </p>
					              <p ng-if="action.action == 'Approved photo '">
					              <img src= "data:image/jpeg;base64,{{action.description}}" width="100">
					              </p>
					              <p ng-if="action.action != 'Added a photo: ' && action.action != 'Approved photo '">{{action.description}}</p>
					            </div>
					          </div>
					        </li>
					        </ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="portfolio-modal modal fade" id="paymentModal"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-content">
			<div class="close-modal" data-dismiss="modal">
				<div class="lr">
					<div class="rl"></div>
				</div>
			</div>
			<div class="container">
				<div class="row">
					<div class="col-lg-8 col-lg-offset-2">
						<div class="modal-body">
							<h2>Donation Details</h2>
							<hr class="star-primary">
							<table class="table table-hover table-striped">
							<thead>
								<tr>
									<th>S.No</th>
									<th>Event Title</th>
									<th>Amount</th>
									<th>Note</th>
									<th>Status</th>
									<th>Paid On</th>
									<th>Ref. No</th>
								</tr>
							</thead>
							<tbody>
								<tr ng-repeat="payment in userPayments">
									<td>{{$index + 1}}</td>
									<td>{{payment.eventTitle}}</td>
									<td>$ {{payment.amount}}</td>
									<td>{{payment.note}}</td>
									<td>
									<span class="label label-danger" ng-show="payment.status == 'FAILED'">{{payment.status}}</span>
									<span class="label label-warning" ng-show="payment.status == 'PENDING'">{{payment.status}}</span>
									<span class="label label-success" ng-show="payment.status == 'SUCCESS'">{{payment.status}}</span>
									</td>
									<td>{{payment.paidOn}}</td>
									<td>{{payment.gatewayId}}</td>
								</tr>
							</tbody>
						</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="portfolio-modal modal fade" id="portfolioModal5"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-content">
			<div class="close-modal" data-dismiss="modal">
				<div class="lr">
					<div class="rl"></div>
				</div>
			</div>
			<div class="container">
				<div class="row">
					<div class="col-lg-8 col-lg-offset-2">
						<div class="modal-body">
							<h2>Project Title</h2>
							<hr class="star-primary">
							<img src="img/portfolio/safe.png"
								class="img-responsive img-centered" alt="">
							<p>
								Use this area of the page to describe your project. The icon
								above is part of a free icon set by <a
									href="https://sellfy.com/p/8Q9P/jV3VZ/">Flat Icons</a>. On
								their website, you can download their free set with 16 icons, or
								you can purchase the entire set with 146 icons for only $12!
							</p>
							<ul class="list-inline item-details">
								<li>Client: <strong><a
										href="http://startbootstrap.com">Start Bootstrap</a> </strong>
								</li>
								<li>Date: <strong><a
										href="http://startbootstrap.com">April 2014</a> </strong>
								</li>
								<li>Service: <strong><a
										href="http://startbootstrap.com">Web Development</a> </strong>
								</li>
							</ul>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">
								<i class="fa fa-times"></i> Close
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="portfolio-modal modal fade" id="post_event_modal"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-content">
			<div class="close-modal" data-dismiss="modal">
				<div class="lr">
					<div class="rl"></div>
				</div>
			</div>
			<div class="container">
				<div class="row">
					<div class="col-lg-8 col-lg-offset-2">
						<div class="modal-body">
							<h2>Post Event</h2>
							<hr class="star-primary">
							<form action="postEventController" method="post"
								enctype="multipart/form-data">
								<input type="hidden" name="lat" id="lat" /> <input type="hidden"
									name="lng" id="lng" />
								<div id="contact-form" class="form-container"
									data-form-container
									style="color: rgb(46, 125, 50); background: rgb(200, 230, 201);">
									<div class="row">
										<div class="form-title">
											<span> Create Event </span>
										</div>
									</div>
									<div class="input-container">
										<div class="row">
											<span class="req-input invalid"> <span
												class="input-status" data-toggle="tooltip"
												data-placement="top" title="Event Title"> </span> 
												<input data-toggle="tooltip"
												data-placement="right" title="Alphanumerics with minimum 8 characters"
												type="text" data-min-length="8" placeholder="Event Title"
												name="event_title" />
											</span>
										</div>

										<div class="row">
											<span class="req-input message-box invalid"> <span
												class="input-status" data-toggle="tooltip"
												data-placement="top" title="Event Description"> </span> 
											<textarea
												data-toggle="tooltip"
												data-placement="right" title="Alphanumerics with minimum 10 characters"
													type="textarea" data-min-length="10"
													name="event_description" placeholder="Event Description"></textarea>
											</span>
										</div>
										<div class="row">
											<span class="req-input invalid"> <span
												class="input-status" data-toggle="tooltip"
												data-placement="top" title="Point of Contact."> </span> 
											<input
											data-toggle="tooltip"
												data-placement="right" title="Alphanumerics with minimum 8 characters"
												type="text" data-min-length="8" placeholder="POC Name"
												name="poc_name">
											</span>
										</div>
										<div class="row">
											<span class="req-input invalid"> <span
												class="input-status" data-toggle="tooltip"
												data-placement="top" title="POC Phone Number."> </span> 
												<input
												data-toggle="tooltip"
												data-placement="right" title="Numerics with minimum 10 characters"
												type="tel" placeholder="Phone Number" name="poc_contact">
											</span>
										</div>


										<div class="row">
											<span class="req-input invalid"> <span
												class="input-status" data-toggle="tooltip"
												data-placement="top" title="Estimated Fund"> </span> 
												<input
												data-toggle="tooltip"
												data-placement="right" title="Numerics with minimum 2 characters"
												type="number" placeholder="Estimated Fund" required
												name="estimated_budget">
											</span>
										</div>

										<div class="row">
											<span class="req-input invalid"> <span
												class="input-status" data-toggle="tooltip"
												data-placement="top" title="Expected Funding."> </span> 
											<input
												data-toggle="tooltip"
												data-placement="right" title="Numerics with minimum 2 characters"
												type="number" placeholder="Expected Fund" required
												name="expected_fund">
											</span>
										</div>
										<div class="row">
											<input type="checkbox" name="status" checked> Active 
										</div>

										<div class="input-group registration-date-time">
											<span class="input-group-addon" id="basic-addon1"><span
												class="glyphicon glyphicon-calendar" aria-hidden="true"></span></span>
											<input class="form-control" name="event_date" id="event_date"
												type="date" required> <span
												class="input-group-addon" id="basic-addon1"><span
												class="glyphicon glyphicon-time" aria-hidden="true"></span></span>
											<input class="form-control" name="event_time" id="event_time"
												type="time" required> <span class="input-group-btn">
												<button class="btn btn-default" type="button"
													onclick="addNow()">
													<span class="glyphicon glyphicon-map-marker"
														aria-hidden="true"></span> Now
												</button>
											</span>
										</div>
										<div class="row">
											<input type="file" class="form-control" id="images"
												name="images[]" onchange="preview_images();" multiple />
										</div>
										<div class="row" id="image_preview"></div>
										<div class="row submit-row">
											<c:if test="${user ne null}">
												<button type="submit"
													class="btn btn-block submit-form valid">Submit</button>
											</c:if>
											<c:if test="${user eq null}">
												<button type="button" class="btn btn-block btn-danger"
													onclick="loginRegister()">Login/Register to post
													event</button>
											</c:if>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="portfolio-modal modal fade" id="donationFormModal"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-content">
			<div class="close-modal" data-dismiss="modal">
				<div class="lr">
					<div class="rl"></div>
				</div>
			</div>
			<div class="container">
				<div class="row" id="donationFormRow">
					
				</div>
			</div>
		</div>
	</div>
	<!-- jQuery -->
	<script src="js/jquery.js"></script>
	<script src="js/jquery.blockUI.js"></script>
	<script src="js/moment.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>
	<script src="js/bootbox.min.js"></script>
	<!-- Plugin JavaScript -->
	<script src="js/jquery.easing.1.3.js"></script>
	<script src="http://momentjs.com/downloads/moment-with-locales.js"></script>
	<script	src="http://momentjs.com/downloads/moment-timezone-with-data.js"></script>
	<script src="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.js"></script>

	<!-- Contact Form JavaScript -->
	<script src="js/jqBootstrapValidation.js"></script>

	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBSHYDResaTjvCjvPIwN8q4w_IM4jdYyEg"></script>
	<script src="js/gmaps.js"></script>
	<!-- Theme JavaScript -->
	<script src="js/freelancer.min.js"></script>
	<script src="js/angular.js"></script>
	<script src="js/angular-cookies.js"></script>
	<script src="js/angular-block-ui.js"></script>
	<script src="js/ng_code.js"></script>
	<script src="js/post_event.js"></script>
	<script	src="//cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.js"></script>



	<script>
 	
 	
 	    function deletePic(eventId,picId){
 	    	bootbox.confirm({
 			    title: "Are you sure..?",
 			    message: "Are you sure you want to delete the pic, because it will be deleted immediately and cannot be reverted.",
 			    buttons: {
 			        cancel: {
 			            label: '<i class="fa fa-times"></i> Cancel'
 			        },
 			        confirm: {
 			            label: '<i class="fa fa-check"></i> Proceed'
 			        }
 			    },
 			   callback: function (result) {
 			   	if(result){
 			   	   $("#updateEventModal").modal('toggle');
	 			   	$.blockUI({
	 			        message: null
	 			    });
 			   		$.post("DeletePhoto",{pic_id:picId},function(data){
 			   			loadUpdateForm(eventId);
 			   		}); 			   		
 			   	}
 			   }
 		   });
 			   
 	    }
	    $('.carousel').carousel({
	        interval: 5000 //changes the speed
	    });
	    
	    $(function () { 
	    	$("#registerationForm input,#loginForm input").not("[type=submit]").jqBootstrapValidation(); 
	    
	    	$('#event_date').datepicker({
	    	    format: 'mm/dd/yyyy',
	    	    startDate: '+1d'
	    	});
	    } );
	    
	    /* function showPic(eventid,id){
	    alert(eventid+" "+id);
	       $('#eventCarousel'+eventid).carousel(id);
	    } */
	   
	    function showPostEvent(lat,lng){
	    	$("#post_event_modal").modal();
	    	$("#lat").val(lat);
	    	$("#lng").val(lng);
	    	addNow();
	    }
	    
	    function addNow() {
	    	  nowDate = moment().format('MM/DD/YYYY');
	    	  nowTime = moment().format('HH:mm');
	    	  $('#event_date').val(nowDate);
	    	  $('#event_time').val(nowTime);
	    	  
	    	}
	    
	    function viewSelectedEvent(eventid) {
	    	$("#viewEventModalWindow1").modal();
	        var scope = angular.element($("#viewEventModal1")).scope();
	        scope.$apply(function () {
	        	scope.updateSelectedEvent(eventid);
	        });
	    }
	    function viewSelectedEvent2(eventid) {
	    	$("#viewEventModalWindow2").modal();
	        var scope = angular.element($("#viewEventModal2")).scope();
	        scope.$apply(function () {
	        	scope.updateSelectedEvent(eventid);
	        });
	    }
    </script>

</body>

</html>

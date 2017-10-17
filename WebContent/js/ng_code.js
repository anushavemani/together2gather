/**
 * 
 */
var app = angular.module('myApp', ['blockUI','ngCookies']);

app.controller('logoutCtrl', function($scope, $location,$cookies,$rootScope,$http) {
		$rootScope.userActions = [];
		$scope.logout = function(){
			
			$cookies.remove('isLogged');
			window.location.href = ("Logout");
		}
		$scope.timeline = function(){
			
			$http({
				method: "GET",
				url : "TimelineController"
			}).then(function(response){
				$rootScope.userActions = response.data;
				$("#timelineModal").modal();
			});
			
		}
		$scope.showPayments= function(){
			$http({
				method: "GET",
				url : "UserPaymentsData"
			}).then(function(response){
				$rootScope.userPayments = response.data;
				$("#paymentModal").modal();
			});
		}
});

app.controller('event1Controller', ['$scope', '$cookies','$http', '$rootScope','blockUI','UserService',eventController]);
app.controller('event2Controller', ['$scope', '$cookies', '$http', '$rootScope','blockUI','UserService',eventController]);

function eventController($scope, $cookies,$http, $rootScope,blockUI,UserService){
	
	$scope.event = {};
	$scope.comment = "";
	$scope.eIndex = 0;
	
	$scope.updateSelectedEvent = function(eventIndex){
		$scope.eIndex = eventIndex;
		$scope.event = $rootScope.eventsList[eventIndex];
	}
	$scope.showSelectedEvent = function(eventIndex){
		$scope.eIndex = eventIndex;
		$("#viewEventModalWindow2").modal();
		$scope.event = $rootScope.eventsList[eventIndex];
	}
	$scope.editEvent = function(){
		loadUpdateForm($scope.event.id);
	}
	$scope.donateEvent = function(){
		donationForm($scope.event.id);
	}
	$scope.showPic = function (eventid,id){
	    $('#eventCarousel'+eventid).carousel(id);
	}
	$scope.isOwn = function(){
		if($cookies.get('isLogged')){
   		 	var user = $cookies.getObject("user");
			return user.ownEvents.indexOf($scope.event.id) >= 0;
		}
		return false;
	}
	$scope.isVolunteered = function(){
		if($cookies.get('isLogged')){
			var user = $cookies.getObject("user");
			return user.volunteered.indexOf($scope.event.id) >= 0;
		}
		return false;
	}
	$scope.postComment = function(){
		var user = $cookies.getObject('user');
		 $http({
				method: 'GET',
				url: "PostComment?userid="+user.id+"&eventid="+$scope.event.id+"&text="+$scope.comment
		 }).then(function(response){
			 $rootScope.eventsList = response.data.events;
			 $scope.event = $rootScope.eventsList[$scope.eIndex];
		 });
	}
	$scope.volunteer = function(status){
		var user = $cookies.getObject('user');
		var message = (status)?"Thank you Volunteering in this event. <br> Please provide us suggestions/notes for us.":"Let us know the reason:"
		bootbox.prompt({
		    title: message,
		    inputType: 'textarea',
		    callback: function (result) {
		    	if(result != null){
			    	$http({
						method: 'GET',
						url: "DoVolunteer?userid="+user.id+"&eventid="+$scope.event.id+"&status="+status+"&note="+result
					}).then(function(response){
						window.location.reload();
					});
		    	}
		    }
		});
	}
	
	
}

function loadUpdateForm(eventid){
	$.blockUI({
        message: null
    });
	$("#eventDataRow").load("updateEventForm.jsp",{eventid:eventid},function(data){
		$.unblockUI();
		//$("#eventDataRow").html(data);
		 // DOM: Create the script element
	    var jsElm = document.createElement("script");
	    // set the type attribute
	    jsElm.type = "application/javascript";
	    // make the script element load file
	    jsElm.src = "js/post_event.js";
	    // finally insert the element to the body element in order to load the script
	    document.body.appendChild(jsElm);
		$("#updateEventModal").modal();
		$('#event_date').datepicker({
    	    format: 'mm/dd/yyyy',
    	    startDate: '+1d'
    	});
	});
}
function donationForm(eventid){
	$.blockUI({
		message: null
	});
	$("#donationFormRow").load("donationForm.jsp",{eventid:eventid},function(data){
		$.unblockUI();
		//$("#eventDataRow").html(data);
		// DOM: Create the script element
		var jsElm = document.createElement("script");
		// set the type attribute
		jsElm.type = "application/javascript";
		// make the script element load file
		jsElm.src = "js/post_event.js";
		// finally insert the element to the body element in order to load the script
		document.body.appendChild(jsElm);
		$("#donationFormModal").modal();
		
	});
}

app.controller('loginCtrl', function($scope, $http,$cookies, $rootScope) {
	
	$scope.checkLogin = function(){
		 $scope.myPromise=$http({
			method: 'GET',
			url: "LoginController?login_email="+$scope.login_email+"&login_pwd="+$scope.login_pwd			
		}).then(function(response){
			$cookies.put('isLogged', true);
			$cookies.putObject('user', response.data);
			window.location.reload();
		}, function myError(error,status) {
			 $('#login_msg').html("<div class='alert alert-danger'>");
             $('#login_msg > .alert-danger').html("<button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;")
                 .append("</button>");
             $('#login_msg > .alert-danger').append("<strong>Login Error..</strong>");
             $('#login_msg > .alert-danger').append('</div>');
	    });
	}
	
});

app.controller('regCtrl', function($scope, $http,$cookies,$rootScope) {
	$rootScope.user = {};
	$scope.register = function(){
		if(!$("#registerationForm input").jqBootstrapValidation("hasErrors")){
			$scope.myPromise=$http({
				method: 'GET',
				url: "RegisterController?"+$("#registerationForm").serialize()
			}).then(function(response){
				$cookies.put('isLogged', true);
				$cookies.putObject('user', response.data);
				window.location.reload();
			}, function myError(response) {
				 $('#reg_msg').html("<div class='alert alert-danger'>");
	             $('#reg_msg > .alert-danger').html("<button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;")
	                 .append("</button>");
	             $('#reg_msg > .alert-danger').append("<strong>Email Already Exists..</strong>");
	             $('#reg_msg > .alert-danger').append('</div>');
		    });
		}
	}
});



app.controller('MapCtrl', function($scope,$http,$cookies,$compile, $rootScope,UserService) {
	$rootScope.eventsList = {};
	var currentMarker;
    var map = new GMaps({
        el: '#map',
        lat: 39.109734,
        lng: -94.540992,
        rightclick:function(e){
        	map.removeMarker(currentMarker);
            currentMarker = map.addMarker({
              lat: e.latLng.lat(),
              lng: e.latLng.lng()
            });
           
         }
    });
	 map.setContextMenu({
	        control: 'map',
	        options: [{
	          title: 'Post Event',
	          name: 'post_event',
	          action: function(e){
	            showPostEvent(e.latLng.lat(),e.latLng.lng());
	            this.hideContextMenu();
	          }
	        }]
	    });
     GMaps.geolocate({
	    	  success: function(position) {
	    		  currentPosition(position.coords.latitude, position.coords.longitude);
//	    		  currentPosition(39.109734, -94.540992);
	    	 },
	    	 error:function(error){
	    		 currentPosition(39.109734, -94.540992);	    		 
	    	 }
	  });
     
     
     function currentPosition(latitude, longitude){
		    var icon = {
						    url: "img/67172-200.png", // url
						    scaledSize: new google.maps.Size(35, 35), // scaled size
				  };
				  map.setCenter(latitude,longitude);
				  map.addMarker({
			    	  lat: latitude,
			    	  lng: longitude,
			    	  icon: icon
			    });
				  map.drawCircle({
			      lat: latitude,
			      lng: longitude,
			      radius: 200,
			     // origin: new google.maps.Point(0, 0),
			     // anchor:new google.maps.Point(20,0),
		   	  strokeColor: '#BBD8E9',
		   	  strokeOpacity: 1,
		   	  strokeWeight: 3,
		   	  fillColor: '#18BC9C',
		   	  fillOpacity: 0.3
		   	});
		    $scope.loadEvents();
		    UserService.getUserData();
     }
     
     function updateMarkers(){
	     angular.forEach($rootScope.eventsList, function(value, index) {
	    	 var iconPath = "img/red_flag.png";
	    	 iconPath = (value.status == "ACTIVE")?iconPath:"img/grey_flag.png";
	    	 if($cookies.get("isLogged")){
	    		 var user = $cookies.getObject("user");
	    		 iconPath = (user.ownEvents.indexOf(value.id) >= 0)?"img/user-flag.png":iconPath;
	    		 iconPath = (user.ownEvents.indexOf(value.id) >= 0 && value.approvedOn == undefined)?"img/orange_flag.png":iconPath;
	    		 iconPath = (user.volunteered.indexOf(value.id) >= 0)?"img/green_flag.png":iconPath;
	    	 }
	     	  var icon = {
	   				    url: iconPath, // url
	   				    scaledSize: new google.maps.Size(35, 35), // scaled size
	   		 };
	     	 if(value.approvedOn != undefined || iconPath=="img/orange_flag.png"){
	     	 map.addMarker({
	   	    	  lat: value.lat,
	   	    	  lng: value.lng,
	   	    	  icon: icon,
	   	    	  title: value.title,
		   	      infoWindow: {
		   	        content:  '		<div class="col-md-12">                                                                              '+
						   	  '			<div class="panel panel-primary">                                                               '+
						   	  '				<div class="panel-heading">                                                                 '+
						   	  '					<h3 class="panel-title">'+value.title+'</h3>                                            '+
						   	  '				</div>                                                                                      '+
						   	  '				<div class="panel-body" style="color:#337AB7">'+value.description+'</div>'+
						   	  (($cookies.get('isLogged'))?
						   	  ('				<div class="panel-footer" >'+
						   			  '<div class="btn-group"><button type="button" class="btn btn-info btn-xs" onClick="viewSelectedEvent('+index+')" >View</button>'+
						   			  '</div> '):
						   	  ('				<div class="panel-footer""><button class="btn btn-danger btn-xs">Login</button></div> '))+
						   	  '			</div>'+
						   	  '</div>'
		   	      }
	   	    });
	     	}
	      });
     }
     $scope.loadEvents = function(){
	     $http({
				method: 'GET',
				url: "GetEventController"	
		 }).then(function(response){
			 $rootScope.eventsList = response.data.events;
			 updateMarkers();
		 });
     }
});

app.factory('UserService', function($http,$cookies){
	
	var service = {};

    service.getUserData = getUserData;

	return service;
	function getUserData(){
		var user = $cookies.getObject("user");
		$http({
			method:"GET",
			url:"UserController?id="+user.id
		}).then(function(response){
				 $cookies.putObject("user",response.data);
		});
	}
});
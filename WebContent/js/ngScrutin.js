/**
 * 
 */

var app = angular.module('scrutinApp', ['blockUI','ngCookies','ngRoute']);

app.config(function($routeProvider){
	
	$routeProvider
	.when("/",{
		templateUrl : "pendingEvents.html"
	})
	.when("/pe",{
		templateUrl : "pendingEvents.html"
	})
	.when("/pc",{
		templateUrl : "pendingComents.html"
	})
	.when("/pp",{
		templateUrl : "pendingPhotos.html"
	});	
});


app.controller("PendingController",function($cookies,$http,$scope,$rootScope){
	
	$rootScope.user = $cookies.getObject("user"); 
	
	$scope.events = {};
	$scope.comments = {};
	$scope.photos = {};
	
	loadData();
	
	function loadData(){
		$http({
			method: "GET",
			url: "PendingData"
		}).then(function(response){
			$scope.events = response.data.events;
			$scope.comments = response.data.comments;
			$scope.photos = response.data.photos;
		});
	}
	
	$scope.approveEvent = function(id){
		
		$http({
			method: "GET",
			url: "ApproveEvent?id="+id
		}).then(function(response){
			loadData();
		});
	}
	$scope.approveComment = function(id){
		
		$http({
			method: "GET",
			url: "ApproveComment?id="+id
		}).then(function(response){
			loadData();
		});
	}
	$scope.approvePhoto = function(id){
		
		$http({
			method: "GET",
			url: "ApprovePhoto?id="+id
		}).then(function(response){
			loadData();
		});
	}
	
});
'use strict';
var letzChaat=angular.module("Collaboration",["ngRoute"]);
letzChaat.config(function($routeProvider) {
	$routeProvider
	.when("/",
	{
		templateUrl:"main.html",
		controller:'mainController'
	})
	.when("/main",
	{
		templateUrl:"main.html",
		controller:'mainController'
	})
	.when("/login",
	{
		templateUrl:"login.html",
		controller:'loginController'
	})
	.when("/register",
	{
		templateUrl:"register.html",
		controller:'registerController'
	})
	.when("/about",
	{
		templateUrl:"about.html",
		controller:'aboutController'
	})
	.when("/404",
	{
		templateUrl:"404.html",
		
	})
	.when("/portfolio",
	{
		templateUrl:"portfolio.html",
		
	})
	.when("/pricing",
	{
		templateUrl:"pricing.html",
		
	})
	.when("/shortcodes",
	{
		templateUrl:"shortcodes.html",
		
	})
	.when("/portfolio",
	{
		templateUrl:"portfolio.html",
		
	})
	.when("/event",
	{
		templateUrl:"event.html",
		controller:'eventController'
	})
	.when("/addEvent",
	{
		templateUrl:"event.html",
		controller:'eventController'
	})
	.when("/blog",
	{
		templateUrl:"blog.html",
		controller:'blogController'
	})
	.when("/blog-item",
	{
		templateUrl:"blog-item.html",
		controller:'blogController'
	})
	.when("/contact",
	{
		templateUrl:"contact.html",
		
	})
	.when("/services",
	{
		templateUrl:"services.html",
		controller:'servicesController'
	}).
	when("/logout",
			{
				templateUrl:"logout.html",
				controller:'logoutController'
			})
	.when("/userHome",
	{
		templateUrl:"userHome.html",
		controller:'userHomeController'
	})
	.when("/jobs",
	{
		templateUrl:"jobs.html",
		controller:'jobsController'
	})
	.when("/admin",
	{
		templateUrl:"admin.html",
		controller:'adminController'
	})
	.when("/adminBlog",
	{
		templateUrl:"adminBlog.html",
		controller:'adminBlogController'
	})
	.when("/adminJobs",
	{
		templateUrl:"adminJobs.html",
		controller:'adminJobsController'
	})
	.when("/forum",
	{
		templateUrl:"forum.html",
		controller:'forumController'
	})
});
letzChaat.controller('mainController',function($scope)		
		{
			$scope.message="you are in main page";
			$scope.isBlog=true;	
		}
		);
letzChaat.controller('logoutController',function($scope,$rootScope)		
		{
	
			console.log("logout controller called");
	
			
			$rootScope.login=true;
			$rootScope.register=true;
			$rootScope.services=true;
			$rootScope.about=true;
			$rootScope.home=true;
			$rootScope.blog=false;
			$rootScope.forum=false;
			$rootScope.jobs=false;
			$rootScope.logout=false;
			$rootScope.chat=false;
			$rootScope.adminBlog=false;
			$rootScope.users=false;
			
		}
		);
letzChaat.controller('loginController',['$scope','$http','$location','$rootScope',function($scope,$http,$location,$rootScope)		
		{
             console.log(" login controller");
			 $scope.login=function()
			 {
				  var loginData={
						  username:$scope.username,	
							password:$scope.password,  
				  }
 $http.post('http://localhost:8086/Collaboration/authenticate',loginData).then(function (response) {
	 console.log("result   data:"+response.data);
	 var r=response.data.toString();
	 console.log("response:"+r);
     
		if(r==1)
			{
			$rootScope.blog=true;
			$rootScope.forum=true;
			$rootScope.jobs=true;
			$rootScope.login=false;
			$rootScope.register=false;
			$rootScope.services=false;
			$rootScope.about=false;
			$rootScope.home=false;
			$rootScope.logout=true;
			$rootScope.chat=true;
			console.log('logout:'+$rootScope.logout);
			console.log("wat is this ya:"+response.data);
			$scope.message="Welcome user";
			$location.path('/userHome');
			}
		if(r==0)
			{
			$scope.username="";
			$scope.password="";
			$scope.message="username/password incorrect";
			$location.path('/login');
			}
		if(r==2)
		{
			$rootScope.login=false;
			$rootScope.register=false;
			$rootScope.services=false;
			$rootScope.about=false;
			$rootScope.home=false;
			$rootScope.adminBlog=true;
			$rootScope.users=true;
			$rootScope.registeredUsers=true;
			$rootScope.logout=true;
			$scope.message="Welcome admin";
	$location.path('/admin');
		}
		
 });  
			 }
		}]
		);
letzChaat.controller('registerController',function($scope,$http)		
		{
			$scope.register=function()
			{
				console.log("username:"+$scope.username);
				var userData={
					userFullName:$scope.userFullName,
					username:$scope.username,
					userEmail:$scope.userEmail,
					userPhone:$scope.userPhone,
					password:$scope.password,
					role:$scope.role
				}
				 var res = $http.post('http://localhost:8086/Collaboration/addUser',userData);
			 		res.success(function(data, status, headers, config) {
			 			console.log("status:"+status);
			 			$scope.message="you are successfully registered!!!";
			 			
			 			$scope.userFullName="";
						$scope.username="";
						$scope.userEmail="";
						$scope.userPhone="";
						$scope.password="";
						$scope.role="";
			 			
			 		});
				
			}
		}
		);


letzChaat.controller("adminJobsController",function($scope,$http,$rootScope)
{
	 $rootScope.login=false;
		$rootScope.register=false;
		$rootScope.services=false;
		$rootScope.about=false;
		$rootScope.home=false;
		$rootScope.adminBlog=true;
		$rootScope.users=true;
		$rootScope.registeredUsers=true;
		$rootScope.logout=true;
		$rootScope.adminJobs=true;
		
		
	  console.log("you are in adminjobs");
	  console.log("inside job controller");
	    $http.get("http://localhost:8086/Collaboration/viewAllJobs")
	    .then(function (response) {$scope.jobs = response.data;});
	   
});


letzChaat.controller("adminBlogController",function($scope,$http,$rootScope)	
		{	
	$rootScope.login=false;
	$rootScope.register=false;
	$rootScope.services=false;
	$rootScope.about=false;
	$rootScope.home=false;
	$rootScope.adminBlog=true;
	$rootScope.users=true;
	$rootScope.registeredUsers=true;
	$rootScope.logout=true;
	$rootScope.adminJobs=true;
	
	$rootScope.addEvent=true;
	
	
	
	console.log("i am in adminblog controller");
	console.log("after this");
			 $http.get("http://localhost:8086/Collaboration/viewBlogs")
			    .then(function (response) {
			    	
			    	$scope.blogs = response.data;
			    	
			    	console.log("data:"+response.data);
			    });
			$scope.newBlog={};
			console.log("In Controller");
			$scope.addBlog=function(newBlog)
			{
				var dataObj = {
						blogId:$scope.blogId,
						title:$scope.title,
						usersID:$scope.usersID,
						dateOfCreation:$scope.dateOfCreation,
						content:$scope.content,
						category:$scope.category
		 		};
				console.log("title:"+dataObj);
				 var res = $http.post('http://localhost:8086/Collaboration/addBlog',dataObj);
				 $http.get("http://localhost:8086/Collaboration/viewBlogs")
			 	    .then(function (response) {$scope.blogs = response.data;});
			 		res.success(function(data, status, headers, config) {
			 			$scope.message = data;
			 			console.log("status:"+status);
			 		});
			 		 
			};
			$scope.editBlog=function(blog)
			{
				console.log("inside editblog");
				console.log("blog:"+blog);
				$scope.blogDataToEdit=blog;
			}
			$scope.saveEdit=function()
			{
				var dataObj = {
						
						blogId:$scope.blogDataToEdit.blogId,
						title:$scope.blogDataToEdit.title,
						usersID:$scope.blogDataToEdit.usersID,
						dateOfCreation:$scope.blogDataToEdit.dateOfCreation,
						content:$scope.blogDataToEdit.content,
						category:$scope.blogDataToEdit.category
		 				
		 		};
				$http.put('http://localhost:8086/Collaboration/updateBlog', dataObj);
				$http.get("http://localhost:8086/Collaboration/viewBlogs")
		 	    .then(function (response) {$scope.blogs = response.data;});
			}
			$scope.deleteBlog=function(blogDataToEdit)
			{
				console.log("delete blog called");
				title:$scope.blogDataToEdit.title;
				console.log("title:"+blogDataToEdit.title);
				blogId:$scope.blogDataToEdit.blogId;
				console.log("blogId:"+blogDataToEdit.blogId);
				$http['delete']('http://localhost:8086/Collaboration/deleteBlog/'+blogDataToEdit.blogId);
				 $http.get("http://localhost:8086/Collaboration/viewBlogs")
			 	    .then(function (response) {$scope.blogs = response.data;});
			}
			
		}

		);

letzChaat.controller('aboutController',function($scope)		
		{
			$scope.message="you are in about page";
		}
		);
letzChaat.controller('servicesController',function($scope)		
		{
			$scope.message="you are in services page";
		}
		);



letzChaat.controller("blogController",function($scope,$http,$rootScope)	
		{	
	
	console.log("i am in blogController");
	console.log("after this");
			 $http.get("http://localhost:8086/Collaboration/viewBlogs")
			    .then(function (response) {
			    	
			    	$scope.blogs = response.data;
			    	
			    	console.log("data:"+response.data);
			    });
			$scope.newBlog={};
			console.log("In Controller");
			$scope.addBlog=function(newBlog)
			{
				var dataObj = {
						blogId:$scope.blogId,
						title:$scope.title,
						usersID:$scope.usersID,
						dateOfCreation:$scope.dateOfCreation,
						content:$scope.content,
						category:$scope.category
		 		};
				console.log("title:"+dataObj);
				 var res = $http.post('http://localhost:8086/Collaboration/addBlog',dataObj);
				 $http.get("http://localhost:8086/Collaboration/viewBlogs")
			 	    .then(function (response) {$scope.blogs = response.data;});
			 		res.success(function(data, status, headers, config) {
			 			$scope.message = data;
			 			console.log("status:"+status);
			 		});
			 		 
			};
			$scope.editBlog=function(blog)
			{
				console.log("inside editblog");
				console.log("blog:"+blog);
				$scope.blogDataToEdit=blog;
			}
			$scope.saveEdit=function()
			{
				var dataObj = {
						
						blogId:$scope.blogDataToEdit.blogId,
						title:$scope.blogDataToEdit.title,
						usersID:$scope.blogDataToEdit.usersID,
						dateOfCreation:$scope.blogDataToEdit.dateOfCreation,
						content:$scope.blogDataToEdit.content,
						category:$scope.blogDataToEdit.category
		 				
		 		};
				$http.put('http://localhost:8086/Collaboration/updateBlog', dataObj);
				$http.get("http://localhost:8086/Collaboration/viewBlogs")
		 	    .then(function (response) {$scope.blogs = response.data;});
			}
			$scope.deleteBlog=function(blogDataToEdit)
			{
				console.log("delete user blog called");
				blogId:$scope.blogDataToEdit.blogId;
				console.log("blogId:"+blogDataToEdit.blogId);
				$http['delete']('http://localhost:8086/Collaboration/deleteBlog/'+blogDataToEdit.blogId);
				 $http.get("http://localhost:8086/Collaboration/viewBlogs")
			 	    .then(function (response) {$scope.blogs = response.data;});
			}
			
		}

		);

letzChaat.controller("eventController",function($scope,$http,$rootScope)	
		{	
	
	console.log("i am in eventController");
	console.log("after this");
			 $http.get("http://localhost:8086/Collaboration/viewEvents")
			    .then(function (response) {
			    	
			    	$scope.events = response.data;
			    	
			    	console.log("data:"+response.data);
			    });
			$scope.newEvent={};
			console.log("In eventController............");
			$scope.addEvent=function(newEvent)
			{
				var dataObj = {
						eventId:$scope.eventId,
						title:$scope.title,
						description:$scope.description,						
						usersID:$scope.usersID,						
						eventDate:$scope.eventDate,	
						venue:$scope.venue
		 		};
				console.log("title:"+dataObj);
				 var res = $http.post('http://localhost:8086/Collaboration/addEvent',dataObj);
				 $http.get("http://localhost:8086/Collaboration/viewEvents")
			 	    .then(function (response) {$scope.events = response.data;});
			 		res.success(function(data, status, headers, config) {
			 			$scope.message = data;
			 			console.log("status:"+status);
			 		});
			 		 
			};
			$scope.editEvent=function(event)
			{
				console.log("inside editEvent");
				//console.log("event:"+event);
				$scope.eventDataToEdit=event;
			}
			$scope.saveEdit=function()
			{
				var dataObj = {
						eventId:$scope.eventDataToEdit.eventId,
						title:$scope.eventDataToEdit.title,
						description:$scope.eventDataToEdit.description,						
						usersID:$scope.eventDataToEdit.usersID,						
						eventDate:$scope.eventDataToEdit.eventDate,	
						venue:$scope.eventDataToEdit.venue
		 		};
				$http.put('http://localhost:8086/Collaboration/updateEvent', dataObj);
				$http.get("http://localhost:8086/Collaboration/viewEvents")
		 	    .then(function (response) {$scope.events = response.data;});
			}
			$scope.deleteevent=function(eventDataToEdit)
			{
				console.log("delete user event called");
				eventId:$scope.eventDataToEdit.eventId;
				console.log("eventId:"+eventDataToEdit.eventId);
				$http['delete']('http://localhost:8086/Collaboration/deleteEvent/'+eventDataToEdit.eventId);
				 $http.get("http://localhost:8086/Collaboration/viewEvents")
			 	    .then(function (response) {$scope.events = response.data;});
			}
			
		}

		);









letzChaat.controller('aboutController',function($scope)		
		{
			$scope.message="you are in about page";
		}
		);
letzChaat.controller('servicesController',function($scope)		
		{
			$scope.message="you are in services page";
		}
		);







letzChaat.controller('forumController',function($scope)		
		{
			$scope.message="you are in forum page";
		}
		);
letzChaat.controller('userHomeController',function($scope)		
		{
			$scope.message="you are in userhome page";
		}
		);

letzChaat.controller('adminController',function($scope)		
		{
			
			$scope.message="you are in admin controller";
		}
		);


letzChaat.controller('jobsController',function($scope,$http)		
		{
	console.log("inside job controller");
    $http.get("http://localhost:8086/Collaboration/viewAllJobs")
    .then(function (response) {$scope.jobs = response.data;});
    
    $scope.applyJob=function()
    {
    	 console.log("applyJob function called");
    	 var jobData={
           jobId:$scope.jobId,
    	 registrationNumber:$scope.registrationNumber,
    	 studentId:$scope.studentId,
    	 certificateNumber:$scope.certificateNumber	
    	 };
    	 $http.post('http://localhost:8086/Collaboration/registerJob',jobData);
    }
		}
       
		);

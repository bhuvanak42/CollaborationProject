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
	.when("/friends",
	{
		templateUrl:"friend.html",
		controller:'friendController'
	})
	.when("/myFriends",
	{
		templateUrl:"MyFriends.html",
		controller:'MyFriendsController'
	})
	.when("/friendsRequests",
	{
		templateUrl:"friendRequest.html",
		controller:'friendRequestController'
	})
	.when("/event",
	{
		templateUrl:"event.html",
		controller:'eventController'
	})
	.when("/adminEvent",
	{
		templateUrl:"adminEvent.html",
		controller:'adminEventController'
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
		controller:'contactController'
		
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
		controller:'adminjobsController'
	})
	.when("/forum",
	{
		templateUrl:"forum.html",
		controller:'forumController'
	})
	.when("/forumAnswers",
	{
		templateUrl:"forumAnswer.html",
		/*controller:'forumAnswersController'*/
	})
});
letzChaat.controller('mainController',function($scope)		
		{
			$scope.message="you are in main page";
			$scope.isBlog=true;	
		}
		);
letzChaat.controller('logoutController',function($scope,$rootScope,$http)		
		{
	
			console.log("logout controller called");
	
			$http.get('http://localhost:8086/Collaboration/logout');
			
			$scope.message="You are successfully logged out...........";
			
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
			$rootScope.event=false;
			$rootScope.friends=false;
			
				
				
				
			
			
			
			
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
			$rootScope.event=true;
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
			/*console.log("wat is this ya:"+response.data);*/
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


/*letzChaat.controller("adminJobsController",function($scope,$http,$rootScope)
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
	   
});*/


letzChaat.controller("adminBlogController",function($scope,$http,$rootScope)	
		{	
	$rootScope.login=false;
	$rootScope.register=false;
	$rootScope.services=false;
	$rootScope.about=false;
	$rootScope.home=false;
	$rootScope.adminBlog=true;
	$rootScope.adminEvent=true;
	$rootScope.users=true;
	$rootScope.registeredUsers=true;
	$rootScope.logout=true;
	$rootScope.adminJobs=true;
	$rootScope.adminForum=true;
	$rootScope.friends=true;
	
	
	console.log("i am in adminblog controller");
	console.log("after this");
			 $http.get("http://localhost:8086/Collaboration/viewBlogs")
			    .then(function (response) {
			    	
			    	$scope.blogs = response.data;
			    	
			    	console.log("xxxx:"+$scope.blogs[1].blogCreationDate);
			    });
			$scope.newBlog={};
			console.log("In Controller");
			$scope.addBlog=function(newBlog)
			{
				var dataObj = {
						blogId:$scope.blogId,
						title:$scope.title,
						usersID:$scope.usersID,
						/*dateOfCreation:$scope.dateOfCreation,*/
						
						content:$scope.content,
						category:$scope.category
						
		 		};
				console.log("title:"+dataObj.dateOfCreation);
				
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
						/*dateOfCreation:$scope.blogDataToEdit.dateOfCreation,*/
						blogCreationDate:$scope.blogCreationDate,
						content:$scope.blogDataToEdit.content,
						category:$scope.blogDataToEdit.category
		 				
		 		};
				
			/*	dataObj=JSON.parse(dataObj);*/
				/*dataObj.dateOfCreation = angular.fromJson(dataObj.dateOfCreation);*/
				
				
				
			/*	dataObj.dateOfCreation = JSON.stringify(dataObj.dateOfCreation);*/
				
				
				
				console.log("date :  "+dataObj.dateOfCreation);
				
				
				
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
			
			$scope.approveBlog=function(i)
			{
				var dataObj = {
						
						blogId:$scope.blogDataToEdit.blogId,
						title:$scope.blogDataToEdit.title,
						usersID:$scope.blogDataToEdit.usersID,
						/*dateOfCreation:$scope.blogDataToEdit.dateOfCreation,*/
						blogCreationDate:$scope.blogDataToEdit.blogCreationDate,
						content:$scope.blogDataToEdit.content,
						category:$scope.blogDataToEdit.category
		 				
		 		};
				$http.put('http://localhost:8086/Collaboration/approveBlog/'+i,dataObj);
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
	$rootScope.event=true;
	$rootScope.blog=true;
	$rootScope.forum=true;
	$rootScope.jobs=true;
	$rootScope.logout=true;
	$rootScope.contact=true;
	
	
	$rootScope.login=false;
	$rootScope.event=true;
	$rootScope.register=false;
	$rootScope.adminJobs=false;
	$rootScope.adminForum=false;
	$rootScope.adminEvent=false;
	$rootScope.adminBlog=false;
	
	console.log("i am in blogController");
	console.log("after this");
			 $http.get("http://localhost:8086/Collaboration/viewBlogs")
			    .then(function (response) {
			    	
			    	$scope.blogs = response.data;
			    	
			    	console.log("date of blog "+$scope.blogs[2].dateOfCreation);
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
						/*dateOfCreation:$scope.dateOfCreation,*/
						content:$scope.content,
						category:$scope.category
		 		};
				
				/*dataObj=JSON.parse(dataObj);*/
				
				/*dataObj.dateOfCreation = angular.fromJson(dataObj.dateOfCreation);
				
				console.log("date :  "+dataObj.dateOfCreation);*/
				
				
				
				var res = $http.post('http://localhost:8086/Collaboration/addBlog',dataObj);
				 $http.get("http://localhost:8086/Collaboration/viewBlogs")
			 	    .then(function (response) {$scope.blogs = response.data;});
			 		res.success(function(data, status, headers, config) {
			 			$scope.message = data;
			 			console.log("status:"+status);
			 		});
			 		 
			};
			$scope.newBlogComment={};
			$scope.addBlogComment = function(newBlogComment)
			{
				var dataObj = {
						blogID:$scope.newBlogComment.blogID,
						blogComment:$scope.newBlogComment.blogComment
		 		};
				
				
				console.log("blog Id is "+ dataObj.blogID);
				console.log("blog Comment is "+ dataObj.blogComment);
				
				var res = $http.post('http://localhost:8086/Collaboration/addBlogComment',dataObj);
				$scope.newBlogComment.blogID="";
				$scope.newBlogComment.blogComment="";
					
				 /*$http.get("http://localhost:8086/Collaboration/viewBlogComments")
			 	    .then(function (response) {$scope.blogcomments = response.data;});
			 		res.success(function(data, status, headers, config) {
			 			$scope.message = data;
			 			console.log("status:"+status);
			 		});*/
			 		 
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
						/*dateOfCreation:$scope.blogDataToEdit.dateOfCreation,*/
						blogCreationDate:$scope.blogCreationDate,
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
letzChaat.controller("adminEventController",function($scope,$http,$rootScope,$filter)	
		{	
	$rootScope.login=false;
	$rootScope.register=false;
	$rootScope.services=false;
	$rootScope.about=false;
	$rootScope.home=false;
	
	
	$rootScope.users=true;
	$rootScope.registeredUsers=true;
	$rootScope.logout=true;
	$rootScope.adminJobs=true;
	$rootScope.adminBlog=true;
	$rootScope.adminForum=true;
	$rootScope.adminEvent=true;
	
	
	
	console.log("i am in admin event controller");
	console.log("after this");
			 $http.get("http://localhost:8086/Collaboration/viewEvents")
			    .then(function (response) {
			    	
			    	$scope.events = response.data;
			    	/*console.log("Date of event is "+$scope.events[2].eventDate);*/
			    	console.log("data:"+response.data);
			    });
			$scope.newEvent={};
			console.log("In admin  eve  Controller");
			$scope.addEvent=function(newEvent)
			{
				var dataObj = {
						
						eventId:$scope.eventId,
						title:$scope.title,
						description:$scope.description,						
						usersID:$scope.usersID,						
						eventDate:$scope.eventDate,	
						dateOfEvent:$scope.dateOfEvent,	
						venue:$scope.venue
		 			};
				
				
				dataObj.dateOfEvent = $filter('date')(dataObj.dateOfEvent, "medium");
				//dataObj.dateOfEvent = Date.parse(dataObj.dateOfEvent);
				console.log("date is "+dataObj.dateOfEvent);
				
				
				
				
				
				/*dataObj.dateOfInterview = new Date(dataObj.dateOfInterview).getTime();*/
				/*dataObj.dateOfInterview = $filter('date')(dataObj.dateOfInterview,'medium')*/
				
				
				
				
				
				
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
				console.log("inside admin editevent");
				console.log("event:"+event);
				$scope.eventDataToEdit=event;
			}
			$scope.saveEdit=function()
			{
				var dataObj = {
						
						eventId:$scope.eventDataToEdit.eventId,
						title:$scope.eventDataToEdit.title,
						description:$scope.eventDataToEdit.description,						
						usersID:$scope.eventDataToEdit.usersID,						
					/*	eventDate:$scope.eventDataToEdit.eventDate,	*/
						dateOfEvent:$scope.eventDataToEdit.dateOfEvent,	
						venue:$scope.eventDataToEdit.venue
		 				
		 		};
				
				dataObj.dateOfEvent = $filter('date')(dataObj.dateOfEvent, "medium");
				//dataObj.eventDate = Date.parse(dataObj.eventDate);
				console.log("date is "+dataObj.dateOfEvent);
				
				
				$http.put('http://localhost:8086/Collaboration/updateEvent', dataObj);
				$http.get("http://localhost:8086/Collaboration/viewEvents")
		 	    .then(function (response) {$scope.events = response.data;});
			}
			$scope.deleteEvent=function(eventDataToEdit)
			{
				console.log("delete event inside admin called");
				title:$scope.eventDataToEdit.title;
				console.log("title:"+eventDataToEdit.title);
				eventId:$scope.eventDataToEdit.eventId;
				console.log("eventId:"+eventDataToEdit.eventId);
				$http['delete']('http://localhost:8086/Collaboration/deleteEvent/'+eventDataToEdit.eventId);
				 $http.get("http://localhost:8086/Collaboration/viewEvents")
			 	    .then(function (response) {$scope.events = response.data;});
			}
			
		}

		);

letzChaat.controller("eventController",function($scope,$http,$rootScope)	
		{	
	$rootScope.event=true;
	$rootScope.blog=true;
	$rootScope.forum=true;
	$rootScope.jobs=true;
	$rootScope.logout=true;
	$rootScope.contact=true;
	
	
	$rootScope.login=false;
	$rootScope.event=true;
	$rootScope.register=false;
	$rootScope.adminJobs=false;
	$rootScope.adminForum=false;
	$rootScope.adminEvent=false;
	$rootScope.adminBlog=false;
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
						//eventDate:$scope.eventDate,	
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
					//	eventDate:$scope.eventDataToEdit.eventDate,	
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







/*letzChaat.controller('forumController',function($scope)		
		{
			$scope.message="you are in forum page";
		}
		);*/
letzChaat.controller('userHomeController',function($scope,$rootScope)		
		{
	
	$rootScope.jobs=true;
	$rootScope.event=true;
	$rootScope.blog=true;
	$rootScope.forum=true;
	$rootScope.logout=true;
	$rootScope.contact=true;
		
	$rootScope.adminJobs=false;
	$rootScope.adminEvent=false;
	$rootScope.adminBlog=false;
	$rootScope.register=false;
	$rootScope.login=false;

	
	
			/*adminForum=true;forum=true;blogitem=true;contact=true;adminEvent=false;
			event=false;shortcodes=true;pricing=true;portfolio=true;blog=false;users=false;
			adminJobs=false;adminBlog=false;jobs=false;
			login=true;register=true;about=true;services=true;home=true;logout=false;chat=false;
			*/
			$scope.message="you are in userhome page";
		}
		);

letzChaat.controller('adminController',function($scope,$rootScope)		
		{
	$rootScope.event=false;
			$scope.message="you are in admin page";
			
			
			console.log("admin Controller  called");
		
			
			$rootScope.adminJobs=true;
			$rootScope.adminEvent=true;
			$rootScope.adminBlog=true;
			$rootScope.adminForum=true;
			$rootScope.logout=true;
			
			
			
			$rootScope.login=false;
			$rootScope.register=false;
			
			
			$rootScope.services=true;
			$rootScope.about=true;
			$rootScope.home=true;
			
			$rootScope.adminForum=false;
		
			
			
			
			
			
		}
		);


letzChaat.controller('jobsController',function($scope,$http,$rootScope)		
		{
	$rootScope.login=false;
	$rootScope.register=false;
	$rootScope.services=true;
	$rootScope.about=true;
	$rootScope.home=true;
	
	$rootScope.adminForum=false;
	$rootScope.adminJobs=false;
	$rootScope.adminBlog=false;
	$rootScope.adminEvent=false;
	$rootScope.logout=true;
	
	$rootScope.jobs=true;
	$rootScope.blog=true;
	$rootScope.forum=true;
	$rootScope.event=true;
	
	
	console.log("inside job controller");
    $http.get("http://localhost:8086/Collaboration/viewAllJobs")
    .then(function (response) {$scope.jobs = response.data;});
    $http.get("http://localhost:8086/Collaboration/jobsApplied")
    .then(function (response) {$scope.jobsApplied = response.data;});
    //console.log("data is "+$scope.jobsApplied);
    
    console.log("inside student  Jobs  Applied ");
    
  
    
   /* angular.forEach($scope.jobsApplied, function(value, key){
        if(value.jobId == "390")
           console.log("username is thomas");
     });*/
    
    
    
    
    
    
    
	/*$scope.studentJobsApplied = [];
	var k = -1;
	
	for(var i=0;i<$scope.jobs1.length;i++){
		console.log(i+"    i val   ");
	for(var j=0;j<$scope.jobsApplied.length;j++)
	{
		console.log(j+"   ");
		if($scope.jobsApplied[j].jobId==$scope.jobs1[i].jobId){
				++k;
				$scope.studentJobsApplied[k] = $scope.jobsApplied[j]; 
		}
	}
	}
	
	console.log("$scope.studentJobsApplied");
	for(i=0;i<$scope.studentJobsApplied.length;i++){
		
		console.log($scope.studentJobsApplied[i]);
	}*/
    
    
    
    
    
    
    
    
    
    
    
    
    
	
	
    $scope.newJob={};
	
	
	$scope.editJob=function(resource)
	{
		console.log("inside editJob");
		//console.log("job:"+job);
		$scope.jobDataToEdit=resource;
	}
	
    $scope.applyJob=function()
    {
    	 console.log("applyJob function called");
    	 var jobData={
           jobId:$scope.jobDataToEdit.jobId,
    	 registrationNumber:$scope.registrationNumber,
    	/* studentId:$scope.studentId,*/
    	 certificateNumber:$scope.certificateNumber	
    	 };
    	 	$http.post('http://localhost:8086/Collaboration/registerJob',jobData).then(function (response) {
		 console.log("result   data:"+response.data);
		 var r=response.data.toString();
		 console.log("response:"+r);
	     
			if(r==1)
				{
				 console.log("job applied successfully");
				/* $scope.apply="true";
				 jobId:$scope.jobDataToEdit.jobId;*/
				 $scope.message="Successfully applied for the job with id "+$scope.jobDataToEdit.jobId;
				 
				}
			 $http.get("http://localhost:8086/Collaboration/viewAllJobs")
			    .then(function (response) {$scope.jobs = response.data;});
			    $http.get("http://localhost:8086/Collaboration/jobsApplied")
			    .then(function (response) { $scope.jobsApplied = response.data;});
			    
  		});
   
    }
		});


letzChaat.controller('adminjobsController',function($scope,$http,$rootScope,$filter)		
		{
					$rootScope.login=false;
					$rootScope.register=false;
					$rootScope.services=false;
					$rootScope.about=false;
					$rootScope.home=false;
					$rootScope.adminBlog=true;
					$rootScope.adminEvent=true;
					$rootScope.users=true;
					$rootScope.registeredUsers=true;
					$rootScope.logout=true;
					$rootScope.adminForum=true;
					$rootScope.adminJobs=true;
	
	
	console.log("inside adminjobsController");
    $http.get("http://localhost:8086/Collaboration/viewAllJobs")
    .then(function (response) {$scope.jobs = response.data;});
   
    
    $scope.newJob={};
	
	$scope.addJob=function(newJob)
	{	console.log("In add admin jobsController............");
		var dataObj = {
				
				company:$scope.company,
				aboutCompany:$scope.aboutCompany,				
				role:$scope.role,						
				skillsRequired:$scope.skillsRequired,
				eligibilityCriteria:$scope.eligibilityCriteria,
				ctc:$scope.ctc,						
				/*dateOfInterview:$scope.dateOfInterview,	*/
				
				interviewDate:$scope.interviewDate,
				
				addressOfTheCompany:$scope.addressOfTheCompany,	
				urlOfTheCompany:$scope.urlOfTheCompany
 		};
		
		
		/*dataObj.dateOfInterview = $filter('date')(dataObj.dateOfInterview, "yyyy-MM-dd HH:mm:ss");*/
		/*dataObj.dateOfInterview = Date.parse(dataObj.dateOfInterview);*/
		/*dataObj.dateOfInterview = new Date(dataObj.dateOfInterview).getTime();*/
		/*dataObj.dateOfInterview = $filter('date')(dataObj.dateOfInterview,'medium')*/
		
		
		
		//console.log("date is "+dataObj.dateOfInterview);
		
		
		
		dataObj.interviewDate = $filter('date')(dataObj.interviewDate, "medium");
		
		console.log("title:"+dataObj);
		 var res = $http.post('http://localhost:8086/Collaboration/addJob',dataObj); 				
		 $http.get("http://localhost:8086/Collaboration/viewAllJobs")
	 	    .then(function (response) {$scope.jobs = response.data;});
	 		res.success(function(data, status, headers, config) {
	 			$scope.message = data;
	 			console.log("status:"+status);
	 		});
	 		$scope.company="",
			$scope.aboutCompany="",				
			$scope.role="",						
			$scope.skillsRequired="",
			$scope.eligibilityCriteria="",
			$scope.ctc="",		
			//$scope.dateOfInterview="";	
			$scope.addressOfTheCompany="";	
			$scope.urlOfTheCompany="";	 		 
	}
	$scope.editJob=function(resource)
	{
		console.log("inside editJob");
		//console.log("job:"+job);
		$scope.jobDataToEdit=resource;
	}
	$scope.saveEdit=function()
	{
		var dataObj = {
				
				jobId:$scope.jobDataToEdit.jobId,
				company:$scope.jobDataToEdit.company,
				aboutCompany:$scope.jobDataToEdit.aboutCompany,						
				role:$scope.jobDataToEdit.role,						
				skillsRequired:$scope.jobDataToEdit.skillsRequired,
				eligibilityCriteria:$scope.jobDataToEdit.eligibilityCriteria,
				ctc:$scope.jobDataToEdit.ctc,						
				/*dateOfInterview:$scope.jobDataToEdit.dateOfInterview,*/
				interviewDate:$scope.jobDataToEdit.interviewDate,
				addressOfTheCompany:$scope.jobDataToEdit.addressOfTheCompany,	
				urlOfTheCompany:$scope.jobDataToEdit.urlOfTheCompany
		
 		};
		
		
		
		dataObj.interviewDate = $filter('date')(dataObj.interviewDate, "medium");
		console.log("interview date is "+dataObj.interviewDate);
		$http.put('http://localhost:8086/Collaboration/updateJob', dataObj);
		$http.get("http://localhost:8086/Collaboration/viewAllJobs")
 	    .then(function (response) {$scope.jobs = response.data;});
	}
	$scope.deleteJob=function(jobDataToEdit)
	{
		console.log("delete user job called");
		jobId:$scope.jobDataToEdit.jobId;
		console.log("jobId:"+jobDataToEdit.jobId);
		$http['delete']('http://localhost:8086/Collaboration/deleteJob/'+jobDataToEdit.jobId);
		 $http.get("http://localhost:8086/Collaboration/viewAllJobs")
	 	    .then(function (response) {$scope.jobs = response.data;});
	}
    
    
    $scope.applyJob=function()
    {
    	 console.log("applyJob function called");
    	 var jobData={
           jobId:$scope.jobDataToEdit.jobId,
    	 registrationNumber:$scope.registrationNumber,
    	/* studentId:$scope.studentId,*/
    	 certificateNumber:$scope.certificateNumber	
    	 };
    	 	$http.post('http://localhost:8086/Collaboration/registerJob',jobData).then(function (response) {
		 console.log("result   data:"+response.data);
		 var r=response.data.toString();
		 console.log("response:"+r);
	     
			if(r==1)
				{
				 console.log("job applied successfully");
				/* $scope.apply="true";
				 jobId:$scope.jobId;*/
				 $scope.message="Successfully applied for the job with id "+$scope.jobId;
				}
  		});
   
    }
		});


letzChaat.controller("forumController",function($scope,$http,$rootScope)	
		{	
	$rootScope.login=false;
	$rootScope.register=false;
	$rootScope.services=true;
	$rootScope.about=true;
	$rootScope.home=true;
	
	$rootScope.adminForum=false;
	$rootScope.adminJobs=false;
	$rootScope.adminBlog=false;
	$rootScope.adminEvent=false;
	$rootScope.logout=true;
	
	$rootScope.jobs=true;
	$rootScope.blog=true;
	$rootScope.forum=true;
	$rootScope.event=true;
	
	
	
	
	console.log("i am in forum controller");
	console.log("after this");
			 $http.get("http://localhost:8086/Collaboration/viewQuestions")
			    .then(function (response) {$scope.questions = response.data;console.log("data:   "+response.data);});
			$scope.newQuestion={};
			console.log("In forum ... Controller");
			$scope.addForum=function(newQuestion)
			{
				var dataObj = {
						questionTitle:$scope.questionTitle,
						questionDescription:$scope.questionDescription		
						
		 		};
				console.log("title:"+dataObj);
				 var res = $http.post('http://localhost:8086/Collaboration/addQuestion',dataObj);
				 $http.get("http://localhost:8086/Collaboration/viewQuestions")
			 	    .then(function (response) {$scope.questions = response.data;});
			 		res.success(function(data, status, headers, config) {
			 			$scope.message = data;
			 			console.log("status:"+status);
			 		});
			 		 
			};
			
			$scope.editForum=function(forum)
			{
				console.log("inside editforum");
				console.log("forum:"+forum);
				$scope.forumDataToEdit=forum;
			}
			$scope.saveEdit=function()
			{
				var dataObj = {
			
						questionId:$scope.forumDataToEdit.questionId,
						questionTitle:$scope.forumDataToEdit.questionTitle,
						questionDescription:$scope.forumDataToEdit.questionDescription
		 				
		 		};
				$http.put('http://localhost:8086/Collaboration/updateQuestion', dataObj);
				$http.get("http://localhost:8086/Collaboration/viewQuestions")
		 	    .then(function (response) {$scope.questions = response.data;});
			}
			$scope.deleteQuestion=function(forumDataToEdit)
			{
				console.log("delete forum inside called");
				
				questionId:$scope.forumDataToEdit.questionId;
				
				console.log("questionId:"+forumDataToEdit.questionId);
				$http['delete']('http://localhost:8086/Collaboration/deleteQuestion/'+forumDataToEdit.questionId);
				 $http.get("http://localhost:8086/Collaboration/viewQuestions")
			 	    .then(function (response) {$scope.questions = response.data;});
			}
			$scope.addAnswer=function()
			{
				var dataObj = {
			
						questionId:$scope.forumDataToEdit.questionId,
						answer:$scope.answer
		 		};
				
				$http.post('http://localhost:8086/Collaboration/addAnswer', dataObj);
				
			}
			$scope.editForumAnswer=function(forum)
			{
				console.log("inside editfvsdfc zsfvvcsdf");
				console.log("forum:"+forum.questionId);
				$scope.forumDataToEdit = forum;
				
				$http.get("http://localhost:8086/Collaboration/getAnswers/"+forum.questionId)
			    .then(function (response) {
			    	console.log("ins zsfvvcsdf");
			    	$scope.answers = response.data;
			    });
				
			}
			
			
			$scope.viewForumAnswer=function(forum)
			{
				console.log("inside view answer");
				console.log("forum:"+forum.questionId);
				$scope.forumDataToEdit = forum;
				
				$http.get("http://localhost:8086/Collaboration/getAnswers/"+forum.questionId)
			    .then(function (response) {
			    	console.log("ins zsfvvcsdf");
			    	$scope.answers = response.data;
			    
			    });
				
			}
			
			
		}

		);
letzChaat.controller("forumAnswersController",function($scope,$http)
		{
		console.log("inside forum answershjjjjjjjjjjjjjjjjjj");
	
		
			console.log("inside editforum");
			/*console.log("forum:"+forum.questionId);
			$scope.forumDataToEdit=forum;*/
			
			$http.get("http://localhost:8086/Collaboration/getAnswers/")
		    .then(function (response) {$scope.answers = response.data;});
		
		$scope.saveEdit=function()
		{
			var dataObj = {
		
					questionId:$scope.forumDataToEdit.questionId,
					questionTitle:$scope.forumDataToEdit.questionTitle,
					questionDescription:$scope.forumDataToEdit.questionDescription
	 				
	 		};
			$http.put('http://localhost:8086/Collaboration/updateQuestion', dataObj);
			$http.get("http://localhost:8086/Collaboration/viewQuestions")
	 	    .then(function (response) {$scope.questions = response.data;});
		}
		
		
		});
letzChaat.controller("contactController",function($scope)
		{
		//console.log("inside contact controller");
		
		$scope.sendMessage=function()
		{
			$scope.message = "Your message submitted successfully";
		}
		
		
		});
letzChaat.controller("friendController",function($scope,$http,$rootScope)
		{
	
	
	
	$rootScope.login=false;
	$rootScope.register=false;
	$rootScope.services=true;
	$rootScope.about=true;
	$rootScope.home=true;
	
	$rootScope.adminForum=false;
	$rootScope.adminJobs=false;
	$rootScope.adminBlog=false;
	$rootScope.adminEvent=false;
	$rootScope.logout=true;
	
	$rootScope.jobs=true;
	$rootScope.blog=true;
	$rootScope.forum=true;
	$rootScope.event=true;
	
	
	
	
		console.log("inside friend controller");
		
		$http.get("http://localhost:8086/Collaboration/currentUser")
	    .then(function (response) {$scope.currentUser = response.data;});
		
		
		
		$http.get("http://localhost:8086/Collaboration/newFriends")
	    .then(function (response) {$scope.users = response.data;});
		
		
		
		$scope.sendFriendRequest=function(user)
		{
			$scope.message = "Your message submitted successfully";
			
			$http.post('http://localhost:8086/Collaboration/addFriend/'+user.username);
			
			console.log("friend for user id "+ user.username +" request sent");
		}
		
		
		});
letzChaat.controller("friendRequestController",function($scope,$http,$rootScope)
		{
	
	
	
	$rootScope.login=false;
	$rootScope.register=false;
	$rootScope.services=true;
	$rootScope.about=true;
	$rootScope.home=true;
	
	$rootScope.adminForum=false;
	$rootScope.adminJobs=false;
	$rootScope.adminBlog=false;
	$rootScope.adminEvent=false;
	$rootScope.logout=true;
	
	$rootScope.jobs=true;
	$rootScope.blog=true;
	$rootScope.forum=true;
	$rootScope.event=true;
	
	
	
	
		console.log("inside friendRequestController");
		
		$http.get("http://localhost:8086/Collaboration/getMyFriendRequests")
	    .then(function (response) {$scope.users = response.data;});
		
		
		
		$scope.acceptRequest=function(user)
		{
			console.log( "Accepted request successfully");
			
			$http.put('http://localhost:8086/Collaboration/acceptFriend/'+user.userID);
			
			console.log("friend for user id "+ user.userID +" accepted");
		}
		
		
		$scope.rejectRequest=function(user)
		{
			console.log( "rejected successfully");
			
			$http.put('http://localhost:8086/Collaboration/rejectFriend/'+user.userID);
			
			console.log("friend for user id "+ user.userID +" rejected");
		}
		
		
		});

letzChaat.controller("MyFriendsController",function($scope,$http,$rootScope)
		{
	
	
	
	$rootScope.login=false;
	$rootScope.register=false;
	$rootScope.services=true;
	$rootScope.about=true;
	$rootScope.home=true;
	
	$rootScope.adminForum=false;
	$rootScope.adminJobs=false;
	$rootScope.adminBlog=false;
	$rootScope.adminEvent=false;
	$rootScope.logout=true;
	
	$rootScope.jobs=true;
	$rootScope.blog=true;
	$rootScope.forum=true;
	$rootScope.event=true;
	
	
	
	
		console.log("inside MyFriendsController");
		
		$http.get("http://localhost:8086/Collaboration/myFriends")
	    .then(function (response) {$scope.users = response.data;});
		
		
		
		$scope.unfriend=function(user)
		{
			console.log( "unfriend successfully");
			
			$http.put('http://localhost:8086/Collaboration/unFriend/'+user.friendID);
			
			console.log("friend for user id "+ user.friendID +" accepted");
		}
		
	
		
		});


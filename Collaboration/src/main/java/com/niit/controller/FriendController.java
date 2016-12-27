package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.dao.FriendsDAO;
import com.niit.dao.UsersDetailDao;
import com.niit.model.Friends;
import com.niit.model.UsersDetail;

@RestController

public class FriendController {

	 private static final Logger Logger = LoggerFactory.getLogger(FriendController.class);
	 
	 
	@Autowired
	FriendsDAO friendsDAO;
	
	@Autowired
	Friends friends;
	
	
	@Autowired
	UsersDetailDao usersDetailDao;
	
	
	
	
	@RequestMapping(value="/currentUser",method = RequestMethod.GET)
    public UsersDetail showNewUsers(HttpSession session) {
	
		UsersDetail loggedInUser =(UsersDetail) session.getAttribute("loggedInUser");
		return loggedInUser;
	}
	
	
	
	
	@RequestMapping(value="/newFriends",method = RequestMethod.GET)
    public List<UsersDetail> newMyFriends(HttpSession session) {
	
		
		UsersDetail loggedInUser =(UsersDetail) session.getAttribute("loggedInUser");
		//friends.setUserID(loggedInUser.getUsername());
		
		List<UsersDetail> list =friendsDAO.showNewUsers(loggedInUser.getUsername());
		
		return list;
	}
	
	
	
	
	
	
	@RequestMapping(value="/myFriends",method = RequestMethod.GET)
    public List<Friends> getMyFriends(HttpSession session) {
	
		
		UsersDetail loggedInUser =(UsersDetail) session.getAttribute("loggedInUser");
		friends.setUserID(loggedInUser.getUsername());
		
	
		List<Friends> myFriends = friendsDAO.getMyFriend(loggedInUser.getUsername());
		
		if(myFriends.isEmpty())
		{
			return null;
			
		}
		
		
		return myFriends;
	}
	
	
	@RequestMapping(value="/getMyFriendRequests",method = RequestMethod.GET)
	public List<Friends> getMyFriendRequests(HttpSession session) {
		
		
		UsersDetail loggedInUser = (UsersDetail) session.getAttribute("loggedInUser");
		List<Friends> myFriendRequests = friendsDAO.getNewFriendRequests(loggedInUser.getUsername());
		
		
		
	//	List<Friends> myFriendRequests = friendsDAO.getNewFriendRequests("Anuradha");
		
		
		
		return myFriendRequests;
		
		/*User loggedInUser = (User) session.getAttribute("loggedInUser");
		friendsDAO.getNewFriendRequests(loggedInUser.getId());
		return new <Friends>(friends, HttpStatus.OK);*/
	}
	
	
	
	
	@RequestMapping(value="/addFriend/{friendID}", method = RequestMethod.POST)
	public Friends sendFriendRequest(@PathVariable("friendID") String friendID,HttpSession session) {
		
		
		UsersDetail loggedInUser =(UsersDetail) session.getAttribute("loggedInUser");
		friends.setUserID(loggedInUser.getUsername());
	//	friends.setUserID("Anuradha");
		friends.setFriendID(friendID);
		friends.setStatus("N");
		friends.setIsOnline('Y');
		friendsDAO.save(friends);
		return friends;
	}
	
	@RequestMapping(value="/unFriend/{friendID}", method = RequestMethod.PUT)
	public Friends unFriend(@PathVariable("friendID") String friendID, HttpSession session) {
		
		UsersDetail loggedInUser = (UsersDetail) session.getAttribute("loggedInUser");
		/*friends.setUserID(loggedInUser.getUsername());
		//friends.setUserID("Anuradha");
		friends.setFriendID(friendID);
		friends.setStatus("U");//N -> New , R-> Rejected , A -> Accepted, U -> Unfriend
		friendsDAO.update(friends);*/
		
		
		
		/*friends=friendsDAO.get(loggedInUser.getUsername(), friendID);
		System.out.println("friend id is "+friends.getId());
		friends.setStatus("U");
		friendsDAO.update(friends);
		
		
		friends=friendsDAO.get(friendID,loggedInUser.getUsername());
		if(friends==null){
			System.out.println("its null");
			friends.setFriendID(loggedInUser.getUsername());
			friends.setUserID(friendID);
			friends.setStatus("U");
			friendsDAO.save(friends);
		}
		
		else{
			friends.setStatus("U");
			friendsDAO.update(friends);
		}*/
		
		
		
		
		/*friends=friendsDAO.get(friendID,loggedInUser.getUsername());
		System.out.println("friend id is "+friends.getId());
		friends.setStatus("U");
		friendsDAO.update(friends);*/
		
		
		
		friends=friendsDAO.get(loggedInUser.getUsername(),friendID);
			friends.setStatus("U");
			friendsDAO.update(friends);
	
		
		
		
		friends=friendsDAO.get(friendID,loggedInUser.getUsername());
			System.out.println("record id "+friends.getId());
			friends.setStatus("U");
			friendsDAO.update(friends);
			
		return friends;
	}
	
	
	
	
	@RequestMapping(value="/acceptFriend/{friendID}", method = RequestMethod.PUT)
	public Friends acceptFriendRequest(@PathVariable("friendID") String friendID, HttpSession session) {
		
		UsersDetail loggedInUser = (UsersDetail) session.getAttribute("loggedInUser");
		System.out.println("user name is "+loggedInUser.getUsername());
		
		friends=friendsDAO.get(friendID,loggedInUser.getUsername());
		
			System.out.println("record id "+friends.getId());
			
			friends.setStatus("A");
			friendsDAO.update(friends);
		
		
		
		
		
		friends=friendsDAO.get(loggedInUser.getUsername(),friendID);
		if(friends==null){
			System.out.println("its null");
			
				friends = new Friends();
				friends.setUserID(loggedInUser.getUsername());
				//friends.setUserID("Anuradha");
				friends.setFriendID(friendID);
				friends.setStatus("A");
				friends.setIsOnline('Y');
				friendsDAO.save(friends);
		}
		
		else{
			System.out.println("record id "+friends.getId());
		
			friends.setStatus("A");
			friendsDAO.update(friends);
		}
		
		return friends;
	}
	

	@RequestMapping(value="/rejectFriend/{friendID}", method = RequestMethod.PUT)
	public Friends rejectFriendFriendRequest(@PathVariable("friendID") String friendID, HttpSession session){
		
		UsersDetail loggedInUser = (UsersDetail) session.getAttribute("loggedInUser");
		System.out.println("user name is "+loggedInUser.getUsername());
		
		/*friends=friendsDAO.get(friendID,loggedInUser.getUsername());
		System.out.println("friend id is "+friends.getId());
		friends.setStatus("R");
		friendsDAO.update(friends);
		
		
		
		
		friends=friendsDAO.get(loggedInUser.getUsername(),friendID);
		if(friends==null){
			System.out.println("its null");
			friends.setFriendID(loggedInUser.getUsername());
			friends.setUserID(friendID);
			friends.setStatus("R");
			friendsDAO.save(friends);
		}
		
		else{
			friends.setStatus("R");
			friendsDAO.update(friends);
		}*/

		
		
		
		
		/*friends=friendsDAO.get(friendID,loggedInUser.getUsername());
		System.out.println("friend id is "+friends.getId());
		friends.setStatus("R");
		friendsDAO.update(friends);
		*/
		
		
		
		friends=friendsDAO.get(loggedInUser.getUsername(),friendID);
		
			friends.setStatus("R");
			friendsDAO.update(friends);
	
		
		
		friends=friendsDAO.get(friendID,loggedInUser.getUsername());
		if(friends==null){
			System.out.println("its null");
			friends = new Friends();
			friends.setFriendID(loggedInUser.getUsername());
			friends.setUserID(friendID);
			friends.setStatus("R");friends.setIsOnline('Y');
			friendsDAO.save(friends);
		}
		
		else{System.out.println("record id "+friends.getId());
			friends.setStatus("R");
			friendsDAO.update(friends);
		}
		
		
		
		
		
		
		
		/*friends.setUserID(loggedInUser.getUsername());
		//friends.setUserID("Anuradha");
		friends.setFriendID(friendID);
		friends.setStatus("R");
		friendsDAO.update(friends);*/
		return friends;		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Just for testing purpose from restclient.
	@RequestMapping(value="/myFriends/{id}", method = RequestMethod.GET)
	public List<Friends> getMyFriendsTemp(@PathVariable("id") String id) {
	
		List<Friends> myFriends = friendsDAO.getMyFriend(id);
		return myFriends;
	}
	
	/* @RequestMapping(value="/friendaccept/{id}" , method = RequestMethod.PUT)
	   public Friends friendaccept(@PathVariable("id") String id, @RequestBody Friends friends ) 
	   {
		   friends = friendsDAO.get(friends.getId()); 
		
		  if(friends==null)
		  {
			  return null;
		  }
		  
		  friends.setStatus("A");
		   
		  friendsDAO.update(friends);
		   
		   return friends;
	   }
	
	 @RequestMapping(value="/friendreject/{id}" , method = RequestMethod.PUT)
	   public  <Friends> friendreject(@PathVariable("id") String id, @RequestBody Friends friends ) 
	   {
		   friends = friendsDAO.get(friends.getId());
		
		  if(friends==null)
		  {
			  Logger.debug("->->->->User does not exist with id "+ friends.getId());
			  friends = new Friends();
			  friends.setErrorMessage("User does not exist with id "+ friends.getId());
			   return new <Friends>(friends, HttpStatus.NOT_FOUND);
		  }
		  
		  friends.setStatus("R");
		   
		  friendsDAO.update(friends);
		   
		   return new <Friends>(friends, HttpStatus.OK);
	   }*/
	 
}

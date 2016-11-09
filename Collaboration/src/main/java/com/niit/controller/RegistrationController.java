/*package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.niit.dao.UsersDetailDao;
import com.niit.model.UsersDetail;

@RestController
public class RegistrationController {
	@Autowired
	UsersDetailDao usersDetailDao;
	
	  //-------------------Retrieve All Users--------------------------------------------------------
	 @RequestMapping(value = "/user/", method = RequestMethod.GET)
	    public ResponseEntity<List<UsersDetail>> listAllUsers() {
	     List<UsersDetail> users = usersDetailDao.getAllUsers();
	        if(users.isEmpty()){
	            return new ResponseEntity<List<UsersDetail>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<UsersDetail>>(users, HttpStatus.OK);
	
	    }

	 //-------------------Retrieve Single User--------------------------------------------------------
     
	    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<UsersDetail> getUser(@PathVariable("id") int id) {
	        System.out.println("Fetching User with id " + id);
	        
	        UsersDetail user = usersDetailDao.getUserById(id);
	   
	        if (user == null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<UsersDetail>(HttpStatus.NOT_FOUND);
	        }
	        System.out.println(user.getUserId() + "\t" + user.getUsername() + "\t"+ "\t" + user.getUserPhone());
	        return new ResponseEntity<UsersDetail>(user, HttpStatus.OK);
	    }
	 
	 
	//-------------------Create a User--------------------------------------------------------
     
	    @RequestMapping(value = "/user/", method = RequestMethod.POST)
	    public ResponseEntity<Void> createUser(@RequestBody UsersDetail usersDetail,UriComponentsBuilder ucBuilder) {
	        System.out.println("Creating User " + usersDetail.getUsername());
	 
	        if (!usersDetailDao.isValidUser(usersDetail.getUsername())) {
	            System.out.println("A User with name " + usersDetail.getUsername() + " already exists");
	            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	        }
	        System.out.println("A User with name " + usersDetail.getUsername() + " adding");
	        usersDetailDao.addUser(usersDetail);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(usersDetail.getUserId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	    
	  //------------------- Update a User --------------------------------------------------------
	     
	    @RequestMapping(value = "/user/{userId}", method = RequestMethod.PUT)
	    public ResponseEntity<UsersDetail> updateUser(@PathVariable("userId") int userId, @RequestBody UsersDetail user) {
	        System.out.println("Updating User " + userId);
	         
	        UsersDetail currentUser = usersDetailDao.getUserById(userId);
	         
	        if (currentUser==null) {
	            System.out.println("User with id " + userId + " not found");
	            return new ResponseEntity<UsersDetail>(HttpStatus.NOT_FOUND);
	        }
	 
	        currentUser.setUsername(user.getUsername());
	        currentUser.setUserFullName(user.getUserFullName());
	        currentUser.setUserPhone(user.getUserPhone());
	        currentUser.setPassword(user.getPassword());
	        currentUser.setRole(user.getRole());
	        currentUser.setUserEmail(user.getUserEmail());
	         
	        usersDetailDao.addUser(currentUser);
	         return new ResponseEntity<UsersDetail>(currentUser, HttpStatus.OK);
	    }
}
*/
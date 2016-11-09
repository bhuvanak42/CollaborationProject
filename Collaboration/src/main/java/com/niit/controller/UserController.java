package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.dao.UsersDetailDao;
import com.niit.model.UsersDetail;;

@RestController
public class UserController {
	@Autowired
	private UsersDetailDao usersDetailDao;
	@RequestMapping(value="/addUser", method=RequestMethod.POST,headers="Accept=application/json")
	public void addUser(@RequestBody UsersDetail usersDetail)
	{
		usersDetailDao.addUser(usersDetail);
	
	}
	 @RequestMapping(value = "/getUsers", method = RequestMethod.GET, headers = "Accept=application/json")  
	 public List<UsersDetail> getUsers()
	 {
		 List<UsersDetail> users=usersDetailDao.getAllUsers();
		return users;
	 }
	 @RequestMapping(value="/updateUser",method=RequestMethod.PUT,headers="Accept=application/json")
	 public void updateUser(@RequestBody UsersDetail usersDetail)
	 {
		 usersDetailDao.addUser(usersDetail);
	 }
	 @RequestMapping(value="/getUser/{id}",method=RequestMethod.GET,headers="Accept=application/json")
	 public @ResponseBody UsersDetail getUserById(@PathVariable("id") int id)
	 {
		 System.out.println("User Id:"+id);
		 return usersDetailDao.getUserById(id);
	 }
	 @RequestMapping(value="/authenticate", method=RequestMethod.POST,headers="Accept=application/json")
	 public int authenticateUser(@RequestBody UsersDetail user,HttpSession session)
	 {
		 System.out.println("username:"+user.getUsername());
		 System.out.println("password:"+user.getPassword());
		 
		 UsersDetail usersDetail=usersDetailDao.getUserByUsername(user.getUsername());
		 
		 int result=0;
		 result=usersDetailDao.validateUser(user.getUsername(),user.getPassword());
		 System.out.println("result we have got is:"+result);
		 
		 if(result!=0){
			 session.setAttribute("loggedInUser", usersDetail);
			 session.setAttribute("loggedInUserId", usersDetail.getUserId());
		 }
		 return result;
	 }

}

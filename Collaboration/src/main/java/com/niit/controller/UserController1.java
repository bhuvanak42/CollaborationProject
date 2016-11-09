package com.niit.controller;
/*package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.dao.UsersDetailDao;
import com.niit.model.UsersDetail;

@RestController
public class UserController {

	@Autowired
	UsersDetailDao usersDetailDao;

	//WORKING
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<UsersDetail>> listAllUsers() {
		List<UsersDetail> userList = usersDetailDao.getAllUsers();
		if (userList.isEmpty()) {
			return new ResponseEntity<List<UsersDetail>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<UsersDetail>>(userList, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/", method = RequestMethod.POST)
	public ResponseEntity<UsersDetail> createUser(@RequestBody UsersDetail user) {

		if (usersDetailDao.isValidUser(user.getUsername())) {
			usersDetailDao.addUser(user);
			return new ResponseEntity<UsersDetail>(user, HttpStatus.OK);
		}
		return new ResponseEntity<UsersDetail>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/", method = RequestMethod.PUT)
	public ResponseEntity<UsersDetail> updateUser(@RequestBody UsersDetail user) {

		if (usersDetailDao.getUserById(user.getUserId()) == null) {
			user = new UsersDetail();
			return new ResponseEntity<UsersDetail>(user, HttpStatus.NOT_FOUND);
		}
		usersDetailDao.addUser(user);
		return new ResponseEntity<UsersDetail>(user, HttpStatus.OK);
	}

	// http://localhost:8081/Collaboration/user/student1
	//WORKING
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<UsersDetail> deleteUser(@PathVariable("id") int id) {

		UsersDetail usersDetail = usersDetailDao.getUserById(id);
		if (usersDetail == null) {
			usersDetail = new UsersDetail();
			usersDetail.setErrorMessage("User doesnot exists");
			return new ResponseEntity<UsersDetail>(usersDetail, HttpStatus.NOT_FOUND);
		}
		usersDetailDao.deleteUser(usersDetail);
		return new ResponseEntity<UsersDetail>(usersDetail, HttpStatus.OK);
	}
}
*/
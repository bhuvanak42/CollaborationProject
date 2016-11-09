package com.niit.test;

import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UsersDetailDao;
import com.niit.model.UsersDetail;

public class UserTest {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();

		UsersDetail usersDetail=(UsersDetail)context.getBean("usersDetail");
	
		
		UsersDetailDao userDetailsDAO = (UsersDetailDao) context.getBean("usersDetailDao");
	
		
		//usersDetail.setUserId("USER_001");
		/*usersDetail.setUsername("Admin Bhuvana");
		usersDetail.setUserFullName("bhuvana");
		usersDetail.setUserEmail("bhuvana@gmail.com");
		usersDetail.setUserPhone("9325427410");
		usersDetail.setPassword("123");
		usersDetail.setRole("ROLE_ADMIN");
		usersDetail.setEnabled(true);
		userDetailsDAO.addUser(usersDetail);*/
		
		
		//usersDetail.setUserId("USER_002");
		
	/*	usersDetail.setUsername("Anu");
		usersDetail.setUserFullName("Anu");
		usersDetail.setUserEmail("anuu@gm.ccc");
		usersDetail.setUserPhone("9324427410");
		usersDetail.setPassword("123");
		usersDetail.setRole("ROLE_STUDENT");
		usersDetail.setEnabled(true);
		userDetailsDAO.addUser(usersDetail);*/
		
		
		//usersDetail.setUserId("USER_003");
		/*usersDetail.setUsername("Asha");
		usersDetail.setUserFullName("Asha");
		usersDetail.setUserEmail("asha@gm.ccc");
		usersDetail.setUserPhone("9365562710");
		usersDetail.setPassword("123");
		usersDetail.setRole("ROLE_STUDENT");
		usersDetail.setEnabled(true);
		userDetailsDAO.addUser(usersDetail);*/
	
		//usersDetail.setUserId("USER_004");
	/*	usersDetail.setUsername("Binzzdu");
		usersDetail.setUserFullName("Bindu");
		usersDetail.setUserEmail("bindzzu@gm.ccc");
		usersDetail.setUserPhone("9311525410");
		usersDetail.setPassword("123");
		usersDetail.setRole("ROLE_ALUMINI");
		usersDetail.setEnabled(true);
		userDetailsDAO.addUser(usersDetail);
	*/
		
		boolean valid=userDetailsDAO.isValidUser("xxx");
		System.out.println("Is valid user? == "+ valid);
		
		List<UsersDetail> list = userDetailsDAO.getAllUsers();

		for (UsersDetail u : list) {
			System.out.println(u.getUserId() + "\t" + u.getUsername() + "\t"+ "\t" + u.getUserPhone());
		}
		context.close();
	}
}
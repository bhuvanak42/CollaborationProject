package com.niit.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.FriendsDAO;
import com.niit.model.Friends;
import com.niit.model.UsersDetail;

public class FriendTest {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();

		Friends friends =(Friends)context.getBean("friends");
		FriendsDAO friendsDAO = (FriendsDAO) context.getBean("friendsDAO");
	
		/*friends.setUserID("Asha");
		friends.setFriendID("Anuradha");
		friends.setStatus("N");
		friends.setIsOnline('Y');
		boolean status = friendsDAO.save(friends);
		System.out.println(status);*/
		
		
		
		List<UsersDetail>list=friendsDAO.showNewUsers("Anuradha");
		for(UsersDetail usersDetail:list){
			System.out.println("item is here "+usersDetail.getUsername());
		}
		
		context.close();
	}
}